package service;

import entity.Todo;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import repository.TodoRepository;

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

    public List<Todo> delete(Todo todo){
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> update(Long id){
        todoRepository.deleteById(id);
        return list();
    }
}
