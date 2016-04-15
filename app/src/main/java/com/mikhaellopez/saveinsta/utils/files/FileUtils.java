package com.mikhaellopez.saveinsta.utils.files;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

import com.mikhaellopez.saveinsta.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Pratik Butani.
 */
public class FileUtils {

    public static boolean downloadPicture(Context mContext, Bitmap bitmap, String fileName) {
        boolean result = false;
        OutputStream output = null;
        try {
            File root = new File(Environment.getExternalStorageDirectory() + File.separator + mContext.getResources().getString(R.string.app_name) + File.separator);
            boolean b = root.mkdirs();

            if (b) {
                File sdImageMainDirectory = new File(root, fileName);
                output = new FileOutputStream(sdImageMainDirectory);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, output);
                output.flush();
            }
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != output) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
