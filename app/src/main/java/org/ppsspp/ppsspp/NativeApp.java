package org.ppsspp.ppsspp;

public class NativeApp {
    public static final int DEVICE_ID_DEFAULT = 0;
    public static final int DEVICE_ID_KEYBOARD = 1;
    public static final int DEVICE_ID_MOUSE = 2;
    public static final int DEVICE_ID_PAD_0 = 10;
    public static final int DEVICE_TYPE_DESKTOP = 2;
    public static final int DEVICE_TYPE_MOBILE = 0;
    public static final int DEVICE_TYPE_TV = 1;

    public static native boolean accelerometer(float f, float f2, float f3);

    public static native void audioConfig(int i, int i2);

    public static native void audioInit();

    public static native void audioShutdown();

    public static native void backbufferResize(int i, int i2, int i3);

    public static native void beginJoystickEvent();

    public static native void computeDesiredBackbufferDimensions();

    public static native void endJoystickEvent();

    public static native int getDesiredBackbufferHeight();

    public static native int getDesiredBackbufferWidth();

    public static native void init(String str, int i, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, String str9);

    public static native boolean isAtTopLevel();

    public static native boolean isLandscape();

    public static native void joystickAxis(int i, int i2, float f);

    public static native boolean keyDown(int i, int i2, boolean z);

    public static native boolean keyUp(int i, int i2);

    public static native boolean mouseWheelEvent(float f, float f2);

    public static native void pause();

    public static native void pushCameraImage(byte[] bArr);

    public static native void pushNewGpsData(float f, float f2, float f3, float f4, float f5, long j);

    public static native String queryConfig(String str);

    public static native void resume();

    public static native void sendMessage(String str, String str2);

    public static native void setDisplayParameters(int i, int i2, int i3, float f);

    public static native void shutdown();

    public static native boolean touch(float f, float f2, int i, int i2);
}
