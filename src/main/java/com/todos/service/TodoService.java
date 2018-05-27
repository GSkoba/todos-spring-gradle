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

    private int id = 0;

    public String getAll(String userId) {
        ArrayList<String> list = new ArrayList<>();
        for (Todo todo :
                todoRepository.findAll()) {
            if (todo.getUserId().toString().equals(userId)) list.add(todo.getTask());
        }
        String data = new Gson().toJson(list);
        return data;
    }

    public Todo addItem(@RequestBody Map<String, Object> newTodo, String userId) {
        Todo todo = new Todo(id++, newTodo.get("itemText").toString(), false, Integer.parseInt(userId));
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


    public void makeAllDone(String userId) {
        for (Todo todo : todoRepository.findAll()) {
            if (todo.getUserId().toString().equals(userId)) {
                todo.setDone(true);
                todoRepository.save(todo);
            }
        }
    }

    public void changeItemState(@RequestBody Map<String, Object> changeItem, String userId) {
        for (Todo todo : todoRepository.findAll()) {
            if (todo.getUserId().toString().equals(userId)) {
                if (todo.getTask().equals(changeItem.get("itemText").toString()) && todo.isDone() == (boolean) changeItem.get("itemState")) {
                    todo.setDone(!todo.isDone());
                    todoRepository.save(todo);
                    break;
                }
            }
        }
    }

}
