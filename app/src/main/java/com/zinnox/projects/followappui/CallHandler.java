package com.zinnox.projects.followappui;

import android.app.Dialog;
import android.app.WallpaperManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CallHandler extends AppCompatActivity
{
    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_handler);
        myDialog = new Dialog(this);

        //SET Wallpaper
        final WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
        final Drawable wallpaperDrawable = wallpaperManager.getDrawable();

        LinearLayout ll = (LinearLayout) findViewById(R.id.call_handler);//Substitute with your layout
        ll.setBackground(wallpaperDrawable);
        //END
    }

    public void popupKeyNote(View v) {

        LinearLayout keynote_circle = (LinearLayout)findViewById(R.id.keynote_circle);
        keynote_circle.setVisibility(View.INVISIBLE);

        CardView keynote_square = (CardView)findViewById(R.id.keynote_square);
        keynote_square.setVisibility(View.VISIBLE);
        /*
        myDialog.setContentView(R.layout.popup_key_note);

        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("M");
        btnFollow = (Button) myDialog.findViewById(R.id.btnfollow);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
        */
    }
    public void Add_key_note(View v){
        CardView keynote_square = (CardView)findViewById(R.id.keynote_square);
        keynote_square.setVisibility(View.INVISIBLE);

        LinearLayout keynote_circle = (LinearLayout)findViewById(R.id.keynote_circle);
        keynote_circle.setVisibility(View.VISIBLE);
        Toast.makeText(getApplication(),"Key Note Added",Toast.LENGTH_SHORT).show();
    }
}
