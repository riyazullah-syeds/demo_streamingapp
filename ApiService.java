package com.entrolabs.firebaseauth.streamingapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("getSiteDetails_1_0/")
    Call<SiteResponse> getSiteDetails(@Query("siteId") int siteId);
}
