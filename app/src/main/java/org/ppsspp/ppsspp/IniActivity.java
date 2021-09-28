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
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import me.ibrahimsn.particle.*;
import arabware.libs.getThumbnail.*;
import io.github.rosemoe.editor.*;
import org.jetbrains.kotlin.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import io.github.rosemoe.editor.widget.CodeEditor;
import io.github.rosemoe.editor.widget.EditorColorScheme;
import io.github.rosemoe.editor.widget.schemes.SchemeNotepadXX;
import io.github.rosemoe.editor.widget.schemes.SchemeDarcula;
import io.github.rosemoe.editor.widget.schemes.SchemeVS2019;

public class IniActivity extends AppCompatActivity {
	
	private FloatingActionButton _fab;
	
	private LinearLayout linear1;
	private LinearLayout mod;
	private LinearLayout linear2;
	private CodeEditor ninjacoder;
	private ImageView text_undo;
	private ImageView text_redo;
	private ImageView selectall;
	private ImageView addfile;
	
	private Intent Filemanger = new Intent();
	private SharedPreferences cred;
	private SharedPreferences cpink;
	
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
		mod = findViewById(R.id.mod);
		linear2 = findViewById(R.id.linear2);
		ninjacoder = findViewById(R.id.ninjacoder);
		text_undo = findViewById(R.id.text_undo);
		text_redo = findViewById(R.id.text_redo);
		selectall = findViewById(R.id.selectall);
		addfile = findViewById(R.id.addfile);
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
				((io.github.rosemoe.editor.widget.CodeEditor)ninjacoder).selectAll();
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
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
		/////hsimod.setHorizontallyScrolling(true);
		ninjacoder.setTypefaceText(Typeface.MONOSPACE);
		
		ninjacoder.setOverScrollEnabled(true);
		
		////////ninjacoder.setEditorLanguage(new JavaLanguage());
		
		///////////ninjacoder.setEditorLanguage(new BaseLanguage());
		
		ninjacoder.setTextSize(18);
		
		int nightModeFlags = getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK;
		if (nightModeFlags == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
				//////1
			ninjacoder.setColorScheme(new SchemeDarcula());
		} else {
			ninjacoder.setColorScheme(new SchemeVS2019());
			
				/////3
		};
		StringBuilder stringBuilder = new StringBuilder();
		
		try {
			
			Scanner scanner = new Scanner(new java.io.File(getIntent().getStringExtra("file"))).useDelimiter("\\Z");
			while (scanner.hasNext()) {
				stringBuilder .append(scanner.next());
			}
			ninjacoder.setText(stringBuilder );
		} catch (Exception rt) {
			rt.printStackTrace();
		}
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { Window w = getWindow();  w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); };
		getWindow().setNavigationBarColor(Color.parseColor("#7cf7fff7"));
	}
	
	@Override
	public void onStart() {
		super.onStart();
		text_undo.setImageResource(R.drawable.editor_undo);
		text_redo.setImageResource(R.drawable.editor_redo);
		selectall.setImageResource(R.drawable.editor_selectall);
		addfile.setImageResource(R.drawable.editor_notebookplus);
		_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("0xFF011231".replace("0xFF" , "#"))));
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