package com.todos.service;

import com.google.gson.Gson;
import com.todos.model.Todo;
import com.todos.model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public String getAll() {
        return new Gson().toJson(todoRepository.findAll());
    }

    public Todo addItem(@RequestBody Map<String, Object> newTodo) {
        Todo todo = new Todo(newTodo.get("itemText").toString(), false, "1");
        todoRepository.save(todo);
        return todo;
    }

    public void deleteItem(@RequestBody Map<String, Object> delTodo) {
        for (Todo todo : todoRepository.findAll()) {
            if (todo.getText().equals(delTodo.get("itemText").toString())) {
                todoRepository.delete(todo);
                break;
            }
        }
    }


    public void makeAllDone() {
        for (Todo todo : todoRepository.findAll()) {
            todo.setDone(true);
            todoRepository.save(todo);
        }
    }

    public void changeItemState(@RequestBody Map<String, Object> changeItem) {
        for (Todo todo : todoRepository.findAll()) {

            if (todo.getText().equals(changeItem.get("itemText").toString()) && todo.isDone() == (boolean) changeItem.get("itemState")) {
                todo.setDone(!todo.isDone());
                todoRepository.save(todo);
                break;
            }

        }
    }

}
