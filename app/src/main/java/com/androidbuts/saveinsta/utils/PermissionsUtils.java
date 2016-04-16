package com.androidbuts.saveinsta.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Copyright (C) 2016 Mikhael LOPEZ
 * Licensed under the Apache License Version 2.0
 */
public class PermissionsUtils {

    //region MY_PERMISSIONS_REQUEST
    public static final int PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;
    //endregion

    public static boolean checkAndRequest(@NonNull final Activity activity, @NonNull final String permission, final int requestCode, String messagePermission, DialogInterface.OnClickListener onCancelListener) {
        boolean result = false;
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setMessage(messagePermission).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);
                    }
                }).setNegativeButton("Cancel", onCancelListener).show();

            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(activity, new String[]{permission}, requestCode);

                // MY_PERMISSIONS_REQUEST is an app-defined int constant.
                // The callback method gets the result of the request.
            }
        } else {
            result = true;
        }
        return result;
    }
}
