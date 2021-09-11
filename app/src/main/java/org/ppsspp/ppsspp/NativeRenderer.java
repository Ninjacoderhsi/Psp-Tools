package org.ppsspp.ppsspp;

import android.opengl.GLSurfaceView.Renderer;
import android.util.Log;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class NativeRenderer implements Renderer {
    private static String TAG = "NativeRenderer";
    private boolean inFrame;
    private NativeActivity mActivity;

    NativeRenderer(NativeActivity nativeActivity) {
        this.mActivity = nativeActivity;
    }

    public native void displayInit();

    public native void displayRender();

    public boolean isRenderingFrame() {
        return this.inFrame;
    }

    public void onDrawFrame(GL10 gl10) {
        this.inFrame = true;
        displayRender();
        this.inFrame = false;
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        Log.i(TAG, "NativeRenderer: onSurfaceCreated");
        displayInit();
    }
}
