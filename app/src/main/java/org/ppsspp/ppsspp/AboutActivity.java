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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView;
import me.ibrahimsn.particle.*;
import org.jetbrains.kotlin.*;
import arabware.libs.getThumbnail.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;

public class AboutActivity extends AppCompatActivity {
	
	private ArrayList<HashMap<String, Object>> Psp = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout linear2;
	private ListView listview1;
	private ImageView imageview1;
	private TextView textview2;
	private TextView textview3;
	
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.about);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear3 = findViewById(R.id.linear3);
		linear2 = findViewById(R.id.linear2);
		listview1 = findViewById(R.id.listview1);
		imageview1 = findViewById(R.id.imageview1);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		net = new RequestNetwork(this);
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				
			}
		});
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("Key", "");
			Psp.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("Key", "");
			Psp.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("Key", "");
			Psp.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("Key", "");
			Psp.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("Key", "");
			Psp.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("key", "");
			Psp.add(_item);
		}
		
		listview1.setAdapter(new Listview1Adapter(Psp));
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
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
				_view = _inflater.inflate(R.layout.about_pt, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final de.hdodenhof.circleimageview.CircleImageView circleimageview1 = _view.findViewById(R.id.circleimageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			
			{
				android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
				SketchUi.setColor(0xFFFFFFFF);float lt = getDip(0);
				float rt = getDip(19);
				float rb = getDip(19);
				float lb = getDip(0);
				SketchUi.setCornerRadii(new float[]{
						lt,lt,rt ,rt,rb,rb ,lb,lb });
				linear1.setElevation(getDip(5));
				android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE0E0E0}), SketchUi, null);
				linear1.setBackground(SketchUi_RD);
			}
			if (_position == 0) {
				circleimageview1.setImageResource(R.drawable.ninjacoder);
				textview1.setText("Ninja Coder");
				textview2.setText("سازنده برنامه");
				{
					android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
					SketchUi.setColor(0xFF03A9F4);float lt = getDip(0);
					float rt = getDip(19);
					float rb = getDip(19);
					float lb = getDip(0);
					SketchUi.setCornerRadii(new float[]{
							lt,lt,rt ,rt,rb,rb ,lb,lb });
					linear2.setElevation(getDip(4));
					android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE0E0E0}), SketchUi, null);
					linear2.setBackground(SketchUi_RD);
				}
			}
			if (_position == 1) {
				circleimageview1.setImageResource(R.drawable.blackerror);
				textview1.setText("Black Error");
				textview2.setText("خدمات انلاین برنامه و پشتیبان انلاین");
				{
					android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
					SketchUi.setColor(0xFF000000);float lt = getDip(0);
					float rt = getDip(19);
					float rb = getDip(19);
					float lb = getDip(0);
					SketchUi.setCornerRadii(new float[]{
							lt,lt,rt ,rt,rb,rb ,lb,lb });
					linear2.setElevation(getDip(4));
					android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE0E0E0}), SketchUi, null);
					linear2.setBackground(SketchUi_RD);
				}
			}
			if (_position == 2) {
				circleimageview1.setImageResource(R.drawable.hirad);
				textview1.setText("Hirad");
				textview2.setText("اشتراک گذاری برنامه و سرمایه گذار");
				{
					android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
					SketchUi.setColor(0xFF4CAF50);float lt = getDip(0);
					float rt = getDip(19);
					float rb = getDip(19);
					float lb = getDip(0);
					SketchUi.setCornerRadii(new float[]{
							lt,lt,rt ,rt,rb,rb ,lb,lb });
					linear2.setElevation(getDip(4));
					android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE0E0E0}), SketchUi, null);
					linear2.setBackground(SketchUi_RD);
				}
			}
			if (_position == 3) {
				circleimageview1.setImageResource(R.drawable.arabware);
				textview1.setText("Arab Ware");
				textview2.setText("Help To Ppsspp Run");
				{
					android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
					SketchUi.setColor(0xFFF44336);float lt = getDip(0);
					float rt = getDip(19);
					float rb = getDip(19);
					float lb = getDip(0);
					SketchUi.setCornerRadii(new float[]{
							lt,lt,rt ,rt,rb,rb ,lb,lb });
					linear2.setElevation(getDip(4));
					android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFFE0E0E0}), SketchUi, null);
					linear2.setBackground(SketchUi_RD);
				}
			}
			if (_position == 4) {
				circleimageview1.setImageResource(R.drawable.abol);
				textview1.setText("Abolfazl Killer");
				textview2.setText("تستر و رفع باگ های برنامه");
				{
					android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
					SketchUi.setColor(0xFF808080);float lt = getDip(0);
					float rt = getDip(19);
					float rb = getDip(19);
					float lb = getDip(0);
					SketchUi.setCornerRadii(new float[]{
							lt,lt,rt ,rt,rb,rb ,lb,lb });
					linear2.setElevation(getDip(4));
					android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFF808080}), SketchUi, null);
					linear2.setBackground(SketchUi_RD);
				}
			}
			if (_position == 5) {
				circleimageview1.setImageResource(R.drawable.hidz);
				textview1.setText("Hisham Dz");
				textview2.setText("help to install app and new ui download");
				{
					android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
					SketchUi.setColor(0xFF00FF0D);float lt = getDip(0);
					float rt = getDip(19);
					float rb = getDip(19);
					float lb = getDip(0);
					SketchUi.setCornerRadii(new float[]{
							lt,lt,rt ,rt,rb,rb ,lb,lb });
					linear2.setElevation(getDip(4));
					android.graphics.drawable.RippleDrawable SketchUi_RD = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{0xFF00FF0D}), SketchUi, null);
					linear2.setBackground(SketchUi_RD);
				}
			}
			circleimageview1.setCircleBackgroundColor(Color.TRANSPARENT);
			
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