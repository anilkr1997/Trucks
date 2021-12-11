package com.AKM.myapplication.ui.Mvpinterface;




import com.AKM.myapplication.ui.dataclass.TransportModel;

import java.util.List;

public interface mvpcallback {
    interface Trackview extends BaseCallback.BaseView {
        void Successfullygetalldata(List<TransportModel.Datum> data);
        void Successfullygetall(List<TransportModel.Datum> data);
    }
    interface TrackPrsent extends BaseCallback.BasePresenter {
        void Callalldata();
        void getSuccesfullyaalldata(List<TransportModel.Datum> data);

    }
    interface TrackModel extends BaseCallback.BaseModel {
        void getTrucklist();
    }
}
