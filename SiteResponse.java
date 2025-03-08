package com.entrolabs.firebaseauth.streamingapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SiteResponse {
    @SerializedName("status")
    private String status;

    @SerializedName("statusCode")
    private int statusCode;

    @SerializedName("message")
    private String message;

    @SerializedName("siteId")
    private int siteId;

    @SerializedName("camList")
    private List<Camera> camList;

    public String getStatus() {
        return status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public int getSiteId() {
        return siteId;
    }

    public List<Camera> getCamList() {
        return camList;
    }

}
