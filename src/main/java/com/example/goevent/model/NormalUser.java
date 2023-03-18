package com.example.goevent.model;

public class NormalUser extends User{
    private int normalUserId;
    private int age;
    private String gender;
    private String address;
    private String email;
    private boolean checkIn;

    public NormalUser() {
    }

    public NormalUser(String fullName, String phone, int normalUserId, int age, String gender, String address, String email) {
        super(fullName, phone);
        this.normalUserId = normalUserId;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
    }

    public NormalUser(int normalUserId, int age, String gender, String address, String email) {
        this.normalUserId = normalUserId;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
    }


    public NormalUser(int userId, String userName, String password, String fullName, String avatar, String phone, int normalUserId, int age, String gender, String address, String email) {
        super(userId, userName, password, fullName, avatar, phone);
        this.normalUserId = normalUserId;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
    }

    public NormalUser(int age, String gender, String address, String email) {
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
    }

    public NormalUser(String userName, String password, String fullName, String avatar, String phone, int age, String gender, String address, String email) {
        super(userName, password, fullName, avatar, phone);
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
    }

    public NormalUser(String password, String fullName, String avatar, String phone, int normalUserId, int age, String gender, String address, String email) {
        super(password, fullName, avatar, phone);
        this.normalUserId = normalUserId;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.email = email;
    }

    public NormalUser(int normalUserId) {
        this.normalUserId = normalUserId;
    }

    public NormalUser(String userName, String password) {
        super(userName, password);
    }

    public int getNormalUserId() {
        return normalUserId;
    }

    public void setNormalUserId(int normalUserId) {
        this.normalUserId = normalUserId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
