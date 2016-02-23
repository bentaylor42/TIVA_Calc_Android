package com.rsiready.tivacalc;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Detects Screen size
        int bigScreen = 0;
        int screenSize = getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK;
        switch (screenSize){
            case Configuration.SCREENLAYOUT_SIZE_LARGE:
                bigScreen = 1;
                break;

            case Configuration.SCREENLAYOUT_SIZE_XLARGE:
                bigScreen = 1;
                break;
        }

        // Sets Up Height Spinner
        if (bigScreen == 0){
            Spinner heightSpinner = (Spinner) findViewById(R.id.spinnerHeight);
            ArrayAdapter<CharSequence> heightAdapter = ArrayAdapter.createFromResource(this, R.array.height_array_abbrev, android.R.layout.simple_spinner_item);
            heightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            heightSpinner.setAdapter(heightAdapter);
        }
        else{
            Spinner heightSpinner = (Spinner) findViewById(R.id.spinnerHeight);
            ArrayAdapter<CharSequence> heightAdapter = ArrayAdapter.createFromResource(this, R.array.height_array_full, android.R.layout.simple_spinner_item);
            heightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            heightSpinner.setAdapter(heightAdapter);
        }


        // Loads AdView
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

        /********************************************************************************************
         Needs Sorting
         *******************************************************************************************/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

        /********************************************************************************************
         Needs Sorting
         *******************************************************************************************/
    }
}


/*************************************** END OF CODE **********************************************/