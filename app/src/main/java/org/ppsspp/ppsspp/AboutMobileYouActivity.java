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
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
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

public class AboutMobileYouActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout linear22;
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear6;
	private LinearLayout linear8;
	private LinearLayout linear21;
	private TextView textview1;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private TextView textview2;
	private TextView jam;
	private TextView tanggal;
	private TextView textview5;
	private TextView textview6;
	private TextView brand;
	private TextView textview8;
	private LinearLayout linearbattery;
	private LinearLayout linear19;
	private LinearLayout line1;
	private LinearLayout line2;
	private LinearLayout line3;
	private LinearLayout line4;
	private LinearLayout line5;
	private LinearLayout line6;
	private TextView persen1;
	private TextView textview32;
	private TextView persen2;
	private TextView peringatan;
	private TextView textview10;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private LinearLayout linear15;
	private LinearLayout linear16;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private LinearLayout linear20;
	private TextView textview11;
	private TextView textview12;
	private TextView serial;
	private TextView textview14;
	private TextView textview15;
	private TextView product;
	private TextView textview16;
	private TextView textview17;
	private TextView id;
	private TextView textview18;
	private TextView textview19;
	private TextView version;
	private TextView type;
	private TextView textview21;
	private TextView user;
	private TextView textview22;
	private TextView textview23;
	private TextView cpu;
	private TextView textview24;
	private TextView textview25;
	private TextView host;
	private TextView textview26;
	private TextView textview27;
	private TextView hardware;
	private TextView textview28;
	private TextView textview29;
	private TextView fingerprint;
	private TextView textview30;
	private TextView textview31;
	private TextView display;
	private TextView textview33;
	private TextView textview34;
	private TextView realease;
	
	private Calendar c = Calendar.getInstance();
	private TimerTask t;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.about_mobile_you);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear22 = findViewById(R.id.linear22);
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		linear6 = findViewById(R.id.linear6);
		linear8 = findViewById(R.id.linear8);
		linear21 = findViewById(R.id.linear21);
		textview1 = findViewById(R.id.textview1);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		textview2 = findViewById(R.id.textview2);
		jam = findViewById(R.id.jam);
		tanggal = findViewById(R.id.tanggal);
		textview5 = findViewById(R.id.textview5);
		textview6 = findViewById(R.id.textview6);
		brand = findViewById(R.id.brand);
		textview8 = findViewById(R.id.textview8);
		linearbattery = findViewById(R.id.linearbattery);
		linear19 = findViewById(R.id.linear19);
		line1 = findViewById(R.id.line1);
		line2 = findViewById(R.id.line2);
		line3 = findViewById(R.id.line3);
		line4 = findViewById(R.id.line4);
		line5 = findViewById(R.id.line5);
		line6 = findViewById(R.id.line6);
		persen1 = findViewById(R.id.persen1);
		textview32 = findViewById(R.id.textview32);
		persen2 = findViewById(R.id.persen2);
		peringatan = findViewById(R.id.peringatan);
		textview10 = findViewById(R.id.textview10);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		linear12 = findViewById(R.id.linear12);
		linear13 = findViewById(R.id.linear13);
		linear14 = findViewById(R.id.linear14);
		linear15 = findViewById(R.id.linear15);
		linear16 = findViewById(R.id.linear16);
		linear17 = findViewById(R.id.linear17);
		linear18 = findViewById(R.id.linear18);
		linear20 = findViewById(R.id.linear20);
		textview11 = findViewById(R.id.textview11);
		textview12 = findViewById(R.id.textview12);
		serial = findViewById(R.id.serial);
		textview14 = findViewById(R.id.textview14);
		textview15 = findViewById(R.id.textview15);
		product = findViewById(R.id.product);
		textview16 = findViewById(R.id.textview16);
		textview17 = findViewById(R.id.textview17);
		id = findViewById(R.id.id);
		textview18 = findViewById(R.id.textview18);
		textview19 = findViewById(R.id.textview19);
		version = findViewById(R.id.version);
		type = findViewById(R.id.type);
		textview21 = findViewById(R.id.textview21);
		user = findViewById(R.id.user);
		textview22 = findViewById(R.id.textview22);
		textview23 = findViewById(R.id.textview23);
		cpu = findViewById(R.id.cpu);
		textview24 = findViewById(R.id.textview24);
		textview25 = findViewById(R.id.textview25);
		host = findViewById(R.id.host);
		textview26 = findViewById(R.id.textview26);
		textview27 = findViewById(R.id.textview27);
		hardware = findViewById(R.id.hardware);
		textview28 = findViewById(R.id.textview28);
		textview29 = findViewById(R.id.textview29);
		fingerprint = findViewById(R.id.fingerprint);
		textview30 = findViewById(R.id.textview30);
		textview31 = findViewById(R.id.textview31);
		display = findViewById(R.id.display);
		textview33 = findViewById(R.id.textview33);
		textview34 = findViewById(R.id.textview34);
		realease = findViewById(R.id.realease);
	}
	
	private void initializeLogic() {
		textview5.setText(Build.MANUFACTURER.concat(" ".concat(Build.MODEL)));
		brand.setText(Build.BRAND);
		serial.setText(Build.SERIAL);
		product.setText(Build.PRODUCT);
		id.setText(Build.ID);
		version.setText(Build.VERSION.SDK);
		user.setText(Build.USER);
		cpu.setText(Build.CPU_ABI);
		host.setText(Build.HOST);
		hardware.setText(Build.HARDWARE);
		fingerprint.setText(Build.FINGERPRINT);
		display.setText(Build.DISPLAY);
		realease.setText(Build.VERSION.SECURITY_PATCH);
		_lengkungan(linear2, 10, "#E41C1A27", 0, 40, "#2c2b33");
		_lengkungan(linear4, 10, "#E41C1A27", 0, 40, "#2c2b33");
		_lengkungan(linear5, 10, "#E41C1A27", 0, 40, "#2c2b33");
		_lengkungan(linear6, 10, "#E41C1A27", 0, 40, "#2c2b33");
		_lengkungan(linear8, 10, "#E41C1A27", 0, 40, "#2c2b33");
		_lengkungan(linearbattery, 10, "#03bad9", 5, 100, "#00000000");
		////////
		/////////
		id.setTextIsSelectable(true);
		peringatan.setVisibility(View.GONE);
		tanggal.setText(new SimpleDateFormat("dd MMMM yyyy").format(c.getTime()));
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						c = Calendar.getInstance();
						jam.setText(new SimpleDateFormat("HH:mm:ss").format(c.getTime()));
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(t, (int)(0), (int)(1000));
		_battery(persen1);
		if (persen1.getText().toString().length() > 1) {
			persen2.setText(persen1.getText().toString().substring((int)(0), (int)(1)));
		}
		if (persen2.getText().toString().equals("9")) {
			line2.setBackgroundColor(0xFF03BAD9);
			line3.setBackgroundColor(0xFF03BAD9);
			line4.setBackgroundColor(0xFF03BAD9);
			line5.setBackgroundColor(0xFF03BAD9);
			_radius_4("#03bad9", "#03bad9", 0, 100, 0, 0, 100, line1);
			_radius_4("#03bad9", "#03bad9", 0, 0, 100, 100, 0, line6);
		}
		else {
			if (persen2.getText().toString().equals("8") || persen2.getText().toString().equals("7")) {
				line2.setBackgroundColor(0xFF03BAD9);
				line3.setBackgroundColor(0xFF03BAD9);
				line4.setBackgroundColor(0xFF03BAD9);
				line5.setBackgroundColor(0xFF03BAD9);
				_radius_4("#03bad9", "#03bad9", 0, 100, 0, 0, 100, line1);
			}
			else {
				if (persen2.getText().toString().equals("6")) {
					line2.setBackgroundColor(0xFF03BAD9);
					line3.setBackgroundColor(0xFF03BAD9);
					line4.setBackgroundColor(0xFF03BAD9);
					_radius_4("#03bad9", "#03bad9", 0, 100, 0, 0, 100, line1);
				}
				else {
					if (persen2.getText().toString().equals("5")) {
						line2.setBackgroundColor(0xFF03BAD9);
						line3.setBackgroundColor(0xFF03BAD9);
						_radius_4("#03bad9", "#03bad9", 0, 100, 0, 0, 100, line1);
					}
					else {
						if (persen2.getText().toString().equals("4") || persen2.getText().toString().equals("3")) {
							line2.setBackgroundColor(0xFF03BAD9);
							_radius_4("#03bad9", "#03bad9", 0, 100, 0, 0, 100, line1);
						}
						else {
							if (persen2.getText().toString().equals("2")) {
								_radius_4("#03bad9", "#03bad9", 0, 100, 0, 0, 100, line1);
							}
							else {
								if (Double.parseDouble(persen1.getText().toString()) < 15) {
									_radius_4("#f44336", "#f44336", 0, 100, 0, 0, 100, line1);
									peringatan.setVisibility(View.VISIBLE);
									persen1.setTextColor(0xFFF44336);
									textview32.setTextColor(0xFFF44336);
								}
								else {
									if (persen1.getText().toString().equals("100")) {
										line2.setBackgroundColor(0xFF03BAD9);
										line3.setBackgroundColor(0xFF03BAD9);
										line4.setBackgroundColor(0xFF03BAD9);
										line5.setBackgroundColor(0xFF03BAD9);
										_radius_4("#03bad9", "#03bad9", 0, 100, 0, 0, 100, line1);
										_radius_4("#03bad9", "#03bad9", 0, 0, 100, 100, 0, line6);
									}
									else {
										
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { Window w = getWindow();  w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); };
		getWindow().setNavigationBarColor(Color.parseColor("#7cf7fff7"));
	}
	public void _lengkungan(final View _view, final double _bayangan, final String _warna_tepi, final double _tebal, final double _lengkungan, final String _warna_bg) {
		android.graphics.drawable.GradientDrawable round = new android.graphics.drawable.GradientDrawable(); round.setColor(Color.parseColor(_warna_bg)); round.setCornerRadius((float)_lengkungan); round.setStroke((int)_tebal, Color.parseColor(_warna_tepi)); _view.setElevation((int)_bayangan); _view.setBackground(round);
	}
	
	
	public void _radius_4(final String _color1, final String _color2, final double _str, final double _n1, final double _n2, final double _n3, final double _n4, final View _view) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_color1));
		
		gd.setStroke((int)_str, Color.parseColor(_color2));
		
		gd.setCornerRadii(new float[]{(int)_n1,(int)_n1,(int)_n2,(int)_n2,(int)_n3,(int)_n3,(int)_n4,(int)_n4});
		
		_view.setBackground(gd);
	}
	
	
	public void _battery(final TextView _textview) {
		BatteryManager bm = (BatteryManager)getSystemService(BATTERY_SERVICE); int batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY); _textview.setText(Integer.toString(batLevel));
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