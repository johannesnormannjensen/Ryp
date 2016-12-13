package com.jof.springmvc.model;

import java.io.Serializable;


public class FriendPK implements Serializable {
    protected User alpha_user_id;
    protected User omega_user_id;

    public FriendPK() {
    }

    public FriendPK(User alpha_user_id, User omega_user_id) {
        this.alpha_user_id = alpha_user_id;
        this.omega_user_id = omega_user_id;
    }

}
