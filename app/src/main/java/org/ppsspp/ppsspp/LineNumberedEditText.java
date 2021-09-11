package org.ppsspp.ppsspp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;


/**

com.my.newproject8.LineNumberedEditText

							        
     android:layout_width="match_parent"						
							android:focusableInTouchMode="true"
							android:focusedByDefault="true"
							android:gravity="left|top"															
							android:textColorHighlight="#FF055F09"
					 				
							
 **/



public class LineNumberedEditText extends EditText
{
    private final Context context;
    private Rect rect;
    private Paint paint;

    public LineNumberedEditText(Context context)
    {
        super(context);
        this.context = context;
        init();
    }

    public LineNumberedEditText(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        this.context = context;
        init();
    }

    public LineNumberedEditText(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        this.context=context;
        init();
    }

    private void init()
    {
        rect = new Rect();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        paint.setTextSize(18);
        paint.setTypeface(Typeface.SERIF);
    }


    @Override
    protected void onDraw(Canvas canvas) {

        int baseline;
        int lineCount = getLineCount();
        int lineNumber = 1;

        for (int i = 0; i < lineCount; ++i)
        {
            baseline=getLineBounds(i, null);
            if (i == 0)
            {
                canvas.drawText(""+lineNumber, rect.left, baseline, paint);
                ++lineNumber;
            }
            else if (getText().charAt(getLayout().getLineStart(i) - 1) == '\n')
            {
                canvas.drawText(""+lineNumber, rect.left, baseline, paint);
                ++lineNumber;
            }
        }


// for setting edittext start padding
        if(lineCount<100)
        {
            setPadding(30,getPaddingTop(),getPaddingRight(),getPaddingBottom());
        
		}

else if(lineCount>100 && lineCount<1000)
{
		
            setPadding(60,getPaddingTop(),getPaddingRight(),getPaddingBottom());
        
		}
else if(lineCount>1000 && lineCount<10000)
{
           
		    setPadding(100,getPaddingTop(),getPaddingRight(),getPaddingBottom());
        
		}
 else if(lineCount>10000 && lineCount<100000)
 {
            
			setPadding(70,getPaddingTop(),getPaddingRight(),getPaddingBottom());
        
		}

        super.onDraw(canvas);
    }
}






