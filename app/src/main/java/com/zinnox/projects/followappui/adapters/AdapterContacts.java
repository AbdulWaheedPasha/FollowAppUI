package com.zinnox.projects.followappui.adapters;

/**
 * Created by apple on 30/01/18.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zinnox.projects.followappui.R;
import com.zinnox.projects.followappui.models.ContactInfo;

import java.util.List;

/**
 * Created by Alshell7 @(Ashraf Khan Workstation)
 * 10:09 PM.
 * 09/Nov/2017
 */



public class AdapterContacts extends RecyclerView.Adapter<AdapterContacts.ContactViewHolder> {


    private List<ContactInfo> contactItemList;
    private Context mContext;

    public AdapterContacts(Context context, List<ContactInfo> contactInfos) {
        this.contactItemList = contactInfos;
        this.mContext = context;

    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_contact, null);
        ContactViewHolder viewHolder = new ContactViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder contactViewHolder, int i) {
        final ContactInfo contactInfo = contactItemList.get(i);

        contactViewHolder.rowContactNam.setText(contactInfo.Name);
        contactViewHolder.rowContactNumber.setText(contactInfo.Number);
    }

    public void removeZikr(ContactInfo ContactInfo)
    {
        contactItemList.remove(ContactInfo);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (null != contactItemList ? contactItemList.size() : 0);
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView rowContactNam;
        TextView rowContactNumber;
        
        ImageView rowAddGroupButton;
        ImageView rowCallButton;
        
        LinearLayout rowFullViewClickActivation;


        public ContactViewHolder(View convertView) {
            super(convertView);
            this.rowContactNam = (TextView) convertView.findViewById(R.id.contact_name);
            this.rowContactNumber = (TextView) convertView.findViewById(R.id.contact_number);
            this.rowAddGroupButton = (ImageView) convertView.findViewById(R.id.contact_group_add);
            this.rowCallButton = (ImageView) convertView.findViewById(R.id.contact_call);

        }
    }
}
