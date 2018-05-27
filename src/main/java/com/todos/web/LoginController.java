package com.todos.web;

import com.todos.model.User;
import com.todos.model.UserRepository;
import com.todos.service.SessionService;
import com.todos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

import static com.todos.utils.Utils.*;

@Controller
public class LoginController {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/")
    public String getPage(@CookieValue(value = USER_ID_COOKIE, defaultValue = EMPTY_STRING) String userId,
                          @CookieValue(value = LOGIN_TOKEN_COOKIE, defaultValue = EMPTY_STRING) String sessionId) {
        return LOGIN_PAGE;
    }

    @PostMapping(value = "/login")
    public String getPage(@RequestBody String body, HttpServletResponse httpServletResponse) {
        HashMap<String, String> data = parseDataFromUrl(body);
        String username = data.get("username");
        String hash = data.get("password");
        for (User item :
                userRepository.findAll()) {
            if (item.getLogin().equals(username) && item.getHash().equals(userService.generateHashCode(hash))) {
                Cookie userIdCookie = new Cookie(USER_ID_COOKIE,
                        Integer.toString(userService.getUserId(username, hash))),

                        loginCookie = new Cookie(LOGIN_TOKEN_COOKIE,
                                sessionService.createSession(userService.getUserId(username, hash)));
                userIdCookie.setHttpOnly(true);
                loginCookie.setHttpOnly(true);
                httpServletResponse.addCookie(userIdCookie);
                httpServletResponse.addCookie(loginCookie);
                return HOME_PAGE;
            }
        }

        return LOGIN_PAGE;
    }


}
