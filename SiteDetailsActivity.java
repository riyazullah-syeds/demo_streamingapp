package com.entrolabs.firebaseauth.streamingapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.entrolabs.firebaseauth.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SiteDetailsActivity extends AppCompatActivity {
    private ImageView snapshotImage;
    private Button btnPlay;
    private String streamingUrl;
    Toolbar toolbar;

    int siteId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_details);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        snapshotImage = findViewById(R.id.snapshotImage);
        btnPlay = findViewById(R.id.btnPlay);

        siteId = getIntent().getIntExtra("siteId", 0);
        fetchSiteDetails(siteId);
    }

    private void fetchSiteDetails(int siteId) {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<SiteResponse> call = apiService.getSiteDetails(siteId);

        call.enqueue(new Callback<SiteResponse>() {
            @Override
            public void onResponse(Call<SiteResponse> call, Response<SiteResponse> response) {
                //   Toast.makeText(SiteDetailsActivity.this, "response"+response.body(), Toast.LENGTH_SHORT).show();
                if (response.isSuccessful() && response.body() != null) {
                    List<Camera> cameras = response.body().getCamList();
                    //   List<Camera> cameras = response.body().getCamList();
                    if (!cameras.isEmpty()) {
                        Camera firstCamera = cameras.get(0);
                        Glide.with(SiteDetailsActivity.this)
                                .load(firstCamera.getImageUrl())
                                .into(snapshotImage);
                        streamingUrl = firstCamera.getWebRtcUrl();
                    }
                } else {
                    Toast.makeText(SiteDetailsActivity.this, "Failed to load site details", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SiteResponse> call, Throwable t) {
                Toast.makeText(SiteDetailsActivity.this, "Failed to load site details", Toast.LENGTH_SHORT).show();
            }
        });


        btnPlay.setOnClickListener(v -> {
            if (streamingUrl != null) {
                Intent intent = new Intent(SiteDetailsActivity.this, StreamActivity.class);
                intent.putExtra("streamingUrl", streamingUrl);
                startActivity(intent);
            } else {
                Toast.makeText(SiteDetailsActivity.this, "Streaming URL not available", Toast.LENGTH_SHORT).show();
            }
        });
    }
}