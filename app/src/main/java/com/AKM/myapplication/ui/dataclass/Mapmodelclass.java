package com.AKM.myapplication.ui.dataclass;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mapmodelclass {
    @SerializedName("stopStartTime")
    @Expose
    private Long stopStartTime;
    @SerializedName("truckRunningState")
    @Expose
    private Integer truckRunningState;
    @SerializedName("truckNumber")
    @Expose
    private String trucknumber;


    private LatLng location;

    public Mapmodelclass(Long stopStartTime, Integer truckRunningState, String trucknumber, LatLng location, Boolean ignitionOn, Long createTime) {
        this.stopStartTime = stopStartTime;
        this.truckRunningState = truckRunningState;
        this.trucknumber = trucknumber;
        this.location = location;
        this.ignitionOn = ignitionOn;
        this.createTime = createTime;
    }

    @SerializedName("ignitionOn")
    @Expose
    private Boolean ignitionOn;

    public Long getStopStartTime() {
        return stopStartTime;
    }

    public void setStopStartTime(Long stopStartTime) {
        this.stopStartTime = stopStartTime;
    }

    public Integer getTruckRunningState() {
        return truckRunningState;
    }

    public void setTruckRunningState(Integer truckRunningState) {
        this.truckRunningState = truckRunningState;
    }

//    public Double getLat() {
//        return lat;
//    }
//
//    public void setLat(Double lat) {
//        this.lat = lat;
//    }
//
//    public Double getLng() {
//        return lng;
//    }
//
//    public void setLng(Double lng) {
//        this.lng = lng;
//    }

    public Boolean getIgnitionOn() {
        return ignitionOn;
    }

    public void setIgnitionOn(Boolean ignitionOn) {
        this.ignitionOn = ignitionOn;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @SerializedName("createTime")
    @Expose
    private Long createTime;

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public String getTrucknumber() {
        return trucknumber;
    }

    public void setTrucknumber(String trucknumber) {
        this.trucknumber = trucknumber;
    }
}

