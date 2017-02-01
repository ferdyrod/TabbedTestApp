package com.ferdyrodriguez.toptenapps.Services;

import com.ferdyrodriguez.toptenapps.Models.AppsFeed;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ferdyrod on 2/1/17.
 */

public interface ItunesServices {

    @GET("/es/rss/topfreeapplications/limit=10/json")
    Call<AppsFeed> getFreeAppData();


    @GET("/es/rss/toppaidapplications/limit=10/json")
    Call<AppsFeed> getPaidAppData();
}
