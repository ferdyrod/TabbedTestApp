package com.ferdyrodriguez.toptenapps.Services;

import com.ferdyrodriguez.toptenapps.Models.AppDetail;
import com.ferdyrodriguez.toptenapps.Models.AppleResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ferdyrod on 2/1/17.
 */

public interface ItunesService {

    @GET("/es/rss/topfreeapplications/limit=10/json")
    Call<AppleResponse> getFreeAppData();


    @GET("/es/rss/toppaidapplications/limit=10/json")
    Call<AppleResponse> getPaidAppData();

    @GET("/lookup")
    Call<AppDetail> getAppDetail(@Query("id") String appId, @Query("country") String country);
}
