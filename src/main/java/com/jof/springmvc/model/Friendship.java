package com.jof.springmvc.model;



import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "friendship")
public class Friendship {
	
	 @Id
	private EmbeddableFriendPK id= new EmbeddableFriendPK();

    @Column(name = "accepted", nullable = false, columnDefinition = "TINYINT(1) DEFAULT '0'")
    private Boolean accepted;

    
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false)
    private Date created_at;
    
    
    @Column(name = "active", columnDefinition = "TINYINT(1) DEFAULT '1'", nullable = false)
    private boolean active;


    public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }


    public User getAlpha_user() {
        return id.getAlpha_user();
    }

    public void setAlpha_user(User alpha_user) {
        this.id.setAlpha_user(alpha_user);
    }

    public User getOmega_user() {
        return id.getOmega_user();
    }

    public void setOmega_user(User omega_user) {
        this.id.setOmega_user(omega_user);
    }
  

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        Friendship other = (Friendship) obj;
       /* if (alpha_user_id == null) {
            if (other.omega_user_id != null)
                return false;
        } else if (!alpha_user_id.equals(other.omega_user_id))
            return false;
        if (omega_user_id == null) {
            if (other.omega_user_id != null)
                return false;
        }*/
        return true;
    }

	/*
     * DO-NOT-INCLUDE passwords in toString function. It is done here just for
	 * convenience purpose.
	 */

    @Override
    public String toString() {
        return "Friend{" + "omega=" + id.getOmega_user() + ", alpha='" + id.getAlpha_user() + ',' + ", created_at='" + created_at + ',' +  '}';
    }
}
