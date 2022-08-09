package com.scaler.todo_withdb.tasks;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.Date;

@Data
public class TaskDto {
    @Nullable
    Long id;
    @Nullable
    String name;
    @Nullable
    Date dueDate;
    @Nullable
    Boolean done;
}
