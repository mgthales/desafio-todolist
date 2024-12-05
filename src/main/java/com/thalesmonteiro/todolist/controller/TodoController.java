package com.thalesmonteiro.todolist.controller;

import com.thalesmonteiro.todolist.entity.Todo;
import com.thalesmonteiro.todolist.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {


    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public List<Todo> create(@RequestBody @Valid Todo todo) {
        return todoService.create(todo);
    }

    @GetMapping
    public List<Todo> list() {
        return todoService.list();
    }

    @PutMapping
    public List<Todo> update(@RequestBody @Valid Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("/{id}")
    public List<Todo> delete(@PathVariable("id") Long id) {
        return todoService.delete(id);
    }
}
