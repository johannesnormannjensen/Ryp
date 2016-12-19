package com.jof.springmvc.service;

import com.jof.springmvc.model.Friendship;
import com.jof.springmvc.model.User;

import java.util.List;

public interface FriendshipService {

	Friendship findFriendshipByIds(User id_alpha, User id_omega);

    void saveFriend(Friendship friend);

    void updateFriend(Friendship friend);

    void deleteByIds(User alpha_id, User omega_id);

    // returns omega ids
    List<Friendship> findAllFriends(User user);
    
  //returns list of friends
    List<Friendship> findAllIncomingFriendRequests(User user);
    
  //returns list of friends
    List<Friendship> findAllOutgoingFriendRequests(User user);

}
