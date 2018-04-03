package com.todos.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class TodosController {
    @RequestMapping(value = "/newTodo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void saveNewTodo(@RequestBody Map<String, Object> newTodo) {
        String out = newTodo.get("itemText").toString();
        System.out.println(out);
    }
}
