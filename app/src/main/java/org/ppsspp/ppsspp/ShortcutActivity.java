package org.ppsspp.ppsspp;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import java.io.File;
import org.ppsspp.ppsspp.SimpleFileChooser.FileSelectedListener;

public class ShortcutActivity extends Activity {
    private static final String TAG = "pspgetx plungin";
    private FileSelectedListener onFileSelectedListener = new FileSelectedListener() {
        public void onFileSelected(File file) {
            ShortcutActivity.this.respondToShortcutRequest(file.getAbsolutePath());
        }
    };

    public static native String queryGameName(String str);

    private void respondToShortcutRequest(String str) {
        Intent intent = new Intent(this, PpssppActivity.class);
        Uri fromFile = Uri.fromFile(new File(str));
        String str2 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Shortcut URI: ");
        stringBuilder.append(fromFile.toString());
        Log.i(str2, stringBuilder.toString());
        intent.setData(fromFile);
        intent.putExtra("org.ppsspp.ppsspp.Shortcuts", str);
        PpssppActivity.CheckABIAndLoadLibrary();
        str = queryGameName(str);
        if (str.equals("")) {
            showBadGameMessage();
            return;
        }
        Intent intent2 = new Intent();
        intent2.putExtra("android.intent.extra.shortcut.INTENT", intent);
        intent2.putExtra("android.intent.extra.shortcut.NAME", str);
        intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(this, 2130903041));
        setResult(-1, intent2);
        finish();
    }

    private void showBadGameMessage() {
        new Thread() {
            public void run() {
                Looper.prepare();
                Builder builder = new Builder(ShortcutActivity.this);
                builder.setMessage(ShortcutActivity.this.getResources().getString(2130968577));
                builder.setTitle(ShortcutActivity.this.getResources().getString(2130968578));
                builder.create().show();
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

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        new SimpleFileChooser(this, Environment.getExternalStorageDirectory(), this.onFileSelectedListener).showDialog();
    }
}
