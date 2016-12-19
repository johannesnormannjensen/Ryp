package com.jof.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Ferenc_S on 12/15/2016.
 */

@Entity
@Table(name = "champion")
public class Champion {

    @Id
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Integer id;

    @NotEmpty
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
