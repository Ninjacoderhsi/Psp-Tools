package org.ppsspp.ppsspp;

import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;

public class PpssppActivity extends NativeActivity {
    public static final String SHORTCUT_EXTRA_KEY = "org.ppsspp.ppsspp.Shortcuts";
    private static final String TAG = "PpssppActivity";
    public static boolean libraryLoaded;
    private static boolean m_hasNoNativeBinary;
    private static boolean m_hasUnsupportedABI;

    static {
        CheckABIAndLoadLibrary();
    }

    public static void CheckABIAndLoadLibrary() {
        if (Build.CPU_ABI.equals("armeabi")) {
            m_hasUnsupportedABI = true;
            return;
        }
        try {
            System.loadLibrary("ppsspp_jni");
            libraryLoaded = true;
        } catch (UnsatisfiedLinkError e) {
            String str = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("LoadLibrary failed, UnsatifiedLinkError: ");
            stringBuilder.append(e.toString());
            Log.e(str, stringBuilder.toString());
            m_hasNoNativeBinary = true;
        }
    }

    public void onCreate(Bundle bundle) {
        if (!m_hasUnsupportedABI) {
            if (!m_hasNoNativeBinary) {
                Intent intent = getIntent();
                String path;
                String str;
                StringBuilder stringBuilder;
                if (intent.getData() != null) {
                    path = intent.getData().getPath();
                    str = TAG;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Found Shortcut Parameter in data: ");
                    stringBuilder.append(path);
                    Log.i(str, stringBuilder.toString());
                    super.setShortcutParam(path);
                } else {
                    path = getIntent().getStringExtra(SHORTCUT_EXTRA_KEY);
                    Log.e(TAG, "Got ACTION_VIEW without a valid uri, trying param");
                    if (path != null) {
                        str = TAG;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("Found Shortcut Parameter in extra-data: ");
                        stringBuilder.append(path);
                        Log.i(str, stringBuilder.toString());
                        super.setShortcutParam(getIntent().getStringExtra(SHORTCUT_EXTRA_KEY));
                    } else {
                        Log.e(TAG, "Shortcut missing parameter!");
                    }
                }
                super.onCreate(bundle);
                return;
            }
        }
        new Thread() {
            public void run() {
                Looper.prepare();
                Builder builder = new Builder(PpssppActivity.this);
                StringBuilder stringBuilder;
                if (PpssppActivity.m_hasUnsupportedABI) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(Build.CPU_ABI);
                    stringBuilder.append(" target is not supported.");
                    builder.setMessage(stringBuilder.toString()).setTitle("Error starting PPSSPP").create().show();
                } else {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("The native part of PPSSPP for ABI ");
                    stringBuilder.append(Build.CPU_ABI);
                    stringBuilder.append(" is missing. Try downloading an official build?");
                    builder.setMessage(stringBuilder.toString()).setTitle("Error starting PPSSPP").create().show();
                }
                Looper.loop();
            }
        }.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(-1);
    }

    public void postCommand(final String str, final String str2) {
        runOnUiThread(new Runnable() {
            public void run() {
                PpssppActivity.this.processCommand(str, str2);
            }
        });
    }
}
