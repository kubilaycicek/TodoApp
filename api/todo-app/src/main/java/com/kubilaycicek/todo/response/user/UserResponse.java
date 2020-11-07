package com.kubilaycicek.todo.response.user;

import com.kubilaycicek.todo.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponse {
    UserDto userDto;
}
