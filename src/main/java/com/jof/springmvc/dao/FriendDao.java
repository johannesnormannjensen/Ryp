package com.jof.springmvc.dao;

import com.jof.springmvc.model.Friend;
import com.jof.springmvc.model.User;

import java.util.List;

public interface FriendDao {

	Friend findFriendshipByIds(Long id_alpha, Long id_omega);

	void save(Friend friend);

	void deleteByIds(Long alpha_id, Long omega_id);

	//returns omega ids
	List<Friend> findAllFriends(User user);

}
