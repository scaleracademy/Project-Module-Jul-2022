package com.scaler.basicapp.pojos;

import java.util.ArrayList;
import java.util.Date;

public class Task {
    private int id;
    private String title;
    private String description;
    private Date deadline;
    private ArrayList<Note> notes;
    private boolean completed;

    public Task(String title, String description, Date deadline, ArrayList<Note> notes, boolean completed) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.notes = notes;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
