package com.AKM.myapplication.ui.Mvpinterface;

import android.content.Context;
import android.util.Log;


import com.AKM.myapplication.ui.Retrofitservice.ApiClient;
import com.AKM.myapplication.ui.Retrofitservice.NoConnectivityException;
import com.AKM.myapplication.ui.dataclass.TransportModel;
import com.AKM.myapplication.ui.dilogbox.ProgressBarDialog;
import com.google.gson.Gson;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ModelView implements mvpcallback.TrackModel {
    mvpcallback.TrackPrsent trackPrsent;
    Context context;
    ProgressBarDialog progressBarDialog;
    private CompositeDisposable compositeDisposable;

    public ModelView(Context context, Truckprsent truckprsent) {
        this.context = context;
        this.trackPrsent = truckprsent;
        compositeDisposable = new CompositeDisposable();
        progressBarDialog = new ProgressBarDialog(context);

    }

    @Override
    public void doDestroyModel() {
        trackPrsent.doDestroyPresenter();
    }

    @Override
    public void getTrucklist() {
        ApiClient.getInstance().getApiService(context)
                .getAlltracklist()
                .subscribeOn(Schedulers.newThread())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull Disposable disposable) throws Exception {
                        progressBarDialog.show();
                    }
                })
                .doOnTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        if (progressBarDialog.isShowing())
                            progressBarDialog.dismiss();
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TransportModel>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(@NonNull TransportModel transportModel) {
                        Log.e("TAG", "onNext: "+ new Gson().toJson(transportModel.getData().get(1)));
//                        Log.e("TAG", "onNext: "+  transportModel.getResponseCode().getResponseCode());
                        if (transportModel.getResponseCode().getResponseCode().equals(200)) {

                            trackPrsent.getSuccesfullyaalldata(transportModel.getData());

                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if (e instanceof NoConnectivityException) {
                            trackPrsent.onFailure("Please check internet connection");
                            // A network or conversion error happened
                        } else {
                            trackPrsent.onFailure(e.toString());
                            Log.e("TAG", "onError: " + e.getMessage());

                        }
                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }
}
