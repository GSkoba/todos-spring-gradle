package com.todos.web;

import com.todos.model.Session;
import com.todos.model.Todo;
import com.todos.model.TodoRepository;
import com.todos.service.SessionService;
import com.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static com.todos.utils.Utils.EMPTY_STRING;
import static com.todos.utils.Utils.LOGIN_TOKEN_COOKIE;
import static com.todos.utils.Utils.USER_ID_COOKIE;

@RestController
@RequestMapping("/")
public class TodosController {

    @Autowired
    private TodoService todoService;
    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "/newTodo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Todo newTodo(@CookieValue(value = USER_ID_COOKIE, defaultValue = EMPTY_STRING) String userId,
                 @CookieValue(value = LOGIN_TOKEN_COOKIE, defaultValue = EMPTY_STRING) String token,
                 @RequestBody Map<String, Object> newTodo) {
        if (sessionService.validate(userId, token)) {
            return todoService.addItem(newTodo, userId);
        }
        return null;
    }

    @RequestMapping(value = "/delTodo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void delTodo(@CookieValue(value = USER_ID_COOKIE, defaultValue = EMPTY_STRING) String userId,
                        @CookieValue(value = LOGIN_TOKEN_COOKIE, defaultValue = EMPTY_STRING) String token,
                        @RequestBody Map<String, Object> delTodo) {
        if (sessionService.validate(userId, token)) {
            todoService.deleteItem(delTodo, userId);
        }
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    String getAllTodo(@CookieValue(value = USER_ID_COOKIE, defaultValue = EMPTY_STRING) String userId,
                      @CookieValue(value = LOGIN_TOKEN_COOKIE, defaultValue = EMPTY_STRING) String token) {
        if (sessionService.validate(userId, token)) {
            return todoService.getAll(userId);
        }
        return null;
    }


    @RequestMapping(value = "/markAllLikeDone", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void markAllLikeDone(@CookieValue(value = USER_ID_COOKIE, defaultValue = EMPTY_STRING) String userId,
                                @CookieValue(value = LOGIN_TOKEN_COOKIE, defaultValue = EMPTY_STRING) String token) {
        todoService.makeAllDone(userId);
    }

    @RequestMapping(value = "/changeItemState", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void changeItemState(@CookieValue(value = USER_ID_COOKIE, defaultValue = EMPTY_STRING) String userId,
                                @CookieValue(value = LOGIN_TOKEN_COOKIE, defaultValue = EMPTY_STRING) String token,
                                @RequestBody Map<String, Object> changeItem) {
        todoService.changeItemState(changeItem,userId);
    }

}
