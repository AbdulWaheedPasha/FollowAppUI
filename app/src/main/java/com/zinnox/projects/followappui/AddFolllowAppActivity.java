package com.zinnox.projects.followappui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zinnox.projects.followappui.blurbehind.BlurBehind;

/**
 * Created by apple on 30/01/18.
 */

public class AddFolllowAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BlurBehind.getInstance()
                .withAlpha(255)
                .withFilterColor(Color.WHITE)
                .setBackground(this);

        setContentView(R.layout.popup_add_followup);




    }


}
