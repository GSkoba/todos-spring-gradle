package com.todos.service;

import com.todos.model.User;
import com.todos.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private int id = 0;

    public boolean createUser(String login, String password){
        if(contains(login,password)) return false;
        String hash = generateHashCode(password);
        User user = new User(id++,login,hash);
        userRepository.save(user);
        return userRepository.existsById(user.getId());
    }

    public Integer getUserId(String login, String password){
        String hash = generateHashCode(password);
        for (User user:
             userRepository.findAll()){
            if (user.getLogin().equals(login) &&
                    user.getHash().equals(hash)) return user.getId();
        }
        return null;
    }

    public boolean contains(String login, String password){
        String hash = generateHashCode(password);
        for (User user:
             userRepository.findAll()) {
            if(user.getLogin().equals(login) && user.getHash().equals(hash)) return true;
        }
        return false;
    }

    public String generateHashCode(String password){
        return Integer.toString(password.hashCode());
    }

}
