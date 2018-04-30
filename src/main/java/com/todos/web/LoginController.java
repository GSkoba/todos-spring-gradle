package com.todos.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import static com.todos.utils.Utils.*;

@Controller
public class LoginController {
    /*@Autowired
    private SessionService sessionService;
    @Autowired
    private UserService userService;*/

    @GetMapping(value = "/")
    public String getPage(@CookieValue(value = USER_ID_COOKIE, defaultValue = EMPTY_STRING) String userId,
                          @CookieValue(value = LOGIN_TOKEN_COOKIE, defaultValue = EMPTY_STRING) String sessionId) {
        return LOGIN_PAGE;
    }
}
