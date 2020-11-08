package com.kubilaycicek.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDto {
    private String name;
    private String username;
    private String email;
    private String password;

}
