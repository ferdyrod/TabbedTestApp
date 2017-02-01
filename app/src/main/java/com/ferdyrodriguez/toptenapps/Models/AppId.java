package com.ferdyrodriguez.toptenapps.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ferdyrod on 2/1/17.
 */
public class AppId {

    @SerializedName("attributes")
    @Expose
    private Attributes idAttribute;

    public Attributes getIdAttribute() {
        return idAttribute;
    }

    public void setIdAttribute(Attributes idAttribute) {
        this.idAttribute = idAttribute;
    }
}
