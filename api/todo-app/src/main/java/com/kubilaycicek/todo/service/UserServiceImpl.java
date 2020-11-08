package com.kubilaycicek.todo.service;

import com.kubilaycicek.todo.dto.UserDto;
import com.kubilaycicek.todo.exception.UserNotFoundException;
import com.kubilaycicek.todo.mapper.UserMapper;
import com.kubilaycicek.todo.model.User;
import com.kubilaycicek.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;
    public final UserMapper userMapper;

    @Override
    public UserDto addUser(UserDto userDto) {
        return findByUsernameOrEmail(userDto.getUsername(), userDto.getEmail()) ? userMapper.toUserDto(userRepository.save(userMapper.toUser(userDto))) : null;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return findByUsernameOrEmail(userDto.getUsername(), userDto.getEmail()) ? userMapper.toUserDto(userRepository.save(userMapper.toUser(userDto))) : null;
    }

    @Override
    public UserDto findById(long id) {
        return userMapper.toUserDto(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("uSER" + id + "does not exist !")));
    }

    @Override
    public UserDto findByUserName(String username) {
        return userMapper.toUserDto(userRepository.findByUsername(username));
    }

    @Override
    public void removeById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toUserDtoList(userRepository.findAll());
    }

    @Override
    public boolean findByUsernameOrEmail(String username, String email) {
        return Optional.ofNullable(userRepository.findByUsernameOrEmail(username, email)
                .orElse(null)).isPresent() ? true : false;
    }
}
