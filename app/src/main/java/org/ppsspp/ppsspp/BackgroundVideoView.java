package org.ppsspp.ppsspp;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;

import androidx.annotation.RequiresApi;

import java.io.IOException;

public class BackgroundVideoView extends SurfaceView implements SurfaceHolder.Callback {

    private MediaPlayer mp;
    private Boolean isStarted = false;

    public BackgroundVideoView(Context context) {
        super(context);
        init();
    }


    public BackgroundVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BackgroundVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BackgroundVideoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mp = new MediaPlayer();
        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        AssetFileDescriptor assetFileDescriptor = getResources().openRawResourceFd(R.raw.gow);
        try {
        if(!isStarted)
        {
            isStarted = true;
            mp.setDataSource(assetFileDescriptor.getFileDescriptor(),
                        assetFileDescriptor.getStartOffset(),
                        assetFileDescriptor.getLength());
        }

            ViewGroup.LayoutParams  layoutParams = getLayoutParams();
                                    layoutParams.height = getHeight();
                                    layoutParams.width = getWidth();
            setLayoutParams(layoutParams);
            mp.prepare();
            mp.setDisplay(getHolder());
            mp.setLooping(true);
            mp.start();
            setVolume(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void setVolume(int amount) {
        final int max = 100;
        final double numerator = max - amount > 0 ? Math.log(max - amount) : 0;
        final float volume = (float) (1 - (numerator / Math.log(max)));

        this.mp.setVolume(volume, volume);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mp.stop();  //Stop the video while surface is destroy
    }
}
