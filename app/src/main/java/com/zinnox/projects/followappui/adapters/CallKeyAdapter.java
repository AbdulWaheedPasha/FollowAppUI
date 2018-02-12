package com.zinnox.projects.followappui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.zinnox.projects.followappui.R;
import com.zinnox.projects.followappui.models.CallKeyNotes;
import com.zinnox.projects.followappui.views.CallKeyNotesViewHolder;
import com.zinnox.projects.followappui.views.CallKeyTitleViewHolder;

import java.util.List;

/**
 * Created by apple on 04/02/18.
 */

public class CallKeyAdapter extends ExpandableRecyclerViewAdapter<CallKeyTitleViewHolder, CallKeyNotesViewHolder> {

    public CallKeyAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public CallKeyTitleViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_key_title_row, parent, false);
        return new CallKeyTitleViewHolder(view);
    }

    @Override
    public CallKeyNotesViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_key_note_item, parent, false);
        return new CallKeyNotesViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(CallKeyNotesViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        CallKeyNotes callKeyNotes = (CallKeyNotes) group.getItems().get(childIndex);
        holder.setArtistName(callKeyNotes.getNote());
        holder.setArtistTime(callKeyNotes.getTime());
    }

    @Override
    public void onBindGroupViewHolder(CallKeyTitleViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setGenreName(group.getTitle());
    }
}
