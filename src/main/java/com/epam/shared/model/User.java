package com.epam.shared.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String loginName;

    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    private Integer trialRequests = 30;

    private String steamKey;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", loginName='" + loginName + '\'' +
            ", password='" + password + '\'' +
            ", steamKey='" + steamKey + '\'' +
            '}';
    }

    public Integer getTrialRequests() {
        return trialRequests;
    }

    public void setTrialRequests(Integer trialRequests) {
        this.trialRequests = trialRequests;
    }
}
