package Tasks;

import Notes.NotesEntity;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {
    HashMap<UUID,TaskEntity> tasks;

    public TaskService(){
        tasks = new HashMap<>();
    }

    /**
     * Create new task
     */
    public void createTask(String name, Date dueDate){
        UUID id = UUID.randomUUID();
        TaskEntity newTask = new TaskEntity(id,name,dueDate,false,new ArrayList<>());
        tasks.put(id,newTask);
    }

    /**
     * Get all tasks
     */
    public List<TaskEntity> getAllTasks(){
        List<TaskEntity> result = new ArrayList<>();
        for (var x:tasks.values()) {
            result.add(x);
        }
        return result;
    }

    /**
     * Get task by id
     */
    public TaskEntity getTaskById(UUID id){
        if(!tasks.containsKey(id)){
            return null;
        }
        return tasks.get(id);
    }


    /**
     * Update task by Id
     */
    public void updateTaskById(UUID id, String name,Date dueDate, Boolean completed){
        if(!tasks.containsKey(id)){
            throw new TaskNotFoundException(id.toString());
        }
        TaskEntity task = tasks.get(id);
        if(name != null){
            task.setName(name);
        }
        if(dueDate != null){
            task.setDueDate(dueDate);
        }
        if(completed != null){
            task.setCompleted(completed);
        }
    }

    /**
     * Delete task by Id
     */
    public void deleteTaskById(UUID id){
        if(tasks.containsKey(id)){
            tasks.remove(id);
        }
    }

    static class TaskNotFoundException extends IllegalArgumentException{
        public TaskNotFoundException(String value){
            super("Task id '"+value+"' not found");
        }
    }
}
