package com.jof.springmvc.service;

import com.jof.springmvc.model.Friend;
import com.jof.springmvc.model.User;

import java.util.List;

public interface FriendService {

    Friend findFriendshipByIds(User id_alpha, User id_omega);

    void saveFriend(Friend friend);

    void updateFriend(Friend friend);

    void deleteByIds(User alpha_id, User omega_id);

    // returns omega ids
    List<Friend> findAllFriends(User user);
    
  //returns list of friends
    List<Friend> findAllIncomingFriendRequests(User user);
    
  //returns list of friends
    List<Friend> findAllOutgoingFriendRequests(User user);

}
