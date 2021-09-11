package org.ppsspp.ppsspp;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Environment;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SimpleFileChooser {
    private static final String PARENT_DIR = "..";
    private Comparator<File> fileArrayComparator = new Comparator<File>() {
        public int compare(File file, File file2) {
            if (file != null) {
                if (file2 != null) {
                    return (!file.isDirectory() || file2.isDirectory()) ? (!file2.isDirectory() || file.isDirectory()) ? file.getName().toUpperCase().compareTo(file2.getName().toUpperCase()) : 1 : -1;
                }
            }
            return 0;
        }
    };
    private final Activity mActivity;
    private File mCurrentPath;
    private String[] mFileList;
    private FileSelectedListener mFileListener;
    private OnClickListener onDialogItemClickedListener = new OnClickListener() {
        public void onClick(DialogInterface dialogInterface, int i) {
            File access$100 = SimpleFileChooser.this.getSelectedFile(SimpleFileChooser.this.mFileList[i]);
            dialogInterface.cancel();
            dialogInterface.dismiss();
            if (access$100.isDirectory()) {
                SimpleFileChooser.this.rebuildFileList(access$100);
                SimpleFileChooser.this.showDialog();
            } else if (SimpleFileChooser.this.mFileListener != null) {
                SimpleFileChooser.this.mFileListener.onFileSelected(access$100);
            }
        }
    };

    public interface FileSelectedListener {
        void onFileSelected(File file);
    }

    public SimpleFileChooser(Activity activity, File file, FileSelectedListener fileSelectedListener) {
        this.mActivity = activity;
        this.mFileListener = fileSelectedListener;
        if (!file.exists()) {
            file = Environment.getExternalStorageDirectory();
        }
        rebuildFileList(file);
    }

    private File getSelectedFile(String str) {
        return str.equals(PARENT_DIR) ? this.mCurrentPath.getParentFile() : new File(this.mCurrentPath, str);
    }

    private void rebuildFileList(File file) {
        this.mCurrentPath = file;
        List arrayList = new ArrayList();
        if (file.getParentFile() != null) {
            arrayList.add(PARENT_DIR);
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            Arrays.sort(listFiles, this.fileArrayComparator);
            for (File name : listFiles) {
                arrayList.add(name.getName());
            }
        }
        this.mFileList = (String[]) arrayList.toArray(new String[0]);
    }

    public void showDialog() {
        Builder builder = new Builder(this.mActivity);
        builder.setTitle(this.mCurrentPath.getPath());
        builder.setItems(this.mFileList, this.onDialogItemClickedListener);
        builder.show();
    }
}
