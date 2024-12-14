package org.eylemabz.services;

import org.eylemabz.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final List<User> users = new ArrayList<>();


    public void registerUser(User user){
        users.add(user);
    }

    public User findUser(String userId){
        return users.stream().filter(user -> user.getId().equals(userId)).findFirst().orElse(null);
    }

    public List<User> listUser(){
        return users;
    }
}
