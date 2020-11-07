package com.kubilaycicek.todo.service;

import com.kubilaycicek.todo.dto.TodoDto;

import java.util.List;

public interface TodoService {
    TodoDto addTodo(TodoDto todoDto);

    TodoDto updateTodo(TodoDto todoDto);

    TodoDto getById(long id);

    void removeById(long id);

    List<TodoDto> findAll();
}
