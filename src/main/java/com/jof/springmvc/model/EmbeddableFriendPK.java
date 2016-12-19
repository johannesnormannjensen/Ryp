package com.jof.springmvc.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class EmbeddableFriendPK implements Serializable {

    @ManyToOne
    private User alpha_user;


    @ManyToOne
    private User omega_user;


    public User getAlpha_user() {
        return alpha_user;
    }


    public void setAlpha_user(User alpha_user_id) {
        this.alpha_user = alpha_user_id;
    }


    public User getOmega_user() {
        return omega_user;
    }


    public void setOmega_user(User omega_user) {
        this.omega_user = omega_user;
    }


}
