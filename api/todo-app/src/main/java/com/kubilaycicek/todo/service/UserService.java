package com.kubilaycicek.todo.service;

import com.kubilaycicek.todo.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    UserDto findById(long id);

    UserDto findByUserName(String username);

    void removeById(long id);

    List<UserDto> findAll();

    boolean findByUsernameOrEmail(String username, String email);
}
