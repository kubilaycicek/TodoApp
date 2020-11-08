package com.kubilaycicek.todo.response.account;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterResponse {
   String message;
   boolean isSuccess;
}
