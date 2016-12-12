package com.jof.springmvc.model;


import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.math.BigInteger;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "comment")
public class Comment {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "created_by", nullable = false, foreignKey = @ForeignKey(name = "FK_CREATED_BY_ID"))
	private User created_by;

	@ManyToOne(optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "review_id", nullable = false, columnDefinition = "INT(11)", foreignKey = @ForeignKey(name = "FK_REVIEW_ID"))
	private Review review_id;

		
	@NotEmpty
	@Column(name = "content", nullable = false, columnDefinition = "VARCHAR(512)")
	private String content;

	@NotEmpty
	@Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = true)
	private Date created_at;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public User getCreated_by() {
		return created_by;
	}

	public void setCreated_by(User created_by) {
		this.created_by = created_by;
	}

	public Review getReview_id() {
		return review_id;
	}

	public void setReview_id(Review review_id) {
		this.review_id = review_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		Comment other = (Comment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (created_by == null) {
			if (other.created_by != null)
				return false;
		} else if (!created_by.equals(other.created_by))
			return false;
		return true;
	}

	/*
	 * DO-NOT-INCLUDE passwords in toString function. It is done here just for
	 * convenience purpose.
	 */

	@Override
	public String toString() {
		return "Review{" + "id=" + id + ", content='" + content + '\'' + ", source_user_id='" + created_by + '\''+
				'}';
	}
}
