package com.todos.service;

import com.todos.model.Todo;
import com.todos.model.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;




    public Todo addItem(@RequestBody Map<String, Object> newTodo){
        System.out.println("Event: addItem");
        Todo todo = new Todo(newTodo.get("itemText").toString(), false);
        todoRepository.save(todo);
        return todo;
    }

    public Todo deleteItem(@RequestBody Map<String, Object> delTodo){
        Todo temp = new Todo(delTodo.get("itemText").toString(),false);
        Optional<Todo> optionalTodo = todoRepository.findById(temp.getId());
        if (optionalTodo.isPresent()){
            Todo item = optionalTodo.get();
            todoRepository.delete(item);
            if (!todoRepository.existsById(temp.getId())){
                return item;
            }
        }
        return null;
    }



}
