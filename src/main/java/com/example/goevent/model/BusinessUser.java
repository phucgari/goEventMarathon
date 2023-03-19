package com.example.goevent.model;

public class BusinessUser extends User{
    private int businessUserId;

    private int user_id;

    public BusinessUser() {
    }

    public BusinessUser(String userName, String password) {
        super(userName, password);
    }




    public BusinessUser(int userId, String userName, String password, String fullName, String avatar, String phone) {
        super(userId, userName, password, fullName, avatar, phone);
    }



    public BusinessUser( String password, String fullName, String avatar, String phone) {
        super( password, fullName, avatar, phone);
    }

    public BusinessUser(int businessUserId) {
        this.businessUserId = businessUserId;
    }

    public BusinessUser(int bUserId, int userId, String name, String avatar, String phone) {
        super(name, avatar, phone);
        this.businessUserId = bUserId;
        this.user_id = userId;
    }

    public BusinessUser(String username, String password, String name, String avatar, String phone) {
        super(username,password,name, avatar, phone);
    }


    public int getBusinessUserId() {
        return businessUserId;
    }

    public void setBusinessUserId(int businessUserId) {
        this.businessUserId = businessUserId;
    }


}
