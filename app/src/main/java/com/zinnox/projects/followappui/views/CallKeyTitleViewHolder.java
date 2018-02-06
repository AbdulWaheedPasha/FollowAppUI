package com.zinnox.projects.followappui.views;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;
import com.zinnox.projects.followappui.R;


/**
 * Created by apple on 04/02/18.
 */

public class CallKeyTitleViewHolder extends GroupViewHolder
{
    private TextView genreTitle;
    public CallKeyTitleViewHolder(View itemView)
    {
        super(itemView);
        genreTitle = (TextView)itemView.findViewById(R.id.list_item_genre_name);

    }
    public void setGenreName(String name){
        genreTitle.setText(name);
    }
}
