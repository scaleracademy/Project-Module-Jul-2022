package com.scaler.todoapp.tasks;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateTaskRequest {
    String name;

    @JsonFormat(pattern="yyyy-MM-dd")
    Date dueDate;
}
