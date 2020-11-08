package com.kubilaycicek.todo.request;

import com.kubilaycicek.todo.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterRequest {
    UserDto userDto;
}
