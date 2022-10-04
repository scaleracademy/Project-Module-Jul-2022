package com.scalerproject.BasicProject;

import java.util.ArrayList;

public class TaskDetails extends Task {
    public ArrayList<Note> getTaskNotes() {
        return TaskNotes;
    }

    public void setTaskNotes(ArrayList<Note> taskNotes) {
        TaskNotes = taskNotes;
    }

    private ArrayList<Note> TaskNotes;
}
