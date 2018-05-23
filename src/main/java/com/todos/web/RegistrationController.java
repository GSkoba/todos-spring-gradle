package com.todos.web;

import com.fasterxml.jackson.databind.util.TypeKey;
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
    public String registrUser(@RequestBody String body){
        HashMap<String, String> data = parseDataFromUrl(body);
        for (String name: data.keySet()){
            String key =name;
            String value = data.get(name);
            System.out.println(key + " " + value);

        }
        if (userService.createUser(data.get("password"),data.get("username"))) {
            return LOGIN_PAGE;
        }else{
            System.out.println("wrong");
            return LOGIN_PAGE;
        }
    }

}
