package com.zinnox.projects.followappui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zinnox.projects.followappui.adapters.GroupListAdapter;


public class GroupDisplayerActivity extends AppCompatActivity
{

    ListView list;
    String[] Contact_Name={
            "Zakeer",
            "owais"
    };
    Integer[] Contact_Img_id = {
            R.drawable.profile,
            R.drawable.profile

    };
    String[] Contact_Number={
            "9739290007",
            "7204465565"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_displayer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Group ListView
        GroupListAdapter adapter=new GroupListAdapter(this, Contact_Name, Contact_Img_id,Contact_Number);
        list=(ListView)findViewById(R.id.group_list);
        list.setAdapter(adapter);

        //Total no. group
        TextView group_count = (TextView)findViewById(R.id.group_count);
        group_count.setText(""+list.getAdapter().getCount() + "");

        //Onclick on List
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= Contact_Name[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.group_displayer_activity, menu);
        return true;
    }



}
