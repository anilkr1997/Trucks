package com.AKM.myapplication.ui.dataclass;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransportModel implements Parcelable {

    @SerializedName("responseCode")
    @Expose
    private ResponseCode responseCode;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    protected TransportModel(Parcel in) {
    }

    public static final Creator<TransportModel> CREATOR = new Creator<TransportModel>() {
        @Override
        public TransportModel createFromParcel(Parcel in) {
            return new TransportModel(in);
        }

        @Override
        public TransportModel[] newArray(int size) {
            return new TransportModel[size];
        }
    };

    public ResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }

    public class ResponseCode {

        @SerializedName("responseCode")
        @Expose
        private Integer responseCode;
        @SerializedName("message")
        @Expose
        private String message;

        public Integer getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(Integer responseCode) {
            this.responseCode = responseCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

    }

    public class Datum {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("companyId")
        @Expose
        private Integer companyId;
        @SerializedName("truckTypeId")
        @Expose
        private Integer truckTypeId;
        @SerializedName("truckSizeId")
        @Expose
        private Integer truckSizeId;
        @SerializedName("truckNumber")
        @Expose
        private String truckNumber;
        @SerializedName("transporterId")
        @Expose
        private Integer transporterId;
        @SerializedName("trackerType")
        @Expose
        private Integer trackerType;
        @SerializedName("imeiNumber")
        @Expose
        private String imeiNumber;
        @SerializedName("simNumber")
        @Expose
        private String simNumber;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("password")
        @Expose
        private String password;
        @SerializedName("createTime")
        @Expose
        private Long createTime;
        @SerializedName("deactivated")
        @Expose
        private Boolean deactivated;
        @SerializedName("breakdown")
        @Expose
        private Boolean breakdown;
        @SerializedName("lastWaypoint")
        @Expose
        private LastWaypoint lastWaypoint;
        @SerializedName("lastRunningState")
        @Expose
        private LastRunningState lastRunningState;
        @SerializedName("durationInsideSite")
        @Expose
        private Integer durationInsideSite;
        @SerializedName("fuelSensorInstalled")
        @Expose
        private Boolean fuelSensorInstalled;
        @SerializedName("externalTruck")
        @Expose
        private Boolean externalTruck;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getCompanyId() {
            return companyId;
        }

        public void setCompanyId(Integer companyId) {
            this.companyId = companyId;
        }

        public Integer getTruckTypeId() {
            return truckTypeId;
        }

        public void setTruckTypeId(Integer truckTypeId) {
            this.truckTypeId = truckTypeId;
        }

        public Integer getTruckSizeId() {
            return truckSizeId;
        }

        public void setTruckSizeId(Integer truckSizeId) {
            this.truckSizeId = truckSizeId;
        }

        public String getTruckNumber() {
            return truckNumber;
        }

        public void setTruckNumber(String truckNumber) {
            this.truckNumber = truckNumber;
        }

        public Integer getTransporterId() {
            return transporterId;
        }

        public void setTransporterId(Integer transporterId) {
            this.transporterId = transporterId;
        }

        public Integer getTrackerType() {
            return trackerType;
        }

        public void setTrackerType(Integer trackerType) {
            this.trackerType = trackerType;
        }

        public String getImeiNumber() {
            return imeiNumber;
        }

        public void setImeiNumber(String imeiNumber) {
            this.imeiNumber = imeiNumber;
        }

        public String getSimNumber() {
            return simNumber;
        }

        public void setSimNumber(String simNumber) {
            this.simNumber = simNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        public Boolean getDeactivated() {
            return deactivated;
        }

        public void setDeactivated(Boolean deactivated) {
            this.deactivated = deactivated;
        }

        public Boolean getBreakdown() {
            return breakdown;
        }

        public void setBreakdown(Boolean breakdown) {
            this.breakdown = breakdown;
        }

        public LastWaypoint getLastWaypoint() {
            return lastWaypoint;
        }

        public void setLastWaypoint(LastWaypoint lastWaypoint) {
            this.lastWaypoint = lastWaypoint;
        }

        public LastRunningState getLastRunningState() {
            return lastRunningState;
        }

        public void setLastRunningState(LastRunningState lastRunningState) {
            this.lastRunningState = lastRunningState;
        }

        public Integer getDurationInsideSite() {
            return durationInsideSite;
        }

        public void setDurationInsideSite(Integer durationInsideSite) {
            this.durationInsideSite = durationInsideSite;
        }

        public Boolean getFuelSensorInstalled() {
            return fuelSensorInstalled;
        }

        public void setFuelSensorInstalled(Boolean fuelSensorInstalled) {
            this.fuelSensorInstalled = fuelSensorInstalled;
        }

        public Boolean getExternalTruck() {
            return externalTruck;
        }

        public void setExternalTruck(Boolean externalTruck) {
            this.externalTruck = externalTruck;
        }




        public class LastRunningState {

            @SerializedName("truckId")
            @Expose
            private Integer truckId;
            @SerializedName("stopStartTime")
            @Expose
            private Long stopStartTime;
            @SerializedName("truckRunningState")
            @Expose
            private Integer truckRunningState;
            @SerializedName("lat")
            @Expose
            private Double lat;
            @SerializedName("lng")
            @Expose
            private Double lng;
            @SerializedName("stopNotficationSent")
            @Expose
            private Integer stopNotficationSent;

            public Integer getTruckId() {
                return truckId;
            }

            public void setTruckId(Integer truckId) {
                this.truckId = truckId;
            }

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

            public Double getLat() {
                return lat;
            }

            public void setLat(Double lat) {
                this.lat = lat;
            }

            public Double getLng() {
                return lng;
            }

            public void setLng(Double lng) {
                this.lng = lng;
            }

            public Integer getStopNotficationSent() {
                return stopNotficationSent;
            }

            public void setStopNotficationSent(Integer stopNotficationSent) {
                this.stopNotficationSent = stopNotficationSent;
            }

        }
        public class LastWaypoint {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("lat")
            @Expose
            private Double lat;
            @SerializedName("lng")
            @Expose
            private Double lng;
            @SerializedName("createTime")
            @Expose
            private Long createTime;
            @SerializedName("accuracy")
            @Expose
            private Double accuracy;
            @SerializedName("bearing")
            @Expose
            private Double bearing;
            @SerializedName("truckId")
            @Expose
            private Integer truckId;
            @SerializedName("speed")
            @Expose
            private Double speed;
            @SerializedName("updateTime")
            @Expose
            private Long updateTime;
            @SerializedName("ignitionOn")
            @Expose
            private Boolean ignitionOn;
            @SerializedName("odometerReading")
            @Expose
            private Double odometerReading;
            @SerializedName("batteryPower")
            @Expose
            private Boolean batteryPower;
            @SerializedName("fuelLevel")
            @Expose
            private Integer fuelLevel;
            @SerializedName("batteryLevel")
            @Expose
            private Integer batteryLevel;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public Double getLat() {
                return lat;
            }

            public void setLat(Double lat) {
                this.lat = lat;
            }

            public Double getLng() {
                return lng;
            }

            public void setLng(Double lng) {
                this.lng = lng;
            }

            public Long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Long createTime) {
                this.createTime = createTime;
            }

            public Double getAccuracy() {
                return accuracy;
            }

            public void setAccuracy(Double accuracy) {
                this.accuracy = accuracy;
            }

            public Double getBearing() {
                return bearing;
            }

            public void setBearing(Double bearing) {
                this.bearing = bearing;
            }

            public Integer getTruckId() {
                return truckId;
            }

            public void setTruckId(Integer truckId) {
                this.truckId = truckId;
            }

            public Double getSpeed() {
                return speed;
            }

            public void setSpeed(Double speed) {
                this.speed = speed;
            }

            public Long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Long updateTime) {
                this.updateTime = updateTime;
            }

            public Boolean getIgnitionOn() {
                return ignitionOn;
            }

            public void setIgnitionOn(Boolean ignitionOn) {
                this.ignitionOn = ignitionOn;
            }

            public Double getOdometerReading() {
                return odometerReading;
            }

            public void setOdometerReading(Double odometerReading) {
                this.odometerReading = odometerReading;
            }

            public Boolean getBatteryPower() {
                return batteryPower;
            }

            public void setBatteryPower(Boolean batteryPower) {
                this.batteryPower = batteryPower;
            }

            public Integer getFuelLevel() {
                return fuelLevel;
            }

            public void setFuelLevel(Integer fuelLevel) {
                this.fuelLevel = fuelLevel;
            }

            public Integer getBatteryLevel() {
                return batteryLevel;
            }

            public void setBatteryLevel(Integer batteryLevel) {
                this.batteryLevel = batteryLevel;
            }

        }

    }



}
