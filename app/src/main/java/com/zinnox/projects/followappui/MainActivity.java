package com.zinnox.projects.followappui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.zinnox.projects.followappui.adapters.PagerAdapterHome;
import com.zinnox.projects.followappui.adapters.TabHomeCallLog;
import com.zinnox.projects.followappui.adapters.TabHomeEvents;
import com.zinnox.projects.followappui.adapters.TabHomeSettings;

public class MainActivity extends AppCompatActivity implements TabHomeCallLog.OnFragmentInteractionListener,TabHomeEvents.OnFragmentInteractionListener,TabHomeSettings.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_history_black_48dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_event_black_48dp));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_settings_black_48dp));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        Button test = new Button(this);

        Utility.applyFontForButton(getApplicationContext(), test);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final PagerAdapterHome adapter = new PagerAdapterHome(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        Toast.makeText(this, "This is a test for PUSH", Toast.LENGTH_SHORT).show();

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.nav_button) {
            Toast.makeText(getApplication(), "nav_button", Toast.LENGTH_SHORT).show();
            Intent mainIntent = new Intent(MainActivity.this,
                    OfflineMetActivity.class);
            startActivity(mainIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
