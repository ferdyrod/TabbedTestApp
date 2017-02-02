package com.ferdyrodriguez.toptenapps.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ferdyrodriguez.toptenapps.Adapters.AppDataAdapter;
import com.ferdyrodriguez.toptenapps.Models.AppleResponse;
import com.ferdyrodriguez.toptenapps.Models.Entry;
import com.ferdyrodriguez.toptenapps.R;
import com.ferdyrodriguez.toptenapps.Services.ItunesService;
import com.ferdyrodriguez.toptenapps.Utils.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaidFragmentTab extends Fragment {

    public static final String TAG = "PaidFragmentTab";

    private List<Entry> appEntries;
    private AppDataAdapter appDataAdapter;
    private RecyclerView recyclerView;


    public PaidFragmentTab() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.free_fragment_tab, container, false);
        populateRV(view);

        return view;
    }

    private void populateRV(View view) {

        appEntries = new ArrayList<>();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        appDataAdapter = new AppDataAdapter(getActivity().getApplicationContext(), appEntries);
        recyclerView.setAdapter(appDataAdapter);

        Retrofit retrofit = getData();

        ItunesService itunesService = retrofit.create(ItunesService.class);
        Call<AppleResponse> call = itunesService.getPaidAppData();
        call.enqueue(new Callback<AppleResponse>() {
            @Override
            public void onResponse(Call<AppleResponse> call, Response<AppleResponse> response) {
                if (response.isSuccessful()) {
                    AppleResponse appleResponse = response.body();
                    Log.d(TAG, "onResponse: " + response.body().getFeed().getEntry());
                    appEntries = appleResponse.getFeed().getEntry();
                    appDataAdapter.setEntriesList(appEntries);

                } else {
                    try {
                        Log.e(TAG, "Retrofit Response: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<AppleResponse> call, Throwable t) {
                Log.d(TAG, t.getLocalizedMessage());
            }
        });

    }

    private Retrofit getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Utils.ITUNES_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }
}
