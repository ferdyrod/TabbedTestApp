package com.ferdyrodriguez.toptenapps.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ferdyrod on 2/1/17.
 */

public class Entry {

    @SerializedName("im:name")
    @Expose
    private AppName im_name;

    @SerializedName("im:image")
    @Expose
    private List<AppImage> im_image = null;

    @SerializedName("im:price")
    @Expose
    private AppPrice im_price;

    @SerializedName("id")
    @Expose
    private AppId appId;

    @SerializedName("im:artist")
    @Expose
    private AppArtist im_artist;

    public AppName getIm_name() {
        return im_name;
    }

    public void setIm_name(AppName im_name) {
        this.im_name = im_name;
    }

    public List<AppImage> getIm_image() {
        return im_image;
    }

    public void setIm_image(List<AppImage> im_image) {
        this.im_image = im_image;
    }

    public AppPrice getIm_price() {
        return im_price;
    }

    public void setIm_price(AppPrice im_price) {
        this.im_price = im_price;
    }

    public AppId getAppId() {
        return appId;
    }

    public void setAppId(AppId appId) {
        this.appId = appId;
    }

    public AppArtist getIm_artist() {
        return im_artist;
    }

    public void setIm_artist(AppArtist im_artist) {
        this.im_artist = im_artist;
    }

}
