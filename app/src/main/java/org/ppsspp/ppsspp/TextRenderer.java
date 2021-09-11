package org.ppsspp.ppsspp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Typeface;
import android.util.Log;

public class TextRenderer {
    private static final String TAG = "TextRenderer";
    private static Paint bg = new Paint();
    private static Paint p = new Paint(129);
    private static Typeface robotoCondensed;

    static {
        p.setColor(-1);
        bg.setColor(-16777216);
    }

    public static void init(Context context) {
        robotoCondensed = Typeface.createFromAsset(context.getAssets(), "Roboto-Condensed.ttf");
        if (robotoCondensed != null) {
            Log.i(TAG, "Successfully loaded Roboto Condensed");
            p.setTypeface(robotoCondensed);
            return;
        }
        Log.e(TAG, "Failed to load Roboto Condensed");
    }

    private static Point measure(String str, double d) {
        String[] split = str.replaceAll("\\r", "").split("\n");
        Point point = new Point();
        int i = 0;
        point.x = 0;
        int length = split.length;
        while (i < length) {
            point.x = Math.max(measureLine(split[i], d).x, point.x);
            i++;
        }
        point.y = (((int) (p.descent() - p.ascent())) * split.length) + 2;
        if (point.x < 1) {
            point.x = 1;
        }
        if (point.y < 1) {
            point.y = 1;
        }
        if (point.x > 2048) {
            point.x = 2048;
        }
        if (point.y > 2048) {
            point.y = 2048;
        }
        return point;
    }

    private static Point measureLine(String str, double d) {
        int measureText;
        if (str.length() > 0) {
            p.setTextSize((float) d);
            measureText = (((int) p.measureText(str)) + 5) & -2;
        } else {
            measureText = 1;
        }
        int descent = (int) ((p.descent() - p.ascent()) + 2.0f);
        Point point = new Point();
        point.x = measureText;
        point.y = descent;
        return point;
    }

    public static int measureText(String str, double d) {
        Point measure = measure(str, d);
        return measure.y | (measure.x << 16);
    }

    public static int[] renderText(String str, double d) {
        Point measure = measure(str, d);
        int i = measure.x;
        int i2 = measure.y;
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawRect(0.0f, 0.0f, (float) i, (float) i2, bg);
        float f = 1.0f;
        for (String str2 : str.replaceAll("\\r", "").split("\n")) {
            if (str2.length() > 0) {
                canvas.drawText(str2, 1.0f, (-p.ascent()) + f, p);
            }
            f += p.descent() - p.ascent();
        }
        int[] iArr = new int[(i * i2)];
        createBitmap.getPixels(iArr, 0, i, 0, 0, i, i2);
        createBitmap.recycle();
        return iArr;
    }
}
