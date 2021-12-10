package com.AKM.myapplication.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.icu.text.SimpleDateFormat;
import android.util.Log;

import androidx.annotation.DrawableRes;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;


import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Uttil {
    Context context;
    public Uttil(Context context) {
        this.context=context;
    }

    public BitmapDescriptor bitmapDescriptorFromVector(Context context, @DrawableRes int vectorDrawableResourceId) {
        Drawable background = ContextCompat.getDrawable(context, vectorDrawableResourceId);
        background.setBounds(0, 0, background.getIntrinsicWidth(), background.getIntrinsicHeight());
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorDrawableResourceId);
        vectorDrawable.setBounds(40, 20, vectorDrawable.getIntrinsicWidth() + 40, vectorDrawable.getIntrinsicHeight() + 20);
        Bitmap bitmap = Bitmap.createBitmap(background.getIntrinsicWidth(), background.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        background.draw(canvas);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
    @SuppressLint({"SimpleDateFormat", "WeekBasedYear"})
    public String converttimespametodate(Long time){
        String date = null;
        Date currentDate = new Date (time);
        SimpleDateFormat dateFormat = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            date = dateFormat.format(currentDate);

        }

        return date;

    }
    @SuppressLint({"SimpleDateFormat", "WeekBasedYear"})
    public Long subtracttowdateandttime(String creation,String stop){
        LocalDate d1 = null;
        Long diffDays = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            try {
                Date  date1 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").parse(stop);
                Date  date2 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").parse(creation);
                Duration diff = Duration.between(date2.toInstant(), date1.toInstant());
                if(diff.toHours() >= 4){
                    diffDays=diff.toHours();
                }

                Log.e("TAG", "subtracttowdateandttime: "+diffDays);

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        return diffDays;
    }
    @SuppressLint({"SimpleDateFormat", "WeekBasedYear"})
    public String  towdateandttime(String creation,String stop){

        String diffDays = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            try {
                Date  date1 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").parse(stop);
                Date  date2 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").parse(creation);
                Duration diff = Duration.between(date2.toInstant(), date1.toInstant());
                if(diff.toDays() != 0){
                    diffDays=diff.toDays()+" Day ago";
                }else if(diff.toHours()!=0) {
                    diffDays=diff.toHours()+" Hours ago";
                }else if (diff.toMinutes()!=0){
                    diffDays=diff.toMinutes()+" Mins ago";

                }

                Log.e("TAG", "subtracttowdateandttime: "+diffDays);

            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        return diffDays;
    }
    public StringBuffer splitString(String str,String type)
    {
        StringBuffer alpha = new StringBuffer(),
                num = new StringBuffer(), special = new StringBuffer();
        for (int i=0; i<str.length(); i++)
        {
            if (Character.isDigit(str.charAt(i)))
                num.append(str.charAt(i));
            else if(Character.isAlphabetic(str.charAt(i)))
                alpha.append(str.charAt(i));
            else
                special.append(str.charAt(i));
        }

        System.out.println(alpha);
        System.out.println(num);
        System.out.println(special);
        if(type.equalsIgnoreCase("S")){
            return alpha;
        }else
        return num;
    }
    public static void setFragment(Fragment fragment, boolean removeStack, FragmentActivity activity, int mContainer) {
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction ftTransaction = fragmentManager.beginTransaction();
        if (removeStack) {
            int size = fragmentManager.getBackStackEntryCount();
            fragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ftTransaction.replace(mContainer, fragment);
        } else {
            ftTransaction.replace(mContainer, fragment);
            ftTransaction.addToBackStack(null);
        }
        ftTransaction.commit();
    }




}
