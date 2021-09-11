package org.ppsspp.ppsspp;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.InputDevice;
import android.view.InputDevice.MotionRange;
import android.view.KeyEvent;
import android.view.MotionEvent;

@TargetApi(12)
public class InputDeviceState {
    private static final String TAG = "InputDeviceState";
    private static final int deviceId = 10;
    private int[] mAxes;
    private InputDevice mDevice;

    public InputDeviceState(InputDevice inputDevice) {
        this.mDevice = inputDevice;
        int i = 0;
        int i2 = 0;
        for (MotionRange source : inputDevice.getMotionRanges()) {
            if ((source.getSource() & 16) != 0) {
                i2++;
            }
        }
        this.mAxes = new int[i2];
        for (MotionRange source2 : inputDevice.getMotionRanges()) {
            if ((source2.getSource() & 16) != 0) {
                int i3 = i + 1;
                this.mAxes[i] = source2.getAxis();
                i = i3;
            }
        }
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Registering input device with ");
        stringBuilder.append(i2);
        stringBuilder.append(" axes: ");
        stringBuilder.append(inputDevice.getName());
        Log.i(str, stringBuilder.toString());
        if (VERSION.SDK_INT >= 19) {
            logAdvanced(inputDevice);
        }
        NativeApp.sendMessage("inputDeviceConnected", inputDevice.getName());
    }

    InputDevice getDevice() {
        return this.mDevice;
    }

    @TargetApi(19)
    void logAdvanced(InputDevice inputDevice) {
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Vendor ID:");
        stringBuilder.append(inputDevice.getVendorId());
        stringBuilder.append(" productId: ");
        stringBuilder.append(inputDevice.getProductId());
        Log.i(str, stringBuilder.toString());
    }

    public boolean onJoystickMotion(MotionEvent motionEvent) {
        int i = 0;
        if ((motionEvent.getSource() & 16) == 0) {
            return false;
        }
        NativeApp.beginJoystickEvent();
        while (i < this.mAxes.length) {
            int i2 = this.mAxes[i];
            NativeApp.joystickAxis(deviceId, i2, motionEvent.getAxisValue(i2));
            i++;
        }
        NativeApp.endJoystickEvent();
        return true;
    }

    public boolean onKeyDown(KeyEvent keyEvent) {
        return NativeApp.keyDown(deviceId, keyEvent.getKeyCode(), keyEvent.getRepeatCount() > 0);
    }

    public boolean onKeyUp(KeyEvent keyEvent) {
        return NativeApp.keyUp(deviceId, keyEvent.getKeyCode());
    }
}
