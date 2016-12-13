package com.jof.springmvc.service;

import java.util.List;

import com.jof.springmvc.model.Friend;
import com.jof.springmvc.model.User;

public interface FriendService {
	
	Friend findFriendshipByIds(Long id_alpha, Long id_omega);

	void saveFriend(Friend friend);
	
	void updateFriend(Friend friend);

	void deleteByIds(Long alpha_id, Long omega_id);

	// returns omega ids
	List<Friend> findAllFriends(User user);
	
}
