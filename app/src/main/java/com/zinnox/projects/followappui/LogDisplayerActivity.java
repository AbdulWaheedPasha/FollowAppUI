package com.zinnox.projects.followappui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zinnox.projects.followappui.adapters.LogListAdapter;

public class LogDisplayerActivity extends AppCompatActivity
{


    ListView list;
    String Contact_Name="Abrar Muqheeth";
    Integer Contact_Img_id = R.drawable.profile;
    String Contact_Number="9739290007";

    String[] call_status ={
            "ic_call_received_24px",
            "outgoing",
            "ic_call_received_24px"
    };
    String[] DateAndTime ={
            "06:30PM, 04 Sep,2017",
            "07:30PM, 07 Aug,2017",
            "08:30PM, 09 Oct,2017"
    };
    String[] session ={
            "2:30",
            "3:10",
            "4:59"
    };
    Boolean[] important_status ={
            false,
            true,
            true
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_displayer);
        //getting the toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //setting the title
        //toolbar.setTitle("My Toolbar");

        //placing toolbar in place of actionbar
        setSupportActionBar(toolbar);



        //Contact ListView
        LogListAdapter adapter=new LogListAdapter(this, call_status,DateAndTime,session,important_status);
        list=(ListView)findViewById(R.id.log_list);
        list.setAdapter(adapter);

        //Total no contact
        TextView total_calls = (TextView)findViewById(R.id.total_calls);
        total_calls.setText(""+list.getAdapter().getCount() + " Total calls");

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem= call_status[+position];
                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.log_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.log_contact) {
            Toast.makeText(getApplication(),"log_contact",Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.log_Call) {
            Toast.makeText(getApplication(),"log_Call",Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.log_email) {
            Toast.makeText(getApplication(),"log_email",Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.log_addgroup) {
            Toast.makeText(getApplication(),"log_addgroup",Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.log_select_all) {
            Toast.makeText(getApplication(),"log_select_all",Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.log_delete_all) {
            Toast.makeText(getApplication(),"log_delete_all",Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
