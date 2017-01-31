package com.ferdyrodriguez.toptenapps.Adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ferdyrodriguez.toptenapps.Fragments.FreeFragmentTab;
import com.ferdyrodriguez.toptenapps.Fragments.PaidFragmentTab;

/**
 * Created by ferdyrod on 1/31/17.
 */

public class FragmentPagerAdapter extends FragmentStatePagerAdapter {
    int TABS_COUNT = 2;
    private Context context;
    private String[] tabTitles = new String[] {
            "Free Apps",
            "Paid Apps"
    };

    public FragmentPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                FreeFragmentTab freeTab = new FreeFragmentTab();
                return freeTab;
            case 1:
                PaidFragmentTab paidTab = new PaidFragmentTab();
                return paidTab;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TABS_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
