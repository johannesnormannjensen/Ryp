package com.jof.springmvc.service;

import com.jof.springmvc.model.Role;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ferenc_S on 12/13/2016.
 */
public class MockRoleService implements RoleService {

	List<Role> roles;
	
	public MockRoleService() {
		roles = new ArrayList<Role>();
		Role role = new Role();
		role.setId(1);
		role.setType("ADMIN");
		roles.add(role);
	}
	
	@Override
	public Role findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role findByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> findAll() {
		return roles;
	}
   
}
