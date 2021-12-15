package com.AKM.myapplication.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.AKM.myapplication.R;
import com.AKM.myapplication.ui.dataclass.Mapmodelclass;
import com.AKM.myapplication.ui.dataclass.TransportModel;
import com.AKM.myapplication.ui.ui.home.HomeFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsFragment extends Fragment implements OnMapReadyCallback , OnBackPressedListener {
    public static final String TAG = HomeFragment.class.getName();
List<Mapmodelclass> location=new ArrayList<>() ;
    SupportMapFragment mapFragment;
    Uttil uttil;
   // List<TransportModel.Datum> data=new ArrayList<>();
    public MapsFragment(List<TransportModel.Datum> arralit) {

        for(int i=0;i<=arralit.size()-1;i++){
            LatLng sayd=new LatLng(arralit.get(i).getLastWaypoint().getLat(),arralit.get(i).getLastWaypoint().getLng());

            location.add(new Mapmodelclass(arralit.get(i).getLastRunningState().getStopStartTime(),arralit.get(i).getLastRunningState().getTruckRunningState(), arralit.get(i).getTruckNumber(), sayd,arralit.get(i).getLastWaypoint().getIgnitionOn(),arralit.get(i).getLastWaypoint().getCreateTime()));
        }
       // mapFragment.getMapAsync(this);
    }

    public static Fragment newInstance(List<TransportModel.Datum> arralit) {
        return new MapsFragment(arralit);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       // prsent=new Truckprsent(getContext(),this);

        uttil=new Uttil(getContext());
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // prsent.Callalldata();

         mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
//        if (mapFragment != null) {
//
//
//          //  mapFragment.getMapAsync(this::onMapReady);
//        }
        if(mapFragment!=null && location.size()>0)
            mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        int imagere = R.drawable.ic_baseline_local_shipping_24;
        for(int i=0;i<=location.size()-1;i++){
            Long time=uttil.subtracttowdateandttime(uttil.converttimespametodate(location.get(i).getStopStartTime()),uttil.converttimespametodate(location.get(i).getCreateTime()));
            if(location.get(i).getTruckRunningState()==1){
               imagere=R.drawable.green;
            }
            else if (time!=null && time >=4){
                imagere=R.drawable.red;
            }
            else if(location.get(i).getTruckRunningState()==0 && !location.get(i).getIgnitionOn()){
                imagere=R.drawable.blue;
            }else if(location.get(i).getTruckRunningState()==0 && location.get(i).getIgnitionOn()){
                imagere=R.drawable.yellow;
            }
            googleMap.addMarker(new MarkerOptions().position(location.get(i).getLocation()).title(location.get(i).getTrucknumber()).icon(uttil.bitmapDescriptorFromVector(this.getActivity(),imagere)).infoWindowAnchor(0.5f, 0.5f));
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(50.0f));

            googleMap.moveCamera(CameraUpdateFactory.newLatLng(location.get(i).getLocation()));
        }
         }


    @Override
    public boolean onBackPressed() {
        return true;
    }
}
