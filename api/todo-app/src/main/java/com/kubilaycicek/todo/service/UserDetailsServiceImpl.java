package com.kubilaycicek.todo.service;

import com.kubilaycicek.todo.model.User;
import com.kubilaycicek.todo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = Optional.ofNullable(userRepository.findByUsername(username)).orElseThrow(
                () -> new UsernameNotFoundException("Invalid username or password."));


        return new org.springframework.security.core
                .userdetails.User(user.getUsername(),
                user.getPassword(),
                Arrays.asList(new SimpleGrantedAuthority("USER")));
    }
}