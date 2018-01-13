package com.zinnox.projects.followappui;

import android.net.Uri;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zinnox.projects.followappui.adapters.PagerAdapterHome;
import com.zinnox.projects.followappui.adapters.TabHomeCallLog;
import com.zinnox.projects.followappui.adapters.TabHomeEvents;
import com.zinnox.projects.followappui.adapters.TabHomeSettings;

public class MainActivity extends AppCompatActivity implements TabHomeCallLog.OnFragmentInteractionListener,TabHomeEvents.OnFragmentInteractionListener,TabHomeSettings.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_history_black_48dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_event_black_48dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_settings_black_48dp));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final PagerAdapterHome adapter = new PagerAdapterHome(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
