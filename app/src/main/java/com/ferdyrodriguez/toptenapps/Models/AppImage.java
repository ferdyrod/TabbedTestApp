package com.ferdyrodriguez.toptenapps.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ferdyrod on 2/1/17.
 */
public class AppImage {

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("attributes")
    @Expose
    private Attributes imageAttributes;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes getAimageAttributes() {
        return imageAttributes;
    }

    public void setimageAttributes(Attributes imageAttributes) {
        this.imageAttributes = imageAttributes;
    }

}
