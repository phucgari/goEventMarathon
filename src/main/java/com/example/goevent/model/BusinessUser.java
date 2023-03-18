package com.example.goevent.model;

public class BusinessUser extends User{
    private int businessUserId;

    public BusinessUser() {
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

}
