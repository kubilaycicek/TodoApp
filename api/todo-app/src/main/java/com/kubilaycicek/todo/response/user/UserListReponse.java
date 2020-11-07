package com.kubilaycicek.todo.response.user;

import com.kubilaycicek.todo.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserListReponse {
    List<UserDto> userDtoList;
}
