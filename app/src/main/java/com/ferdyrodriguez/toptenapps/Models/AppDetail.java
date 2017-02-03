package com.ferdyrodriguez.toptenapps.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ferdyrod on 2/3/17.
 */

public class AppDetail {

    @SerializedName("resultCount")
    @Expose
    private Integer resultCount;
    @SerializedName("results")
    @Expose
    private List<AppResult> results = null;

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public List<AppResult> getResults() {
        return results;
    }

    public void setResults(List<AppResult> results) {
        this.results = results;
    }

}
