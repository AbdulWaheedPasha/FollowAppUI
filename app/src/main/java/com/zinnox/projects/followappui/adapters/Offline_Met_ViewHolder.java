package com.zinnox.projects.followappui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zinnox.projects.followappui.R;

/**
 * Created by SONU on 25/09/15.
 */
public class Offline_Met_ViewHolder extends RecyclerView.ViewHolder {


public TextView title;


public Offline_Met_ViewHolder(View view) {
        super(view);


        this.title = (TextView) view.findViewById(R.id.cardTitle);

}
        }