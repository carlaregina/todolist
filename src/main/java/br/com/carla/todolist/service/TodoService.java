package br.com.carla.todolist.service;

import br.com.carla.todolist.entity.Todo;

import br.com.carla.todolist.exception.BadRequestException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import br.com.carla.todolist.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> list(){
        Sort sort = Sort.by("priority").descending().and(
                Sort.by("name").ascending());
        return todoRepository.findAll(sort);
    }

    public List<Todo> update(Long id, Todo todo) {
        todoRepository.findById(id).ifPresentOrElse((existingTodo) -> {
            todo.setId(id);
            todoRepository.save(todo);
        }, () -> {
            throw new BadRequestException("Todo %d does not exist! ".formatted(id));
        });

        return list();

    }

    public List<Todo> delete(Long id) {
        todoRepository.findById(id).ifPresentOrElse((existingTodo) -> todoRepository.delete(existingTodo), () -> {
            throw new BadRequestException("Todo %d does not exist! ".formatted(id));
        });
        return list();
    }

}
