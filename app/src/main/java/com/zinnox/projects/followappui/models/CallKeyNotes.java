package com.zinnox.projects.followappui.models;

/**
 * Created by apple on 04/02/18.
 */

public class CallKeyNotes {

    private String name;
    private String time;
    private String title;

    //KeyNote
    public String getNote() {
        return name;
    }
    public void setNote(String name) {
        this.name = name;
    }

    //time
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.name = time;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
