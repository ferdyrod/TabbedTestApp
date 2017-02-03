package com.ferdyrodriguez.toptenapps.Services;

import com.ferdyrodriguez.toptenapps.Utils.Utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ferdyrod on 2/2/17.
 */

public class RestClient {

    private static Retrofit retrofit;

    public static <S> S createService(Class<S> serviceClass) {
        retrofit = new Retrofit.Builder()
                .baseUrl(Utils.ITUNES_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(serviceClass);
    }

}
