package com.scaler.todoapp.notes;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NoteEntity {
    Integer id;
    String title;
    String body;
}
