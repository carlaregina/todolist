package br.com.carla.todolist;

import br.com.carla.todolist.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

class TodolistApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateTodoSuccess() {
        var todo = new Todo("todo 1", "primeiro todo", false, 1);

        webTestClient
                .post()
                .uri("/todos")
                .bodyValue(todo)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$.[0].name").isEqualTo(todo.getName())
                .jsonPath("$.[0].description").isEqualTo(todo.getDescription())
                .jsonPath("$.[0].finished").isEqualTo(todo.isFinished())
                .jsonPath("$.[0].priority").isEqualTo(todo.getPriority());


    }

    @Test
    void testCreateTodoFailure() {

        webTestClient
                .post()
                .uri("/todos")
                .bodyValue(new Todo("","", false, 0))
                .exchange()
                .expectStatus().isBadRequest();
    }
}
