package com.zinnox.projects.followappui.tasks;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import com.zinnox.projects.followappui.models.ContactInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 30/01/18.
 */

public class ContactsLoaderTask extends AsyncTask<Context, Void, List<ContactInfo>>
{
    public ContactsLoaderTask()
    {
        super();
    }


    private String getParsedNumber(String s)
    {
        return s;
    }



    @Override
    protected List<ContactInfo> doInBackground(Context... voids)
    {

        Context context = voids[0];

        List<ContactInfo> mPhoneContacts = new ArrayList<>();
        List<String> phoneNumbersFiltered = new ArrayList<>();
        int totalUnfilteredContacts = 0;

        if (true) {
            logout("Beginning the cursor fetching contacts from android");
            final Uri contentUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
            final String[] projection = {
                    ContactsContract.Contacts._ID,
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                    ContactsContract.CommonDataKinds.Phone.NUMBER,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID,
                    ContactsContract.CommonDataKinds.Email.DATA
            };
            final String order = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " COLLATE NOCASE ASC";

            try {
                //Cursor mCursor = getActivity().getContentResolver().query(contentUri, projection,ContactsContract.Contacts.HAS_PHONE_NUMBER + "=?", new String[] { "1" },order);
                Cursor mCursor = context.getContentResolver().query(contentUri, projection, null, null,order);
                if (null == mCursor || mCursor.getCount() < 1) {
                    logout("No Contacts found or was an error");
                } else
                {
                    logout("Starting the cursor for getting the contacts...");
                    while (mCursor.moveToNext())
                    {
                        int nameIndex = mCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
                        int numberIndex = mCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                        int idIndex = mCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.CONTACT_ID);
                        long id = mCursor.getLong(idIndex);
                        Uri contactUri = ContactsContract.Contacts.CONTENT_URI;
                        Uri displayUri = ContentUris.withAppendedId(contactUri, id);

                        String filteredNumber = getParsedNumber(mCursor.getString(numberIndex));

                        if (filteredNumber != null) {
                            logout("Received filtered number : " + filteredNumber);
                            String name = mCursor.getString(nameIndex);

                           /* mPhoneContactsSet.add(new ContactInfo(name,
                                    filteredNumber,
                                    id, displayUri
                            ));*/

                            if(!phoneNumbersFiltered.contains(filteredNumber))
                            {
                                ContactInfo contactInfo = new ContactInfo(name,
                                        filteredNumber,
                                        id, displayUri
                                );
                                phoneNumbersFiltered.add(filteredNumber);
                                mPhoneContacts.add(contactInfo);
                            }
                            totalUnfilteredContacts += 1;
                        }

                            /*ContactInfo contactInfo;
                            if (!mPhoneContacts.contains(new ContactInfo(name, filteredNumber))) {
                                contactInfo = new ContactInfo(name,
                                        filteredNumber,
                                        id, displayUri
                                );
                                mPhoneContacts.add(contactInfo);

                            }*/ /*else {
                                logout("Already contained " + name);
                            }*/
                    }

                    logout("TOTAL UNFILTERED CONTACTS : " + totalUnfilteredContacts);
                    logout("TOTAL FILTERED CONTACTS : " + mPhoneContacts.size());
                }
                if (mCursor != null) {
                    mCursor.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return mPhoneContacts;
    }

    private void logout(String s)
    {

    }


}