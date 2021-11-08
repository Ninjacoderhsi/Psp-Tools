package org.ppsspp.ppsspp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.CheckBox;
import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.CompoundButton;
import org.jetbrains.kotlin.*;
import io.github.rosemoe.sora.langs.textmate.*;
import io.github.rosemoe.sora.textmate.core.*;
import io.github.rosemoe.sora.textmate.languageconfiguration.*;
import arabware.libs.getThumbnail.*;
import org.antlr.v4.runtime.*;
import me.ibrahimsn.particle.*;
import io.github.rosemoe.sora.*;
import javaxml.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;

public class SettingppssppActivity extends AppCompatActivity {
	
	private LinearLayout background;
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private LinearLayout linear4;
	private LinearLayout linear3;
	private LinearLayout animator;
	private LinearLayout pngajpg;
	private TextView textview1;
	private EditText edittext1;
	private CheckBox checkbox1;
	private CheckBox checkbox2;
	
	private SharedPreferences d;
	private SharedPreferences img;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.settingppsspp);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		background = findViewById(R.id.background);
		vscroll1 = findViewById(R.id.vscroll1);
		linear2 = findViewById(R.id.linear2);
		linear4 = findViewById(R.id.linear4);
		linear3 = findViewById(R.id.linear3);
		animator = findViewById(R.id.animator);
		pngajpg = findViewById(R.id.pngajpg);
		textview1 = findViewById(R.id.textview1);
		edittext1 = findViewById(R.id.edittext1);
		checkbox1 = findViewById(R.id.checkbox1);
		checkbox2 = findViewById(R.id.checkbox2);
		d = getSharedPreferences("d", Activity.MODE_PRIVATE);
		img = getSharedPreferences("img", Activity.MODE_PRIVATE);
		
		//OnTouch
		linear2.setOnTouchListener(new View.OnTouchListener(){
				@Override
				public boolean onTouch(View v, MotionEvent event){
						int ev = event.getAction();
						switch (ev) {
								case MotionEvent.ACTION_DOWN:
								
								 
								
								break;
								case MotionEvent.ACTION_UP:
								
								 
								
								break;
						} return true;
				}
		});
		
		checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					checkbox1.setText("انیمیشن روشن");
					d.edit().putString("ani", "1").commit();
				}
				else {
					checkbox1.setText("انیمیشن خاموش");
					d.edit().putString("ani", "2").commit();
				}
			}
		});
		
		checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					img.edit().putString("i1", "onimg").commit();
					checkbox2.setText("پنجره شناور روشن");
				}
				else {
					img.edit().putString("i1", "offimg").commit();
					checkbox2.setText("پنجره شناور خاموش");
				}
			}
		});
	}
	
	private void initializeLogic() {
		
		//////color
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			SketchUi.setColor(0xFFFFFFFF);pngajpg.setElevation(getDip(5));
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE0E0E0}), SketchUi, null);
			pngajpg.setBackground(SketchUi_RD);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			SketchUi.setColor(0xFFFFFFFF);animator.setElevation(getDip(5));
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE0E0E0}), SketchUi, null);
			animator.setBackground(SketchUi_RD);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			SketchUi.setColor(0xFFFFFFFF);linear3.setElevation(getDip(5));
			android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE0E0E0}), SketchUi, null);
			linear3.setBackground(SketchUi_RD);
		}
		try{
			if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { 
				Window w = this.getWindow();w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
				w.setStatusBarColor(0xFF222629); w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); }
		}catch(Exception e){
			 
		}
		animator.setVisibility(View.GONE);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		if (d.getString("ani", "").equals("1")) {
			checkbox1.setChecked(true);
		}
		else {
			checkbox1.setChecked(false);
		}
		if (img.getString("i1", "").equals("onimg")) {
			checkbox2.setChecked(true);
		}
		else {
			checkbox2.setChecked(false);
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}