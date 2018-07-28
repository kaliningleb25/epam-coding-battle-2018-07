package com.epam.server.model;

import javax.persistence.Entity;

@Entity
public class User {

    private String firstName;
    private String lastName;
    private String loginName;
    private String password;
    private String steamKey;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSteamKey() {
        return steamKey;
    }

    public void setSteamKey(String steamKey) {
        this.steamKey = steamKey;
    }
}
