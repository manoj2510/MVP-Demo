package com.example.mvpapp.utils;

import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.mvpapp.R;
import com.google.android.material.snackbar.Snackbar;


public class SnackBarUtil {

    public static void setSnackBar(View rootLayout, String snackTitle) {
        Snackbar snackbar = Snackbar.make(rootLayout, snackTitle, Snackbar.LENGTH_LONG);
        snackbar.show();
        View view = snackbar.getView();
        TextView textView = view.findViewById(android.R.id.accessibilityActionContextClick);
        textView.setMaxLines(4);
        textView.setTextColor(ContextCompat.getColor(rootLayout.getContext(), R.color.colorAccent));
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
    }

}
