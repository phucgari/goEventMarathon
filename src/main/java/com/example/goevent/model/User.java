package com.example.goevent.model;

public abstract class User {
    private int userId;
    private String userName;
    private String password;
    private String fullName;
    private String avatar;
    private String phone;

    public User() {
    }


    public User(int userId, String userName, String password, String fullName, String avatar, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.avatar = avatar;
        this.phone = phone;
    }

    public User(String userName, String password, String fullName, String avatar, String phone) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.avatar = avatar;
        this.phone = phone;
    }

    public User(String password, String fullName, String avatar, String phone) {
        this.password = password;
        this.fullName = fullName;
        this.avatar = avatar;
        this.phone = phone;
    }
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }

    public User(String fullName, String avatar, String phone) {
        this.fullName = fullName;
        this.avatar = avatar;
        this.phone = phone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
