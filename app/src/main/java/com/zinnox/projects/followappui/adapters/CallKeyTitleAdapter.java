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

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zinnox.projects.followappui.R;
import com.zinnox.projects.followappui.adapters.helper.OnStartDragListener;
import com.zinnox.projects.followappui.adapters.helper.TouchHelperCallback;
import com.zinnox.projects.followappui.models.CallKeyNotes;

import java.lang.ref.WeakReference;
import java.util.ArrayList;



public class CallKeyTitleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements OnStartDragListener {

    private WeakReference<Activity> mActivity;
    private ItemTouchHelper mItemTouchHelper;

    private String mTitle;
    private ArrayList<CallKeyNotes> mCallKeyNoteList;
    private boolean isCollapsed = true;

    public CallKeyTitleAdapter(Activity activity, String title, ArrayList<CallKeyNotes> callKeyNoteList) {
        mActivity = new WeakReference<Activity>(activity);
        mTitle = title;
        mCallKeyNoteList = callKeyNoteList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_key_title_row, viewGroup, false);
        return new CallKeyTitleAdapter.TitleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof TitleViewHolder) {
            final CallKeyTitleAdapter.TitleViewHolder holder = (CallKeyTitleAdapter.TitleViewHolder) viewHolder;
            holder.textView.setText(mTitle);
            setupNoteList(holder.recyclerView, mCallKeyNoteList);
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (isCollapsed) {
                        holder.recyclerView.setVisibility(View.VISIBLE);
                        isCollapsed = false;
                    } else {
                        holder.recyclerView.setVisibility(View.GONE);
                        isCollapsed = true;
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return (null != mTitle ? 1 : 0);
    }

    public class TitleViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;
        private RecyclerView recyclerView;
        TitleViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.list_item_genre_name);
            imageView = view.findViewById(R.id.list_item_genre_arrow);
            recyclerView = view.findViewById(R.id.recyclerView);
        }
    }

    private void setupNoteList(RecyclerView recyclerView, ArrayList<CallKeyNotes> mCallKeyNoteList) {
        CallKeyNoteAdapter adapter = new CallKeyNoteAdapter(mCallKeyNoteList);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity.get(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        ItemTouchHelper.Callback callback = new TouchHelperCallback(adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}