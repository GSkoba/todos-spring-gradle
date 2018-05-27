package com.todos.web;

import com.fasterxml.jackson.databind.util.TypeKey;
import com.todos.model.User;
import com.todos.model.UserRepository;
import com.todos.service.UserService;
import com.todos.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import static com.todos.utils.Utils.HOME_PAGE;
import static com.todos.utils.Utils.LOGIN_PAGE;
import static com.todos.utils.Utils.parseDataFromUrl;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registrUser(@RequestBody String body) {
        try {
            HashMap<String, String> data = parseDataFromUrl(body);
            userService.createUser(data.get("username"), data.get("password"));
            return LOGIN_PAGE;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(ex);
        }
        return LOGIN_PAGE;
    }

}
