package br.com.thalesmonteiro.desafio_todolist.repository;

import br.com.thalesmonteiro.desafio_todolist.entidy.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
