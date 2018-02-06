package com.zinnox.projects.followappui;

import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.zinnox.projects.followappui.adapters.Offline_Met_RecyclerView;

import java.util.ArrayList;

public class OfflineMetActivity extends AppCompatActivity
{
    private static RecyclerView recyclerView;
    private static Toolbar toolbar;
    private static CollapsingToolbarLayout collapsingToolbarLayout;
    int mutedColor = R.attr.colorPrimary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_met);

        //Add Wallpaper
        final WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        final Drawable wallpaperDrawable = wallpaperManager.getDrawable();

        RecyclerView ll = (RecyclerView) findViewById(R.id.recyclerView);//Substitute with your layout
        ll.setBackground(wallpaperDrawable);
        //END

        toolbar = (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("Offline Meetings");//Set Title over collapsing toolbar layout


        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.background);

      // It will generate colors based on the image in an AsyncTask.
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @SuppressWarnings("ResourceType")
            @Override
            public void onGenerated(Palette palette) {

                mutedColor = palette.getMutedColor(R.color.colorPrimary);
                collapsingToolbarLayout.setContentScrimColor(mutedColor);
                collapsingToolbarLayout.setStatusBarScrimColor(R.color.colorAccent);
            }
        });
        setRecyclerView();


    }

    //Setting recycler view
    private void setRecyclerView() {

        recyclerView = (RecyclerView)
                findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView
                .setLayoutManager(new LinearLayoutManager(OfflineMetActivity.this));//Linear Items


        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arrayList.add("New Recording " + i);//Adding items to recycler view
        }
        Offline_Met_RecyclerView adapter = new Offline_Met_RecyclerView(OfflineMetActivity.this, arrayList);
        recyclerView.setAdapter(adapter);// set adapter on recyclerview

    }

    //Go to recording activity
    public void StartNewRecording(View v){
        Intent mainIntent = new Intent(OfflineMetActivity.this,
                OfflineMetPlayRecActivity.class);
        startActivity(mainIntent);
    }

}
