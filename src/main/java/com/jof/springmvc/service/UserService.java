package com.jof.springmvc.service;

import com.jof.springmvc.model.User;

import java.util.List;


public interface UserService {

    User findById(int id);

    User findByUserName(String sso);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserByUsername(String sso);

    List<User> findAllUsers();

    boolean isUsernameUnique(Integer id, String sso);

}