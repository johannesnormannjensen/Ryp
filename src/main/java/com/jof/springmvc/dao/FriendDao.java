package com.jof.springmvc.dao;

import java.math.BigInteger;
import java.util.List;

import com.jof.springmvc.model.Friend;
import com.jof.springmvc.model.User;

public interface FriendDao {

	Friend findFriendshipByIds(BigInteger id_alpha,BigInteger id_omega);

	void save(Friend friend);

	void deleteByIds(BigInteger alpha_id,BigInteger omega_id);

	//returns omega ids
	List<Friend> findAllFriends(User user);

}
