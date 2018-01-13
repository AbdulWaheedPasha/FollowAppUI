package com.zinnox.projects.followappui.adapters;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by apple on 11/01/18.
 */

public class PagerAdapterHome extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PagerAdapterHome(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position)
        {

            case 0:
                TabHomeCallLog tab1 = new TabHomeCallLog();
                return tab1;
            case 1:
                TabHomeEvents tab2 = new TabHomeEvents();
                return  tab2;
            case 2:
                TabHomeSettings tab3 = new TabHomeSettings();
                return  tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
