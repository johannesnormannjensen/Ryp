package com.jof.springmvc.dao;

import com.jof.springmvc.model.User;

import java.math.BigInteger;
import java.util.List;


public interface UserDao {

    User findById(Long id);

    User findByUsername(String username);

    void save(User user);

    void deleteByUsername(String username);

    List<User> findAllUsers();

}