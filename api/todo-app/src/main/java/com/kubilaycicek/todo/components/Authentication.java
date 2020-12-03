package com.kubilaycicek.todo.components;

public interface Authentication {
     org.springframework.security.core.Authentication getAuthentication();
     String getUsername();
     boolean isAuthenticated();
     boolean hasRole(Long roleId);
}
