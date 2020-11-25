package com.kubilaycicek.todo.api;

import com.kubilaycicek.todo.constants.MappingConstants;
import com.kubilaycicek.todo.request.TodoRequest;
import com.kubilaycicek.todo.response.todo.TodoListResponse;
import com.kubilaycicek.todo.response.todo.TodoResponse;
import com.kubilaycicek.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(MappingConstants.TODO_REST_URL)
@RequiredArgsConstructor
public class TodoRestController {
    private final TodoService todoService;

    @PostMapping("/")
    public TodoResponse addTodo(@RequestBody @Valid TodoRequest req) {
        return new TodoResponse(todoService.addTodo(req.getTodoDto()));
    }

    @PutMapping("/")
    public TodoResponse updateTodo(@RequestBody @Valid TodoRequest req) {
        return new TodoResponse(todoService.updateTodo(req.getTodoDto()));
    }

    @GetMapping("/list")
    public TodoListResponse findAll() {
        return new TodoListResponse(todoService.findAll());
    }

    @GetMapping("/todo/{id}")
    public TodoResponse getTodo(@PathVariable(name = "id") long id) {
        return new TodoResponse(todoService.getById(id));
    }

    @DeleteMapping("/delete/{id}")
    public void removeById(@PathVariable(name = "id") long id) {
        todoService.removeById(id);
    }
}