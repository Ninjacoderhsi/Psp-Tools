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
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.os.Build;
import androidx.core.content.FileProvider;
import java.io.File;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.AdapterView;
import android.view.View;
import org.jetbrains.kotlin.*;
import me.ibrahimsn.particle.*;
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
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_linear2;
	private LinearLayout _drawer_linear3;
	private LinearLayout _drawer_linear4;
	private LinearLayout _drawer_linear5;
	private LinearLayout _drawer_mobile_1;
	private LinearLayout _drawer_linear7;
	private LinearLayout _drawer_linear8;
	private LinearLayout _drawer_linear9;
	private LinearLayout _drawer_linear6;
	private ImageView _drawer_imageview1;
	private ImageView _drawer_gamestore;
	private TextView _drawer_textview1;
	private ImageView _drawer_ppsspp;
	private TextView _drawer_textview2;
	private ImageView _drawer_about;
	private TextView _drawer_textview3;
	private ImageView _drawer_mobile;
	private TextView _drawer_textview5;
	private ImageView _drawer_github;
	private TextView _drawer_textview7;
	private ImageView _drawer_telgram;
	private TextView _drawer_textview6;
	private ImageView _drawer_imageview2;
	private TextView _drawer_textview8;
	private ImageView _drawer_exit;
	private TextView _drawer_textview4;
	
	private Intent i = new Intent();
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	private Intent tt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	private File _file_tt;
	private AlertDialog.Builder Dialog;
	
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
		_drawer_linear1 = _nav_view.findViewById(R.id.linear1);
		_drawer_linear2 = _nav_view.findViewById(R.id.linear2);
		_drawer_linear3 = _nav_view.findViewById(R.id.linear3);
		_drawer_linear4 = _nav_view.findViewById(R.id.linear4);
		_drawer_linear5 = _nav_view.findViewById(R.id.linear5);
		_drawer_mobile_1 = _nav_view.findViewById(R.id.mobile_1);
		_drawer_linear7 = _nav_view.findViewById(R.id.linear7);
		_drawer_linear8 = _nav_view.findViewById(R.id.linear8);
		_drawer_linear9 = _nav_view.findViewById(R.id.linear9);
		_drawer_linear6 = _nav_view.findViewById(R.id.linear6);
		_drawer_imageview1 = _nav_view.findViewById(R.id.imageview1);
		_drawer_gamestore = _nav_view.findViewById(R.id.gamestore);
		_drawer_textview1 = _nav_view.findViewById(R.id.textview1);
		_drawer_ppsspp = _nav_view.findViewById(R.id.ppsspp);
		_drawer_textview2 = _nav_view.findViewById(R.id.textview2);
		_drawer_about = _nav_view.findViewById(R.id.about);
		_drawer_textview3 = _nav_view.findViewById(R.id.textview3);
		_drawer_mobile = _nav_view.findViewById(R.id.mobile);
		_drawer_textview5 = _nav_view.findViewById(R.id.textview5);
		_drawer_github = _nav_view.findViewById(R.id.github);
		_drawer_textview7 = _nav_view.findViewById(R.id.textview7);
		_drawer_telgram = _nav_view.findViewById(R.id.telgram);
		_drawer_textview6 = _nav_view.findViewById(R.id.textview6);
		_drawer_imageview2 = _nav_view.findViewById(R.id.imageview2);
		_drawer_textview8 = _nav_view.findViewById(R.id.textview8);
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
					if (liststring.get((int)(_position)).endsWith(".ini")) {
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
		
		_drawer_linear5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AboutActivity.class);
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
		
		_drawer_linear7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://github.com/Ninjacoderhsi/Psp-Tools"));
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
		
		_drawer_linear9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://t.me/psptools"));
				startActivity(i);
			}
		});
		
		_drawer_linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finishAffinity();
			}
		});
		
		_drawer_imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
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
		LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view);  androidx.drawerlayout.widget.DrawerLayout .LayoutParams params = (androidx.drawerlayout.widget.DrawerLayout .LayoutParams)_nav_view.getLayoutParams();  params.width = (int)getDip((int)250);  params.height = androidx.drawerlayout.widget.DrawerLayout .LayoutParams.MATCH_PARENT;  _nav_view.setLayoutParams(params);
		 _nav_view.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
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
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
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
														imageview1.setImageResource(R.drawable.apkfile);
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
			checkbox2.setVisibility(View.GONE);
			//ARGHOZALI
			
			Animation animation; animation = AnimationUtils.loadAnimation( getApplicationContext(), android.R.anim.slide_in_left ); animation.setDuration(700); linear1.startAnimation(animation); animation = null;
			
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