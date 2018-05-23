package com.todos.web;

import com.todos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import static com.todos.utils.Utils.HOME_PAGE;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registrUser(@RequestBody String body){
        System.out.println(body);
      //  userService.createUser("gskoba","1111");
        return HOME_PAGE;
    }

}
