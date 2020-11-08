package com.kubilaycicek.todo.api;

import com.kubilaycicek.todo.constants.MappingConstants;
import com.kubilaycicek.todo.constants.StringConstants;
import com.kubilaycicek.todo.dto.UserDto;
import com.kubilaycicek.todo.enums.OperationStatus;
import com.kubilaycicek.todo.filter.JwtTokenUtil;
import com.kubilaycicek.todo.request.LoginRequest;
import com.kubilaycicek.todo.request.RegisterRequest;
import com.kubilaycicek.todo.response.account.LoginResponse;
import com.kubilaycicek.todo.response.account.RegisterResponse;
import com.kubilaycicek.todo.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(MappingConstants.ACCOUNT_REST_URL)
public class AccountRestController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserServiceImpl userService;

    @CrossOrigin
    @RequestMapping(value = MappingConstants.ACCOUNT_LOGIN_REST_URL, method = RequestMethod.POST)
    public LoginResponse login(@RequestBody LoginRequest req) throws AuthenticationException {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        final UserDto loginUserDto = userService.findByUserName(req.getUsername());
        final String token = jwtTokenUtil.generateToken(req.getUsername());

        return new LoginResponse(token, loginUserDto);
    }

    @CrossOrigin
    @RequestMapping(value = MappingConstants.ACCOUNT_REGISTER_REST_URL, method = RequestMethod.POST)
    public RegisterResponse register(@RequestBody RegisterRequest req) {
        UserDto userDto = Optional.ofNullable(userService.addUser(req.getUserDto())).orElse(null);
        if (userDto != null) {
            return new RegisterResponse(StringConstants.SUCCESS_FULL_MESSAGE, OperationStatus.SUCCESS.getValue());
        } else {
            return new RegisterResponse(StringConstants.UN_SUCCESS_MESSAGE, OperationStatus.UN_SUCCESS.getValue());
        }
    }
}
