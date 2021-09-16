package org.ppsspp.ppsspp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.widget.LinearLayout;
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
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ScrollView;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Build;
import androidx.core.content.FileProvider;
import java.io.File;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.AdapterView;
import android.view.View;
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

public class FilesActivity extends AppCompatActivity {
	
	public final int REQ_CD_TT = 101;
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private FloatingActionButton _fab;
	private DrawerLayout _drawer;
	private String subtitle = "";
	private String Folder = "";
	private double position = 0;
	private boolean chack = false;
	private String info = "";
	private String UpFolder = "";
	private boolean DC = false;
	private String Android = "";
	private String path = "";
	
	private ArrayList<String> liststring = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> File_map = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> game = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap_games = new ArrayList<>();
	
	private RelativeLayout linear2;
	private ParticleView linear1;
	private LinearLayout linear3;
	private LinearLayout back;
	private ListView listview1;
	private ImageView imageview1;
	private TextView textview1;
	private RelativeLayout _drawer_relativeLayout;
	private LinearLayout _drawer_particleView;
	private LinearLayout _drawer_ui1;
	private ScrollView _drawer_vscroll2;
	private LinearLayout _drawer_linear12;
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_linear13;
	private LinearLayout _drawer_linear3;
	private LinearLayout _drawer_linear4;
	private LinearLayout _drawer_linear9;
	private LinearLayout _drawer_linear8;
	private LinearLayout _drawer_linear7;
	private LinearLayout _drawer_linear11;
	private LinearLayout _drawer_mobile_1;
	private LinearLayout _drawer_linear5;
	private LinearLayout _drawer_linear10;
	private LinearLayout _drawer_linear6;
	private ImageView _drawer_imageview5;
	private TextView _drawer_textview11;
	private ImageView _drawer_gamestore;
	private TextView _drawer_textview1;
	private ImageView _drawer_ppsspp;
	private TextView _drawer_textview2;
	private ImageView _drawer_imageview2;
	private TextView _drawer_textview8;
	private ImageView _drawer_telgram;
	private TextView _drawer_textview6;
	private ImageView _drawer_github;
	private TextView _drawer_textview7;
	private ImageView _drawer_imageview4;
	private TextView _drawer_textview10;
	private ImageView _drawer_mobile;
	private TextView _drawer_textview5;
	private ImageView _drawer_about;
	private TextView _drawer_textview3;
	private ImageView _drawer_imageview3;
	private TextView _drawer_textview9;
	private ImageView _drawer_exit;
	private TextView _drawer_textview4;
	
