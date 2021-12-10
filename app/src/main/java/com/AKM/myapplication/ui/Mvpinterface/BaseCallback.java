package com.AKM.myapplication.ui.Mvpinterface;

public interface BaseCallback {
    interface BaseView {
        void onFailure(String message);
    }

    interface BasePresenter {
        void doDestroyPresenter();
        void onFailure(String message);
    }

    interface BaseModel {
        void doDestroyModel();
    }
}
