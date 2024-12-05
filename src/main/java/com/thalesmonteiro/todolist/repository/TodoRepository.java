package com.thalesmonteiro.todolist.repository;

import com.thalesmonteiro.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
