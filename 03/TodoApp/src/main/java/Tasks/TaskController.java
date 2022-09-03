package Tasks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService service){
        this.taskService = service;
    }

    @GetMapping("/")
    public ResponseEntity<List<TaskEntity>> getAllTasks(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskService.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskService.getTaskById(id));
    }

    @PostMapping("/")
    public ResponseEntity CreateTask(CreateTaskRequest request){
        taskService.createTask(request.Name,request.DueDate);
        return ResponseEntity.status(HttpStatus.CREATED).body("Task Created Successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity UpdateTask(@PathVariable UUID id, String name, Date dueDate, Boolean completed){
        taskService.updateTaskById(id,name,dueDate,completed);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Task Updated Successfully");
    }

    @PostMapping("/{id}")
    public ResponseEntity DeleteTask(@PathVariable UUID id){
        taskService.deleteTaskById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Task Deleted Successfully");
    }
}
