package com.ferdyrodriguez.toptenapps.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ferdyrod on 2/1/17.
 */
public class AppPrice {

    @SerializedName("attributes")
    @Expose
    private Attributes priceAttribute;

    public Attributes getPriceAttribute() {
        return priceAttribute;
    }

    public void setPriceAttributes(Attributes priceAttributes) {
        this.priceAttribute = priceAttributes;
    }
}
