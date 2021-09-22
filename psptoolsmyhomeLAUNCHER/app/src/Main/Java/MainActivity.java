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
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import android.webkit.WebView;
import android.webkit.WebSettings;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.content.Intent;
import android.net.Uri;
import android.content.ClipData;
import android.animation.ObjectAnimator;
import android.view.animation.LinearInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.app.Activity;
import android.content.SharedPreferences;
import java.io.IOException;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import android.graphics.Typeface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class MainActivity extends AppCompatActivity {
	
	public final int REQ_CD_FFO = 101;
	
	private Timer _timer = new Timer();
	
	private boolean bottom_ = false;
	private String color = "";
	private boolean mode = false;
	private String color2 = "";
	private String prevColor = "";
	private String charSeq = "";
	private String iniColor = "";
	private String HEX = "";
	private String chosenColor = "";
	private boolean apka = false;
	private double width = 0;
	private double ht = 0;
	private boolean picked = false;
	private HashMap<String, Object> wallp = new HashMap<>();
	private String pmg = "";
	private double dht = 0;
	private boolean opend = false;
	
	private ArrayList<String> apps = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear94;
	private LinearLayout linear;
	private LinearLayout bottom;
	private LinearLayout blur;
	private LinearLayout home_time;
	private LinearLayout linear61;
	private LinearLayout linear62;
	private LinearLayout linear63;
	private LinearLayout linear64;
	private LinearLayout linear93;
	private ImageView imageview20;
	private ImageView imageview35;
	private TextView textview16;
	private TextView textview17;
	private TextView textview13;
	private LinearLayout linear65;
	private ImageView imageview23;
	private ImageView imageview21;
	private TextView hours;
	private TextView minutes;
	private TextView Day;
	private TextView Day_month;
	private LinearLayout linear4;
	private LinearLayout main;
	private RecyclerView recyclerview2;
	private LinearLayout controlPanal;
	private ImageView imageview7;
	private LinearLayout swipe_button;
	private ImageView imageview8;
	private ImageView swipe_icon;
	private LinearLayout linear7;
	private LinearLayout linear9;
	private LinearLayout linear11;
	private LinearLayout linear10;
	private LinearLayout linear12;
	private TextView Daa;
	private TextView month;
	private TextView hour1;
	private LinearLayout saperate;
	private TextView minute;
	private LinearLayout linear53;
	private ImageView imageview10;
	private LinearLayout linear13;
	private TextView textview7;
	private TextView textview5;
	private TextView textview6;
	private LinearLayout linear14;
	private LinearLayout linear15;
	private LinearLayout linear17;
	private ImageView imageview13;
	private TextView textview9;
	private ImageView imageview14;
	private TextView textview10;
	private ImageView imageview15;
	private TextView textview8;
	private LinearLayout linear21;
	private LinearLayout linear29;
	private LinearLayout ads;
	private LinearLayout linear33;
	private LinearLayout linear35;
	private LinearLayout camera;
	private ImageView camerap;
	private LinearLayout gallery;
	private ImageView galleryp;
	private LinearLayout linear32;
	private ImageView imageview18;
	private LinearLayout phone;
	private ImageView phonep;
	private LinearLayout sms;
	private ImageView smsp;
	private LinearLayout linear49;
	private LinearLayout linearcolor;
	private LinearLayout linear70;
	private LinearLayout linear66;
	private LinearLayout linear69;
	private LinearLayout linear83;
	private LinearLayout dark;
	private LinearLayout linear54;
	private TextView textview12;
	private ImageView imageviewSun;
	private LinearLayout linear60;
	private LinearLayout linear59;
	private LinearLayout linear58;
	private ImageView imageview19;
	private LinearLayout linear85;
	private LinearLayout linear84;
	private LinearLayout linear86;
	private LinearLayout linear87;
	private LinearLayout linear88;
	private ImageView imageview33;
	private ImageView imageview32;
	private ImageView imageview31;
	private TextView textview14;
	private ImageView imageview30;
	private WebView webview1;
	private LinearLayout linear89;
	private ImageView imageview34;
	
	private TimerTask timer;
	private Calendar tool = Calendar.getInstance();
	private Intent id = new Intent();
	private Intent ffo = new Intent(Intent.ACTION_GET_CONTENT);
	private ObjectAnimator fjf = new ObjectAnimator();
	private ObjectAnimator fkf = new ObjectAnimator();
	private SharedPreferences sharinf;
	private TimerTask rjf;
	private Intent ijn = new Intent();
	private AlertDialog cus;
	private WallpaperManager ds;
	private Vibrator vibrate;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
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
		linear94 = findViewById(R.id.linear94);
		linear = findViewById(R.id.linear);
		bottom = findViewById(R.id.bottom);
		blur = findViewById(R.id.blur);
		home_time = findViewById(R.id.home_time);
		linear61 = findViewById(R.id.linear61);
		linear62 = findViewById(R.id.linear62);
		linear63 = findViewById(R.id.linear63);
		linear64 = findViewById(R.id.linear64);
		linear93 = findViewById(R.id.linear93);
		imageview20 = findViewById(R.id.imageview20);
		imageview35 = findViewById(R.id.imageview35);
		textview16 = findViewById(R.id.textview16);
		textview17 = findViewById(R.id.textview17);
		textview13 = findViewById(R.id.textview13);
		linear65 = findViewById(R.id.linear65);
		imageview23 = findViewById(R.id.imageview23);
		imageview21 = findViewById(R.id.imageview21);
		hours = findViewById(R.id.hours);
		minutes = findViewById(R.id.minutes);
		Day = findViewById(R.id.Day);
		Day_month = findViewById(R.id.Day_month);
		linear4 = findViewById(R.id.linear4);
		main = findViewById(R.id.main);
		recyclerview2 = findViewById(R.id.recyclerview2);
		controlPanal = findViewById(R.id.controlPanal);
		imageview7 = findViewById(R.id.imageview7);
		swipe_button = findViewById(R.id.swipe_button);
		imageview8 = findViewById(R.id.imageview8);
		swipe_icon = findViewById(R.id.swipe_icon);
		linear7 = findViewById(R.id.linear7);
		linear9 = findViewById(R.id.linear9);
		linear11 = findViewById(R.id.linear11);
		linear10 = findViewById(R.id.linear10);
		linear12 = findViewById(R.id.linear12);
		Daa = findViewById(R.id.Daa);
		month = findViewById(R.id.month);
		hour1 = findViewById(R.id.hour1);
		saperate = findViewById(R.id.saperate);
		minute = findViewById(R.id.minute);
		linear53 = findViewById(R.id.linear53);
		imageview10 = findViewById(R.id.imageview10);
		linear13 = findViewById(R.id.linear13);
		textview7 = findViewById(R.id.textview7);
		textview5 = findViewById(R.id.textview5);
		textview6 = findViewById(R.id.textview6);
		linear14 = findViewById(R.id.linear14);
		linear15 = findViewById(R.id.linear15);
		linear17 = findViewById(R.id.linear17);
		imageview13 = findViewById(R.id.imageview13);
		textview9 = findViewById(R.id.textview9);
		imageview14 = findViewById(R.id.imageview14);
		textview10 = findViewById(R.id.textview10);
		imageview15 = findViewById(R.id.imageview15);
		textview8 = findViewById(R.id.textview8);
		linear21 = findViewById(R.id.linear21);
		linear29 = findViewById(R.id.linear29);
		ads = findViewById(R.id.ads);
		linear33 = findViewById(R.id.linear33);
		linear35 = findViewById(R.id.linear35);
		camera = findViewById(R.id.camera);
		camerap = findViewById(R.id.camerap);
		gallery = findViewById(R.id.gallery);
		galleryp = findViewById(R.id.galleryp);
		linear32 = findViewById(R.id.linear32);
		imageview18 = findViewById(R.id.imageview18);
		phone = findViewById(R.id.phone);
		phonep = findViewById(R.id.phonep);
		sms = findViewById(R.id.sms);
		smsp = findViewById(R.id.smsp);
		linear49 = findViewById(R.id.linear49);
		linearcolor = findViewById(R.id.linearcolor);
		linear70 = findViewById(R.id.linear70);
		linear66 = findViewById(R.id.linear66);
		linear69 = findViewById(R.id.linear69);
		linear83 = findViewById(R.id.linear83);
		dark = findViewById(R.id.dark);
		linear54 = findViewById(R.id.linear54);
		textview12 = findViewById(R.id.textview12);
		imageviewSun = findViewById(R.id.imageviewSun);
		linear60 = findViewById(R.id.linear60);
		linear59 = findViewById(R.id.linear59);
		linear58 = findViewById(R.id.linear58);
		imageview19 = findViewById(R.id.imageview19);
		linear85 = findViewById(R.id.linear85);
		linear84 = findViewById(R.id.linear84);
		linear86 = findViewById(R.id.linear86);
		linear87 = findViewById(R.id.linear87);
		linear88 = findViewById(R.id.linear88);
		imageview33 = findViewById(R.id.imageview33);
		imageview32 = findViewById(R.id.imageview32);
		imageview31 = findViewById(R.id.imageview31);
		textview14 = findViewById(R.id.textview14);
		imageview30 = findViewById(R.id.imageview30);
		webview1 = findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		linear89 = findViewById(R.id.linear89);
		imageview34 = findViewById(R.id.imageview34);
		ffo.setType("image/*");
		ffo.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		sharinf = getSharedPreferences("SMLUANCHER", Activity.MODE_PRIVATE);
		vibrate = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		
		blur.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				
				return true;
			}
		});
		
		blur.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				bottom_ = false;
				_close_animation();
				imageview7.setVisibility(View.VISIBLE);
				imageview8.setVisibility(View.VISIBLE);
			}
		});
		
		imageview23.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Uri packageURI = Uri.parse("package:".concat("apps.get((int)(0))")); Intent uninstallIntent = new Intent(Intent.ACTION_DELETE, packageURI); startActivity(uninstallIntent);
			}
		});
		
		imageview21.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				pmg = apps.get((int)(0));
				try {
					    Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
					    intent.setData(Uri.parse("package:" + pmg));
					    startActivity(intent);
					
				} catch ( ActivityNotFoundException e ) {
					
					    Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS);
					    startActivity(intent);
					
				}
			}
		});
		
		recyclerview2.addOnScrollListener(new RecyclerView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(RecyclerView recyclerView, int _scrollState) {
				super.onScrollStateChanged(recyclerView, _scrollState);
				
			}
			
			@Override
			public void onScrolled(RecyclerView recyclerView, int _offsetX, int _offsetY) {
				super.onScrolled(recyclerView, _offsetX, _offsetY);
				linear62.setVisibility(View.GONE);
			}
		});
		
		imageview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (bottom_) {
					bottom_ = false;
					_close_animation();
				}
				else {
					bottom_ = true;
					imageview7.setVisibility(View.GONE);
					imageview8.setVisibility(View.GONE);
					_open_animation();
					main.setVisibility(View.VISIBLE);
				}
			}
		});
		
		swipe_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (bottom_) {
					bottom_ = false;
					_close_animation();
				}
				else {
					bottom_ = true;
					recyclerview2.setVisibility(View.VISIBLE);
					_resizeView(bottom, width, ht);
					imageview8.setVisibility(View.GONE);
					imageview7.setVisibility(View.GONE);
					_poo();
				}
			}
		});
		
		imageview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (bottom_) {
					bottom_ = false;
					_close_animation();
				}
				else {
					bottom_ = true;
					imageview8.setVisibility(View.GONE);
					imageview7.setVisibility(View.GONE);
					_open_animation();
					controlPanal.setVisibility(View.VISIBLE);
				}
			}
		});
		
		dark.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (mode) {
					imageviewSun.setImageResource(R.drawable.moon);
					textview12.setText("DARK MODE");
					mode = false;
					color = "#CE263238";
					sharinf.edit().putString("md", "dark").commit();
				}
				else {
					imageviewSun.setImageResource(R.drawable.sun_1);
					textview12.setText("LIGHT MODE");
					mode = true;
					color = "#CEFFFFFF";
					sharinf.edit().putString("md", "").commit();
				}
				if (mode) {
					if (color2.equals("#FFFFFF")) {
						color2 = "#37474f";
						sharinf.edit().putString("clr", "#37474f").commit();
					}
				}
				else {
					if (color2.equals("#37474f")) {
						color2 = "#FFFFFf";
						sharinf.edit().putString("clr", "#ffffff").commit();
					}
				}
				_ui();
				_col();
			}
		});
		
		linear60.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (mode) {
					color2 = "#37474f";
				}
				else {
					color2 = "#FFFFFF";
				}
				sharinf.edit().putString("clr", color2).commit();
				_col();
			}
		});
		
		linear59.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sharinf.edit().putString("clr", "#2196f3").commit();
				color2 = "#2196f3";
				_col();
			}
		});
		
		linear58.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		imageview19.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				
				return true;
			}
		});
		
		imageview19.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				cus = new AlertDialog.Builder(MainActivity.this).create();
				LayoutInflater cusLI = getLayoutInflater();
				View cusCV = (View) cusLI.inflate(R.layout.color_picker, null);
				cus.setView(cusCV);
				final LinearLayout xyy1 = (LinearLayout)
				cusCV.findViewById(R.id.linear1);
				final LinearLayout xyy2 = (LinearLayout)
				cusCV.findViewById(R.id.linear12);
				final LinearLayout xyy3 = (LinearLayout)
				cusCV.findViewById(R.id.linear25);
				final LinearLayout xyy4 = (LinearLayout)
				cusCV.findViewById(R.id.linear26);
				final LinearLayout xyy5 = (LinearLayout)
				cusCV.findViewById(R.id.linear27);
				final LinearLayout xyy6 = (LinearLayout)
				cusCV.findViewById(R.id.linear33);
				final LinearLayout xyy7 = (LinearLayout)
				cusCV.findViewById(R.id.linear34);
				final LinearLayout xyy8 = (LinearLayout)
				cusCV.findViewById(R.id.linear35);
				final LinearLayout xyy9 = (LinearLayout)
				cusCV.findViewById(R.id.linear36);
				final LinearLayout xyy10 = (LinearLayout)
				cusCV.findViewById(R.id.linear38);
				final LinearLayout xyy11 = (LinearLayout)
				cusCV.findViewById(R.id.linear40);
				final LinearLayout xyy13 = (LinearLayout)
				cusCV.findViewById(R.id.linear39);
				final LinearLayout xyy12 = (LinearLayout)
				cusCV.findViewById(R.id.linear41);
				final EditText xyy16 = (EditText)
				cusCV.findViewById(R.id.edittext2);
				final TextView xyy15 = (TextView)
				cusCV.findViewById(R.id.textview1);
				cus.show();
				xyy2.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_d(xyy2);
					}
				});
				xyy3.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_d(xyy3);
					}
				});
				xyy4.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_d(xyy4);
					}
				});
				xyy5.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_d(xyy5);
					}
				});
				xyy6.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_d(xyy6);
					}
				});
				xyy7.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_d(xyy7);
					}
				});
				xyy8.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_d(xyy8);
					}
				});
				xyy9.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_d(xyy9);
					}
				});
				xyy10.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_d(xyy10);
					}
				});
				xyy11.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_d(xyy11);
					}
				});
				xyy12.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_d(xyy12);
					}
				});
				xyy13.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						_d(xyy13);
					}
				});
				xyy15.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						try{
							color2 = xyy16.getText().toString();
							_col();
						}catch(Exception e){
							SketchwareUtil.CustomToast(getApplicationContext(), "INVALID HEX COLOR", Color.parseColor(color2), 16, Color.parseColor(color), 15, SketchwareUtil.TOP);
						}
					}
				});
			}
		});
		
		linear84.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivityForResult(ffo, REQ_CD_FFO);
			}
		});
		
		imageview33.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
				startActivity(ijn);
			}
		});
		
		//webviewOnProgressChanged
		webview1.setWebChromeClient(new WebChromeClient() {
				@Override public void onProgressChanged(WebView view, int _newProgress) {
					
				}
		});
		
		//OnDownloadStarted
		webview1.setDownloadListener(new DownloadListener() {
			public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
				DownloadManager.Request webview1a = new DownloadManager.Request(Uri.parse(url));
				String webview1b = CookieManager.getInstance().getCookie(url);
				webview1a.addRequestHeader("cookie", webview1b);
				webview1a.addRequestHeader("User-Agent", userAgent);
				webview1a.setDescription("Downloading file...");
				webview1a.setTitle(URLUtil.guessFileName(url, contentDisposition, mimetype));
				webview1a.allowScanningByMediaScanner(); webview1a.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); webview1a.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, URLUtil.guessFileName(url, contentDisposition, mimetype));
				
				DownloadManager webview1c = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
				webview1c.enqueue(webview1a);
				showMessage("Downloading File....");
				BroadcastReceiver onComplete = new BroadcastReceiver() {
					public void onReceive(Context ctxt, Intent intent) {
						showMessage("Download Complete!");
						unregisterReceiver(this);
						
					}};
				registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
			}
		});
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
	}
	
	private void initializeLogic() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { Window w = getWindow();  w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS); };
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		getWindow().setNavigationBarColor(Color.parseColor("#7cf7fff7"));
		color2 = "#CE37474f";
		mode = true;
		_data();
		_ui();
		_col();
		_close_animation();
		_text();
		width = SketchwareUtil.getDisplayWidthPixels(getApplicationContext());
		ht = SketchwareUtil.getDisplayHeightPixels(getApplicationContext()) - (SketchwareUtil.getDisplayHeightPixels(getApplicationContext()) / 4);
		dht = SketchwareUtil.getDisplayHeightPixels(getApplicationContext()) - (SketchwareUtil.getDisplayHeightPixels(getApplicationContext()) / 1.8d);
		_tools();
		recyclerview2.setLayoutManager(new GridLayoutManager(this, 5));
		recyclerview2.setAdapter(new Recyclerview2Adapter(_getapplist("app_name", "app_package")));
		main.setVisibility(View.GONE);
		recyclerview2.setVisibility(View.GONE);
		controlPanal.setVisibility(View.GONE);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_FFO:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				sharinf.edit().putString("walll", _filePath.get((int)(0))).commit();
				WallDialogFragmentActivityN = new WallDialogFragmentActivity();
				WallDialogFragmentActivityN.show(getSupportFragmentManager(),"1");
				_filePath.clear();
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		if (bottom_) {
			bottom_ = false;
			_close_animation();
			main.setVisibility(View.GONE);
			recyclerview2.setVisibility(View.GONE);
			controlPanal.setVisibility(View.GONE);
			linear62.setVisibility(View.GONE);
		}
		else {
			
		}
	}
	public void _open_animation() {
		_Animator(bottom, "translationY", SketchwareUtil.getDip(getApplicationContext(), (int)(-310)), 300);
		swipe_icon.setImageResource(R.drawable.down_grey);
		blur.setVisibility(View.VISIBLE);
	}
	
	
	public void _close_animation() {
		_Animator(bottom, "translationY", SketchwareUtil.getDip(getApplicationContext(), (int)(-50)), 300);
		swipe_icon.setImageResource(R.drawable.grid_white);
		blur.setVisibility(View.GONE);
		main.setVisibility(View.GONE);
		recyclerview2.setVisibility(View.GONE);
		controlPanal.setVisibility(View.GONE);
		imageview8.setVisibility(View.VISIBLE);
		imageview7.setVisibility(View.VISIBLE);
		linear62.setVisibility(View.GONE);
	}
	
	
	public void _Animator(final View _view, final String _propertyName, final double _value, final double _duration) {
		ObjectAnimator anim = new ObjectAnimator();
		anim.setTarget(_view);
		anim.setPropertyName(_propertyName);
		anim.setFloatValues((float)_value);
		anim.setDuration((long)_duration);
		anim.setInterpolator(new android.view.animation.AccelerateDecelerateInterpolator());
		anim.start();
	}
	
	
	public void _ui() {
		ads.setVisibility(View.GONE);
		linear62.setVisibility(View.GONE);
		if (mode) {
			color = "#CEffffff";
			_SX_CornerRadius_4(linear60, "#37474f", "#37474f", 0, 30, 30, 30, 30);
		}
		else {
			color = "#CE37474f";
			_SX_CornerRadius_4(linear60, "#ffffff", "#ffffff", 0, 30, 30, 30, 30);
		}
		blur.setBackgroundColor(0x59000000);
		_SX_CornerRadius_4(bottom, color, color, 0, 50, 50, 0, 0);
		_SX_CornerRadius_4(swipe_button, color, color, 0, 50, 50, 10, 10);
		_SX_CornerRadius_4(dark, color, color, 0, 30, 30, 30, 30);
		_SX_CornerRadius_4(linear54, color, color, 0, 30, 30, 30, 30);
		_SX_CornerRadius_4(linear63, color, color, 0, 15, 15, 15, 15);
		_SX_CornerRadius_4(linear64, color, color, 0, 15, 15, 15, 15);
		_SX_CornerRadius_4(linear65, color, color, 0, 15, 15, 15, 15);
		_SX_CornerRadius_4(linear84, color, color, 0, 15, 15, 15, 15);
		_SX_CornerRadius_4(linear85, color, color, 0, 15, 15, 15, 15);
		_SX_CornerRadius_4(linear59, "#2196f3", "#2196f3", 0, 30, 30, 30, 30);
		_SX_CornerRadius_4(linear58, "#eeeeee", "#eeeeee", 0, 30, 30, 30, 30);
		textview12.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/robto.ttf"), 0);
		{
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			int clrs [] = {0xFFFFE259,0xFFFFA751};
			 gd= new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TL_BR, clrs);
			gd.setCornerRadius(d*10);
			camera.setElevation(d*6);
			camera.setBackground(gd);
		}
		{
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			int clrs [] = {0xFF614385,0xFF516395};
			 gd= new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TL_BR, clrs);
			gd.setCornerRadius(d*10);
			gallery.setElevation(d*6);
			gallery.setBackground(gd);
		}
		{
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			int clrs [] = {0xFF02AABD,0xFF00DAC};
			 gd= new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TL_BR, clrs);
			gd.setCornerRadius(d*10);
			phone.setElevation(d*6);
			phone.setBackground(gd);
		}
		{
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			int d = (int) getApplicationContext().getResources().getDisplayMetrics().density;
			int clrs [] = {0xFFA1C4FD,0xFFC2E9FB};
			 gd= new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TL_BR, clrs);
			gd.setCornerRadius(d*10);
			sms.setElevation(d*6);
			sms.setBackground(gd);
		}
	}
	
	
	public void _setBackground(final View _view, final double _radius, final double _shadow, final String _color, final boolean _ripple) {
		if (_ripple) {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setElevation((int)_shadow);
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#9e9e9e")});
			android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
			_view.setClickable(true);
			_view.setBackground(ripdrb);
		}
		else {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setBackground(gd);
			_view.setElevation((int)_shadow);
		}
	}
	
	
	public void _SX_CornerRadius_4(final View _view, final String _color1, final String _color2, final double _str, final double _n1, final double _n2, final double _n3, final double _n4) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_color1));
		
		gd.setStroke((int)_str, Color.parseColor(_color2));
		
		gd.setCornerRadii(new float[]{(int)_n1,(int)_n1,(int)_n2,(int)_n2,(int)_n3,(int)_n3,(int)_n4,(int)_n4});
		
		_view.setBackground(gd);
		
		_view.setElevation(8);
	}
	
	
	public void _Fade(final View _view, final double _value, final double _duration, final double _start) {
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_Animator(_view, "alpha", _value, _duration);
						_Animator(_view, "scaleX", _value, _duration);
						_Animator(_view, "scaleY", _value, _duration);
						if (_value == 1) {
							_Animator(_view, "translationY", 0, _duration);
						}
						else {
							_Animator(_view, "translationY", 200, _duration);
						}
					}
				});
			}
		};
		_timer.schedule(timer, (int)(_start));
	}
	
	
	public void _setImageBitmap(final ImageView _imageview, final String _packagename) {
		new ApplicationInfo(this).setImageBitmap(_imageview,_packagename);
	}
	
	
	public void _library() {
	}
	
	public static class ApplicationInfo {
		
		private Context myContext;
		
		public ApplicationInfo(Context context) {
			    myContext = context;
		}
		
		public ApplicationInfo(Fragment fragment) {
			    myContext = fragment.getActivity();
		}
		
		public ApplicationInfo(DialogFragment fragment) {
			    myContext = fragment.getActivity();
		}
		
		public void setImageBitmap (final ImageView _imageview, final String _packagename) {
					try {
							    Drawable iconImage = myContext.getPackageManager().getApplicationIcon(_packagename);
							    _imageview.setImageDrawable(iconImage);
							    } catch (android.content.pm.PackageManager.NameNotFoundException e) {
							        
							    }
			}
			
			
			public ArrayList<HashMap<String, Object>> getApplicationList (final String _app_name, final String _package_name) {
					{
							android.content.pm.PackageManager pm = myContext.getPackageManager();
							     HashMap<String, Object> Map = new HashMap<>();
								 ArrayList<HashMap<String, Object>> map = new ArrayList<>();
							    Intent intent = new Intent(Intent.ACTION_MAIN, null);
							    intent.addCategory(Intent.CATEGORY_LAUNCHER);
							    List<android.content.pm.ResolveInfo> PackList = pm.queryIntentActivities(intent, android.content.pm.PackageManager.PERMISSION_GRANTED);
							    for (android.content.pm.ResolveInfo rInfo : PackList) {
									
									        String AppName = rInfo.activityInfo.applicationInfo.loadLabel(pm).toString();
									        String PackageName = rInfo.activityInfo.applicationInfo.packageName;
									Map = new HashMap<>();
									Map.put(_app_name, AppName);
									Map.put(_package_name, PackageName);
									map.add(Map);
									        }
							        return map;
							        }
			}
			
			public void openApp(String packageName) {
				    Intent launchIntent = myContext.getPackageManager().getLaunchIntentForPackage(packageName);
				    myContext.startActivity(launchIntent);
			}
			
			
		}
	{
	}
	
	
	public ArrayList<HashMap<String, Object>> _getapplist(final String _app_name, final String _package_name) {
		return new ApplicationInfo(this).getApplicationList(_app_name,_package_name);
	}
	
	
	public void _text() {
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/robto.ttf"), 0);
		textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/robto.ttf"), 0);
		textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/robto.ttf"), 0);
		textview8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/robto.ttf"), 0);
		textview9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/robto.ttf"), 0);
		textview10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/robto.ttf"), 0);
		hours.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/robto.ttf"), 0);
		minutes.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/robto.ttf"), 0);
		Day.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/robto.ttf"), 0);
		Day_month.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/robto.ttf"), 0);
		Daa.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/robto.ttf"), 0);
		month.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/robto.ttf"), 0);
		hour1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/robto.ttf"), 0);
		minute.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/robto.ttf"), 0);
	}
	
	
	public void _tools() {
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						tool = Calendar.getInstance();
						hour1.setText(new SimpleDateFormat("HH").format(tool.getTime()));
						minutes.setText(new SimpleDateFormat("mm").format(tool.getTime()));
						Day_month.setText(new SimpleDateFormat("dd").format(tool.getTime()).concat(" / ".concat(new SimpleDateFormat("MM").format(tool.getTime()))));
						minute.setText(new SimpleDateFormat("mm").format(tool.getTime()));
						hours.setText(new SimpleDateFormat("HH").format(tool.getTime()));
						month.setText(new SimpleDateFormat("MMMM").format(tool.getTime()));
						Day.setText(new SimpleDateFormat("EEE").format(tool.getTime()));
						Daa.setText(new SimpleDateFormat("dd").format(tool.getTime()));
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timer, (int)(0), (int)(1000));
	}
	
	
	public void _openApplication(final String _packageName) {
		new ApplicationInfo(this).openApp(_packageName);
	}
	
	
	public void _setWallpaper(final View _view, final String _ss) {
		_view.setBackground(new android.graphics.drawable.BitmapDrawable(getResources(), FileUtil.decodeSampleBitmapFromPath(_ss, 1024, 1024)));
	}
	
	
	public void _resizeView(final View _v, final double _w, final double _h) {
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int)_w, (int)_h);
		_v.setLayoutParams(layoutParams);
	}
	
	
	public void _poo() {
		blur.setVisibility(View.VISIBLE);
		_Animator(bottom, "translationY", -1 * ht, 300);
		swipe_icon.setImageResource(R.drawable.down_grey);
	}
	
	
	public void _data() {
		if (sharinf.getString("md", "").equals("")) {
			mode = true;
			color = "#CEffffff";
		}
		else {
			if (sharinf.getString("md", "").equals("dark")) {
				mode = false;
				color = "#CE37474f";
			}
			else {
				mode = true;
				color = "#CEffffff";
			}
		}
		if (sharinf.getString("clr", "").equals("")) {
			if (mode) {
				color2 = "#CE37474f";
				sharinf.edit().putString("clr", "#CE37474f").commit();
			}
			else {
				color2 = "#CEffffff";
				sharinf.edit().putString("clr", "#CEFFFFFF").commit();
			}
		}
		else {
			color2 = sharinf.getString("clr", "");
		}
		if (sharinf.getString("ps", "").equals("")) {
			sharinf.edit().putString("ps", String.valueOf((long)(0))).commit();
		}
		else {
			
		}
	}
	
	
	public void _col() {
		_textview(textview12, color2);
		_textview(textview8, color2);
		_textview(textview10, color2);
		_textview(textview9, color2);
		_textview(textview6, color2);
		_textview(textview5, color2);
		_textview(textview7, color2);
		_textview(minute, color2);
		_textview(hour1, color2);
		_textview(month, color2);
		_textview(textview13, color2);
		_textview(textview14, color2);
		_imagevi(imageview7, color2);
		_imagevi(imageview8, color2);
		_imagevi(swipe_icon, color2);
		_imagevi(imageview13, color2);
		_imagevi(imageview14, color2);
		_imagevi(imageview15, color2);
		_imagevi(imageviewSun, color2);
		_imagevi(imageview19, color2);
		_imagevi(imageview21, color2);
		_imagevi(imageview23, color2);
		_imagevi(imageview30, color2);
		_imagevi(imageview31, color);
		_imagevi(imageview32, color);
		_imagevi(imageview33, color);
		_SX_CornerRadius_4(linear86, color2, color, 0, 15, 15, 15, 15);
		_SX_CornerRadius_4(linear87, color2, color2, 0, 15, 15, 15, 15);
		_SX_CornerRadius_4(linear88, color2, color2, 0, 15, 15, 15, 15);
		sharinf.edit().putString("clr", color2).commit();
	}
	
	
	public void _textview(final TextView _r, final String _s) {
		_r.setTextColor(Color.parseColor(_s));
	}
	
	
	public void _imagevi(final ImageView _v, final String _f) {
		_v.setColorFilter(Color.parseColor(_f), PorterDuff.Mode.MULTIPLY);
	}
	
	
	public void _drag() {
	}
	protected class dr implements View.OnDragListener {
		public boolean onDrag(View v, DragEvent event) {
			final int action = event.getAction();
			switch(action) {
				case DragEvent.ACTION_DRAG_STARTED:
				 
				return true;
				case DragEvent.ACTION_DRAG_ENTERED:
				 
				v.invalidate();
				return true;
				case DragEvent.ACTION_DRAG_LOCATION:
				//drag started
				 
				return true;
				case DragEvent.ACTION_DRAG_EXITED:
				 
				v.invalidate();
				return true;
				case DragEvent.ACTION_DROP:
				//drop
				 
				v.invalidate();
				return true;
				case DragEvent.ACTION_DRAG_ENDED:
				v.invalidate();
				 
				return true;
				default:
				break;
			}
			return false;
		}
	};
	{
	}
	
	
	public void _menu() {
		_setImageBitmap(imageview35, apps.get((int)(0)));
		textview13.setText(apps.get((int)(1)));
		linear62.setVisibility(View.VISIBLE);
	}
	
	
	public void _more_block() {
	}
	private WallDialogFragmentActivity WallDialogFragmentActivityN;
	private FragmentManager WallDialogFragmentActivityFM;
	{
	}
	
	
	public void _loop() {
		if (sharinf.getString("dc1color", "").equals("f")) {
			color2 = sharinf.getString("clr", "");
			_ui();
			opend = false;
			sharinf.edit().putString("dc1color", "t").commit();
		}
		else {
			_loop();
		}
	}
	
	
	public void _d(final View _view) {
		ColorDrawable viewColor = (ColorDrawable)
		_view.getBackground();
		int colorId = viewColor.getColor();
		color2 = String.format("#%06X", (0xFFFFFF & colorId));
		_col();
	}
	
	
	public void _SetRadiusToView(final View _view, final double _radius, final String _Colour) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(); gd.setColor(Color.parseColor(_Colour)); gd.setCornerRadius((int)_radius); _view.setBackground(gd);
	}
	
	public class Recyclerview2Adapter extends RecyclerView.Adapter<Recyclerview2Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _v = _inflater.inflate(R.layout.apps, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			_setImageBitmap(imageview1, _data.get((int)_position).get("app_package").toString());
			textview1.setText(_data.get((int)_position).get("app_name").toString());
			textview1.setTextColor(Color.parseColor(color2));
			imageview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					_openApplication(_data.get((int)_position).get("app_package").toString());
				}
			});
			imageview1.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					apps.add((int)(0), _data.get((int)_position).get("app_package").toString());
					apps.add((int)(1), _data.get((int)_position).get("app_name").toString());
					_menu();
					return true;
				}
			});
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
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