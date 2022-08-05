package com.scaler.todoapp.tasks;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class TasksServiceTests {

    private TasksService tasksService = new TasksService();

    /**
     * can create a new task
     */
    @Test
    void canCreateTask() {
        tasksService.createTask("task1", new Date());
        HashSet tasksSet = tasksService.getAllTasks();
        Iterator<TaskEntity> taskIterator =tasksSet.iterator();

        Assertions.assertEquals(1, tasksSet.size());
        Assertions.assertEquals("task1", taskIterator.next().getName());
    }

}
