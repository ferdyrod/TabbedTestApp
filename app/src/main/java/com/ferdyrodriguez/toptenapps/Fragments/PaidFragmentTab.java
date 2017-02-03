package com.ferdyrodriguez.toptenapps.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ferdyrodriguez.toptenapps.Adapters.AppDataAdapter;
import com.ferdyrodriguez.toptenapps.DetailActivity;
import com.ferdyrodriguez.toptenapps.Models.AppleResponse;
import com.ferdyrodriguez.toptenapps.Models.Entry;
import com.ferdyrodriguez.toptenapps.R;
import com.ferdyrodriguez.toptenapps.Services.ItunesService;
import com.ferdyrodriguez.toptenapps.Services.RestClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PaidFragmentTab extends Fragment {

    public static final String TAG = PaidFragmentTab.class.getSimpleName();

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
        appDataAdapter = new AppDataAdapter(getActivity().getApplicationContext(),
                appEntries,
                new AppDataAdapter.AppItemClickListener() {
                    @Override
                    public void onItemClick(View itemView, int position) {
                        String appId = appEntries.get(position).getAppId().getIdAttribute().getAppId();
                        Intent intent = new Intent(getContext(), DetailActivity.class);
                        Log.d(TAG, "onItemClick: paid " + appId);
                        intent.putExtra("appId", appId);
                        startActivity(intent);
                    }
                });

        recyclerView.setAdapter(appDataAdapter);

        ItunesService itunesService = RestClient.createService(ItunesService.class);
        Call<AppleResponse> call = itunesService.getPaidAppData();
        call.enqueue(new Callback<AppleResponse>() {
            @Override
            public void onResponse(Call<AppleResponse> call, Response<AppleResponse> response) {
                if (response.isSuccessful()) {
                    AppleResponse appleResponse = response.body();
                    Log.d(TAG, "onResponse: Paid apps" + response.body().getFeed().getEntry());
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
}