	private Intent i = new Intent();
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	private Intent tt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	private File _file_tt;
	private AlertDialog.Builder Dialog;
	private SharedPreferences d;
	private SharedPreferences one;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.files);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
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
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_fab = findViewById(R.id._fab);
		
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(FilesActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		linear2 = findViewById(R.id.linear2);
		linear1 = findViewById(R.id.linear1);
		linear3 = findViewById(R.id.linear3);
		back = findViewById(R.id.back);
		listview1 = findViewById(R.id.listview1);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		_drawer_relativeLayout = _nav_view.findViewById(R.id.relativeLayout);
		_drawer_particleView = _nav_view.findViewById(R.id.particleView);
		_drawer_ui1 = _nav_view.findViewById(R.id.ui1);
		_drawer_vscroll2 = _nav_view.findViewById(R.id.vscroll2);
		_drawer_linear12 = _nav_view.findViewById(R.id.linear12);
		_drawer_linear1 = _nav_view.findViewById(R.id.linear1);
		_drawer_linear13 = _nav_view.findViewById(R.id.linear13);
		_drawer_linear3 = _nav_view.findViewById(R.id.linear3);
		_drawer_linear4 = _nav_view.findViewById(R.id.linear4);
		_drawer_linear9 = _nav_view.findViewById(R.id.linear9);
		_drawer_linear8 = _nav_view.findViewById(R.id.linear8);
		_drawer_linear7 = _nav_view.findViewById(R.id.linear7);
		_drawer_linear11 = _nav_view.findViewById(R.id.linear11);
		_drawer_mobile_1 = _nav_view.findViewById(R.id.mobile_1);
		_drawer_linear5 = _nav_view.findViewById(R.id.linear5);
		_drawer_linear10 = _nav_view.findViewById(R.id.linear10);
		_drawer_linear6 = _nav_view.findViewById(R.id.linear6);
		_drawer_imageview5 = _nav_view.findViewById(R.id.imageview5);
		_drawer_textview11 = _nav_view.findViewById(R.id.textview11);
		_drawer_gamestore = _nav_view.findViewById(R.id.gamestore);
		_drawer_textview1 = _nav_view.findViewById(R.id.textview1);
		_drawer_ppsspp = _nav_view.findViewById(R.id.ppsspp);
		_drawer_textview2 = _nav_view.findViewById(R.id.textview2);
		_drawer_imageview2 = _nav_view.findViewById(R.id.imageview2);
		_drawer_textview8 = _nav_view.findViewById(R.id.textview8);
		_drawer_telgram = _nav_view.findViewById(R.id.telgram);
		_drawer_textview6 = _nav_view.findViewById(R.id.textview6);
		_drawer_github = _nav_view.findViewById(R.id.github);
		_drawer_textview7 = _nav_view.findViewById(R.id.textview7);
		_drawer_imageview4 = _nav_view.findViewById(R.id.imageview4);
		_drawer_textview10 = _nav_view.findViewById(R.id.textview10);
		_drawer_mobile = _nav_view.findViewById(R.id.mobile);
		_drawer_textview5 = _nav_view.findViewById(R.id.textview5);
		_drawer_about = _nav_view.findViewById(R.id.about);
		_drawer_textview3 = _nav_view.findViewById(R.id.textview3);
		_drawer_imageview3 = _nav_view.findViewById(R.id.imageview3);
		_drawer_textview9 = _nav_view.findViewById(R.id.textview9);
		_drawer_exit = _nav_view.findViewById(R.id.exit);
		_drawer_textview4 = _nav_view.findViewById(R.id.textview4);
		net = new RequestNetwork(this);
		_file_tt = FileUtil.createNewPictureFile(getApplicationContext());
		Uri _uri_tt;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
			_uri_tt = FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName() + ".provider", _file_tt);
		} else {
			_uri_tt = Uri.fromFile(_file_tt);
		}
		tt.putExtra(MediaStore.EXTRA_OUTPUT, _uri_tt);
		tt.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
		Dialog = new AlertDialog.Builder(this);
		d = getSharedPreferences("d", Activity.MODE_PRIVATE);
		one = getSharedPreferences("one", Activity.MODE_PRIVATE);
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (Folder.equals(FileUtil.getExternalStorageDir())) {
					finish();
				}
				else {
					UpFolder = Folder.substring((int)(0), (int)(Folder.lastIndexOf("/")));
					Folder = UpFolder;
					_RefreshData();
				}
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				position = _position;
				if (FileUtil.isDirectory(liststring.get((int)(_position)))) {
					Folder = liststring.get((int)(_position));
					_RefreshData();
				}
				else {
					if (liststring.get((int)(_position)).endsWith(".json") || (liststring.get((int)(_position)).endsWith(".txt") || (liststring.get((int)(_position)).endsWith(".xml") || liststring.get((int)(_position)).endsWith(".ini")))) {
						i.putExtra("file", FileUtil.readFile(liststring.get((int)(_position))));
						i.putExtra("save", liststring.get((int)(_position)));
						i.setClass(getApplicationContext(), IniActivity.class);
						startActivity(i);
					}
					if (liststring.get((int)(_position)).endsWith(".apk")) {
						try {
							if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
													Uri uri = androidx.core.content.FileProvider.getUriForFile(getApplicationContext(),
															FilesActivity.this.getPackageName() + ".provider", new java.io.File(liststring.get((int)(_position))));
													Intent intent = new Intent(Intent.ACTION_VIEW);
													intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
													intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
													intent.setDataAndType(uri, "application/vnd.android.package-archive");
													startActivity(intent);
								
											} else {
													Intent intent = new Intent(Intent.ACTION_VIEW);
													intent.setDataAndType(Uri.fromFile( new java.io.File(liststring.get((int)(_position)))),
															"application/vnd.android.package-archive");
													intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
													startActivity(intent);
											}
							
						} catch (Exception rr) {
							showMessage (rr.toString());
						}
					}
					if (liststring.get((int)(_position)).endsWith(".png") || (liststring.get((int)(_position)).endsWith(".jpge") || (liststring.get((int)(_position)).endsWith(".tk") || liststring.get((int)(_position)).endsWith(".apng")))) {
						final AlertDialog dialog1 = new AlertDialog.Builder(FilesActivity.this).create();
						View inflate = getLayoutInflater().inflate(R.layout.image,null); 
						dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
						dialog1.setView(inflate);
						LinearLayout linear1 = (LinearLayout) inflate.findViewById(R.id.linear1);
						ImageView imageview2 = (ImageView) inflate.findViewById(R.id.imageview2);
						ImageView close = (ImageView) inflate.findViewById(R.id.close);
						LinearLayout user1 = (LinearLayout) inflate.findViewById(R.id.user1);
						{
							android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
							SketchUi.setColor(0xFFFFFFFF);float lt = getDip(22);
							float rt = getDip(22);
							float rb = getDip(0);
							float lb = getDip(0);
							SketchUi.setCornerRadii(new float[]{
									lt,lt,rt ,rt,rb,rb ,lb,lb });
							SketchUi.setStroke((int)getDip(1) ,0xFF008DCD);
							user1.setElevation(getDip(5));
							user1.setBackground(SketchUi);
						}
						imageview2.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(liststring.get((int)(_position)), 1024, 1024));
						close.setImageResource(R.drawable.close_file);
						close.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
										
									dialog1.dismiss();
								
								}
						});
						dialog1.setCancelable(true);
						dialog1.show();
					}
					if (liststring.get((int)(_position)).endsWith(".iso") || liststring.get((int)(_position)).endsWith(".cso")) {
						i.setClass(getApplicationContext(), PpssppActivity.class);
						startActivity(i);
					}
					if (liststring.get((int)(_position)).endsWith(".gif")) {
						final AlertDialog dialog1 = new AlertDialog.Builder(FilesActivity.this).create();
						View inflate = getLayoutInflater().inflate(R.layout.image,null); 
						dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
						dialog1.setView(inflate);
						LinearLayout linear1 = (LinearLayout) inflate.findViewById(R.id.linear1);
						ImageView imageview2 = (ImageView) inflate.findViewById(R.id.imageview2);
						ImageView close = (ImageView) inflate.findViewById(R.id.close);
						LinearLayout user1 = (LinearLayout) inflate.findViewById(R.id.user1);
						LinearLayout gifs = (LinearLayout) inflate.findViewById(R.id.gifs);
						{
							android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
							SketchUi.setColor(0xFFFFFFFF);float lt = getDip(22);
							float rt = getDip(22);
							float rb = getDip(0);
							float lb = getDip(0);
							SketchUi.setCornerRadii(new float[]{
									lt,lt,rt ,rt,rb,rb ,lb,lb });
							SketchUi.setStroke((int)getDip(1) ,0xFF008DCD);
							user1.setElevation(getDip(5));
							user1.setBackground(SketchUi);
						}
						imageview2.setVisibility(View.GONE);
						
						boolean largeSize = true;
						
						java.io.File file = new java.io.File(liststring.get((int)(_position)));
						
						
						java.io.InputStream stream = null;
						    try {
							        stream = new java.io.FileInputStream(file);
							    } catch (IOException e) {
							        e.printStackTrace();
							    }
						          
						
						GifDecoderView view = new GifDecoderView(getApplicationContext(), stream);                 
						
						DisplayMetrics displayMetrics = new DisplayMetrics();
						        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
						        int height = displayMetrics.heightPixels;
						        int width = displayMetrics.widthPixels;
						
						
						view.setScaleType(ImageView.ScaleType.FIT_CENTER);
						
						if (largeSize) {
							view.setMinimumWidth(width);
							view.setMinimumHeight(height);
						}
						gifs.removeAllViews();
						gifs.addView(view);
						close.setImageResource(R.drawable.close_file);
						close.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
										
									dialog1.dismiss();
								
								}
						});
						dialog1.setCancelable(true);
						dialog1.show();
					}
				}
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.openDrawer(GravityCompat.START);
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
		
		_drawer_linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), GameActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
				i.setClass(getApplicationContext(), PpssppActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_linear9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://t.me/psptools"));
				startActivity(i);
			}
		});
		
		_drawer_linear8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("http://t.me/ppsspp1"));
				startActivity(i);
			}
		});
		
		_drawer_linear7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://github.com/Ninjacoderhsi/Psp-Tools"));
				startActivity(i);
			}
		});
		
		_drawer_linear11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ShellemuActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_mobile_1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AboutMobileYouActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_linear5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AboutActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_linear10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), SettingppssppActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finishAffinity();
			}
		});
		
		_drawer_github.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://github.com/Ninjacoderhsi/Psp-Tools"));
				startActivity(i);
			}
		});
	}
	
	private void initializeLogic() {
		Folder = FileUtil.getExternalStorageDir();
		_RefreshData();
		if (true) {
			     getSupportActionBar().hide();
		}
		else {
					getSupportActionBar().show();
		}
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
			Window w =FilesActivity.this.getWindow();
			w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(0xFF23252A);
		}
		
		
		getWindow().getDecorView()
		  .setSystemUiVisibility(
		    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
		  );
		listview1.setHorizontalScrollBarEnabled(false);
		listview1.setVerticalScrollBarEnabled(false);
		listview1.setOverScrollMode(ListView.OVER_SCROLL_NEVER);
		int nightModeFlags = getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK;
		if (nightModeFlags == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
				//////1
			_drawer_ui1.setBackgroundColor(0xFF000000);
			_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("0xFF002236".replace("0xFF" , "#"))));
			LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);  androidx.drawerlayout.widget.DrawerLayout .LayoutParams params = (androidx.drawerlayout.widget.DrawerLayout .LayoutParams)_nav_view.getLayoutParams();  params.width = (int)getDip((int)250);  params.height = androidx.drawerlayout.widget.DrawerLayout .LayoutParams.MATCH_PARENT;  _nav_view.setLayoutParams(params);
			 _nav_view.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
		} else {
			_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("0xFF2196F3".replace("0xFF" , "#"))));
			LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);  androidx.drawerlayout.widget.DrawerLayout .LayoutParams params = (androidx.drawerlayout.widget.DrawerLayout .LayoutParams)_nav_view.getLayoutParams();  params.width = (int)getDip((int)250);  params.height = androidx.drawerlayout.widget.DrawerLayout .LayoutParams.MATCH_PARENT;  _nav_view.setLayoutParams(params);
			 _nav_view.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
			
				/////3
		};
		if (one.getString("y1", "").equals("")) {
			one.edit().putString("y1", "1").commit();
			final AlertDialog dialog1 = new AlertDialog.Builder(FilesActivity.this).create();
			View inflate = getLayoutInflater().inflate(R.layout.android11,null); 
			dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
			dialog1.setView(inflate);
			androidx.cardview.widget.CardView cardview1 = (androidx.cardview.widget.CardView) inflate.findViewById(R.id.cardview1);
			LinearLayout bg = (LinearLayout) inflate.findViewById(R.id.bg);
			LinearLayout p1 = (LinearLayout) inflate.findViewById(R.id.p1);
			TextView no = (TextView) inflate.findViewById(R.id.no);
			TextView ok = (TextView) inflate.findViewById(R.id.ok);
			bg.setBackground(new android.graphics.drawable.GradientDrawable() { public android.graphics.drawable.GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)1, 0xFFFFFFFF));
			p1.setBackground(new android.graphics.drawable.GradientDrawable() { public android.graphics.drawable.GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)1, 0xFF2196F3));
			cardview1.setCardBackgroundColor(0xFFFFFFFF);
			cardview1.setRadius((float)25);
			cardview1.setCardElevation((float)3);
			no.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
							
						dialog1.dismiss();
					
					}
			});
			ok.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
							
						path = "/sdcard/psp";
					if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
						    try {
							        
							       if (permission()) {	   
								if (FileUtil.isExistFile(path)) {
									FileUtil.makeDir(path);
								}          
										                } else {
										                  RequestPermission_Dialog();
								
										                }
							        
							        
							    } catch (Exception e) {
							               
							    }
								                
							         } else {
						
						if (FileUtil.isExistFile(path)) {
							FileUtil.makeDir(path);
						}
						
					}
					dialog1.dismiss();
					
					}
			});
			dialog1.setCancelable(false);
			dialog1.show();
		}
		else {
			
		}
	}
	
	@Override
	public void onBackPressed() {
		Dialog.setTitle("Psp Tools");
		Dialog.setIcon(R.drawable.ic_splash);
		Dialog.setMessage("Exit in App?");
		Dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				finishAffinity();
			}
		});
		Dialog.setNeutralButton("no", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		Dialog.create().show();
	}
	
	@Override
	public void onStart() {
		super.onStart();
		listview1.setOnScrollListener(new ListView.OnScrollListener() {
				
				private int mLastFirstVisibleItem;
				
				@Override
				public void onScrollStateChanged(AbsListView view, int scrollState) {
				}
				
				@Override
				public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
						
						if(mLastFirstVisibleItem<firstVisibleItem) {
								_fab.hide();
						}
						
						if(mLastFirstVisibleItem>firstVisibleItem) {
								_fab.show();
						}
						
						mLastFirstVisibleItem = firstVisibleItem;
						
				}
				
		});
		_drawer_ppsspp.setImageResource(R.drawable.iconppsspp);
		_drawer_gamestore.setImageResource(R.drawable.gamestore);
		_drawer_github.setImageResource(R.drawable.github_icon);
		_drawer_about.setImageResource(R.drawable.information_variant);
		_drawer_telgram.setImageResource(R.drawable.telegram);
		_drawer_exit.setImageResource(R.drawable.exit_to_app);
		_drawer_mobile.setImageResource(R.drawable.information_outline);
		imageview1.setImageResource(R.drawable.folder);
		_drawer_imageview2.setImageResource(R.drawable.gptel);
		_drawer_imageview3.setImageResource(R.drawable.cog_outline);
		_fab.setImageResource(R.drawable.fabicon);
		_drawer_imageview4.setImageResource(R.drawable.shell);
		_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("0xFF00101A".replace("0xFF" , "#"))));
		if (d.getString("ani", "").equals("1")) {
			linear1.setVisibility(View.VISIBLE);
		}
		else {
			if (d.getString("ani", "").equals("2")) {
				linear1.setVisibility(View.GONE);
				listview1.setFastScrollEnabled(true);
				linear2.setBackgroundColor(0xFF000000);
			}
			else {
				
			}
		}
	}
	public void _RefreshData() {
		listview1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); listview1.setItemsCanFocus(false);
		File_map.clear();
		subtitle = Folder;
		FileUtil.listDir(Folder, liststring);
		Collections.sort(liststring, String.CASE_INSENSITIVE_ORDER);
		position = 0;
		for(int _repeat14 = 0; _repeat14 < (int)(liststring.size()); _repeat14++) {
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("file", liststring.get((int)(position)));
				File_map.add(_item);
			}
			
			position++;
		}
		listview1.setAdapter(new Listview1Adapter(File_map));
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
	}
	
	
	public void _getApkIcon(final String _path, final ImageView _imageview) {
		android.content.pm.PackageManager packageManager = this.getPackageManager();
		android.content.pm.PackageInfo packageInfo = packageManager.getPackageArchiveInfo(_path, 0);
		packageInfo.applicationInfo.sourceDir = _path;
		packageInfo.applicationInfo.publicSourceDir = _path;
		_imageview.setImageDrawable(packageInfo.applicationInfo.loadIcon(packageManager));
		packageInfo = null;
		packageManager = null;
	}
	
	
	public void _setBitmapFromVideo(final ImageView _imageview, final String _path) {
		class ContextClass {
			
			private Context myContext;
			
			public ContextClass(Context activity) {
				myContext = activity;
			}
			
			public ContextClass(Fragment fragment) {
				myContext = fragment.getActivity();
			}
			
			public ContextClass(DialogFragment fragment) {
				myContext = fragment.getActivity();
			}
			
			public final Context getContext() {
				return myContext;
			}
		}
		_imageview.setImageBitmap(new VideoThumbnail(new ContextClass(this).getContext()).fromPath(_path));
	}
	
	
	public void _mm() {
	}
	/*
Code Edited by Hichem Soft
youtube channel : Hichem Soft
*/
	@Override
	    protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		  super.onActivityResult(_requestCode, _resultCode, _data);
		            
		if (_requestCode == new_folder){
			    if (_resultCode == Activity.RESULT_OK) {
				            if (_data != null) {
					              final Uri uri2 = _data.getData();
					if (Uri.decode(uri2.toString()).endsWith(":")) {
						SketchwareUtil.showMessage(getApplicationContext(), "⛔");
						askPermission(uri2.toString());
					}
					else {
						final int takeFlags = i.getFlags()
						            & (Intent.FLAG_GRANT_READ_URI_PERMISSION
						            | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
						// Check for the freshest data.
						getContentResolver().takePersistableUriPermission(uri2, takeFlags);
						
						
						 
						
						
					}
					
					       } else {
					        
					   }
				       } else {
				      
				 
				 
				   }
		}
		
		
		if (_requestCode == 2000) {
				      if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
						        if (Environment.isExternalStorageManager()) {
								          
								        } else {
								
								        }
						      }
				    
		}
		
		
		
		       
		
	}
	
	// solve android 11 sdcard permissions
	
	
	 public void RequestPermission_Dialog() {
		    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
				      try {
						        Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
						        intent.addCategory("android.intent.category.DEFAULT");
						        intent.setData(Uri.parse(String.format("package: ", new Object[]{getApplicationContext().getPackageName()})));
						        startActivityForResult(intent, 2000);
						      } catch (Exception e) {
						        Intent obj = new Intent();
						        obj.setAction(android.provider.Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
						        startActivityForResult(obj, 2000);
						      }
				    } else {
				      androidx.core.app.ActivityCompat.requestPermissions(FilesActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE, android.Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE);
				    }
		  }
	
	  public boolean permission() {
		    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) { // R is Android 11
				      return Environment.isExternalStorageManager();
				    } else {
				      int write = androidx.core.content.ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
				      int read = androidx.core.content.ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.READ_EXTERNAL_STORAGE);
				
				      return write == android.content.pm.PackageManager.PERMISSION_GRANTED
				          && read == android.content.pm.PackageManager.PERMISSION_GRANTED;
				    }
	} 
	
	// ask permissions request
	
	public void askPermission(final String _uri) {
				i.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
						i.setAction(Intent.ACTION_OPEN_DOCUMENT_TREE);
						    i.putExtra(android.provider.DocumentsContract.EXTRA_INITIAL_URI, Uri.parse(_uri));
						        startActivityForResult(i, new_folder);
		}
	
	// check permissions of path if accepted 
	
	
	public boolean checkPermission(final String _uri) {
				Uri muri = Uri.parse(_uri);
				    dFile = androidx.documentfile.provider.DocumentFile.fromTreeUri(getApplicationContext(), muri);
				                    
				if (dFile.canRead() && dFile.canWrite()) {
						return true ;
				}
				return false ;
		}
	
	// simple path to UriTree path
	
	
	public String pathToRealUri( String _path) {
				uriFor1 = "content://com.android.externalstorage.documents/tree/primary%3A";
		
		if ( _path.endsWith("/")) {
			_path = _path.substring(0, _path.length()-1);
		}
		
		
				if (_path.contains("/sdcard/")) {
						uriFor2 = _path.replace("/sdcard/", "").replace("/", "%2F");
						
						if (uriFor2.substring(uriFor2.length()-1, uriFor2.length()).equals("/")) {
								
								uriFor2 = uriFor1.substring(0, uriFor1.length()-1);
								
						}
						
				}
				else {
						if (_path.contains("/storage/") && _path.contains("/emulated/")) {
								uriFor2 = _path.replace("/storage/emulated/0/", "").replace("/", "%2F");
								
								if (uriFor2.substring(uriFor2.length()-1, uriFor2.length()).equals("/")) {
										
										uriFor2 = uriFor1.substring(0, uriFor1.length()-1);
										
								}	
								
						}
						else {
								
						}
				}
				return uriFor1 = uriFor1 + uriFor2;
		}
	
	
	// simple path to UriTree path 2
	
	public String pathToUri( String _path) {
				uriFor1 = "content://com.android.externalstorage.documents/tree/primary%3AAndroid/document/primary%3A";
		
		if ( _path.endsWith("/")) {
			_path = _path.substring(0, _path.length()-1);
		}
		
				if (_path.contains("/sdcard/")) {
						uriFor2 = _path.replace("/sdcard/", "").replace("/", "%2F");
						
						if (uriFor2.substring(uriFor2.length()-1, uriFor2.length()).equals("/")) {
								
								uriFor2 = uriFor1.substring(0, uriFor1.length()-1);
								
						}
						
						
				}
				else {
						if (_path.contains("/storage/") && _path.contains("/emulated/")) {
								uriFor2 = _path.replace("/storage/emulated/0/", "").replace("/", "%2F");
								
								if (uriFor2.substring(uriFor2.length()-1, uriFor2.length()).equals("/")) {
										
										uriFor2 = uriFor1.substring(0, uriFor1.length()-1);
										
								}
								
						}
						else {
								
						}
				}
				return uriFor1 = uriFor1 + uriFor2;
		}
	
	// ccopy file from path to path
	
	private boolean copyAsset(final String assetFilename, final Uri targetUri) {
		  			try{
			  				int count;
			  				InputStream input = null;
					OutputStream output = null;
			  				
			  				ContentResolver content = getApplicationContext().getContentResolver();
						  
			            input = getApplicationContext().getAssets().open(assetFilename);
						
			            output = content.openOutputStream(targetUri);
			            
			            
			  				byte data[] = new byte[1024];
			  				while ((count = input.read(data))>0) {
				  					output.write(data, 0, count);
				  			}
			  				output.flush();
			  				output.close();
			  				input.close();
			  				
			  				SketchwareUtil.showMessage(getApplicationContext(), "success ✔️ نجاح ");
							 
			  		}catch(Exception e){
			  				
			  				SketchwareUtil.showMessage(getApplicationContext(), e.toString());
							  return false;
			  		}
		
		return true;
	}
	
	
	  final static int REQUEST_CODE = 333;
	  final static  int OLD_REQUEST = 2000;
	  private SharedPreferences sha;
	private Intent ninjacoder = new Intent();
		private  Uri muri;
		private String uriFor1 = "";
		private String uriFor2 = "";
		private  
		androidx.documentfile.provider.DocumentFile dFile;
		private double PermissionNumber;
		private  static final int new_folder = 43;
	{
	}
	
	
	public void _classgif() {
	}
	
	public class GifDecoder {
		
		    public static final int STATUS_OK = 0;
		
		    public static final int STATUS_FORMAT_ERROR = 1;
		
		    public static final int STATUS_OPEN_ERROR = 2;
		
		    protected static final int MAX_STACK_SIZE = 4096;
		    protected InputStream in;
		    protected int status;
		    protected int width; // full image width
		    protected int height; // full image height
		    protected boolean gctFlag; // global color table used
		    protected int gctSize; // size of global color table
		    protected int loopCount = 1; // iterations; 0 = repeat forever
		    protected int[] gct; // global color table
		    protected int[] lct; // local color table
		    protected int[] act; // active color table
		    protected int bgIndex; // background color index
		    protected int bgColor; // background color
		    protected int lastBgColor; // previous bg color
		    protected int pixelAspect; // pixel aspect ratio
		    protected boolean lctFlag; // local color table flag
		    protected boolean interlace; // interlace flag
		    protected int lctSize; // local color table size
		    protected int ix, iy, iw, ih; // current image rectangle
		    protected int lrx, lry, lrw, lrh;
		    protected Bitmap image; // current frame
		    protected Bitmap lastBitmap; // previous frame
		    protected byte[] block = new byte[256]; // current data block
		    protected int blockSize = 0; // block size last graphic control extension info
		    protected int dispose = 0; // 0=no action; 1=leave in place; 2=restore to bg; 3=restore to prev
		    protected int lastDispose = 0;
		    protected boolean transparency = false; // use transparent color
		    protected int delay = 0; // delay in milliseconds
		    protected int transIndex; // transparent color index
		    // LZW decoder working arrays
		    protected short[] prefix;
		    protected byte[] suffix;
		    protected byte[] pixelStack;
		    protected byte[] pixels;
		    protected Vector<GifFrame> frames; // frames read from current file
		    protected int frameCount;
		
		    private  class GifFrame {
			            public GifFrame(Bitmap im, int del) {
				                    image = im;
				                    delay = del;
				            }
			
			            public Bitmap image;
			            public int delay;
			    }
		
		
		    public int getDelay(int n) {
			            delay = -1;
			            if ((n >= 0) && (n < frameCount)) {
				                    delay = frames.elementAt(n).delay;
				            }
			            return delay;
			    }
		
		
		    public int getFrameCount() {
			            return frameCount;
			    }
		
		
		    public Bitmap getBitmap() {
			            return getFrame(0);
			    }
		
		
		    public int getLoopCount() {
			            return loopCount;
			    }
		    protected void setPixels() {
			
			            int[] dest = new int[width * height];
			
			            if (lastDispose > 0) {
				                    if (lastDispose == 3) {
					                            // use image before last
					                            int n = frameCount - 2;
					                            if (n > 0) {
						                                    lastBitmap = getFrame(n - 1);
						                            } else {
						                                    lastBitmap = null;
						                            }
					                    }
				                    if (lastBitmap != null) {
					                            lastBitmap.getPixels(dest, 0, width, 0, 0, width, height);
					                            if (lastDispose == 2) {
						                                    // fill last image rect area with background color
						                                    int c = 0;
						                                    if (!transparency) {
							                                            c = lastBgColor;
							                                    }
						                                    for (int i = 0; i < lrh; i++) {
							                                            int n1 = (lry + i) * width + lrx;
							                                            int n2 = n1 + lrw;
							                                            for (int k = n1; k < n2; k++) {
								                                                    dest[k] = c;
								                                            }
							                                    }
						                            }
					                    }
				            }
			            int pass = 1;
			            int inc = 8;
			            int iline = 0;
			            for (int i = 0; i < ih; i++) {
				                    int line = i;
				                    if (interlace) {
					                            if (iline >= ih) {
						                                    pass++;
						                                    switch (pass) {
							                                    case 2:
							                                            iline = 4;
							                                            break;
							                                    case 3:
							                                            iline = 2;
							                                            inc = 4;
							                                            break;
							                                    case 4:
							                                            iline = 1;
							                                            inc = 2;
							                                            break;
							                                    default:
							                                            break;
							                                    }
						                            }
					                            line = iline;
					                            iline += inc;
					                    }
				                    line += iy;
				                    if (line < height) {
					                            int k = line * width;
					                            int dx = k + ix; // start of line in dest
					                            int dlim = dx + iw; // end of dest line
					                            if ((k + width) < dlim) {
						                                    dlim = k + width; // past dest edge
						                            }
					                            int sx = i * iw; // start of line in source
					                            while (dx < dlim) {
						                                    // map color and insert in destination
						                                    int index = ((int) pixels[sx++]) & 0xff;
						                                    int c = act[index];
						                                    if (c != 0) {
							                                            dest[dx] = c;
							                                    }
						                                    dx++;
						                            }
					                    }
				            }
			            image = Bitmap.createBitmap(dest, width, height, android.graphics.Bitmap.Config.ARGB_4444);
			    }
		    public Bitmap getFrame(int n) {
			            if (frameCount <= 0)
			                    return null;
			            n = n % frameCount;
			            return ((GifFrame) frames.elementAt(n)).image;
			    }
		    public int read(InputStream is) {
			            init();
			            if (is != null) {
				                    in = is;
				                    readHeader();
				                    if (!err()) {
					                            readContents();
					                            if (frameCount < 0) {
						                                    status = STATUS_FORMAT_ERROR;
						                            }
					                    }
				            } else {
				                    status = STATUS_OPEN_ERROR;
				            }
			            try {
				                    is.close();
				            } catch (Exception e) {
				            }
			            return status;
			    }      
		    protected void decodeBitmapData() {
			            int nullCode = -1;
			            int npix = iw * ih;
			            int available, clear, code_mask, code_size, end_of_information, in_code, old_code, bits, code, count, i, datum, data_size, first, top, bi, pi;
			            if ((pixels == null) || (pixels.length < npix)) {
				                    pixels = new byte[npix]; // allocate new pixel array
				            }
			            if (prefix == null) {
				                    prefix = new short[MAX_STACK_SIZE];
				            }
			            if (suffix == null) {
				                    suffix = new byte[MAX_STACK_SIZE];
				            }
			            if (pixelStack == null) {
				                    pixelStack = new byte[MAX_STACK_SIZE + 1];
				            }                
			            data_size = read();
			            clear = 1 << data_size;
			            end_of_information = clear + 1;
			            available = clear + 2;
			            old_code = nullCode;
			            code_size = data_size + 1;
			            code_mask = (1 << code_size) - 1;
			            for (code = 0; code < clear; code++) {
				                    prefix[code] = 0; // XXX ArrayIndexOutOfBoundsException
				                    suffix[code] = (byte) code;
				            }               
			            datum = bits = count = first = top = pi = bi = 0;
			            for (i = 0; i < npix;) {
				                    if (top == 0) {
					                            if (bits < code_size) {
						                                    // Load bytes until there are enough bits for a code.
						                                    if (count == 0) {
							                                            // Read a new data block.
							                                            count = readBlock();
							                                            if (count <= 0) {
								                                                    break;
								                                            }
							                                            bi = 0;
							                                    }
						                                    datum += (((int) block[bi]) & 0xff) << bits;
						                                    bits += 8;
						                                    bi++;
						                                    count--;
						                                    continue;
						                            }                               
					                            code = datum & code_mask;
					                            datum >>= code_size;
					                            bits -= code_size;                               
					                            if ((code > available) || (code == end_of_information)) {
						                                    break;
						                            }
					                            if (code == clear) {
						                                    // Reset decoder.
						                                    code_size = data_size + 1;
						                                    code_mask = (1 << code_size) - 1;
						                                    available = clear + 2;
						                                    old_code = nullCode;
						                                    continue;
						                            }
					                            if (old_code == nullCode) {
						                                    pixelStack[top++] = suffix[code];
						                                    old_code = code;
						                                    first = code;
						                                    continue;
						                            }
					                            in_code = code;
					                            if (code == available) {
						                                    pixelStack[top++] = (byte) first;
						                                    code = old_code;
						                            }
					                            while (code > clear) {
						                                    pixelStack[top++] = suffix[code];
						                                    code = prefix[code];
						                            }
					                            first = ((int) suffix[code]) & 0xff;
					                            if (available >= MAX_STACK_SIZE) {
						                                    break;
						                            }
					                            pixelStack[top++] = (byte) first;
					                            prefix[available] = (short) old_code;
					                            suffix[available] = (byte) first;
					                            available++;
					                            if (((available & code_mask) == 0) && (available < MAX_STACK_SIZE)) {
						                                    code_size++;
						                                    code_mask += available;
						                            }
					                            old_code = in_code;
					                    }
				                    // Pop a pixel off the pixel stack.
				                    top--;
				                    pixels[pi++] = pixelStack[top];
				                    i++;
				            }
			            for (i = pi; i < npix; i++) {
				                    pixels[i] = 0; // clear missing pixels
				            }
			    }        
		    protected boolean err() {
			            return status != STATUS_OK;
			    }       
		    protected void init() {
			            status = STATUS_OK;
			            frameCount = 0;
			            frames = new Vector<GifFrame>();
			            gct = null;
			            lct = null;
			    }        
		    protected int read() {
			            int curByte = 0;
			            try {
				                    curByte = in.read();
				            } catch (Exception e) {
				                    status = STATUS_FORMAT_ERROR;
				            }
			            return curByte;
			    }       
		    protected int readBlock() {
			            blockSize = read();
			            int n = 0;
			            if (blockSize > 0) {
				                    try {
					                            int count = 0;
					                            while (n < blockSize) {
						                                    count = in.read(block, n, blockSize - n);
						                                    if (count == -1) {
							                                            break;
							                                    }
						                                    n += count;
						                            }
					                    } catch (Exception e) {
					                            e.printStackTrace();
					                    }
				                    if (n < blockSize) {
					                            status = STATUS_FORMAT_ERROR;
					                    }
				            }
			            return n;
			    }        
		    protected int[] readColorTable(int ncolors) {
			            int nbytes = 3 * ncolors;
			            int[] tab = null;
			            byte[] c = new byte[nbytes];
			            int n = 0;
			            try {
				                    n = in.read(c);
				            } catch (Exception e) {
				                    e.printStackTrace();
				            }
			            if (n < nbytes) {
				                    status = STATUS_FORMAT_ERROR;
				            } else {
				                    tab = new int[256]; // max size to avoid bounds checks
				                    int i = 0;
				                    int j = 0;
				                    while (i < ncolors) {
					                            int r = ((int) c[j++]) & 0xff;
					                            int g = ((int) c[j++]) & 0xff;
					                            int b = ((int) c[j++]) & 0xff;
					                            tab[i++] = 0xff000000 | (r << 16) | (g << 8) | b;
					                    }
				            }
			            return tab;
			    }       
		    protected void readContents() {
			            // read GIF file content blocks
			            boolean done = false;
			            while (!(done || err())) {
				                    int code = read();
				                    switch (code) {
					                    case 0x2C: // image separator
					                            readBitmap();
					                            break;
					                    case 0x21: // extension
					                            code = read();
					                            switch (code) {
						                            case 0xf9: // graphics control extension
						                                    readGraphicControlExt();
						                                    break;
						                            case 0xff: // application extension
						                                    readBlock();
						                                    String app = "";
						                                    for (int i = 0; i < 11; i++) {
							                                            app += (char) block[i];
							                                    }
						                                    if (app.equals("NETSCAPE2.0")) {
							                                            readNetscapeExt();
							                                    } else {
							                                            skip(); // don't care
							                                    }
						                                    break;
						                            case 0xfe:// comment extension
						                                    skip();
						                                    break;
						                            case 0x01:// plain text extension
						                                    skip();
						                                    break;
						                            default: // uninteresting extension
						                                    skip();
						                            }
					                            break;
					                    case 0x3b: // terminator
					                            done = true;
					                            break;
					                    case 0x00: // bad byte, but keep going and see what happens break;
					                    default:
					                            status = STATUS_FORMAT_ERROR;
					                    }
				            }
			    }      
		    protected void readGraphicControlExt() {
			            read(); // block size
			            int packed = read(); // packed fields
			            dispose = (packed & 0x1c) >> 2; // disposal method
			            if (dispose == 0) {
				                    dispose = 1; // elect to keep old image if discretionary
				            }
			            transparency = (packed & 1) != 0;
			            delay = readShort() * 10; // delay in milliseconds
			            transIndex = read(); // transparent color index
			            read(); // block terminator
			    }       
		    protected void readHeader() {
			            String id = "";
			            for (int i = 0; i < 6; i++) {
				                    id += (char) read();
				            }
			            if (!id.startsWith("GIF")) {
				                    status = STATUS_FORMAT_ERROR;
				                    return;
				            }
			            readLSD();
			            if (gctFlag && !err()) {
				                    gct = readColorTable(gctSize);
				                    bgColor = gct[bgIndex];
				            }
			    }        
		    protected void readBitmap() {
			            ix = readShort(); // (sub)image position & size
			            iy = readShort();
			            iw = readShort();
			            ih = readShort();
			            int packed = read();
			            lctFlag = (packed & 0x80) != 0; // 1 - local color table flag interlace
			            lctSize = (int) Math.pow(2, (packed & 0x07) + 1);
			            interlace = (packed & 0x40) != 0;
			            if (lctFlag) {
				                    lct = readColorTable(lctSize); // read table
				                    act = lct; // make local table active
				            } else {
				                    act = gct; // make global table active
				                    if (bgIndex == transIndex) {
					                            bgColor = 0;
					                    }
				            }
			            int save = 0;
			            if (transparency) {
				                    save = act[transIndex];
				                    act[transIndex] = 0; // set transparent color if specified
				            }
			            if (act == null) {
				                    status = STATUS_FORMAT_ERROR; // no color table defined
				            }
			            if (err()) {
				                    return;
				            }
			            decodeBitmapData(); // decode pixel data
			            skip();
			            if (err()) {
				                    return;
				            }
			            frameCount++;
			            // create new image to receive frame data
			            image = Bitmap.createBitmap(width, height, android.graphics.Bitmap.Config.ARGB_4444);
			            setPixels(); // transfer pixel data to image
			            frames.addElement(new GifFrame(image, delay)); // add image to frame
			            // list
			            if (transparency) {
				                    act[transIndex] = save;
				            }
			            resetFrame();
			    }
		    protected void readLSD() {
			            // logical screen size
			            width = readShort();
			            height = readShort();
			            // packed fields
			            int packed = read();
			            gctFlag = (packed & 0x80) != 0; // 1 : global color table flag
			            // 2-4 : color resolution
			            // 5 : gct sort flag
			            gctSize = 2 << (packed & 7); // 6-8 : gct size
			            bgIndex = read(); // background color index
			            pixelAspect = read(); // pixel aspect ratio
			    }       
		    protected void readNetscapeExt() {
			            do {
				                    readBlock();
				                    if (block[0] == 1) {
					                            // loop count sub-block
					                            int b1 = ((int) block[1]) & 0xff;
					                            int b2 = ((int) block[2]) & 0xff;
					                            loopCount = (b2 << 8) | b1;
					                    }
				            } while ((blockSize > 0) && !err());
			    }       
		    protected int readShort() {
			            // read 16-bit value, LSB first
			            return read() | (read() << 8);
			    }
		    protected void resetFrame() {
			            lastDispose = dispose;
			            lrx = ix;
			            lry = iy;
			            lrw = iw;
			            lrh = ih;
			            lastBitmap = image;
			            lastBgColor = bgColor;
			            dispose = 0;
			            transparency = false;
			            delay = 0;
			            lct = null;
			    }
		    protected void skip() {
			            do {
				                    readBlock();
				            } while ((blockSize > 0) && !err());
			    }
	}
	
	public class GifDecoderView extends ImageView {
		
		private boolean mIsPlayingGif = false;
		
		private GifDecoder mGifDecoder;
		
		private Bitmap mTmpBitmap;
		
		final Handler mHandler = new Handler();
		
		
		    
		
		final Runnable mUpdateResults = new Runnable() {
			    public void run() {
				        if (mTmpBitmap != null && !mTmpBitmap.isRecycled()) {
					            GifDecoderView.this.setImageBitmap(mTmpBitmap);
					        }
				    }
		};
		
		public GifDecoderView(Context context, InputStream stream) {
			    super(context);
			    playGif(stream);
		}
		
		private void playGif(InputStream stream) {
			    mGifDecoder = new GifDecoder();
			    mGifDecoder.read(stream);
			
			    mIsPlayingGif = true;
			
			    new Thread(new Runnable() {
				        public void run() {
					            final int n = mGifDecoder.getFrameCount();
					            final int ntimes = mGifDecoder.getLoopCount();
					            int repetitionCounter = 0;
					            do {
						                for (int i = 0; i < n; i++) {
							                    mTmpBitmap = mGifDecoder.getFrame(i);
							                    int t = mGifDecoder.getDelay(i);
							                    mHandler.post(mUpdateResults);
							                    try {
								                        Thread.sleep(t);
								                    } catch (InterruptedException e) {
								                        e.printStackTrace();
								                    }
							                }
						                if(ntimes != 0) {
							                    repetitionCounter ++;
							                }
						            } while (mIsPlayingGif && (repetitionCounter <= ntimes));
					        }
				    }).start();
		}
		
		public void stopRendering() {
			    mIsPlayingGif = true;
		}
	}
	
	public class GifMovieView extends View {
		
		private Movie mMovie;
		
		private long mMoviestart;
		
		public GifMovieView(Context context, InputStream stream) {
			    super(context);
			
			    mMovie = Movie.decodeStream(stream);        
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			    canvas.drawColor(Color.TRANSPARENT);
			    super.onDraw(canvas);
			    final long now = SystemClock.uptimeMillis();
			
			    if (mMoviestart == 0) { 
				        mMoviestart = now;
				    }
			
			    final int relTime = (int)((now - mMoviestart) % mMovie.duration());
			    mMovie.setTime(relTime);
			    mMovie.draw(canvas, 10, 10);
			    this.invalidate();
		}
	}
	
	{
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
				_view = _inflater.inflate(R.layout.custom_files, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView format = _view.findViewById(R.id.format);
			final TextView bilgi = _view.findViewById(R.id.bilgi);
			final CheckBox checkbox2 = _view.findViewById(R.id.checkbox2);
			final TextView idgames = _view.findViewById(R.id.idgames);
			
			textview1.setText(Uri.parse(liststring.get((int)(_position))).getLastPathSegment());
			///////Add vicrtor image So Speed To App///////
			if (FileUtil.isDirectory(liststring.get((int)(_position)))) {
				imageview1.setImageResource(R.drawable.folder);
			}
			else {
				if (liststring.get((int)(_position)).endsWith(".png") || liststring.get((int)(_position)).endsWith(".jpg")) {
					imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(liststring.get((int)(_position)), 1024, 1024));
					info = liststring.get((int)(_position));
					final java.io.File file1 = new java.io.File(info);
					try{
						long length = file1.length();
						length = length/1024;
						bilgi.setText("File size : " + length +" KB");
					}catch(Exception e){
						showMessage("File not found : " + e.getMessage() + e);
					}
					if (chack) {
						checkbox2.setChecked(true);
					}
					else {
						checkbox2.setChecked(false);
					}
				}
				else {
					if (liststring.get((int)(_position)).endsWith(".tk") || liststring.get((int)(_position)).endsWith(".tk")) {
						imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(liststring.get((int)(_position)), 1024, 1024));
						info = liststring.get((int)(_position));
						final java.io.File file1 = new java.io.File(info);
						try{
							long length = file1.length();
							length = length/1024;
							bilgi.setText("File size : " + length +" KB");
						}catch(Exception e){
							showMessage("File not found : " + e.getMessage() + e);
						}
						format.setText("TK.JKH");
						idgames.setText("USA.JPN");
						linear1.setBackground(new android.graphics.drawable.GradientDrawable() { public android.graphics.drawable.GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)15, 0xFFF44336));
						linear1.setElevation((int)5);
					}
					else {
						if (liststring.get((int)(_position)).endsWith(".mp4") || (liststring.get((int)(_position)).endsWith(".acc") || liststring.get((int)(_position)).endsWith(".mp5"))) {
							/////copmliter in image victor Pathini/////
							_setBitmapFromVideo(imageview1, liststring.get((int)(_position)));
						}
						else {
							if (liststring.get((int)(_position)).endsWith(".ini")) {
								linear1.setBackground(new android.graphics.drawable.GradientDrawable() { public android.graphics.drawable.GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)15, 0xFF3F51B5));
								linear1.setElevation((int)5);
								imageview1.setImageResource(R.drawable.inipath);
								info = liststring.get((int)(_position));
								final java.io.File file1 = new java.io.File(info);
								try{
									long length = file1.length();
									length = length/1024;
									bilgi.setText("File size : " + length +" KB");
								}catch(Exception e){
									showMessage("File not found : " + e.getMessage() + e);
								}
							}
							else {
								/////
								if (liststring.get((int)(_position)).endsWith(".nomedia")) {
									info = liststring.get((int)(_position));
									final java.io.File file1 = new java.io.File(info);
									try{
										long length = file1.length();
										length = length/1024;
										bilgi.setText("File size : " + length +" KB");
									}catch(Exception e){
										showMessage("File not found : " + e.getMessage() + e);
									}
									imageview1.setImageResource(R.drawable.unknown);
								}
								else {
									if (liststring.get((int)(_position)).endsWith(".ISO") || liststring.get((int)(_position)).endsWith(".iso")) {
										imageview1.setImageResource(R.drawable.isofile);
										final java.io.File file1 = new java.io.File(info);
										try{
											long length = file1.length();
											length = length/1024;
											bilgi.setText("File size : " + length +" KB");
										}catch(Exception e){
											showMessage("File not found : " + e.getMessage() + e);
										}
										info = liststring.get((int)(_position));
									}
									else {
										if (liststring.get((int)(_position)).endsWith(".cso")) {
											imageview1.setImageResource(R.drawable.csofile);
											final java.io.File file1 = new java.io.File(info);
											try{
												long length = file1.length();
												length = length/1024;
												bilgi.setText("File size : " + length +" KB");
											}catch(Exception e){
												showMessage("File not found : " + e.getMessage() + e);
											}
											info = liststring.get((int)(_position));
										}
										else {
											if (liststring.get((int)(_position)).endsWith(".zip")) {
												imageview1.setImageResource(R.drawable.zipfile);
												info = liststring.get((int)(_position));
												final java.io.File file1 = new java.io.File(info);
												try{
													long length = file1.length();
													length = length/1024;
													bilgi.setText("File size : " + length +" KB");
												}catch(Exception e){
													showMessage("File not found : " + e.getMessage() + e);
												}
											}
											else {
												if (liststring.get((int)(_position)).endsWith(".rar")) {
													imageview1.setImageResource(R.drawable.rarfile);
													info = liststring.get((int)(_position));
													final java.io.File file1 = new java.io.File(info);
													try{
														long length = file1.length();
														length = length/1024;
														bilgi.setText("File size : " + length +" KB");
													}catch(Exception e){
														showMessage("File not found : " + e.getMessage() + e);
													}
												}
												else {
													if (liststring.get((int)(_position)).endsWith(".apk")) {
														info = liststring.get((int)(_position));
														final java.io.File file1 = new java.io.File(info);
														try{
															long length = file1.length();
															length = length/1024;
															bilgi.setText("File size : " + length +" KB");
														}catch(Exception e){
															showMessage("File not found : " + e.getMessage() + e);
														}
														_getApkIcon(liststring.get((int)(_position)), imageview1);
													}
													else {
														if (liststring.get((int)(_position)).endsWith(".xml") || (liststring.get((int)(_position)).endsWith(".txt") || liststring.get((int)(_position)).endsWith(".json"))) {
															imageview1.setImageResource(R.drawable.xml_code);
															info = liststring.get((int)(_position));
															final java.io.File file1 = new java.io.File(info);
															try{
																long length = file1.length();
																length = length/1024;
																bilgi.setText("File size : " + length +" KB");
															}catch(Exception e){
																showMessage("File not found : " + e.getMessage() + e);
															}
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
					}
				}
			}
			idgames.setVisibility(View.GONE);
			checkbox2.setVisibility(View.GONE);
			if (d.getString("ani", "").equals("1")) {
				//ARGHOZALI
				
				Animation animation; animation = AnimationUtils.loadAnimation( getApplicationContext(), android.R.anim.slide_in_left ); animation.setDuration(700); linear1.startAnimation(animation); animation = null;
			}
			else {
				if (d.getString("ani", "").equals("2")) {
					
				}
				else {
					
				}
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