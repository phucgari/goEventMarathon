package com.example.goevent.model;

public class BusinessUser extends User{
    private int businessUserId;

    private String gender;

    public BusinessUser() {
    }

    public BusinessUser(String userName, String password) {
        super(userName, password);
    }

    public BusinessUser(int businessUserId, String gender) {
        this.businessUserId = businessUserId;
        this.gender = gender;

    }

    public BusinessUser(String gender) {
        this.gender = gender;
    }

    public BusinessUser(int userId, String userName, String password, String fullName, String avatar, String phone, String gender) {
        super(userId, userName, password, fullName, avatar, phone);
        this.gender = gender;
    }

    public BusinessUser( String userName, String password, String fullName, String avatar, String phone, String gender) {
        super(userName, password, fullName, avatar, phone);
        this.gender = gender;
    }

    public BusinessUser( String password, String fullName, String avatar, String phone, String gender) {
        super( password, fullName, avatar, phone);

        this.gender = gender;
    }

    public BusinessUser(int businessUserId) {
        this.businessUserId = businessUserId;
    }

    public int getBusinessUserId() {
        return businessUserId;
    }

    public void setBusinessUserId(int businessUserId) {
        this.businessUserId = businessUserId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
