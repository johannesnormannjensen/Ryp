package com.jof.springmvc.service;

import com.jof.springmvc.dao.UserDao;
import com.jof.springmvc.model.Friend;
import com.jof.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public User findById(Long id) {
        return dao.findById(id);
    }

    public User findByUserName(String username) {
        User user = dao.findByUsername(username);
        return user;
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends.
     */
    public void updateUser(User user) {
        User entity = dao.findById(user.getId());
        if (entity != null) {
            entity.setUsername(user.getUsername());
            if (!user.getPassword().equals(entity.getPassword())) {
                entity.setPassword(passwordEncoder.encode(user.getPassword()));
            }
            entity.setEmail(user.getEmail());
            entity.setRoles(user.getRoles());
        }
    }


    public void deleteUserByUsername(String username) {
        dao.deleteByUsername(username);
    }

    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    public boolean isUsernameUnique(Long id, String username) {
        User user = findByUserName(username);
        return (user == null || ((id != null) && (user.getId() == id)));
    }


    public List<User> getFriendsAsUsers(List<Friend> friends) {

        List<User> users = new ArrayList<User>();

        for (int i = 0; i < friends.size(); i++) {
            users.add(findById(friends.get(i).getOmega_user_id()));
        }

        return users;
    }

}