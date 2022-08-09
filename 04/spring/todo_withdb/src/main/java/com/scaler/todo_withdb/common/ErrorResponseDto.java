package com.scaler.todo_withdb.common;

import lombok.Data;
import lombok.NonNull;

@Data
public class ErrorResponseDto {
    @NonNull
    private String message;
}
