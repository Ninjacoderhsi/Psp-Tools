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
import android.widget.ScrollView;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.view.View;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Typeface;
import arabware.libs.getThumbnail.*;
import org.jetbrains.kotlin.*;
import me.ibrahimsn.particle.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class IniActivity extends AppCompatActivity {
	
	private FloatingActionButton _fab;
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout mod;
	private ImageView undo;
	private ImageView redo;
	private ImageView selectall;
	private ImageView addfile;
	private ImageView cut;
	private ImageView copy;
	private ImageView past;
	private ScrollView vscroll1;
	private LinearLayout editor;
	private Ninjacoder hsimod;
	private LinearLayout linear7;
	private TextView textview49;
	private TextView textview50;
	private TextView textview54;
	private TextView textview51;
	private TextView textview52;
	private TextView textview53;
	private TextView textview55;
	private TextView textview56;
	private TextView textview57;
	private TextView textview58;
	private TextView textview59;
	private TextView textview60;
	private TextView textview61;
	private TextView textview62;
	private TextView textview63;
	private TextView textview64;
	
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
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		mod = findViewById(R.id.mod);
		undo = findViewById(R.id.undo);
		redo = findViewById(R.id.redo);
		selectall = findViewById(R.id.selectall);
		addfile = findViewById(R.id.addfile);
		cut = findViewById(R.id.cut);
		copy = findViewById(R.id.copy);
		past = findViewById(R.id.past);
		vscroll1 = findViewById(R.id.vscroll1);
		editor = findViewById(R.id.editor);
		hsimod = findViewById(R.id.hsimod);
		linear7 = findViewById(R.id.linear7);
		textview49 = findViewById(R.id.textview49);
		textview50 = findViewById(R.id.textview50);
		textview54 = findViewById(R.id.textview54);
		textview51 = findViewById(R.id.textview51);
		textview52 = findViewById(R.id.textview52);
		textview53 = findViewById(R.id.textview53);
		textview55 = findViewById(R.id.textview55);
		textview56 = findViewById(R.id.textview56);
		textview57 = findViewById(R.id.textview57);
		textview58 = findViewById(R.id.textview58);
		textview59 = findViewById(R.id.textview59);
		textview60 = findViewById(R.id.textview60);
		textview61 = findViewById(R.id.textview61);
		textview62 = findViewById(R.id.textview62);
		textview63 = findViewById(R.id.textview63);
		textview64 = findViewById(R.id.textview64);
		cred = getSharedPreferences("cred", Activity.MODE_PRIVATE);
		cpink = getSharedPreferences("cpink", Activity.MODE_PRIVATE);
		
		selectall.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((EditText)hsimod).selectAll();
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
		
		cut.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				hsimod.setText("");
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", hsimod.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Cut Text".concat(hsimod.getText().toString()));
			}
		});
		
		copy.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", hsimod.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Cupied!!!!");
			}
		});
		
		past.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				((android.content.ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).addPrimaryClipChangedListener(new android.content.ClipboardManager.OnPrimaryClipChangedListener() {
					public void onPrimaryClipChanged() {
						
						android.content.ClipboardManager clipboard = (android.content.ClipboardManager) getSystemService(CLIPBOARD_SERVICE); 
						String clip = clipboard.getText().toString();
						hsimod.setText(clip);
						
					}
				});
				
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (getIntent().getStringExtra("save").equals("empty")) {
					
				}
				else {
					FileUtil.writeFile(getIntent().getStringExtra("save"), hsimod.getText().toString());
					SketchwareUtil.showMessage(getApplicationContext(), "saved");
				}
			}
		});
	}
	
	private void initializeLogic() {
		hsimod.setText(getIntent().getStringExtra("file"));
		hsimod.setTextColor(0xFFFFFFFF);
		hsimod.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/gow.ttf"), 1);
		colorHandles(hsimod, 0xFFF44336);
		setCursorDrawableColor(hsimod, 0xFFF44336);
		hsimod.setHighlightColor(0xFFF44336);
		hsimod.setHorizontallyScrolling(true);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			SketchUi.setColor(0xFF424242);float lt = getDip(39);
			float rt = getDip(39);
			float rb = getDip(0);
			float lb = getDip(0);
			SketchUi.setCornerRadii(new float[]{
					lt,lt,rt ,rt,rb,rb ,lb,lb });
			SketchUi.setStroke((int)getDip(1) ,0xFF9C27B0);
			linear7.setElevation(getDip(5));
			linear7.setBackground(SketchUi);
		}
		{
			android.graphics.drawable.GradientDrawable SketchUi = new android.graphics.drawable.GradientDrawable();
			SketchUi.setColor(0xFF424242);float lt = getDip(0);
			float rt = getDip(0);
			float rb = getDip(20);
			float lb = getDip(20);
			SketchUi.setCornerRadii(new float[]{
					lt,lt,rt ,rt,rb,rb ,lb,lb });
			SketchUi.setStroke((int)getDip(2) ,0xFF9C27B0);
			linear2.setElevation(getDip(5));
			linear2.setBackground(SketchUi);
		}
		_editUndoRedo(hsimod, undo, redo);
		undo.setImageResource(R.drawable.editor_undo);
		redo.setImageResource(R.drawable.editor_redo);
		selectall.setImageResource(R.drawable.editor_selectall);
		addfile.setImageResource(R.drawable.editor_notebookplus);
		cut.setImageResource(R.drawable.editor_cut);
		copy.setImageResource(R.drawable.editor_copy);
		past.setImageResource(R.drawable.editor_past);
		_fab.setImageResource(R.drawable.editor_save);
		_fab.setBackgroundTintList(android.content.res.ColorStateList.valueOf(Color.parseColor("0xFF011231".replace("0xFF" , "#"))));
		_colortextred();
		_colortextpimk();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		SketchwareUtil.showMessage(getApplicationContext(), "در حال بارگذاری صبور باشید.......\n\nloading.......");
	}
	public void _Pastme() {
	}
	public void past(View v){
		
		    String selected = hsimod.getText().toString().substring(hsimod.getSelectionStart(), hsimod.getSelectionEnd());
		    
		    TextView t = (TextView)v;
		    
		    String text = t.getText().toString();
		    
		    if (selected.length() >0){
			      Editable e = hsimod.getText();
			      int start = hsimod.getSelectionStart();
			      int end = hsimod.getSelectionEnd();
			      if (end > 0){
				        e.replace(Math.min(start, end), Math.max(start, end), text);
				        
				      }
			    } else {
			      hsimod.getText().insert(hsimod.getSelectionStart(), text);
			    }
		
		  }
	  {
	}
	
	
	public void _editUndoRedo(final TextView _edittext, final View _undo, final View _redo) {
		final TextViewUndoRedo helper = new TextViewUndoRedo(_edittext);
		_undo.setOnClickListener (new View.OnClickListener() {
			@Override
			          public void onClick(View v) {
				            helper.undo();
				          }
		});
		_redo.setOnClickListener (new View.OnClickListener() {
			@Override
			          public void onClick(View v) {
				            helper.redo();
				          }
		});
	}
	public class TextViewUndoRedo {
			
			private boolean mIsUndoOrRedo = false;
			private EditHistory mEditHistory;
			private EditTextChangeListener mChangeListener;
			private TextView mTextView;
		
			
			public TextViewUndoRedo(TextView textView) {
					mTextView = textView;
					mEditHistory = new EditHistory();
					mChangeListener = new EditTextChangeListener();
					mTextView.addTextChangedListener(mChangeListener);
			}
		
			public void disconnect() {
					mTextView.removeTextChangedListener(mChangeListener);
			}
		
			public void setMaxHistorySize(int maxHistorySize) {
					mEditHistory.setMaxHistorySize(maxHistorySize);
			}
		
			public void clearHistory() {
					mEditHistory.clear();
			}
		
			
			public boolean getCanUndo() {
					return (mEditHistory.mmPosition > 0);
			}
		
			public void undo() {
					EditItem edit = mEditHistory.getPrevious();
					if (edit == null) {
							return;
					}
			
					Editable text = mTextView.getEditableText();
					int start = edit.mmStart;
					int end = start + (edit.mmAfter != null ? edit.mmAfter.length() : 0);
			
					mIsUndoOrRedo = true;
					text.replace(start, end, edit.mmBefore);
					mIsUndoOrRedo = false;
			
					for (Object o : text.getSpans(0, text.length(), android.text.style.UnderlineSpan.class)) {
							text.removeSpan(o);
					}
			
					Selection.setSelection(text, edit.mmBefore == null ? start
							: (start + edit.mmBefore.length()));
			}
		
			public boolean getCanRedo() {
					return (mEditHistory.mmPosition < mEditHistory.mmHistory.size());
			}
		
			public void redo() {
					EditItem edit = mEditHistory.getNext();
					if (edit == null) {
							return;
					}
			
					Editable text = mTextView.getEditableText();
					int start = edit.mmStart;
					int end = start + (edit.mmBefore != null ? edit.mmBefore.length() : 0);
			
					mIsUndoOrRedo = true;
					text.replace(start, end, edit.mmAfter);
					mIsUndoOrRedo = false;
			
					for (Object o : text.getSpans(0, text.length(), android.text.style.UnderlineSpan.class)) {
							text.removeSpan(o);
					}
			
					Selection.setSelection(text, edit.mmAfter == null ? start
							: (start + edit.mmAfter.length()));
			}
		
			public void storePersistentState(android.content.SharedPreferences.Editor editor, String prefix) {
			
					editor.putString(prefix + ".hash",
							String.valueOf(mTextView.getText().toString().hashCode()));
					editor.putInt(prefix + ".maxSize", mEditHistory.mmMaxHistorySize);
					editor.putInt(prefix + ".position", mEditHistory.mmPosition);
					editor.putInt(prefix + ".size", mEditHistory.mmHistory.size());
			
					int i = 0;
					for (EditItem ei : mEditHistory.mmHistory) {
							String pre = prefix + "." + i;
				
							editor.putInt(pre + ".start", ei.mmStart);
							editor.putString(pre + ".before", ei.mmBefore.toString());
							editor.putString(pre + ".after", ei.mmAfter.toString());
				
							i++;
					}
			}
		
			public boolean restorePersistentState(SharedPreferences sp, String prefix)
					throws IllegalStateException {
			
					boolean ok = doRestorePersistentState(sp, prefix);
					if (!ok) {
							mEditHistory.clear();
					}
			
					return ok;
			}
		
			private boolean doRestorePersistentState(SharedPreferences sp, String prefix) {
			
					String hash = sp.getString(prefix + ".hash", null);
					if (hash == null) {
							return true;
					}
			
					if (Integer.valueOf(hash) != mTextView.getText().toString().hashCode()) {
							return false;
					}
			
					mEditHistory.clear();
					mEditHistory.mmMaxHistorySize = sp.getInt(prefix + ".maxSize", -1);
			
					int count = sp.getInt(prefix + ".size", -1);
					if (count == -1) {
							return false;
					}
			
					for (int i = 0; i < count; i++) {
							String pre = prefix + "." + i;
				
							int start = sp.getInt(pre + ".start", -1);
							String before = sp.getString(pre + ".before", null);
							String after = sp.getString(pre + ".after", null);
				
							if (start == -1 || before == null || after == null) {
									return false;
							}
							mEditHistory.add(new EditItem(start, before, after));
					}
			
					mEditHistory.mmPosition = sp.getInt(prefix + ".position", -1);
					if (mEditHistory.mmPosition == -1) {
							return false;
					}
			
					return true;
			}
		
			private final class EditHistory {
			
					private int mmPosition = 0;
					private int mmMaxHistorySize = -1;
					private final LinkedList<EditItem> mmHistory = new LinkedList<EditItem>();
					private void clear() {
							mmPosition = 0;
							mmHistory.clear();
					}
			
					private void add(EditItem item) {
							while (mmHistory.size() > mmPosition) {
									mmHistory.removeLast();
							}
							mmHistory.add(item);
							mmPosition++;
				
							if (mmMaxHistorySize >= 0) {
									trimHistory();
							}
					}
			
					private void setMaxHistorySize(int maxHistorySize) {
							mmMaxHistorySize = maxHistorySize;
							if (mmMaxHistorySize >= 0) {
									trimHistory();
							}
					}
			
					private void trimHistory() {
							while (mmHistory.size() > mmMaxHistorySize) {
									mmHistory.removeFirst();
									mmPosition--;
							}
				
							if (mmPosition < 0) {
									mmPosition = 0;
							}
					}
			
					private EditItem getPrevious() {
							if (mmPosition == 0) {
									return null;
							}
							mmPosition--;
							return mmHistory.get(mmPosition);
					}
			
					private EditItem getNext() {
							if (mmPosition >= mmHistory.size()) {
									return null;
							}
				
							EditItem item = mmHistory.get(mmPosition);
							mmPosition++;
							return item;
					}
			}
		
			private final class EditItem {
					private final int mmStart;
					private final CharSequence mmBefore;
					private final CharSequence mmAfter;
			
					public EditItem(int start, CharSequence before, CharSequence after) {
							mmStart = start;
							mmBefore = before;
							mmAfter = after;
					}
			}
		
			private final class EditTextChangeListener implements TextWatcher {
			
					private CharSequence mBeforeChange;
					private CharSequence mAfterChange;
			
					public void beforeTextChanged(CharSequence s, int start, int count,
							int after) {
							if (mIsUndoOrRedo) {
									return;
							}
				
							mBeforeChange = s.subSequence(start, start + count);
					}
			
					public void onTextChanged(CharSequence s, int start, int before,
							int count) {
							if (mIsUndoOrRedo) {
									return;
							}
				
							mAfterChange = s.subSequence(start, start + count);
							mEditHistory.add(new EditItem(start, mBeforeChange, mAfterChange));
					}
			
					public void afterTextChanged(Editable s) {
					}
			}
	}
	{
	}
	
	
	public void _more() {
	}
	public static void colorHandles(TextView view, int color) {
		        try {
			            java.lang.reflect.Field editorField = TextView.class.getDeclaredField("mEditor");
			            if (!editorField.isAccessible()) {
				                editorField.setAccessible(true);
				            }
			            Object editor = editorField.get(view);
			            Class<?> editorClass = editor.getClass();
			            String[] handleNames = {"mSelectHandleLeft", "mSelectHandleRight", "mSelectHandleCenter"};
			            String[] resNames = {"mTextSelectHandleLeftRes", "mTextSelectHandleRightRes", "mTextSelectHandleRes"};
			            for (int i = 0; i < handleNames.length; i++) {
				                java.lang.reflect.Field handleField = editorClass.getDeclaredField(handleNames[i]);
				                if (!handleField.isAccessible()) {
					                    handleField.setAccessible(true);
					                }
				                android.graphics.drawable.Drawable handleDrawable = (android.graphics.drawable.Drawable) handleField.get(editor);
				                if (handleDrawable == null) {
					                    java.lang.reflect.Field resField = TextView.class.getDeclaredField(resNames[i]);
					                    if (!resField.isAccessible()) {
						                        resField.setAccessible(true);
						                    }
					                    int resId = resField.getInt(view);
					                    handleDrawable = view.getResources().getDrawable(resId);
					                }
				                if (handleDrawable != null) {
					                    android.graphics.drawable.Drawable drawable = handleDrawable.mutate();
					                    drawable.setColorFilter(color, PorterDuff.Mode.SRC_IN);
					                    handleField.set(editor, drawable);
					                }
				            }
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
		    }
	
	    public static void setCursorDrawableColor(TextView editText, int color) {
		        try {
			            java.lang.reflect.Field fCursorDrawableRes = TextView.class.getDeclaredField("mCursorDrawableRes");
			            fCursorDrawableRes.setAccessible(true);
			            int mCursorDrawableRes = fCursorDrawableRes.getInt(editText);
			            java.lang.reflect.Field fEditor = TextView.class.getDeclaredField("mEditor");
			            fEditor.setAccessible(true);
			            Object editor = fEditor.get(editText);
			            Class<?> clazz = editor.getClass();
			            java.lang.reflect.Field fCursorDrawable = clazz.getDeclaredField("mCursorDrawable");
			            fCursorDrawable.setAccessible(true);
			            android.graphics.drawable.Drawable[] drawables = new android.graphics.drawable.Drawable[2];
			            android.content.res.Resources res = editText.getContext().getResources();
			            drawables[0] = res.getDrawable(mCursorDrawableRes);
			            drawables[1] = res.getDrawable(mCursorDrawableRes);
			            drawables[0].setColorFilter(color, PorterDuff.Mode.SRC_IN);
			            drawables[1].setColorFilter(color, PorterDuff.Mode.SRC_IN);
			            fCursorDrawable.set(editor, drawables);
			        } catch (final Throwable ignored) {
			        }
	}
	{
	}
	
	
	public void _colortextred() {
		if (cred.getString("red", "").equals("reds")) {
			hsimod.setTextColor(0xFFF44336);
			textview49.setTextColor(0xFFF44336);
			textview50.setTextColor(0xFFF44336);
			textview54.setTextColor(0xFFF44336);
			textview51.setTextColor(0xFFF44336);
			textview52.setTextColor(0xFFF44336);
			textview53.setTextColor(0xFFF44336);
			textview55.setTextColor(0xFFF44336);
			textview56.setTextColor(0xFFF44336);
			textview57.setTextColor(0xFFF44336);
			textview58.setTextColor(0xFFF44336);
			textview59.setTextColor(0xFFF44336);
			textview60.setTextColor(0xFFF44336);
			textview61.setTextColor(0xFFF44336);
			textview62.setTextColor(0xFFF44336);
			textview63.setTextColor(0xFFF44336);
			textview64.setTextColor(0xFFF44336);
		}
		else {
			
		}
	}
	
	
	public void _colortextpimk() {
		if (cpink.getString("pink", "").equals("pinks")) {
			hsimod.setTextColor(0xFFE91E63);
			textview49.setTextColor(0xFFE91E63);
			textview50.setTextColor(0xFFE91E63);
			textview54.setTextColor(0xFFE91E63);
			textview51.setTextColor(0xFFE91E63);
			textview52.setTextColor(0xFFE91E63);
			textview53.setTextColor(0xFFE91E63);
			textview55.setTextColor(0xFFE91E63);
			textview56.setTextColor(0xFFE91E63);
			textview57.setTextColor(0xFFE91E63);
			textview58.setTextColor(0xFFE91E63);
			textview59.setTextColor(0xFFE91E63);
			textview60.setTextColor(0xFFE91E63);
			textview61.setTextColor(0xFFE91E63);
			textview62.setTextColor(0xFFE91E63);
			textview63.setTextColor(0xFFE91E63);
			textview64.setTextColor(0xFFE91E63);
		}
		else {
			
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