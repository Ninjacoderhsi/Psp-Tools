package org.ppsspp.home.launcher;

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
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import android.content.SharedPreferences;
import java.io.IOException;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import android.view.View;
import android.graphics.Typeface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class WallDialogFragmentActivity extends DialogFragment {
	
	private String color = "";
	
	private LinearLayout linear1;
	private LinearLayout linear3;
	private ImageView imageview1;
	private LinearLayout linear2;
	private TextView textview2;
	
	private SharedPreferences shref;
	private WallpaperManager wap;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.wall_dialog_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		linear1 = _view.findViewById(R.id.linear1);
		linear3 = _view.findViewById(R.id.linear3);
		imageview1 = _view.findViewById(R.id.imageview1);
		linear2 = _view.findViewById(R.id.linear2);
		textview2 = _view.findViewById(R.id.textview2);
		shref = getContext().getSharedPreferences("SMLUANCHER", Activity.MODE_PRIVATE);
		
		linear2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				WallpaperManager wallpaperManager = WallpaperManager.getInstance(getContext().getApplicationContext());
				try { 
					Bitmap bitmap = ((android.graphics.drawable.BitmapDrawable) imageview1.getDrawable()).getBitmap();
					wallpaperManager.setBitmap(bitmap);
				} 
				catch (Exception g) { 
					g.printStackTrace(); 
				}
			}
		});
		
		textview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				WallpaperManager wap = WallpaperManager.getInstance(getContext().getApplicationContext());
				try {
					Bitmap wapBM = ((android.graphics.drawable.BitmapDrawable) imageview1.getDrawable()).getBitmap();
					wap.setBitmap(wapBM);
				}
				catch (Exception g) {
				}
			}
		});
	}
	
	private void initializeLogic() {
		if (getDialog() != null) { 
				int width = ViewGroup.LayoutParams.MATCH_PARENT;
				int height = ViewGroup.LayoutParams.MATCH_PARENT; 
				 getDialog().getWindow().setLayout(width, height);
				getDialog().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		}
		if (shref.getString("md", "").equals("dark")) {
			color = "#CE37474f";
		}
		else {
			color = "#Ceffffff";
		}
		_SX_CornerRadius_4(linear1, color, color, 0, 30, 30, 30, 30);
		imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(shref.getString("walll", ""), 1024, 1024));
		textview2.setTextColor(Color.parseColor(shref.getString("clr", "")));
		textview2.setTypeface(Typeface.createFromAsset(getContext().getAssets(),"fonts/robto.ttf"), 0);
	}
	
	public void _SX_CornerRadius_4(final View _view, final String _color1, final String _color2, final double _str, final double _n1, final double _n2, final double _n3, final double _n4) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_color1));
		
		gd.setStroke((int)_str, Color.parseColor(_color2));
		
		gd.setCornerRadii(new float[]{(int)_n1,(int)_n1,(int)_n2,(int)_n2,(int)_n3,(int)_n3,(int)_n4,(int)_n4});
		
		_view.setBackground(gd);
		
		_view.setElevation(8);
	}
	
}