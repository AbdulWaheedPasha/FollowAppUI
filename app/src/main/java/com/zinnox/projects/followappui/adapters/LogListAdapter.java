package com.zinnox.projects.followappui.adapters;

/**
 * Created by apple on 24/01/18.
 */

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zinnox.projects.followappui.R;

public class LogListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] call_status;
    private final String[] DateAndTime;
    private final String[] session;
    private final Boolean[] important_status;

    public LogListAdapter(Activity context, String[] call_status, String[] DateAndTime, String[] session,Boolean[] important_status) {
        super(context, R.layout.list_log, call_status);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.call_status=call_status;
        this.DateAndTime=DateAndTime;
        this.session =session;
        this.important_status = important_status;

    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_log, null,true);

        ImageView call_status_ref = (ImageView) rowView.findViewById(R.id.call_status);
        TextView DateAndTime_ref = (TextView) rowView.findViewById(R.id.DateAndTime);
        TextView session_ref = (TextView) rowView.findViewById(R.id.session);
        ImageView important_status_ref = (ImageView) rowView.findViewById(R.id.important_status);

        if(call_status[position]=="ic_call_received_24px")
        call_status_ref.setImageResource(R.drawable.ic_call_received_24px);
        else
            call_status_ref.setImageResource(R.drawable.ic_call_made_24px);
        DateAndTime_ref.setText(DateAndTime[position]);
        session_ref.setText(session[position]);
        if(important_status[position])
        important_status_ref.setImageResource(R.drawable.ic_grade_24px);

        return rowView;

    };
}
