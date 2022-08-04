package Notes;

import Tasks.TaskEntity;
import Tasks.TaskService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class NotesService {

    private TaskService taskService;
    public NotesService(TaskService service){
        this.taskService = service;
    }

    /**
     * Add note to taskId
     */
    public void addNote(UUID taskId, String title, String body){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task != null){
            List<NotesEntity> taskNotes = task.getNotes();
            taskNotes.add(new NotesEntity(UUID.randomUUID(),title,body));
        }
    }

    /**
     * Update note by id and taskId
     */
    public void updateNoteById(UUID taskId, UUID noteId, String title, String body){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task != null){
            List<NotesEntity> taskNotes = task.getNotes();
            for (var x:taskNotes) {
                if(x.id == noteId){
                    if(title != null){
                        x.setTitle(title);
                    }
                    if(body != null){
                        x.setBody(body);
                    }
                }
            }
        }
    }

    /**
     * Remove note by id and taskId
     */
    public void deleteNoteById(UUID taskId, UUID noteId){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task != null){
            List<NotesEntity> taskNotes = task.getNotes();
            for (int i = 0; i < taskNotes.size(); i++) {
                if(taskNotes.get(i).id == noteId){
                    taskNotes.remove(i);
                }
            }
        }
    }

}
