package com.jof.springmvc.service;

import com.jof.springmvc.model.Friend;
import com.jof.springmvc.model.User;

import java.util.List;


public interface UserService {

    User findById(Long id);

    User findByUserName(String username);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserByUsername(String username);

    List<User> findAllUsers();
    
    List<User> getFriendsAsUsers(List<Friend> friends);

    boolean isUsernameUnique(Long id, String username);

}