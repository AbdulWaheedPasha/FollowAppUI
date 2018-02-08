package com.zinnox.projects.followappui;

import android.app.WallpaperManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class OfflineMetPlayRecActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline_met_play_rec);

        //SET Wallpaper
        final WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        final Drawable wallpaperDrawable = wallpaperManager.getDrawable();

        LinearLayout ll = (LinearLayout) findViewById(R.id.offline_met_rec_body);//Substitute with your layout
        ll.setBackground(wallpaperDrawable);
        //END
    }
    public void PlayPauseOperation(View v){

        ImageView PlayPauseOperation =  (ImageView) findViewById(R.id.PlayPauseOperation);

        if (PlayPauseOperation.getDrawable().getConstantState() == getResources().getDrawable( R.drawable.ic_play_arrow_24px).getConstantState())
        {
            PlayPauseOperation.setImageResource(R.drawable.ic_stop_24px);
            Toast.makeText(getApplicationContext(),"stop logo",Toast.LENGTH_LONG).show();
        }
        else{
            PlayPauseOperation.setImageResource(R.drawable.ic_play_arrow_24px);
        }

    }
}
