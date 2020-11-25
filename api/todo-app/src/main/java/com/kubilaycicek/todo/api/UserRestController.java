package com.kubilaycicek.todo.api;

import com.kubilaycicek.todo.constants.MappingConstants;
import com.kubilaycicek.todo.request.UserRequest;
import com.kubilaycicek.todo.response.user.UserListReponse;
import com.kubilaycicek.todo.response.user.UserResponse;
import com.kubilaycicek.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(MappingConstants.USER_REST_URL)
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("/")
    public UserResponse addUser(@RequestBody @Valid UserRequest req) {
        return new UserResponse(userService.addUser(req.getUserDto()));
    }

    @PutMapping("/")
    public UserResponse updateUser(@RequestBody @Valid UserRequest req) {
        return new UserResponse(userService.updateUser(req.getUserDto()));
    }

    @GetMapping("/list")
    public UserListReponse findAll() {
        return new UserListReponse(userService.findAll());
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable(name = "id") long id) {
        return new UserResponse(userService.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public void removeById(@PathVariable(name = "id") long id) {
        userService.removeById(id);
    }
}
