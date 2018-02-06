package com.zinnox.projects.followappui.models;

/**
 * Created by apple on 13/01/18.
 */

import android.net.Uri;

import java.io.Serializable;

/**
 * Class holding the information of the contact needed for this app.
 */
public class ContactInfo implements Serializable
{
    public String Name = null;
    public String Number = null;
    public Long ID = null;
    public Uri ImageLocation = null;
    public String EmailId = DEFAULT_EMAIL_ID;
    public static final String DEFAULT_EMAIL_ID = "none@none";
    //// DONE: 12/Jul/2016 integrate with settings, Contacts to display, :name purged:number:both:
    //private int equalisingType = 2;

    public ContactInfo(String name, String number){
        this.Name = name;
        this.Number = number;
        //initialiseEqualisingType();
    }
    public ContactInfo(String name, String number, Long id, Uri imageUri){
        this.Name = name;
        this.Number = number;
        this.ID = id;
        this.ImageLocation = imageUri;
        //initialiseEqualisingType();
    }

    public ContactInfo(String name, String number, Long id, Uri imageUri, String emailId){
        this.Name = name;
        this.Number = number;
        this.ID = id;
        this.ImageLocation = imageUri;
        this.EmailId = emailId;
        //initialiseEqualisingType();
    }

       /* private void initialiseEqualisingType(){
            equalisingType = Integer.parseInt(PreferenceManager
                    .getDefaultSharedPreferences(FollowApp
                            .getGlobalContext())
                    .getString(Settings
                            .SETTINGS_CONTACT_LIST_TYPE, "1"));
        }*/

    public String toString(){
        return ("Contact Name : " + Name + ", Contact Number : " + Number + ", Image Location : " + ImageLocation.toString());
    }

    @Override
    public boolean equals(Object other)
    {
        return  other instanceof ContactInfo && (((ContactInfo) other).Number.equals(this.Number));
            /*switch (equalisingType) {
                case 1 :
                    acceptedStrategy = other instanceof ContactInfo && (((ContactInfo) other).Name.equals(this.Name));
                    break;
                case 2:
                    acceptedStrategy = other instanceof ContactInfo && (((ContactInfo) other).Number.equals(this.Number));;
                    break;
                case 3:
                    acceptedStrategy = other instanceof ContactInfo && (((ContactInfo) other).Name.equals(this.Name) || ((ContactInfo) other).Number.equals(this.Number));;
                    break;
                default:
                    acceptedStrategy = other instanceof ContactInfo && (((ContactInfo) other).Name.equals(this.Name));
                    break;
            }
            */
        //return acceptedStrategy;
    }


}