package com.jof.springmvc.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {


    @Id
    @Column(name = "id", nullable = false, columnDefinition = "BIGINT(20)")
    private Long id;


    @OneToMany(mappedBy = "source_user_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<Review>();

    @OneToMany(mappedBy = "created_by", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<Comment>();

    @NotEmpty
    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @NotEmpty
	@Column(name = "region")
	private String region;
    
    @NotEmpty
    @Column(name = "password", nullable = false)
    private String password;

    @NotEmpty
    @Column(name = "email", nullable = false)
    private String email;


    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = true)
    private Date created_at;


    @Column(name = "active", nullable = false, columnDefinition = "TINYINT(1) DEFAULT '1'")
    private boolean active;

    @Column(name = "removed", nullable = false, columnDefinition = "TINYINT(1) DEFAULT '0'")
    private boolean removed;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {
            @JoinColumn(name = "role_id")})
    private Set<Role> roles = new HashSet<Role>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Date getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public boolean isActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isRemoved() {
        return this.removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }


    public List<Review> getStudents() {
        return reviews;
    }

    public void setStudents(List<Review> review) {
        this.reviews = review;
    }


    public List<Review> getReviews() {
        return reviews;
    }

    public void addReviews(Review review) {
        reviews.add(review);
        review.setSource_user_id(this);
    }

    public void removeReviews(Review review) {
        review.setSource_user_id(null);
        this.reviews.remove(review);
    }


    public List<Comment> getComments() {
        return comments;
    }

    public void addComments(Comment comment) {
        comments.add(comment);
        comment.setCreated_by(this);
    }

    public void removeComments(Comment comment) {
        comment.setCreated_by(null);
        this.comments.remove(comment);
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (username == null) {
            if (other.username != null)
                return false;
        } else if (!username.equals(other.username))
            return false;
        return true;
    }

	/*
     * DO-NOT-INCLUDE passwords in toString function. It is done here just for
	 * convenience purpose.
	 */

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + ", email='"
                + email + '\'' + ", roles=" + roles + ", Created at=" + created_at + '}';
    }
}