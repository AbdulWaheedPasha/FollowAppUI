package com.zinnox.projects.followappui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.zinnox.projects.followappui.adapters.CallKeyTitleAdapter;
import com.zinnox.projects.followappui.blurbehind.BlurBehind;
import com.zinnox.projects.followappui.blurbehind.OnBlurCompleteListener;
import com.zinnox.projects.followappui.models.CAllKeyTitle;
import com.zinnox.projects.followappui.models.CallKeyNotes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 25/01/18.
 */

public class CallDataDisplayerActivity extends AppCompatActivity {

    ExpandableRelativeLayout expandableLayout3, expandableLayout4;
    RecyclerView list;

    String[] Contact_Name = {
            "Zakeer",
            "Waheed",
            "owais"
    };

    Integer[] Contact_Img_id = {
            R.drawable.profile,
            R.drawable.profile,
            R.drawable.profile

    };

    String[] Contact_Number = {
            "9739290007",
            "9663413886",
            "7204465565"
    };

    Boolean[] Contact_Group_status = {
            true,
            false,
            true
    };

    private RecyclerView mRecyclerView;
    private CallKeyTitleAdapter mAdapter;
    private List<CAllKeyTitle> TitleNotes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_data_displayer);

        mRecyclerView = findViewById(R.id.recyler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(CallDataDisplayerActivity.this));
        //getAllNotes();
        mAdapter = new CallKeyTitleAdapter(this, "Call Key Points", getArrayList());
        mRecyclerView.setAdapter(mAdapter);

        RelativeLayout Tap_here_to_make_follow_up = findViewById(R.id.Tap_here_to_make_follow_up);
        Tap_here_to_make_follow_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlurBehind.getInstance().execute(CallDataDisplayerActivity.this, new OnBlurCompleteListener() {
                    @Override
                    public void onBlurComplete() {
                        startActivity(new Intent(CallDataDisplayerActivity.this, AddFolllowAppActivity.class));
                    }
                });
            }
        });
    }

    public void PlayPauseOperation(View v) {
        ImageView PlayPauseOperation = findViewById(R.id.play_pause_button);

        if (PlayPauseOperation.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.ic_play_circle_filled_24px).getConstantState()) {
            PlayPauseOperation.setImageResource(R.drawable.ic_pause_circle_outline_24px);
        } else {
            PlayPauseOperation.setImageResource(R.drawable.ic_play_circle_filled_24px);
        }
    }

    public void expandableButton3(View view) {
        expandableLayout3 = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout3);
        expandableLayout3.toggle(); // toggle expand and collapse
    }

    /*public void getAllNotes() {
        TitleNotes = new ArrayList<>(6);
        List<CallKeyNotes> callKeyNotes = new ArrayList<>(3);
        callKeyNotes.add(new CallKeyNotes("This is First Key point", "1:00"));
        callKeyNotes.add(new CallKeyNotes("This is second key point", "2:00"));
        callKeyNotes.add(new CallKeyNotes("This is the third key point", "3:00"));
        TitleNotes.add(new CAllKeyTitle("Call Key Points", callKeyNotes));
    }*/

    private ArrayList<CallKeyNotes> getArrayList() {
        CallKeyNotes noteItem1 = new CallKeyNotes();
        noteItem1.setNote("This is first key point");
        noteItem1.setTime("1:00");

        CallKeyNotes noteItem2 = new CallKeyNotes();
        noteItem2.setNote("This is second key point");
        noteItem2.setTime("2:00");

        CallKeyNotes noteItem3 = new CallKeyNotes();
        noteItem3.setNote("This is third key point");
        noteItem3.setTime("3:00");

        ArrayList<CallKeyNotes> item = new ArrayList<>();
        item.add(noteItem1);
        item.add(noteItem2);
        item.add(noteItem3);
        return item;
    }


}
