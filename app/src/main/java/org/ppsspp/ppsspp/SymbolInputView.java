package org.ppsspp.ppsspp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import io.github.rosemoe.editor.widget.CodeEditor;
import io.github.rosemoe.editor.widget.SymbolChannel;
import android.view.*;
import android.view.View.*;
import android.text.*;
import android.text.style.*;

public class SymbolInputView extends LinearLayout {


    public SymbolInputView(Context context) {
        super(context);
     setBackgroundColor(Color.TRANSPARENT);
        setOrientation(HORIZONTAL);
    }

    public SymbolInputView(Context context, AttributeSet attrs) {
        super(context, attrs);
   setBackgroundColor(Color.TRANSPARENT);
        setOrientation(HORIZONTAL);
    }

    public SymbolInputView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
  setBackgroundColor(Color.TRANSPARENT);
        setOrientation(HORIZONTAL);
    }

    public SymbolInputView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
          setBackgroundColor(Color.TRANSPARENT);
        setOrientation(HORIZONTAL);
    }

    private SymbolChannel channel;

    public void bindEditor(CodeEditor editor) {
        channel = editor.createNewSymbolChannel();
    }

    public void removeSymbols() {
        removeAllViews();
    }


    public void addSymbols(String[] display, final String[] insertText) {
        int count = Math.max(display.length, insertText.length);
		
        for (int i = 0; i < count; i++) {
           final Button btn = new Button(getContext(), null, android.R.attr.buttonStyleSmall);
            btn.setText(display[i]);
			btn.setTypeface(null, android.graphics.Typeface.BOLD);
			btn.setTextColor(0xFFF44336);
			btn.setTextSize(15);
            btn.setBackground(new ColorDrawable(0));
            addView(btn, new LinearLayout.LayoutParams(-2, -1));
             final int finalI = i;
            
			btn.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View view) {

channel.insertSymbol(btn.getText().toString(), 1);
          
					}
				});
        }
    }

}