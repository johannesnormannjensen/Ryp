package com.jof.springmvc.service;

import com.jof.springmvc.dao.UserDao;
import com.jof.springmvc.model.Friendship;
import com.jof.springmvc.model.Match;
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
        if(user.getId() != null) throw new UnsupportedOperationException();
        dao.save(user);
    }

    /*
     * Since the method is running with Transaction, No need to call hibernate
     * update explicitly. Just fetch the entity from db and update it with
     * proper values within transaction. It will be updated in db once
     * transaction ends.
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

    @Override
    public List<User> getFriendsAsUsers(List<Friendship> friends, User disclude) {
        List<User> users = new ArrayList<User>();

        for (int i = 0; i < friends.size(); i++) {
            User user = findById(friends.get(i).getAlpha_user().getId());

            if (!user.getId().equals(disclude.getId())) {
                users.add(user);
            }

            user = findById(friends.get(i).getOmega_user().getId());
            Long a = user.getId();
            Long b = disclude.getId();


            if (!user.getId().equals(disclude.getId())) {
                users.add(user);
            }
        }

        return users;
    }

    @Override
    public List<User> findAllUsersButMe(User disclude) {
        return dao.findAllUsersButMe(disclude.getId());
    }

	@Override
	public void negateActivationByUsername(String username) {
		dao.negateActivationByUsername(username);
	}

}