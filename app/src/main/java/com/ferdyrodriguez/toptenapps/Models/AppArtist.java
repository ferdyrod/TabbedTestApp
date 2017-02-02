package com.ferdyrodriguez.toptenapps.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ferdyrod on 2/1/17.
 */
public class AppArtist {

    @SerializedName("label")
    @Expose
    private String appArtist;

    public String getAppArtist() {
        return appArtist;
    }

    public void setAppArtist(String appArtist) {
        this.appArtist = appArtist;
    }
}
