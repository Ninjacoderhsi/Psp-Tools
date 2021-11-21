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
import android.widget.AdapterView;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.antlr.v4.runtime.*;
import me.ibrahimsn.particle.*;
import io.github.rosemoe.sora.*;
import javaxml.*;
import org.jetbrains.kotlin.*;
import com.google.gson.*;
import io.github.rosemoe.sora.langs.textmate.*;
import io.github.rosemoe.sora.textmate.core.*;
import io.github.rosemoe.sora.textmate.languageconfiguration.*;
import arabware.libs.getThumbnail.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;

public class GamemasterActivity extends AppCompatActivity {
	
	private ArrayList<HashMap<String, Object>> listservers = new ArrayList<>();
	
	private LinearLayout linear1;
	private ListView listview1;
	
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	private Intent intenr = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.gamemaster);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		listview1 = findViewById(R.id.listview1);
		network = new RequestNetwork(this);
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				intenr.setClass(getApplicationContext(), GamedownloadmasterActivity.class);
				intenr.putExtra("name", listservers.get((int)_position).get("name").toString());
				intenr.putExtra("size", listservers.get((int)_position).get("size").toString());
				intenr.putExtra("model", listservers.get((int)_position).get("model").toString());
				intenr.putExtra("icon", listservers.get((int)_position).get("icon").toString());
				intenr.putExtra("link", listservers.get((int)_position).get("link").toString());
				startActivity(intenr);
			}
		});
		
		_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				try{
					listservers = new Gson().fromJson(_response, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
					listview1.setAdapter(new Listview1Adapter(listservers));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				}catch(Exception e){
					 
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.CustomToast(getApplicationContext(), _message, 0xFFFFFFFF, 15, 0x89005AFF, 30, SketchwareUtil.CENTER);
			}
		};
	}
	
	private void initializeLogic() {
		network.startRequestNetwork(RequestNetworkController.GET, "https://raw.githubusercontent.com/Ninjacoderhsi/teat/main/Tws.json", "a", _network_request_listener);
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
				_view = _inflater.inflate(R.layout.customgame, null);
			}
			
			final androidx.cardview.widget.CardView cardview1 = _view.findViewById(R.id.cardview1);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final androidx.cardview.widget.CardView cardview2 = _view.findViewById(R.id.cardview2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final ImageView icon = _view.findViewById(R.id.icon);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final LinearLayout linear8 = _view.findViewById(R.id.linear8);
			final LinearLayout linear9 = _view.findViewById(R.id.linear9);
			final TextView name = _view.findViewById(R.id.name);
			final TextView size = _view.findViewById(R.id.size);
			final TextView model = _view.findViewById(R.id.model);
			
			name.setText(listservers.get((int)_position).get("name").toString());
			size.setText(listservers.get((int)_position).get("size").toString());
			model.setText(listservers.get((int)_position).get("model").toString());
			Glide.with(getApplicationContext()).load(Uri.parse(listservers.get((int)_position).get("icon").toString())).into(icon);
			
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