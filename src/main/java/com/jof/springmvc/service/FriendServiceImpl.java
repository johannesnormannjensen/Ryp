package com.jof.springmvc.service;

import com.jof.springmvc.dao.FriendDao;
import com.jof.springmvc.model.Friend;
import com.jof.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("friendService")
@Transactional
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendDao dao;

    @Override
    public Friend findFriendshipByIds(Long id_alpha, Long id_omega) {
        return dao.findFriendshipByIds(id_alpha, id_omega);
    }

    @Override
    public void saveFriend(Friend friend) {
        dao.save(friend);

    }

    @Override
    public void updateFriend(Friend friend) {

        Friend entity = dao.findFriendshipByIds(friend.getAlpha_user_id(), friend.getOmega_user_id());
        if (entity != null) {
            entity.setAccepted(friend.getAccepted());
        }
    }

    @Override
    public void deleteByIds(Long alpha_id, Long omega_id) {
        dao.deleteByIds(alpha_id, omega_id);

    }

    @Override
    public List<Friend> findAllFriends(User user) {
        return dao.findAllFriends(user);
    }

}
