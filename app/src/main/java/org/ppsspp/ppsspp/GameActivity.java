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
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.AdapterView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.bumptech.glide.Glide;
import arabware.libs.getThumbnail.*;
import org.antlr.v4.runtime.*;
import me.ibrahimsn.particle.*;
import io.github.rosemoe.sora.*;
import io.github.rosemoe.sora.langs.java.*;
import io.github.rosemoe.sora.langs.universal.*;
import io.github.rosemoe.sora.langs.html.*;
import io.github.rosemoe.sora.langs.css3.*;
import io.github.rosemoe.sora.langs.base.*;
import org.jetbrains.kotlin.*;
import io.github.rosemoe.sora.langs.python.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class GameActivity extends AppCompatActivity {
	
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap_games = new ArrayList<>();
	
	private LinearLayout linear1;
	private ListView listview1;
	
	private RequestNetwork newnet;
	private RequestNetwork.RequestListener _newnet_request_listener;
	private Intent els = new Intent();
	private AlertDialog.Builder dialog;
	private SharedPreferences cred;
	private SharedPreferences cpink;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.game);
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
		linear1 = findViewById(R.id.linear1);
		listview1 = findViewById(R.id.listview1);
		newnet = new RequestNetwork(this);
		dialog = new AlertDialog.Builder(this);
		cred = getSharedPreferences("cred", Activity.MODE_PRIVATE);
		cpink = getSharedPreferences("cpink", Activity.MODE_PRIVATE);
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				els.putExtra("name", listmap_games.get((int)_position).get("name").toString());
				els.putExtra("id", listmap_games.get((int)_position).get("id").toString());
				els.putExtra("Size", listmap_games.get((int)_position).get("Size").toString());
				els.putExtra("img", listmap_games.get((int)_position).get("img").toString());
				els.putExtra("link", listmap_games.get((int)_position).get("link").toString());
				els.setClass(getApplicationContext(), GamedownloadActivity.class);
				startActivity(els);
			}
		});
		
		_newnet_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				try{
					listmap_games = new Gson().fromJson(_response, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
					listview1.setAdapter(new Listview1Adapter(listmap_games));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				}catch(Exception e){
					 
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				dialog.setTitle("game download");
				dialog.setIcon(R.drawable.ic_splash);
				dialog.setMessage("متاسفم این قسمت نیازمند اینترنت میباشد لطفان از وصل بدون اینترنت 3g/4g/wifi اطمینان حاصل کنید و دوباره تلاش کنید");
				dialog.setPositiveButton("تایید", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						els.setClass(getApplicationContext(), FilesActivity.class);
						startActivity(els);
					}
				});
				dialog.create().show();
			}
		};
	}
	
	private void initializeLogic() {
		newnet.startRequestNetwork(RequestNetworkController.GET, "https://raw.githubusercontent.com/hsigamerppsspp/hsi/main/psptools", "a", _newnet_request_listener);
		FileUtil.makeDir("sdcard/psp/game/psptools");
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { Window w = getWindow();  w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); };
		getWindow().setNavigationBarColor(Color.parseColor("#7cf7fff7"));
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.custom_game, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final ImageView more = _view.findViewById(R.id.more);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final TextView name = _view.findViewById(R.id.name);
			final TextView textview6 = _view.findViewById(R.id.textview6);
			final TextView size = _view.findViewById(R.id.size);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			final TextView id = _view.findViewById(R.id.id);
			
			name.setText(listmap_games.get((int)_position).get("name").toString());
			id.setText(listmap_games.get((int)_position).get("id").toString());
			size.setText(listmap_games.get((int)_position).get("Size").toString());
			Glide.with(getApplicationContext()).load(Uri.parse(listmap_games.get((int)_position).get("img").toString())).into(imageview1);
			cardview1.setCardBackgroundColor(Color.TRANSPARENT);
			cardview1.setRadius((float)20);
			more.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(GameActivity.this);
					
					View bottomSheetView; bottomSheetView = getLayoutInflater().inflate(R.layout.gozarsh,null );
					bottomSheetDialog.setContentView(bottomSheetView);
					
					bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
					
					LinearLayout id1 = (LinearLayout) bottomSheetView.findViewById(R.id.id1);
					LinearLayout id2 = (LinearLayout) bottomSheetView.findViewById(R.id.id2);
					LinearLayout id3 = (LinearLayout) bottomSheetView.findViewById(R.id.id3);
					LinearLayout id4 = (LinearLayout) bottomSheetView.findViewById(R.id.id4);
					ImageView image = (ImageView) bottomSheetView.findViewById(R.id.image);
					WebView webview1 = (WebView) bottomSheetView.findViewById(R.id.webview1);
					id1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)6, 0xFF424242));
					id2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)6, 0xFF424242));
					id3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)6, 0xFF424242));
					id4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)6, 0xFF424242));
					image.setColorFilter(0xFFE91E63, PorterDuff.Mode.MULTIPLY);
					id1.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
							
							bottomSheetDialog.dismiss();
							
						}
					});
					id2.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
							
							bottomSheetDialog.dismiss();
							
						}
					});
					id3.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
							
							bottomSheetDialog.dismiss();
							
						}
					});
					id4.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
							
							bottomSheetDialog.dismiss();
							
						}
					});
					bottomSheetDialog.setCancelable(false);
					bottomSheetDialog.show();
				}
			});
			if (cred.getString("red", "").equals("reds")) {
				textview2.setTextColor(0xFFF44336);
				name.setTextColor(0xFFF44336);
				textview6.setTextColor(0xFFF44336);
				size.setTextColor(0xFFF44336);
				textview5.setTextColor(0xFFF44336);
				id.setTextColor(0xFFF44336);
			}
			else {
				
			}
			if (cpink.getString("pink", "").equals("pinks")) {
				textview2.setTextColor(0xFFE91E63);
				name.setTextColor(0xFFE91E63);
				textview6.setTextColor(0xFFE91E63);
				size.setTextColor(0xFFE91E63);
				textview5.setTextColor(0xFFE91E63);
				id.setTextColor(0xFFE91E63);
			}
			else {
				
			}
			
			return _view;
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