package com.kubilaycicek.todo;

import com.kubilaycicek.todo.components.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class TodoApplication {


	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}
}
