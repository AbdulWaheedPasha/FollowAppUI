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

public class ContactListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] Contact_Name;
    private final Integer[] Contact_Img_Id;
    private final String[] Contact_Number;
    private final Boolean[] Contact_Group_status;


    public ContactListAdapter(Activity context, String[] Contact_Name, Integer[] Contact_Img_Id, String[] Contact_Number, Boolean[] Contact_Group_status) {
        super(context, R.layout.list_contact, Contact_Name);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.Contact_Name=Contact_Name;
        this.Contact_Img_Id=Contact_Img_Id;
        this.Contact_Number =Contact_Number;
        this.Contact_Group_status = Contact_Group_status;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_contact, null,true);

        TextView contact_name = (TextView) rowView.findViewById(R.id.contact_name);
        ImageView contact_image = (ImageView) rowView.findViewById(R.id.contact_image);
        TextView contact_number = (TextView) rowView.findViewById(R.id.contact_number);
        ImageView contact_group_add = (ImageView) rowView.findViewById(R.id.contact_group_add);

        contact_name.setText(Contact_Name[position]);
        contact_image.setImageResource(Contact_Img_Id[position]);
        contact_number.setText(Contact_Number[position]);
        if(!Contact_Group_status[position])
            contact_group_add.setVisibility(View.INVISIBLE);

        return rowView;

    };
}
