package com.jof.springmvc.dao;

import com.jof.springmvc.model.Friendship;
import com.jof.springmvc.model.User;

import java.util.List;

public interface FriendshipDao {

    Friendship findFriendshipByIds(User id_alpha, User id_omega);

    void save(Friendship friend);

    void deleteByIds(User alpha_id, User omega_id);

    //returns list of friends
    List<Friendship> findAllFriends(User user);

    //returns list of friends
    List<Friendship> findAllIncomingFriendRequests(User user);

    //returns list of friends
    List<Friendship> findAllOutgoingFriendRequests(User user);

}
