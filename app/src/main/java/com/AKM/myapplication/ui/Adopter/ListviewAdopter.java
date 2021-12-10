package com.AKM.myapplication.ui.Adopter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.AKM.myapplication.R;
import com.AKM.myapplication.ui.Uttil;
import com.AKM.myapplication.ui.dataclass.TransportModel;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ListviewAdopter extends ArrayAdapter<TransportModel.Datum> implements Filterable {
    List<TransportModel.Datum> data=new ArrayList<>();

    private Context context;

    int resorce=R.layout.listviewlayout;
Uttil uttil;


    public ListviewAdopter(@NonNull Context context, int resource, @NonNull List<TransportModel.Datum> objects) {
        super(context,resource,objects);
        this.resorce=resource;
        this.data=objects;
        this.context= context.getApplicationContext();
        uttil=new Uttil(context);
    }




    @SuppressLint({"SetTextI18n", "SimpleDateFormat"})
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null){
             convertView = inflater.inflate(resorce, parent, false);
        }

        TextView Traucknumber = (TextView) convertView.findViewById(R.id.trucknumber);
        TextView timeaccording = (TextView) convertView.findViewById(R.id.timeaccording);
        TextView timetype = (TextView) convertView.findViewById(R.id.timetype);
        TextView statusofthetruck = (TextView) convertView.findViewById(R.id.statusofthetruck);
        TextView speedofthetruck = (TextView) convertView.findViewById(R.id.speedofthetruck);
        TextView speedunit = (TextView) convertView.findViewById(R.id.speedunit);
       ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);


        Traucknumber.setText(data.get(position).getTruckNumber());
        String timespam=uttil.towdateandttime(uttil.converttimespametodate(data.get(position).getLastRunningState().getStopStartTime()),uttil.converttimespametodate(data.get(position).getLastWaypoint().getCreateTime()));
      if(timespam!=null){
          timeaccording.setText(uttil.splitString(timespam,"N"));
          timetype.setText(uttil.splitString(timespam,"S"));

      } else {
          timeaccording.setText("");
          timeaccording.setText("");

      }


        speedofthetruck.setText(data.get(position).getLastWaypoint().getSpeed().toString());
        if(data.get(position).getLastWaypoint().getIgnitionOn().equals(true)){
            imageView.setImageResource(R.drawable.ic_baseline_local_shipping_24);
        }else {
            imageView.setImageResource(R.drawable.ic_baseline_battery_alert_24);

        }

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {


            if(data.get(position).getLastRunningState().getTruckRunningState()!=0){
                statusofthetruck.setText("Running Since "+uttil.towdateandttime(uttil.converttimespametodate(data.get(position).getLastRunningState().getStopStartTime()),uttil.converttimespametodate(data.get(position).getLastWaypoint().getCreateTime())));
            }else {
                statusofthetruck.setText("Stope Since "+uttil.towdateandttime(uttil.converttimespametodate(data.get(position).getLastRunningState().getStopStartTime()),uttil.converttimespametodate(data.get(position).getLastWaypoint().getCreateTime())));

            }
        }



        return convertView;

    }





}