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

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void test(@RequestBody Map<String, Object> newTodo) {
        String out = newTodo.get("itemText").toString();
        System.out.println(out);
    }


    @RequestMapping(value = "/newTodo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Todo newTodo(@RequestBody Map<String,Object> newTodo){
        return todoService.addItem(newTodo);
    }

    @RequestMapping(value = "/delTodo",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void delTodo(@RequestBody Map<String,Object> delTodo){
        System.out.println("Event: delTodo");
        todoService.deleteItem(delTodo);
    }

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String getAllTodo(){
        System.out.println("Event: getAll");
        return todoService.getAll();
    }


    @RequestMapping(value = "/markAllLikeDone", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void markAllLikeDone(){
        System.out.println("Event: mark All like Done");
        todoService.makeAllDone();
    }

    @RequestMapping(value = "/changeItemState", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void changeItemState(@RequestBody Map<String, Object> changeItem){
        System.out.println("Event: change State");
        todoService.changeItemState(changeItem);
    }

}
