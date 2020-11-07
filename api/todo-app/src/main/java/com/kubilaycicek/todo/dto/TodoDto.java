package com.kubilaycicek.todo.dto;

import com.kubilaycicek.todo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto extends BaseDto {

    private String title;

    private Status status;

    private UserDto userDto;
}
