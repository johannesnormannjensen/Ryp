package com.jof.springmvc.service;

import com.jof.springmvc.model.Friend;
import com.jof.springmvc.model.Role;
import com.jof.springmvc.model.User;
import com.jof.springmvc.util.region.RegionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.mockito.Spy;

/**
 * Created by Ferenc_S on 12/13/2016.
 */
public class MockUserService implements UserService {
	public static final Long ID = 1337L;
	
	public static final String ROLE_USER = "USER";
	public static final String ROLE_ADMIN = "ADMIN";
	
	public static final String ADMIN_NAME = "AdminGuy";
	public static final String ADMIN_EMAIL = "admin@player.com";
	public static final String ADMIN_PASSWORD = "password";
	
	public static final String USER_NAME = "LeagueGuy";
	public static final String USER_EMAIL = "fantastic@player.com";
	public static final String USER_PASSWORD = "totallysafe";
	
	public static final String REGION_EUW = "EUW";
	public static final String REGION_EUNE = "EUNE";
	
	List<User> users = new ArrayList<User>();

    public MockUserService() {
        User user;
        Role userRole = new Role();
        userRole.setId(1);
        userRole.setType("USER");
        
        Role adminRole = new Role();
        userRole.setId(2);
        userRole.setType("ADMIN");

        // adding simple users.. pff!
        for (int i = 1; i < 5; i++) {
            user = new User();
            user.setId(ID + Long.valueOf(i));
            user.setUsername(USER_NAME + i);
            user.setEmail(i + USER_EMAIL);
            user.setPassword(USER_PASSWORD);
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
            user.setRegion(REGION_EUW);
            users.add(user);
        }
        
        // adding the admin
        user = new User();
        user.setId(ID);
        user.setUsername(ADMIN_NAME);
        user.setEmail(ADMIN_EMAIL);
        user.setPassword(ADMIN_PASSWORD);
        user.setRoles(new HashSet<Role>(Arrays.asList(adminRole)));
        user.setRegion(REGION_EUW);
        users.add(user);
        
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
    	Iterator<User> iter = users.iterator();
    	while (iter.hasNext()) {
    	    User user = iter.next();
    	    if (user.getUsername() != null && user.getUsername().equals(username)) {
    	    	iter.remove();
    	    }
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
