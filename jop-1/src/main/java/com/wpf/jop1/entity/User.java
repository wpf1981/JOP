package com.wpf.jop1.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @outhor wpf
 * @date 2018/12/24 - 9:09
 */
@Entity
@Table(name = "USERINFO")
@Data
public class User {
    @Id
    private String id;
    @Column
    private String name;
    @Column
    private String pass;
    @Column
    private String rdate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }
}
