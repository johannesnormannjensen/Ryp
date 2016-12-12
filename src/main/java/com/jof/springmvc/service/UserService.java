package com.jof.springmvc.service;

import com.jof.springmvc.model.User;

import java.util.List;


public interface UserService {

    User findById(int id);

    User findByUserName(String username);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserByUsername(String username);

    List<User> findAllUsers();

    boolean isUsernameUnique(Integer id, String username);

}