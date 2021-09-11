package org.ppsspp.ppsspp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.graphics.Typeface;
import android.content.ClipData;
import android.content.ClipboardManager;
import me.ibrahimsn.particle.*;
import org.jetbrains.kotlin.*;
import arabware.libs.getThumbnail.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class IniActivity extends AppCompatActivity {
	
	private FloatingActionButton _fab;
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout mod;
	private ImageView imageview1;
	private ImageView imageview2;
	private ImageView imageview3;
	private ImageView imageview5;
	private ImageView imageview7;
	private ImageView imageview6;
	private ImageView imageview8;
	private ScrollView vscroll1;
	private LinearLayout editor;
	private LineNumberedEditText hsimod;
	private LinearLayout linear7;
	private TextView textview49;
	private TextView textview50;
	private TextView textview54;
	private TextView textview51;
	private TextView textview52;
	private TextView textview53;
	private TextView textview55;
	private TextView textview56;
	private TextView textview57;
	private TextView textview58;
	private TextView textview59;
	private TextView textview60;
	private TextView textview61;
	private TextView textview62;
	private TextView textview63;
	private TextView textview64;
	
	private Intent Filemanger = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.ini);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_fab = findViewById(R.id._fab);
		
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		mod = findViewById(R.id.mod);
		imageview1 = findViewById(R.id.imageview1);
		imageview2 = findViewById(R.id.imageview2);
		imageview3 = findViewById(R.id.imageview3);
		imageview5 = findViewById(R.id.imageview5);
		imageview7 = findViewById(R.id.imageview7);
		imageview6 = findViewById(R.id.imageview6);
		imageview8 = findViewById(R.id.imageview8);
		vscroll1 = findViewById(R.id.vscroll1);
		editor = findViewById(R.id.editor);
		hsimod = findViewById(R.id.hsimod);
		linear7 = findViewById(R.id.linear7);
		textview49 = findViewById(R.id.textview49);
		textview50 = findViewById(R.id.textview50);
		textview54 = findViewById(R.id.textview54);
		textview51 = findViewById(R.id.textview51);
		textview52 = findViewById(R.id.textview52);
		textview53 = findViewById(R.id.textview53);
		textview55 = findViewById(R.id.textview55);
		textview56 = findViewById(R.id.textview56);
		textview57 = findViewById(R.id.textview57);
		textview58 = findViewById(R.id.textview58);
		textview59 = findViewById(R.id.textview59);
		textview60 = findViewById(R.id.textview60);
		textview61 = findViewById(R.id.textview61);
		textview62 = findViewById(R.id.textview62);
		textview63 = findViewById(R.id.textview63);
		textview64 = findViewById(R.id.textview64);
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((EditText)hsimod).selectAll();
				SketchwareUtil.showMessage(getApplicationContext(), "Select All Text");
			}
		});
		
		imageview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Filemanger.setClass(getApplicationContext(), FilesActivity.class);
				startActivity(Filemanger);
				SketchwareUtil.showMessage(getApplicationContext(), "Context Files How To Set (ini File)");
			}
		});
		
		imageview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				hsimod.setText("");
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", hsimod.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Cut Text".concat(hsimod.getText().toString()));
			}
		});
		
		imageview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", hsimod.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Cupied!!!!");
			}
		});
		
		imageview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((android.content.ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).addPrimaryClipChangedListener(new android.content.ClipboardManager.OnPrimaryClipChangedListener() {
					public void onPrimaryClipChanged() {
						
						android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(CLIPBOARD_SERVICE); 
						String clip = clipboard.getText().toString();
						hsimod.setText(clip);
						
					}
				});
				
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (getIntent().getStringExtra("save").equals("empty")) {
					
				}
				else {
					FileUtil.writeFile(getIntent().getStringExtra("save"), hsimod.getText().toString());
					SketchwareUtil.showMessage(getApplicationContext(), "saved");
				}
			}
		});
	}
	
	private void initializeLogic() {
		hsimod.setText(getIntent().getStringExtra("file"));
		hsimod.setTextColor(0xFFFFFFFF);
		hsimod.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gow.ttf"), 1);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		
	}
	public void _Pastme() {
	}
	public void past(View v){
		
		    String selected = hsimod.getText().toString().substring(hsimod.getSelectionStart(), hsimod.getSelectionEnd());
		    
		    TextView t = (TextView)v;
		    
		    String text = t.getText().toString();
		    
		    if (selected.length() >0){
			      Editable e = hsimod.getText();
			      int start = hsimod.getSelectionStart();
			      int end = hsimod.getSelectionEnd();
			      if (end > 0){
				        e.replace(Math.min(start, end), Math.max(start, end), text);
				        
				      }
			    } else {
			      hsimod.getText().insert(hsimod.getSelectionStart(), text);
			    }
		
		  }
	  {
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