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
import com.google.android.material.button.*;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
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

public class DebugActivity extends AppCompatActivity {
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private ScrollView vscroll1;
	private MaterialButton materialbutton1;
	private ImageView imageview1;
	private TextView textview1;
	private LinearLayout linear3;
	private TextView textview2;
	
	private Intent nova = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.debug);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		vscroll1 = findViewById(R.id.vscroll1);
		materialbutton1 = findViewById(R.id.materialbutton1);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		linear3 = findViewById(R.id.linear3);
		textview2 = findViewById(R.id.textview2);
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				nova.setClass(getApplicationContext(), FilesActivity.class);
				startActivity(nova);
			}
		});
	}
	
	private void initializeLogic() {
		textview2.setText(getIntent().getStringExtra("error"));
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