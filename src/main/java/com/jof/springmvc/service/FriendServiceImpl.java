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
    public Friend findFriendshipByIds(User id_alpha, User id_omega) {
        return dao.findFriendshipByIds(id_alpha, id_omega);
    }

    @Override
    public void saveFriend(Friend friend) {
        dao.save(friend);

    }

    @Override
    public void updateFriend(Friend friend) {

        Friend entity = dao.findFriendshipByIds(friend.getAlpha_user(), friend.getOmega_user());
        if (entity != null) {
            entity.setAccepted(friend.getAccepted());
            entity.setActive(friend.getActive());
        }
    }

    @Override
    public void deleteByIds(User alpha_id, User omega_id) {
    	
    	Friend friend = findFriendshipByIds(alpha_id, omega_id);
    	friend.setActive(false);
    	updateFriend(friend);
    	
    	//we just set them as inactive
       // dao.deleteByIds(alpha_id, omega_id);

    }

    @Override
    public List<Friend> findAllFriends(User user) {
        return dao.findAllFriends(user);
    }

	@Override
	public List<Friend> findAllIncomingFriendRequests(User user) {
		return dao.findAllIncomingFriendRequests(user);
	}

	@Override
	public List<Friend> findAllOutgoingFriendRequests(User user) {
		return dao.findAllOutgoingFriendRequests(user);
	}

}
