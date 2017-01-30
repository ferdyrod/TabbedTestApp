package com.ferdyrodriguez.toptenapps;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.free_tab_title));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.paid_tab_title));

    }
}