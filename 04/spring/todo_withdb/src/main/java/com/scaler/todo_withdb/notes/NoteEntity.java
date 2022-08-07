package com.scaler.todo_withdb.notes;

import com.scaler.todo_withdb.common.BaseEntity;
import com.scaler.todo_withdb.tasks.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

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
    TaskEntity task;
}
