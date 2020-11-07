package com.kubilaycicek.todo.response.todo;

import com.kubilaycicek.todo.dto.TodoDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TodoResponse {
    private TodoDto todoDto;
}