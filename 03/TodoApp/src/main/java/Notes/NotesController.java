package Notes;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {
    private NotesService noteService;

    public NotesController(NotesService service){
        this.noteService = service;
    }

    @PostMapping("/")
    public ResponseEntity AddNoteToTask(@PathVariable UUID taskId, String title, String body){
        noteService.addNote(taskId, title, body);
        return ResponseEntity.status(HttpStatus.CREATED).body("Note Added!");
    }

    @PutMapping("/{noteId}")
    public ResponseEntity UpdateNoteById(@PathVariable UUID taskId, @PathVariable UUID noteId, String title, String body){
        noteService.updateNoteById(taskId, noteId,title, body);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Note Updated!");
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity DeleteNoteById(@PathVariable UUID taskId, @PathVariable UUID noteId){
        noteService.deleteNoteById(taskId, noteId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Note Deleted!");
    }

}
