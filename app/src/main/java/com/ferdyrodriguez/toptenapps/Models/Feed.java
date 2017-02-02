package com.ferdyrodriguez.toptenapps.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ferdyrod on 2/1/17.
 */

public class Feed {

    @SerializedName("entry")
    @Expose
    private List<Entry> entry = null;

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

}

