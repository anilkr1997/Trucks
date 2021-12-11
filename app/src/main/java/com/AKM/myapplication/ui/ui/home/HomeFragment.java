package com.AKM.myapplication.ui.ui.home;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;


import com.AKM.myapplication.R;
import com.AKM.myapplication.ui.Adopter.ListviewAdopter;
import com.AKM.myapplication.ui.HomeActivity;
import com.AKM.myapplication.ui.MapsFragment;
import com.AKM.myapplication.ui.Mvpinterface.Truckprsent;
import com.AKM.myapplication.ui.Mvpinterface.mvpcallback;
import com.AKM.myapplication.ui.OnBackPressedListener;
import com.AKM.myapplication.ui.Sendata;
import com.AKM.myapplication.ui.dataclass.TransportModel;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements mvpcallback.Trackview , OnBackPressedListener, Sendata {
    public static final String TAG = HomeFragment.class.getName();
mvpcallback.TrackPrsent prsent;
String s;
public ListView listView;
public  List<TransportModel.Datum> arralit=new ArrayList<>();
public static List<TransportModel.Datum> search=new ArrayList<>();
public ListviewAdopter listviewAdopter;
    ArrayList<TransportModel.Datum> filteredItems = new ArrayList<TransportModel.Datum>();
 Context activity;
Toolbar actionBar;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

    }

    public HomeFragment(Activity text) {
        this.activity=text;
    }



    public static Fragment newInstance(Activity text) {

        return new HomeFragment(text);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        prsent=new Truckprsent(getContext(),this);
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        return inflater.inflate(R.layout.fragment_home, container, false);




    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new HomeFragment(this.getActivity());

        listView=view.findViewById(R.id.list_item);

        prsent.Callalldata();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // prsent.onFailure(arralit.get(i).getLastRunningState().toString());
            }
        });
        if(getActivity() instanceof HomeActivity)
        ((HomeActivity) getActivity()).setSendData(this);


    }






    @Override
    public void onFailure(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void Successfullygetalldata(List<TransportModel.Datum> data) {
        arralit.addAll(data);
        listviewAdopter=new ListviewAdopter(activity, R.layout.listviewlayout,arralit);
        listView.setAdapter(listviewAdopter);

        listviewAdopter.notifyDataSetChanged();
        new MapsFragment(arralit);


    }

    @Override
    public void Successfullygetall(List<TransportModel.Datum> data) {
        search.addAll(data);

    }

    @Override
    public boolean onBackPressed() {
        return false;
    }



    @Override
    public void gonder(String isim) {
        Log.e(TAG, "gonder: "+isim );
new CountryFilter().publishResults(isim,new CountryFilter().performFiltering(isim));
    }




    public class CountryFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            Log.e(TAG, "performFiltering: "+constraint);
            constraint = constraint.toString().toUpperCase();
            FilterResults result = new FilterResults();
            filteredItems = new ArrayList<TransportModel.Datum>();

            if (constraint!=null &&constraint.toString().length() > 0) {
                filteredItems.clear();
                for (int i = 0, l = arralit.size()-1; i < l; i++) {
                    TransportModel.Datum country = arralit.get(i);
                    if (country.getTruckNumber().toUpperCase().contains(constraint))

                    filteredItems.add(country);

                    // if(filteredItems.get(i).getTruckNumber()!=)

                    Log.e(TAG, "performFiltering: "+country.getTruckNumber() );
                }


                result.count = filteredItems.size();
                result.values = filteredItems;
            } else {
                synchronized (this) {
                    result.values = search;
                    result.count = search.size();
                }
            }
            //Log.e(TAG, "performFiltering: res "+filteredItems.get(0).getTruckNumber() );


            return result;
        }
        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            Log.e(TAG, "publishResults: res "+filterResults.count);
            if (filterResults.count > 0) {
                arralit.clear();

                arralit=(ArrayList<TransportModel.Datum>)filterResults.values;


                 Successfullygetalldata(arralit);



            } else {
                Log.e(TAG, "publishResults: " );

                listviewAdopter.notifyDataSetInvalidated();
            }
        }


    }




}