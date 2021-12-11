package com.AKM.myapplication.ui.Mvpinterface;

import android.content.Context;
import android.util.Log;


import com.AKM.myapplication.ui.dataclass.TransportModel;

import java.util.List;

public class Truckprsent implements mvpcallback.TrackPrsent {
    Context context;
   mvpcallback.TrackModel trackModel;
   mvpcallback.Trackview trackview;

    public Truckprsent(Context context,mvpcallback.Trackview trackview) {
        this.context=context;
        this.trackview=trackview;
        trackModel=new ModelView(context,this);

    }
    @Override
    public void doDestroyPresenter() {
     trackModel.doDestroyModel();
    }

    @Override
    public void onFailure(String message) {
    trackview.onFailure(message);
    }

    @Override
    public void Callalldata() {
    trackModel.getTrucklist();
    }

    @Override
    public void getSuccesfullyaalldata(List<TransportModel.Datum> data) {
         trackview.Successfullygetalldata(data);
         trackview.Successfullygetall(data);
    }
}
