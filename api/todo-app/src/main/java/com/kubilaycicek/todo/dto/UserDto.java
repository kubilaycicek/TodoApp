package com.kubilaycicek.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto extends BaseDto {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Username is mandatory")
    private String username;
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Password is mandatory")
    private String password;
}
