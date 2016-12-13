package com.jof.springmvc.service;

import com.jof.springmvc.model.Friend;
import com.jof.springmvc.model.User;

import java.util.List;

public interface FriendService {

    Friend findFriendshipByIds(Long id_alpha, Long id_omega);

    void saveFriend(Friend friend);

    void updateFriend(Friend friend);

    void deleteByIds(Long alpha_id, Long omega_id);

    // returns omega ids
    List<Friend> findAllFriends(User user);

}
