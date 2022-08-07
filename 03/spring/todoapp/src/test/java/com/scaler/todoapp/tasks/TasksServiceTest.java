package com.scaler.todoapp.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class TasksServiceTest {

    private TasksService taskService = new TasksService();

    /**
     * Can create a new task
     */
    @Test
    void canCreateTask(){
        taskService.createTask("task1", new Date());
        Assertions.assertEquals(1, taskService.getAllTasks().size());
        Assertions.assertEquals("task1", taskService.getTaskById(0).getName());
    }

}
