package com.jof.springmvc.service;

import com.jof.springmvc.model.Role;

import java.util.List;


public interface RoleService {

    Role findById(int id);

    Role findByType(String type);

    List<Role> findAll();

}