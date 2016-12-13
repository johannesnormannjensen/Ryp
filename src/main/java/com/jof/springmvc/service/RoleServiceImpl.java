package com.jof.springmvc.service;

import com.jof.springmvc.dao.RoleDao;
import com.jof.springmvc.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDao dao;

    public Role findById(int id) {
        return dao.findById(id);
    }

    public Role findByType(String type) {
        return dao.findByType(type);
    }

    public List<Role> findAll() {
        return dao.findAll();
    }
}