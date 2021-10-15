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
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import io.github.rosemoe.sora.*;
import me.ibrahimsn.particle.*;
import org.antlr.v4.runtime.*;
import org.jetbrains.kotlin.*;
import io.github.rosemoe.sora.langs.base.*;
import io.github.rosemoe.sora.langs.css3.*;
import io.github.rosemoe.sora.langs.html.*;
import io.github.rosemoe.sora.langs.java.*;
import io.github.rosemoe.sora.langs.python.*;
import io.github.rosemoe.sora.langs.universal.*;
import arabware.libs.getThumbnail.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import io.github.rosemoe.sora.widget.CodeEditor;
import io.github.rosemoe.sora.langs.EmptyLanguage;
import io.github.rosemoe.sora.langs.desc.CDescription;
import io.github.rosemoe.sora.langs.desc.CppDescription;
import io.github.rosemoe.sora.langs.desc.JavaScriptDescription;
import io.github.rosemoe.sora.langs.html.HTMLLanguage;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import io.github.rosemoe.sora.langs.python.PythonLanguage;
import io.github.rosemoe.sora.langs.universal.UniversalLanguage;
import io.github.rosemoe.sora.widget.schemes.HTMLScheme;
import io.github.rosemoe.sora.widget.schemes.SchemeDarcula;
import io.github.rosemoe.sora.widget.schemes.SchemeEclipse;
import io.github.rosemoe.sora.widget.schemes.SchemeGitHub;
import io.github.rosemoe.sora.widget.schemes.SchemeNotepadXX;
import io.github.rosemoe.sora.widget.schemes.SchemeVS2019;


