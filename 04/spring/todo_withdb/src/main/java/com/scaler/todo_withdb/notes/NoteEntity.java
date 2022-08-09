package com.scaler.todo_withdb.notes;

import com.scaler.todo_withdb.common.BaseEntity;
import com.scaler.todo_withdb.tasks.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name="notes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoteEntity extends BaseEntity {
    @Column(name="title", nullable = false)
    private String title;

    @Column(name="body", nullable = false)
    private String body;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    TaskEntity task;
}
