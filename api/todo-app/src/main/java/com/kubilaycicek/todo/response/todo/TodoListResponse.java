package com.kubilaycicek.todo.response.todo;

import com.kubilaycicek.todo.dto.TodoDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class TodoListResponse {
    private List<TodoDto> todoDtoList;
}