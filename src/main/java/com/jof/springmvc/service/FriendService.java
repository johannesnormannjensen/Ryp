package com.jof.springmvc.service;

import java.math.BigInteger;
import java.util.List;

import com.jof.springmvc.model.Friend;
import com.jof.springmvc.model.User;

public interface FriendService {
	
	Friend findFriendshipByIds(BigInteger id_alpha, BigInteger id_omega);

	void saveFriend(Friend friend);
	
	void updateFriend(Friend friend);

	void deleteByIds(BigInteger alpha_id, BigInteger omega_id);

	// returns omega ids
	List<Friend> findAllFriends(User user);
	
}
