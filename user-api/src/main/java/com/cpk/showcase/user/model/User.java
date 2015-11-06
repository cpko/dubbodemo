package com.cpk.showcase.user.model;

import java.io.Serializable;

/**
 * Author:cp
 * Created on 11/3/15.
 */
public class User implements Serializable {

    private static final long serialVersionUID = -3440091985337561049L;

    private Long id;

    private String name;

    private String mobile;

    private String password;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
