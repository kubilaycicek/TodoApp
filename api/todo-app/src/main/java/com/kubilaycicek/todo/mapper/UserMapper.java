package com.kubilaycicek.todo.mapper;

import com.kubilaycicek.todo.dto.UserDto;
import com.kubilaycicek.todo.model.User;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Named("toUser")
    User toUser(UserDto userDto);

    @Named("toUserDto")
    UserDto toUserDto(User user);

    @IterableMapping(qualifiedByName = "toUser")
    List<User> toUserList(List<UserDto> userDtoList);

    @IterableMapping(qualifiedByName = "toUserDto")
    List<UserDto> toUserDtoList(List<User> userList);
}
