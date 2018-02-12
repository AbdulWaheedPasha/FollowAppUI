/*
 * Copyright (c) 2018 Arindam Karmakar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zinnox.projects.followappui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zinnox.projects.followappui.R;
import com.zinnox.projects.followappui.models.CallKeyNotes;

import java.util.ArrayList;

/**
 * Created by Arindam Karmakar on 13/02/2018.
 */

public class CallKeyNoteAdapter extends RecyclerView.Adapter {

    private static final String TAG = CallKeyNoteAdapter.class.getSimpleName();
    private ArrayList<CallKeyNotes> mCallKeyNoteList;

    CallKeyNoteAdapter(ArrayList<CallKeyNotes> callKeyNoteList) {
        mCallKeyNoteList = callKeyNoteList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_key_note_item, viewGroup, false);
        return new CallKeyNoteAdapter.NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof NoteViewHolder) {
            final CallKeyNoteAdapter.NoteViewHolder holder = (CallKeyNoteAdapter.NoteViewHolder) viewHolder;
            final CallKeyNotes item = mCallKeyNoteList.get(position);

            if (item.getNote() != null && item.getTime() != null) {
                holder.artistName.setText(item.getNote());
                holder.artistTime.setText(item.getTime());
            }
        }
    }

    @Override
    public int getItemCount() {
        return mCallKeyNoteList == null ? 0 : mCallKeyNoteList.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        private TextView artistName, artistTime;

        NoteViewHolder(View view) {
            super(view);
            artistName = view.findViewById(R.id.key_note_details);
            artistTime = view.findViewById(R.id.key_note_time);
        }
    }
}