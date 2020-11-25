package com.kubilaycicek.todo.dto;

import com.kubilaycicek.todo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto extends BaseDto {

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Title is mandatory")
    private Status status;

    private UserDto userDto;
}