public class IniActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private FloatingActionButton _fab;
	private String inipath = "";
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private CodeEditor ninjacoder;
	private HorizontalScrollView hscroll1;
	private LinearLayout searchbar;
	private ImageView text_undo;
	private ImageView text_redo;
	private ImageView selectall;
	private ImageView addfile;
	private ImageView imageview1;
	private SymbolInputView sysbar;
	private EditText serach;
	private EditText reaplsellall;
	private Button button1;
	
	private Intent Filemanger = new Intent();
	private SharedPreferences cred;
	private SharedPreferences cpink;
	private ProgressDialog tet;
	private TimerTask tt;
	
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
		ninjacoder = findViewById(R.id.ninjacoder);
		hscroll1 = findViewById(R.id.hscroll1);
		searchbar = findViewById(R.id.searchbar);
		text_undo = findViewById(R.id.text_undo);
		text_redo = findViewById(R.id.text_redo);
		selectall = findViewById(R.id.selectall);
		addfile = findViewById(R.id.addfile);
		imageview1 = findViewById(R.id.imageview1);
		sysbar = findViewById(R.id.sysbar);
		serach = findViewById(R.id.serach);
		reaplsellall = findViewById(R.id.reaplsellall);
		button1 = findViewById(R.id.button1);
		cred = getSharedPreferences("cred", Activity.MODE_PRIVATE);
		cpink = getSharedPreferences("cpink", Activity.MODE_PRIVATE);
		
		text_undo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ninjacoder.undo();
			}
		});
		
		text_redo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ninjacoder.redo();
			}
		});
		
		selectall.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((io.github.rosemoe.sora.widget.CodeEditor)ninjacoder).selectAll();
				SketchwareUtil.showMessage(getApplicationContext(), "Select All Text");
			}
		});
		
		addfile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Filemanger.setClass(getApplicationContext(), FilesActivity.class);
				startActivity(Filemanger);
				SketchwareUtil.showMessage(getApplicationContext(), "Context Files How To Set (ini File)");
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				searchbar.setVisibility(View.VISIBLE);
			}
		});
		
		serach.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				ninjacoder.getSearcher().search(_charSeq);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (reaplsellall.getVisibility() == View.GONE) {
					reaplsellall.setVisibility(View.VISIBLE);
				}
				else {
					if (reaplsellall.getText().toString().length() > 0) {
						try {
							            ninjacoder.getSearcher().replaceAll(reaplsellall.getText().toString());
							        } catch (IllegalStateException e) {
							            e.printStackTrace();
							        }
						searchbar.setVisibility(View.GONE);
					}
				}
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (getIntent().getStringExtra("save").equals("empty")) {
					
				}
				else {
					FileUtil.writeFile(getIntent().getStringExtra("save"), ninjacoder.getText().toString());
					SketchwareUtil.showMessage(getApplicationContext(), "saved");
				}
			}
		});
	}
	
	private void initializeLogic() {
		try{
			getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
			searchbar.setVisibility(View.GONE);
			ninjacoder.setTypefaceText(Typeface.MONOSPACE);
			
			ninjacoder.setTextSize(18);
			
			SymbolInputView inputView = findViewById(R.id.sysbar);
			
			        inputView.bindEditor(ninjacoder);
			        inputView.addSymbols(new String[]{"->", "{", "}", "(", ")", "<" , ">" ,  ",", ".", ";", "\"", "?", "+", "-", "*", "/"},
			                new String[]{"\t", "{}", "}", "(", ")", ",", ".", ";", "\"", "?", "+", "-", "*", "/"});
			
		}catch(Exception e){
			 
		}
		/////hsimod.setHorizontallyScrolling(true);
		StringBuilder gini = new StringBuilder();
		
		try {
			
			Scanner scanner = new Scanner(new java.io.File(getIntent().getStringExtra("file"))).useDelimiter("\\Z");
			while (scanner.hasNext()) {
				gini .append(scanner.next());
			}
			ninjacoder.setText(gini );
		} catch (Exception rt) {
			rt.printStackTrace();
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		text_undo.setImageResource(R.drawable.editor_undo);
		text_redo.setImageResource(R.drawable.editor_redo);
		selectall.setImageResource(R.drawable.editor_selectall);
		addfile.setImageResource(R.drawable.editor_notebookplus);
		imageview1.setImageResource(R.drawable.more);
		int nightModeFlags = getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK;
		if (nightModeFlags == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
				//////1
			serach.setTextColor(0xFFFFFFFF);
			reaplsellall.setTextColor(0xFFFFFFFF);
			button1.setTextColor(0xFFFFFFFF);
			serach.setHintTextColor(0xFFEF5350);
			reaplsellall.setHintTextColor(0xFFEF5350);
			//////color dark mod on
			{
				android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
				SketchUi.setColor(0xFF1E1E1E);SketchUi.setCornerRadius(getDip(4));
				serach.setElevation(getDip(2));
				serach.setBackground(SketchUi);
			}
			{
				android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
				SketchUi.setColor(0xFF1E1E1E);SketchUi.setCornerRadius(getDip(4));
				reaplsellall.setElevation(getDip(2));
				reaplsellall.setBackground(SketchUi);
			}
			{
				android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
				SketchUi.setColor(0xFF424242);SketchUi.setCornerRadius(getDip(4));
				button1.setElevation(getDip(2));
				button1.setBackground(SketchUi);
			}
			_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("0xFF011231".replace("0xFF" , "#"))));
		} else {
			serach.setHintTextColor(0xFFBDBDBD);
			reaplsellall.setHintTextColor(0xFFBDBDBD);
			serach.setTextColor(0xFF000000);
			reaplsellall.setTextColor(0xFF000000);
			button1.setTextColor(0xFF000000);
			////colordarkmod off
			{
				android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
				SketchUi.setColor(0xFFEEEEEE);SketchUi.setCornerRadius(getDip(4));
				serach.setElevation(getDip(2));
				serach.setBackground(SketchUi);
			}
			{
				android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
				SketchUi.setColor(0xFFEEEEEE);SketchUi.setCornerRadius(getDip(4));
				reaplsellall.setElevation(getDip(2));
				reaplsellall.setBackground(SketchUi);
			}
			{
				android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
				SketchUi.setColor(0xFFF5F5F5);SketchUi.setCornerRadius(getDip(4));
				button1.setElevation(getDip(2));
				button1.setBackground(SketchUi);
			}
			_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("0xFFEEEEEE".replace("0xFF" , "#"))));
			
				/////3
		};
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
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