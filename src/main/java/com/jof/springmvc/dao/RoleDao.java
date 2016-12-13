package com.jof.springmvc.dao;

import com.jof.springmvc.model.Role;

import java.util.List;


public interface RoleDao {

    List<Role> findAll();

    Role findByType(String type);

    Role findById(int id);
}