package com.todos.web;

import com.todos.service.SessionService;
import com.todos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import static com.todos.utils.Utils.*;

@Controller
public class LoginController {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String getPage(@CookieValue(value = USER_ID_COOKIE, defaultValue = EMPTY_STRING) String userId,
                          @CookieValue(value = LOGIN_TOKEN_COOKIE, defaultValue = EMPTY_STRING) String sessionId) {
        if (sessionId.equals("")) {
            return LOGIN_PAGE;
        } else {
            if(sessionService.isIdFormat(userId, 10)){
                if (!sessionService.validate(userId, sessionId)) {
                    return LOGIN_PAGE;
                } else {
                    return HOME_PAGE;
                }
            } else {
                return LOGIN_PAGE;
            }
        }
    }


}
