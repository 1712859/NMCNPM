package com.example.groupmanagement.model;

import com.google.gson.annotations.SerializedName;

public class Account {
    @SerializedName("jwt")
    private String jwt;
    @SerializedName("username")
    private  String username;
    @SerializedName("phone")
    private String phone;
    @SerializedName("email")
    private String email;
    @SerializedName("avatar")
    private String avatar;

    public Account(String jwt, String username, String phone, String email, String avatar) {
        this.jwt = jwt;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.avatar = avatar;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
