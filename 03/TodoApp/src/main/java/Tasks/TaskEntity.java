package Tasks;

import Notes.NotesEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskEntity {
    UUID id;
    String Name;
    Date DueDate;
    Boolean Completed;
    List<NotesEntity> Notes;
}
