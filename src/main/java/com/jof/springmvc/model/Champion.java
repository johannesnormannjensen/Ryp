package com.jof.springmvc.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Ferenc_S on 12/15/2016.
 */

@Entity
@Table(name = "champion")
public class Champion {

    @Id
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long id;

    @NotEmpty
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    Extra data (img location etc.)
     */
}
