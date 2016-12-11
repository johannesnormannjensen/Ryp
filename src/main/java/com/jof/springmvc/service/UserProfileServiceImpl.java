package com.jof.springmvc.service;

import com.jof.springmvc.dao.UserProfileDao;
import com.jof.springmvc.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    final
    UserProfileDao dao;

    @Autowired
    public UserProfileServiceImpl(UserProfileDao dao) {
        this.dao = dao;
    }

    public UserProfile findById(int id) {
        return dao.findById(id);
    }

    public UserProfile findByType(String type) {
        return dao.findByType(type);
    }

    public List<UserProfile> findAll() {
        return dao.findAll();
    }
}