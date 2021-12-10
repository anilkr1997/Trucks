package com.AKM.myapplication.ui.dilogbox;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.AKM.myapplication.R;

public class ProgressBarDialog extends Dialog {
    Context context;

    public ProgressBarDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.progress_dialog_layout);

        this.setCanceledOnTouchOutside(false);
        this.setCancelable(true);

        getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setLayout((int)(context.getResources().getDisplayMetrics().widthPixels),(int)(context.getResources().getDisplayMetrics().heightPixels));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(context, R.color.purple_200));
        }


    }
}
