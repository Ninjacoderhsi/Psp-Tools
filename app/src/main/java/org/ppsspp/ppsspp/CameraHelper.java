package org.ppsspp.ppsspp; 
 
import android.annotation.TargetApi; 
import android.content.Context; 
import android.graphics.Rect; 
import android.graphics.SurfaceTexture; 
import android.graphics.YuvImage; 
import android.hardware.Camera; 
import android.util.Log; 
import java.io.ByteArrayOutputStream; 
import java.io.IOException; 
import java.io.OutputStream; 
import java.util.List; 
 
@TargetApi(value=23) 
public class CameraHelper { 
    private static final String TAG = "CameraHelper"; 
    private long lastTime = 0L; 
    private Camera mCamera = null; 
    private Camera.PreviewCallback mPreviewCallback; 
    private SurfaceTexture mSurfaceTexture; 
    private int previewHeight = 0; 
    private int previewWidth = 0; 
 
    public CameraHelper(Context context) { 
        this.mPreviewCallback = new Camera.PreviewCallback(){ 
 
            public void onPreviewFrame(byte[] arrby, Camera camera) { 
                long l = System.currentTimeMillis(); 
                if (l - CameraHelper.this.lastTime < 100L) { 
                    return; 
                } 
                CameraHelper.this.lastTime = l; 
                YuvImage yuvImage = new YuvImage(arrby, 17, CameraHelper.this.previewWidth, CameraHelper.this.previewHeight, null); 
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); 
                yuvImage.compressToJpeg(new Rect((-480 + CameraHelper.this.previewWidth) / 2, (-272 + CameraHelper.this.previewHeight) / 2, CameraHelper.this.previewWidth - (-480 + CameraHelper.this.previewWidth) / 2, CameraHelper.this.previewHeight - (-272 + CameraHelper.this.previewHeight) / 2), 80, (OutputStream)byteArrayOutputStream); 
                NativeApp.pushCameraImage(byteArrayOutputStream.toByteArray()); 
            } 
        }; 
        this.mSurfaceTexture = new SurfaceTexture(10); 
    } 
 
    /* 
     * Enabled aggressive block sorting 
     * Enabled unnecessary exception pruning 
     * Enabled aggressive exception aggregation 
     */ 
 
    void startCamera() { 
        List list; 
        Camera.Parameters parameters; 
        int n; 
        Log.d((String)TAG, (String)"startCamera"); 
            this.mCamera = Camera.open(); 
            parameters = this.mCamera.getParameters(); 
            list = parameters.getSupportedPreviewSizes(); 
            this.previewWidth = ((Camera.Size)list.get((int)0)).width; 
            this.previewHeight = ((Camera.Size)list.get((int)0)).height; 
            n = 0; 
        do { 
            if (n >= list.size()) break; 
            StringBuilder stringBuilder = new StringBuilder(); 
            stringBuilder.append("getSupportedPreviewSizes["); 
            stringBuilder.append(n); 
            stringBuilder.append("]: "); 
            stringBuilder.append(((Camera.Size)list.get((int)n)).height); 
            stringBuilder.append(" "); 
            stringBuilder.append(((Camera.Size)list.get((int)n)).width); 
            Log.d((String)TAG, (String)stringBuilder.toString()); 
            if (((Camera.Size)list.get((int)n)).width <= 640 && ((Camera.Size)list.get((int)n)).height <= 480) { 
                this.previewWidth = ((Camera.Size)list.get((int)n)).width; 
                this.previewHeight = ((Camera.Size)list.get((int)n)).height; 
                break; 
            } 
            ++n; 
        } while (true); 
        StringBuilder stringBuilder = new StringBuilder(); 
        stringBuilder.append("setPreviewSize("); 
        stringBuilder.append(this.previewWidth); 
        stringBuilder.append(", "); 
        stringBuilder.append(this.previewHeight); 
        stringBuilder.append(")"); 
        Log.d((String)TAG, (String)stringBuilder.toString()); 
        parameters.setPreviewSize(this.previewWidth, this.previewHeight); 
        List list2 = parameters.getSupportedPreviewFpsRange(); 
        int[] arrn = (int[])list2.get(0); 
        int n2 = 0; 
        do { 
            if (n2 >= list2.size()) { 
                StringBuilder stringBuilder2 = new StringBuilder(); 
                stringBuilder2.append("setPreviewFpsRange("); 
                stringBuilder2.append(arrn[0]); 
                stringBuilder2.append(", "); 
                stringBuilder2.append(arrn[1]); 
                stringBuilder2.append(")"); 
                Log.d((String)TAG, (String)stringBuilder2.toString()); 
                parameters.setPreviewFpsRange(arrn[0], arrn[1]); 
                try {
                this.mCamera.setParameters(parameters); 
                this.mCamera.setPreviewTexture(this.mSurfaceTexture); 
                this.mCamera.setPreviewCallback(this.mPreviewCallback); 
                this.mCamera.startPreview(); 
                } catch(IOException e) {
                    
                }
                return; 
            } 
            StringBuilder stringBuilder3 = new StringBuilder(); 
            stringBuilder3.append("getSupportedPreviewFpsRange["); 
            stringBuilder3.append(n2); 
            stringBuilder3.append("]: "); 
            stringBuilder3.append(((int[])list2.get(n2))[0]); 
            stringBuilder3.append(" "); 
            stringBuilder3.append(((int[])list2.get(n2))[1]); 
            Log.d((String)TAG, (String)stringBuilder3.toString()); 
            if (((int[])list2.get(n2))[0] <= arrn[0] && ((int[])list2.get(n2))[1] <= arrn[1]) { 
                arrn = (int[])list2.get(n2); 
            } 
            ++n2; 
        } while (true); 
    } 
 
    void stopCamera() { 
        Log.d((String)TAG, (String)"stopCamera"); 
        if (this.mCamera != null) { 
            this.mCamera.setPreviewCallback(null); 
            this.mCamera.stopPreview(); 
            this.mCamera.release(); 
            this.mCamera = null; 
        } 
    } 
 
} 
 
 
