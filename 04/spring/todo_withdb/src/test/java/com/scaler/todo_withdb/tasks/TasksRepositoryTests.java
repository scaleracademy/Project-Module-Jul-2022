package com.scaler.todo_withdb.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class TasksRepositoryTests {
    @Autowired private TasksRepository tasksRepository;

    @Test
    public void canCreateTask(){
        TaskEntity task = new TaskEntity();
        task.name = "test task";
        task.dueDate = new Date();
        task.done = false;
        tasksRepository.save(task);

        assertEquals("test task",tasksRepository.findAll().get(0).name);
    }
}
