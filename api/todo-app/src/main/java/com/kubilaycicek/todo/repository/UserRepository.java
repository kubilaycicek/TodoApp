package com.kubilaycicek.todo.repository;

import com.kubilaycicek.todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(long id);
    User findByUsername(String username);
    Optional<User> findByUsernameOrEmail(String username, String email);
}
