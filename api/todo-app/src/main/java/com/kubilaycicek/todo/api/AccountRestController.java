package com.kubilaycicek.todo.api;

import com.kubilaycicek.todo.constants.MappingConstants;
import com.kubilaycicek.todo.dto.UserDto;
import com.kubilaycicek.todo.filter.JwtTokenUtil;
import com.kubilaycicek.todo.request.LoginRequest;
import com.kubilaycicek.todo.response.account.LoginResponse;
import com.kubilaycicek.todo.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RequiredArgsConstructor
@RestController
@RequestMapping(MappingConstants.ACCOUNT_REST_URL)
public class AccountRestController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserServiceImpl userService;

    @CrossOrigin
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public LoginResponse login(@RequestBody LoginRequest req) throws AuthenticationException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        final UserDto loginUserDto = userService.findByUserName(req.getUsername());
        final String token = jwtTokenUtil.generateToken(req.getUsername());

        return new LoginResponse(token, loginUserDto);

    }
}
