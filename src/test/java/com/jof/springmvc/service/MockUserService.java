package com.jof.springmvc.service;

import com.jof.springmvc.model.Friend;
import com.jof.springmvc.model.Role;
import com.jof.springmvc.model.User;
import com.jof.springmvc.util.region.RegionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Ferenc_S on 12/13/2016.
 */
public class MockUserService implements UserService {
    List<User> users;

    public MockUserService() {
        users = new ArrayList<>();
        User user;

        user = new User();
        user.setUsername("AdminName");
        user.setEmail("admin@f23fff.sem");
        user.setId(Long.valueOf(66));
        user.setPassword("pwd");
        Role profile = new Role();
        profile.setId(66);
        profile.setType("USER");
        profile.setType("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(profile)));

        for (int i = 0; i < 5; i++) {
            user = new User();
            user.setUsername("Name " + i);
            user.setEmail("useremail" + i + "@f23fff.sem");
            user.setId(Long.valueOf(i));
            user.setPassword("pwd");
            profile = new Role();
            profile.setId(i);
            profile.setType("USER");
            user.setRoles(new HashSet<Role>(Arrays.asList(profile)));
            user.setRegion("EUW");
            users.add(new User());
        }
    }

    @Override
    public User findById(Long id) {
        return users.get(id.intValue());
    }

    @Override
    public User findByUserName(final String username) {
        for (User user : users) {
            if (user.getUsername() != null && user.getUsername().equals(username))
                return user;
        }
        return null;
    }

    @Override
    public void saveUser(User user) {
        users.add(user);
    }

    @Override
    public void updateUser(User user) {
        users.set(users.indexOf(user), user);
    }

    @Override
    public void deleteUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername() != null && user.getUsername().equals(username))
                users.remove(user);
        }
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }

   
    @Override
    public boolean isUsernameUnique(Long id, String username) {
        return findByUserName(username) == null;
    }

	@Override
	public List<User> getFriendsAsUsers(List<Friend> friends, User disclude) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUsersButMe(User disclude) {
		List<User> userEx = users;
		userEx.remove(disclude);
		return users;
	}
}
