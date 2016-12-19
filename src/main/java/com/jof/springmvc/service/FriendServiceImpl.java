package com.jof.springmvc.service;

import com.jof.springmvc.dao.FriendshipDao;
import com.jof.springmvc.model.Friendship;
import com.jof.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("friendService")
@Transactional
public class FriendServiceImpl implements FriendshipService {

    @Autowired
    private FriendshipDao dao;

    @Override
    public Friendship findFriendshipByIds(User id_alpha, User id_omega) {
        return dao.findFriendshipByIds(id_alpha, id_omega);
    }

    @Override
    public void saveFriend(Friendship friend) {
        dao.save(friend);

    }

    @Override
    public void updateFriend(Friendship friend) {

    	Friendship entity = dao.findFriendshipByIds(friend.getAlpha_user(), friend.getOmega_user());
        if (entity != null) {
            entity.setAccepted(friend.getAccepted());
            entity.setActive(friend.getActive());
            entity.setAlpha_user(friend.getAlpha_user());
            entity.setOmega_user(friend.getOmega_user());            
        }
    }

    @Override
    public void deleteByIds(User alpha_id, User omega_id) {
    	
    	Friendship friend = findFriendshipByIds(alpha_id, omega_id);
    	friend.setActive(false);
    	updateFriend(friend);
    	
    	//we just set them as inactive
//        dao.deleteByIds(alpha_id, omega_id);

    }

    @Override
    public List<Friendship> findAllFriends(User user) {
        return dao.findAllFriends(user);
    }

	@Override
	public List<Friendship> findAllIncomingFriendRequests(User user) {
		return dao.findAllIncomingFriendRequests(user);
	}

	@Override
	public List<Friendship> findAllOutgoingFriendRequests(User user) {
		return dao.findAllOutgoingFriendRequests(user);
	}

}
