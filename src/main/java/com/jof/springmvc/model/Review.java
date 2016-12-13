package com.jof.springmvc.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "review")
public class Review implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @OneToMany(mappedBy = "review_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<Comment>();


    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "source_user_id", nullable = false, foreignKey = @ForeignKey(name = "FK_SOURCE_USER_ID"))
    private User source_user_id;


    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "target_user_id", nullable = false, foreignKey = @ForeignKey(name = "FK_TARGET_USER_ID"))
    private User target_user_id;


    @NotEmpty
    @Column(name = "game_id", nullable = false, columnDefinition = "BIGINT(20)")
    private Long game_id;

    @NotEmpty
    @Column(name = "title", nullable = false, columnDefinition = "VARCHAR(45)")
    private String title;

    @NotEmpty
    @Column(name = "body", nullable = false, columnDefinition = "VARCHAR(512)")
    private String body;

    @NotEmpty
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = true)
    private Date created_at;

    @NotEmpty
    @Column(name = "positive", nullable = false, columnDefinition = "TINYINT(4) DEFAULT '0'")
    private boolean positive;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getSource_user_id() {
        return source_user_id;
    }

    public void setSource_user_id(User source_user_id) {
        this.source_user_id = source_user_id;
    }

    public User getTarget_user_id() {
        return target_user_id;
    }

    public void setTarget_user_id(User target_user_id) {
        this.target_user_id = target_user_id;
    }

    public Long getGame_id() {
        return game_id;
    }

    public void setGame_id(Long game_id) {
        this.game_id = game_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public boolean isPositive() {
        return positive;
    }

    public void setPositive(boolean positive) {
        this.positive = positive;
    }


    public List<Comment> getComments() {
        return comments;
    }

    public void addComments(Comment comment) {
        comments.add(comment);
        comment.setReview_id(this);
    }

    public void removeComments(Comment comment) {
        comment.setCreated_by(null);
        this.comments.remove(comment);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        Review other = (Review) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (source_user_id == null) {
            if (other.source_user_id != null)
                return false;
        } else if (!source_user_id.equals(other.source_user_id))
            return false;
        return true;
    }

	/*
     * DO-NOT-INCLUDE passwords in toString function. It is done here just for
	 * convenience purpose.
	 */

    @Override
    public String toString() {
        return "Review{" + "id=" + id + ", title='" + title + '\'' + ", source_user_id='" + source_user_id + '\'' + ", target_user_id='"
                + target_user_id + ", body='" + body + "'}";
    }
}