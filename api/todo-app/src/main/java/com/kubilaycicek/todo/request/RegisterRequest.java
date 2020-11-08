package com.kubilaycicek.todo.request;

import com.kubilaycicek.todo.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    UserDto userDto;
}
