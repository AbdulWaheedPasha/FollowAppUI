package com.zinnox.projects.followappui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.zinnox.projects.followappui.R;

import java.util.ArrayList;

/**
 * Created by SONU on 25/09/15.
 */
public class Offline_Met_RecyclerView extends
        RecyclerView.Adapter<Offline_Met_ViewHolder> {
    private ArrayList<String> arrayList;
    private Context context;


    public Offline_Met_RecyclerView(Context context,
                                    ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }


    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);

    }

    @Override
    public void onBindViewHolder(Offline_Met_ViewHolder holder,
                                 int position) {


        final Offline_Met_ViewHolder mainHolder = (Offline_Met_ViewHolder) holder;
        //Setting text over textview
        mainHolder.title.setText(arrayList.get(position));

    }

    @Override
    public Offline_Met_ViewHolder onCreateViewHolder(
            ViewGroup viewGroup, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(viewGroup.getContext());

        ViewGroup mainGroup = (ViewGroup) mInflater.inflate(
                R.layout.item_row, viewGroup, false);
        Offline_Met_ViewHolder mainHolder = new Offline_Met_ViewHolder(mainGroup) {
            @Override
            public String toString() {
                return super.toString();
            }
        };


        return mainHolder;

    }


}
