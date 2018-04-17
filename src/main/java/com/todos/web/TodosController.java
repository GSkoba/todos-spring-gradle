package com.todos.web;

import com.todos.model.Todo;
import com.todos.model.TodoRepository;
import com.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TodosController {

    @Autowired
    private TodoService todoService;

    @RequestMapping("/test")
    public void test(@RequestBody Map<String, Object> newTodo) {
        String out = newTodo.get("itemText").toString();
        System.out.println(out);
    }


    @RequestMapping("/newTodo")
    public @ResponseBody Todo newTodo(@RequestBody Map<String,Object> newTodo){
        return todoService.addItem(newTodo);
    }

    @RequestMapping(value = "/delTodo",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Todo delTodo(@RequestBody Map<String,Object> delTodo){
        return todoService.deleteItem(delTodo);
    }





}
