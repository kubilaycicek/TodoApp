package com.kubilaycicek.todo.repository;

import com.kubilaycicek.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo,Long>  {
    Optional<Todo> findById(long id);
}
