package br.com.carla.todolist.web;

import br.com.carla.todolist.entity.Todo;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.carla.todolist.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    ResponseEntity<List<Todo>> create(@RequestBody @Valid Todo todo){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(todoService.create(todo));
    }

    @GetMapping
    List<Todo> list(){
        return todoService.list();
    }

    @PutMapping
    List<Todo> update(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.update(id, todo);
    }

    @DeleteMapping({"{id}"})
    List<Todo> delete(@PathVariable("id") Long id){
        return todoService.delete(id);
    }
}
