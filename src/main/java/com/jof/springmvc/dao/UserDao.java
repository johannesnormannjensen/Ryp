package com.jof.springmvc.dao;

import com.jof.springmvc.model.User;

import java.util.List;


public interface UserDao {

    User findById(int id);

    User findByUsername(String sso);

    void save(User user);

    void deleteByUsername(String sso);

    List<User> findAllUsers();

}