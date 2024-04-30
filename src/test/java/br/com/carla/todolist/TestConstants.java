package br.com.carla.todolist;

import br.com.carla.todolist.entity.Todo;

import java.util.ArrayList;
import java.util.List;

public class TestConstants {

    public static final List<Todo> TODOS = new ArrayList<>() {
        {
            add(new Todo(9995L, "@carlavasconcellos", "like", false, 1));
            add(new Todo(9996L, "@carlavasconcellos", "comment", false, 1));
            add(new Todo(9997L, "@carlavasconcellos", "share", false, 1));
            add(new Todo(9998L, "@carlavasconcellos", "subscribe", false, 1));
            add(new Todo(9999L, "@carlavasconcellos", "active notifications", false, 1));
        }
    };

    public static final Todo TODO = TODOS.get(0);
}
