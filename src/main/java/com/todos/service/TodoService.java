package com.todos.service;

import com.google.gson.Gson;
import com.todos.model.Todo;
import com.todos.model.TodoRepository;
import com.todos.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Map;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    public String getAll(String userId, String token) {
        ArrayList<Todo> list = new ArrayList<>();
        for (Todo todo:
             todoRepository.findAll()) {
            if (todo.getUserId().toString().equals(userId)) list.add(todo);
        }
        return new Gson().toJson(list);
    }

    public Todo addItem(@RequestBody Map<String, Object> newTodo, String userId) {
        Todo todo = new Todo(newTodo.get("itemText").toString(), false,userId);
        todoRepository.save(todo);
        return todo;
    }

    public void deleteItem(@RequestBody Map<String, Object> delTodo, String userId) {
        for (Todo todo : todoRepository.findAll()) {
            if (todo.getUserId().toString().equals(userId)) {
                if (todo.getTask().equals(delTodo.get("itemText").toString())) {
                    todoRepository.delete(todo);
                    break;
                }
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

            if (todo.getTask().equals(changeItem.get("itemText").toString()) && todo.isDone() == (boolean) changeItem.get("itemState")) {
                todo.setDone(!todo.isDone());
                todoRepository.save(todo);
                break;
            }

        }
    }

}
