package com.jof.springmvc.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "friend")
@IdClass(FriendPK.class)
public class Friend {

    @Id
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "alpha_user_id", nullable = false, foreignKey = @ForeignKey(name = "FK_ALPHA_USER_ID"))
    private User alpha_user_id;

    @Id
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "omega_user_id", nullable = false, foreignKey = @ForeignKey(name = "FK_OMEGA_USER_ID"))
    private User omega_user_id;


    @NotEmpty
    @Column(name = "accepted", nullable = false, columnDefinition = "TINYINT(1) DEFAULT '0'")
    private Boolean accepted;


    @NotEmpty
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = true)
    private Date created_at;


    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }


    public User getAlpha_user() {
        return alpha_user_id;
    }

    public void setAlpha_user(User alpha_user_id) {
        this.alpha_user_id = alpha_user_id;
    }

    public User getOmega_user() {
        return omega_user_id;
    }

    public void setOmega_user(User omega_user_id) {
        this.omega_user_id = omega_user_id;
    }


    public Long getAlpha_user_id() {
        return alpha_user_id.getId();
    }


    public Long getOmega_user_id() {
        return omega_user_id.getId();
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
        Friend other = (Friend) obj;
        if (alpha_user_id == null) {
            if (other.omega_user_id != null)
                return false;
        } else if (!alpha_user_id.equals(other.omega_user_id))
            return false;
        if (omega_user_id == null) {
            if (other.omega_user_id != null)
                return false;
        }
        return true;
    }

	/*
     * DO-NOT-INCLUDE passwords in toString function. It is done here just for
	 * convenience purpose.
	 */

    @Override
    public String toString() {
        return "Review{" + "omega=" + omega_user_id + ", alpha='" + alpha_user_id + '\'' + ", at='" + created_at + '\'' +
                '}';
    }
}
