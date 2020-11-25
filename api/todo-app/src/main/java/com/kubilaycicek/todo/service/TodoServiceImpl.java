package com.kubilaycicek.todo.service;

import com.kubilaycicek.todo.dto.TodoDto;
import com.kubilaycicek.todo.exception.TodoNotFoundException;
import com.kubilaycicek.todo.exception.UserNotFoundException;
import com.kubilaycicek.todo.mapper.TodoMapper;
import com.kubilaycicek.todo.model.Todo;
import com.kubilaycicek.todo.repository.TodoRepository;
import com.kubilaycicek.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;
    private final TodoMapper todoMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
        Todo todo = todoMapper.toTodo(todoDto);

        todo.setUser(userRepository.findById(todoDto.getUserDto().getId())
                .orElseThrow(() -> new UserNotFoundException("Todo" + todoDto.getId() + "does not exist !")));

        return todoMapper.toTodoDto(todoRepository.save(todo));
    }

    @Override
    public TodoDto updateTodo(TodoDto todoDto) {
        Todo todoDb = todoRepository.findById(todoDto.getId()).orElseThrow(() -> new TodoNotFoundException("Todo" + todoDto.getId() + "does not exist !"));
        todoDb.setTitle(todoDto.getTitle());
        todoDb.setStatus(todoDto.getStatus());
        todoDb.setUser(userRepository.findById(todoDto.getUserDto().getId())
                .orElseThrow(() -> new UserNotFoundException("Todo" + todoDto.getId() + "does not exist !")));

        return todoMapper.toTodoDto(todoRepository.save(todoDb));
    }

    @Override
    public TodoDto getById(long id) {
        return todoMapper.toTodoDto(todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo" + id + "does not exist !")));
    }

    @Override
    public void removeById(long id) {
        Todo todoDb = todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException("Todo" + id + "does not exist !"));

        todoRepository.delete(todoDb);
    }

    @Override
    public List<TodoDto> findAll() {
        return todoMapper.toTodoDtoList(todoRepository.findAll());
    }
}