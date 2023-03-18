package com.example.goevent.model;

public class BusinessUser extends User{
    private int businessUserId;

    public BusinessUser() {
    }

    public BusinessUser(int businessUserId) {
        this.businessUserId = businessUserId;
    }

    public BusinessUser(int userId, String userName, String password, String fullName, String avatar, String phone, int businessUserId) {
        super(userId, userName, password, fullName, avatar, phone);
        this.businessUserId = businessUserId;
    }

    public BusinessUser(String userName, String password, String fullName, String avatar, String phone, int businessUserId) {
        super(userName, password, fullName, avatar, phone);
        this.businessUserId = businessUserId;
    }

    public BusinessUser(String userName, String password, int businessUserId) {
        super(userName, password);
        this.businessUserId = businessUserId;
    }

    public int getBusinessUserId() {
        return businessUserId;
    }

    public void setBusinessUserId(int businessUserId) {
        this.businessUserId = businessUserId;
    }

}
