package com.kubilaycicek.todo.response.account;

import com.kubilaycicek.todo.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    String token;
    UserDto userDto;
}
