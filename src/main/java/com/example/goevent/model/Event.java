package com.example.goevent.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Event {
    private int eventId;
    private LocalDateTime holdTime;
    private String eventName;
    private long fee;
    private String profilePic;
    private ArrayList<String> pictures;
    private ArrayList<String> tag;
    private String description;
    private String address;
    private int b_userID;
    private int numberRegister;
    private int numberParticipant;

    public Event() {
    }

    public Event(LocalDateTime holdTime, String eventName, long fee, String profilePic, ArrayList<String> pictures, ArrayList<String> tag, String description, String address, int b_userID) {
        this.holdTime = holdTime;
        this.eventName = eventName;
        this.fee = fee;
        this.profilePic = profilePic;
        this.pictures = pictures;
        this.tag = tag;
        this.description = description;
        this.address = address;
        this.b_userID = b_userID;
    }

    public Event(int eventId, LocalDateTime holdTime, String eventName, long fee, String profilePic, ArrayList<String> pictures, ArrayList<String> tag, String description, String address, int b_userID, int numberRegister, int numberParticipant) {
        this.eventId = eventId;
        this.holdTime = holdTime;
        this.eventName = eventName;
        this.fee = fee;
        this.profilePic = profilePic;
        this.pictures = pictures;
        this.tag = tag;
        this.description = description;
        this.address = address;
        this.b_userID = b_userID;
        this.numberRegister = numberRegister;
        this.numberParticipant = numberParticipant;
    }

    public Event(int eventId, LocalDateTime holdTime, String eventName, String address) {
        this.eventId = eventId;
        this.holdTime = holdTime;
        this.eventName = eventName;
        this.address = address;
    }

    public Event(int eventId, String eventName, String address, int numberRegister, int numberParticipant) {
        this.eventId=eventId;
        this.eventName=eventName;
        this.address=address;
        this.numberRegister=numberRegister;
        this.numberParticipant=numberParticipant;
    }

    public long getFee() {
        return fee;
    }

    public int getNumberRegister() {
        return numberRegister;
    }

    public void setNumberRegister(int numberRegister) {
        this.numberRegister = numberRegister;
    }

    public int getNumberParticipant() {
        return numberParticipant;
    }

    public void setNumberParticipant(int numberParticipant) {
        this.numberParticipant = numberParticipant;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }

    public ArrayList<String> getPictures() {
        return pictures;
    }

    public void setPictures(ArrayList<String> pictures) {
        this.pictures = pictures;
    }

    public ArrayList<String> getTag() {
        return tag;
    }

    public void setTag(ArrayList<String> tag) {
        this.tag = tag;
    }

    public int getB_userID() {
        return b_userID;
    }

    public void setB_userID(int b_userID) {
        this.b_userID = b_userID;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public LocalDateTime getHoldTime() {
        return holdTime;
    }

    public void setHoldTime(LocalDateTime holdTime) {
        this.holdTime = holdTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
