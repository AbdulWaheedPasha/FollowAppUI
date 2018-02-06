package com.zinnox.projects.followappui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.zinnox.projects.followappui.adapters.AdapterContacts;
import com.zinnox.projects.followappui.models.ContactInfo;
import com.zinnox.projects.followappui.tasks.ContactsLoaderTask;

import java.util.List;

public class ContactsDisplayerActivity extends AppCompatActivity{

    RecyclerView list;
    String[] Contact_Name={
            "Zakeer",
            "Waheed",
            "owais"
    };
    Integer[] Contact_Img_id = {
            R.drawable.profile,
            R.drawable.profile,
            R.drawable.profile

    };
    String[] Contact_Number={
            "9739290007",
            "9663413886",
            "7204465565"
    };
    Boolean[] Contact_Group_status={
        true,
        false,
        true
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_displayer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //Contact ListView
        //ContactListAdapter adapter=new ContactListAdapter(this, Contact_Name, Contact_Img_id,Contact_Number,Contact_Group_status);
        list=(RecyclerView) findViewById(R.id.contact_list);

        list.setLayoutManager(new LinearLayoutManager(this));
        //Total no contact
        TextView contact_count = (TextView)findViewById(R.id.contact_count);

        //contact_count.setText(""+list.getAdapter().getCount());

//        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                // TODO Auto-generated method stub
//                String Slecteditem= Contact_Name[+position];
//                Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
//
//            }
//        });

        new LoadContactsTask().execute(ContactsDisplayerActivity.this);
    }

    private class LoadContactsTask extends ContactsLoaderTask
    {

        @Override
        protected List<ContactInfo> doInBackground(Context... voids)
        {
            return super.doInBackground(voids);
        }

        @Override
        protected void onPostExecute(List<ContactInfo> contactInfos)
        {
            super.onPostExecute(contactInfos);
            AdapterContacts adapterContacts = new AdapterContacts(ContactsDisplayerActivity.this, contactInfos);
            list.setAdapter(adapterContacts);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.contactdisplayer_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.nav_button) {
            Intent mainIntent = new Intent(ContactsDisplayerActivity.this,
                    GroupDisplayerActivity.class);
            startActivity(mainIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
