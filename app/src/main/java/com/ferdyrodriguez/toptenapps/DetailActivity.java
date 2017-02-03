package com.ferdyrodriguez.toptenapps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.ferdyrodriguez.toptenapps.Models.AppDetail;
import com.ferdyrodriguez.toptenapps.Models.AppResult;
import com.ferdyrodriguez.toptenapps.Services.ItunesService;
import com.ferdyrodriguez.toptenapps.Services.RestClient;
import com.ferdyrodriguez.toptenapps.Utils.Utils;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ferdyrod on 2/3/17.
 */
public class DetailActivity extends AppCompatActivity{

    private static final String TAG = DetailActivity.class.getSimpleName();
    private AppResult details;

    private ImageView appIcon;
    private TextView appName;
    private TextView appDeveloper;
    private TextView appPrice;
    private TextView appGenres;
    private TextView appVersion;
    private TextView appReleaseDate;
    private TextView appCurrentReleaseDate;
    private TextView appDescription;

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        String appId = extras.getString("appId");

        ItunesService itunesService = RestClient.createService(ItunesService.class);
        Call<AppDetail> call = itunesService.getAppDetail(appId, Utils.COUNTRY);
        call.enqueue(new Callback<AppDetail>() {
            @Override
            public void onResponse(Call<AppDetail> call, Response<AppDetail> response) {
                if(response.isSuccessful()){
                    AppDetail appDetail = response.body();
                    Log.d(TAG, "onResponse: " + appDetail.getResultCount());
                    details = appDetail.getResults().get(0);
                    setupDetailView(details);

                }  else {
                    try {
                        Log.e(TAG, "Retrofit Response: " + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<AppDetail> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());

            }
        });


    }

    private void setupDetailView(AppResult details) {
        String imageUrl = details.getArtworkUrl100();
        String name = details.getTrackName();
        String developer = details.getArtistName();
        String price = Utils.verifyPrice(details.getPrice().toString());
        String genres = TextUtils.join(", ", details.getGenres());
        String version = details.getVersion();
        String releaseDate = Utils.formatDate(details.getReleaseDate());
        String currentVersionReleaseDate = Utils.formatDate(details.getCurrentVersionReleaseDate());
        String description = details.getDescription();

        appIcon = (ImageView) findViewById(R.id.appDetailIcon);
        appName = (TextView) findViewById(R.id.appDetailName);
        appDeveloper = (TextView) findViewById(R.id.appDetailDeveloper);
        appPrice = (TextView) findViewById(R.id.appDetailPrice);
        appGenres = (TextView) findViewById(R.id.appDetailGenres);
        appVersion = (TextView) findViewById(R.id.appDetailVersion);
        appReleaseDate = (TextView) findViewById(R.id.appDetailReleaseDate);
        appCurrentReleaseDate = (TextView) findViewById(R.id.appDetailCurrentReleaseDate);
        appDescription = (TextView) findViewById(R.id.appDetaillDescription);

        Picasso
                .with(this)
                .load(imageUrl)
                .into(appIcon);

        appName.setText(name);
        appDeveloper.setText(developer);
        appPrice.setText(price);
        appGenres.setText(genres);
        appVersion.setText(version);
        appReleaseDate.setText(releaseDate);
        appCurrentReleaseDate.setText(currentVersionReleaseDate);
        appDescription.setText(description);
    }
}
