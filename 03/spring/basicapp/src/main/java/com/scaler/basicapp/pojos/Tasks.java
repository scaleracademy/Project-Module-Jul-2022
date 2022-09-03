package com.scaler.basicapp.pojos;

import java.util.Date;

public class Tasks {

    private String title;
    private String due_date;
    private Boolean completed;
    private Notes note;


    public Tasks(String title, String due_date, Boolean completed){
        this.title = title;
        this.due_date = due_date;
        this.completed = completed;
        this.note = null;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDue_date(String due_date){
        this.due_date = due_date;
    }
    public String getDue_date(){
        return due_date;
    }

    public void setCompleted(Boolean completed){
        this.completed = completed;
    }

    public Boolean getCompleted(){
        return completed;
    }

    public void setNotes(Notes note){
        this.note = note;
    }
    public Notes getNotes(){
        return note;
    }

}
