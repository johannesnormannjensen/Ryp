package com.jof.springmvc.dao;

import com.jof.springmvc.model.Friend;
import com.jof.springmvc.model.User;

import java.util.List;

public interface FriendDao {

    Friend findFriendshipByIds(User id_alpha, User id_omega);

    void save(Friend friend);

    void deleteByIds(User alpha_id, User omega_id);

    //returns list of friends
    List<Friend> findAllFriends(User user);
    
  //returns list of friends
    List<Friend> findAllIncomingFriendRequests(User user);
    
  //returns list of friends
    List<Friend> findAllOutGoingFriendRequests(User user);

}
