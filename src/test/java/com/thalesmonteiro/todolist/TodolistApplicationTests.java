package com.thalesmonteiro.todolist;

import com.thalesmonteiro.todolist.entity.Todo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class TodolistApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void textCreateTodoSuccess() {
		var todo = new Todo("todo 1", "desc todo 1", false,  1);

		webTestClient.post()
				.uri("/todos")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].nome").isEqualTo(todo.getNome())
				.jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
				.jsonPath("$[0].realizado").isEqualTo(todo.getRealizado())
				.jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());
	}
	@Test
	void textCreateTodoFailure() {

		webTestClient
				.post()
				.uri("/todos")
				.bodyValue(new Todo("", "", false, 0)).exchange()
				.expectStatus().isBadRequest();

	}

}