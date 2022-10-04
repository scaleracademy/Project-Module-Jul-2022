package com.scaler.todoapp.tasks;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
public class TasksService {
    List<TaskEntity> tasks;
    HashSet<TaskEntity> tasksSet =new HashSet();

    public TasksService() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Get all tasks
     */
    public HashSet<TaskEntity> getAllTasks() {
        return tasksSet;
    }

    /**
     * Create a new task
     */
    public void createTask(String name, Date dueDate) {
        int newTaskId = tasks.size();
        TaskEntity task = new TaskEntity(newTaskId, name, dueDate, false, new ArrayList<>());

        tasks.add(task);
        tasksSet.add(task);
    }

    /**
     * Get a task by id
     */

    public TaskEntity getTaskById(int id) {
        if (!checkTaskId(id)) {
            System.out.println("Invalid Task ID: " + id);
        }
        return tasks.get(id);
    }

    /**
     * Delete a task by id
     */
    public void deleteTaskById(int id) {
        if (tasks.size() <= id) {
            throw new TaskNotFoundException(id);
        }
        if (tasks.get(id)==null) {
            throw new DeletedTaskException(id);
        }
        tasksSet.remove(tasks.get(id));
        tasks.set(id, null);
    }

    /**
     * Update a task by id
     */
    public void updateTaskById(int id, String name, Date dueDate, Boolean completed) {
        // TODO: if we add ids inside task object, then list index and task.id might not be same!!
        if (!checkTaskId(id)) {
            System.out.println("Invalid Task ID: " + id);
        }
        TaskEntity task = tasks.get(id);
        tasksSet.remove(task);

        if (name != null) {
            task.setName(name);
        }
        if (dueDate != null) {
            task.setDueDate(dueDate);
        }
        if (completed != null) {
            task.setCompleted(completed);
        }
        tasksSet.add(task);
    }

    /**
     * Check if task ID is valid
     */
    public boolean checkTaskId(int id) throws TaskNotFoundException, DeletedTaskException {
        if (!checkTaskId(id)) {
            System.out.println("Invalid Task ID: " + id);
        }
        return true;
    }
    static class TaskNotFoundException extends IllegalArgumentException {
        public TaskNotFoundException(int taskId) {
            super("Task with id = " + taskId + " not found.");
        }
    }

    static class DeletedTaskException extends IllegalArgumentException {
        public DeletedTaskException(int taskId) {
            super("Task with id = " + taskId + " has been deleted.");
        }
    }
}
