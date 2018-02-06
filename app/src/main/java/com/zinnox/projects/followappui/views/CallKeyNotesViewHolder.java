package com.zinnox.projects.followappui.views;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.zinnox.projects.followappui.R;

/**
 * Created by apple on 04/02/18.
 */

public class CallKeyNotesViewHolder extends ChildViewHolder
{
    private TextView artistName;
    private TextView artistTime;
    public CallKeyNotesViewHolder(View itemView)
    {
        super(itemView);
        artistName = (TextView)itemView.findViewById(R.id.key_note_details);
        artistTime = (TextView)itemView.findViewById(R.id.key_note_time);
    }
    public void setArtistName(String name){
        artistName.setText(name);
    }

    public void setArtistTime(String time){
        artistTime.setText(time);
    }

}
