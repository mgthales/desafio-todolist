package br.com.thalesmonteiro.desafio_todolist.controller;

import br.com.thalesmonteiro.desafio_todolist.entidy.Todo;
import br.com.thalesmonteiro.desafio_todolist.service.TodoService;
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
    List<Todo> create(@RequestBody Todo todo){
        return todoService.create(todo);
    }
    @GetMapping
    List<Todo> list(){
        return todoService.list();
    }
    @PatchMapping("/{id}")
    List<Todo> update(@PathVariable Long id, @RequestBody Todo todo){

        return todoService.update(todo);
    }
    @DeleteMapping("{id}")
    List<Todo> delete(@PathVariable Long id){
        return todoService.delete(id);
    }
}
