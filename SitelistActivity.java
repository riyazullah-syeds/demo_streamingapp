package com.entrolabs.firebaseauth.streamingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.entrolabs.firebaseauth.R;

import java.util.Collections;

public class SitelistActivity extends AppCompatActivity {
    private Spinner siteSpinner;
    private Button btnFetchSite;
    private int selectedSiteId;
    ArrayAdapter adapter;
    //  private final int[] siteIds = {36320, 36347, 36337};
    private final Integer[] siteIds = new Integer[]{36320, 36347, 36337};
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitelist);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //  toolbar.setTitleTextColor(Color.WHITE);
        //  toolbar.getNavigationIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

        siteSpinner = findViewById(R.id.siteSpinner);
        btnFetchSite = findViewById(R.id.btnFetchSite);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, siteIds);
        siteSpinner.setAdapter(adapter);
        btnFetchSite.setOnClickListener(v -> {
            selectedSiteId = (int) siteSpinner.getSelectedItem();
            Intent intent = new Intent(SitelistActivity.this, SiteDetailsActivity.class);
            intent.putExtra("siteId", selectedSiteId);
            startActivity(intent);
        });
    }
}