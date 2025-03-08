package com.entrolabs.firebaseauth.streamingapp;

import com.google.gson.annotations.SerializedName;

public class Camera {
    @SerializedName("cameraId")
    private String cameraId;

    @SerializedName("cameraName")
    private String cameraName;

    @SerializedName("image")
    private String imageUrl;

    @SerializedName("webRtcUrl")
    private String webRtcUrl;

    public String getCameraId() {
        return cameraId;
    }

    public String getCameraName() {
        return cameraName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getWebRtcUrl() {
        return webRtcUrl;
    }

}
