package org.ppsspp.ppsspp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.provider.Settings.System;
import android.util.Log;

public class PowerSaveModeReceiver extends BroadcastReceiver {
    private static final String TAG = "PowerSaveModeReceiver";
    private static boolean isBatteryLow;
    private static boolean isPowerSaving;

    private static boolean getBooleanSetting(Context context, String str) {
        String string = System.getString(context.getContentResolver(), str);
        return string != null && string.equals("1");
    }

    private static boolean getExtraPowerSaving(Context context) {
        if (getBooleanSetting(context, "user_powersaver_enable")) {
            return true;
        }
        String string = System.getString(context.getContentResolver(), "powersaving_switch");
        Object obj = (string == null || string.equals("")) ? null : 1;
        return (obj == null && getBooleanSetting(context, "psm_switch")) || getBooleanSetting(context, "powersaving_switch");
    }

    @TargetApi(21)
    private static boolean getNativePowerSaving(Context context) {
        return ((PowerManager) context.getSystemService("power")).isPowerSaveMode();
    }

    public static void initAndSend(final Activity activity) {
        sendPowerSaving(activity);
        if (VERSION.SDK_INT >= 16) {
            activity.getContentResolver().registerContentObserver(System.CONTENT_URI, true, new ContentObserver(null) {
                @TargetApi(16)
                public void onChange(boolean z, Uri uri) {
                    super.onChange(z, uri);
                    String path = uri.getPath();
                    if (path != null) {
                        path = path.substring(path.lastIndexOf("/") + 1, path.length());
                        if (path.equals("user_powersaver_enable") || path.equals("psm_switch") || path.equals("powersaving_switch")) {
                            PowerSaveModeReceiver.sendPowerSaving(activity);
                        }
                    }
                }
            });
        }
    }

    private static void sendPowerSaving(Context context) {
        if (VERSION.SDK_INT >= 21) {
            isPowerSaving = getNativePowerSaving(context);
        } else {
            isPowerSaving = getExtraPowerSaving(context);
        }
        if (PpssppActivity.libraryLoaded) {
            try {
                if (!isBatteryLow) {
                    if (!isPowerSaving) {
                        NativeApp.sendMessage("core_powerSaving", "false");
                        return;
                    }
                }
                NativeApp.sendMessage("core_powerSaving", "true");
            } catch (Exception e) {
                String str = TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Exception in sendPowerSaving: ");
                stringBuilder.append(e.toString());
                Log.e(str, stringBuilder.toString());
            }
            return;
        }
        Log.e(TAG, "Cannot send power saving: Library not loaded");
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.intent.action.BATTERY_LOW")) {
            isBatteryLow = true;
        } else if (action.equals("android.intent.action.BATTERY_OKAY")) {
            isBatteryLow = false;
        }
        sendPowerSaving(context);
    }
}
