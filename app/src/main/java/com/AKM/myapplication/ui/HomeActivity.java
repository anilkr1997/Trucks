package com.AKM.myapplication.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.SearchView;


import com.AKM.myapplication.R;
import com.AKM.myapplication.ui.ui.home.HomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;


public class HomeActivity extends AppCompatActivity{
    private Toolbar actionBar;
    FloatingActionButton fab;
    boolean chan=true;

    public Sendata sendData;
    public void setSendData(Sendata sendData){     //create setter for interface
        this.sendData = sendData;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
      actionBar=findViewById(R.id.toolbar);
      setSupportActionBar(actionBar);
        Uttil.setFragment(HomeFragment.newInstance(this), true, this, R.id.nav_host_fragment_content_home);
        fab=findViewById(R.id.fab);

       fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        MenuItem menuItem=menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.e("TAG", "onQueryTextSubmit: "+query );
                searchView.clearFocus();
                return false;

            }

            @Override
            public boolean onQueryTextChange(String newText) {

                sendData.gonder(newText);

                Log.e("TAG", "onQueryTextChange: "+newText );
                return false;
            }
        });
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()){
            case R.id.action_map:

if(chan){
    Uttil.setFragment(MapsFragment.newInstance(HomeFragment.search), false, this, R.id.nav_host_fragment_content_home);
    item.setIcon(R.drawable.ic_baseline_list_24);

    chan=false;
}else {
    item.setIcon(R.drawable.maps);
    chan =true;
    Uttil.setFragment(HomeFragment.newInstance(this), true, this, R.id.nav_host_fragment_content_home);


}





                return true;
            case R.id.action_search:

                return true;

        }

        return super.onOptionsItemSelected(item);
    }






    @Override
    public void onBackPressed() {
        Fragment fragment;
        fragment = getSupportFragmentManager().findFragmentById(R.id.container);
      if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        } else if (!(fragment instanceof OnBackPressedListener) || !((OnBackPressedListener) fragment).onBackPressed()) {

            super.onBackPressed();
        }
    }






}