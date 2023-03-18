package com.example.goevent.model;

import java.time.LocalDateTime;

public class Event extends BusinessUser{
    private int eventId;
    private LocalDateTime holdTime;
    private String eventName;
    private long free;
    private String profilePic;
    private String description;
    private String address;

    public Event() {
    }

    public Event(int eventId, LocalDateTime holdTime, String eventName, long free, String profilePic, String description, String address) {
        this.eventId = eventId;
        this.holdTime = holdTime;
        this.eventName = eventName;
        this.free = free;
        this.profilePic = profilePic;
        this.description = description;
        this.address = address;
    }
    public Event(LocalDateTime holdTime, String eventName, long free, String profilePic, String description, String address) {
        this.holdTime = holdTime;
        this.eventName = eventName;
        this.free = free;
        this.profilePic = profilePic;
        this.description = description;
        this.address = address;
    }

    public Event(int businessUserId, int eventId, LocalDateTime holdTime, String eventName, long free, String profilePic, String description, String address) {
        super(businessUserId);
        this.eventId = eventId;
        this.holdTime = holdTime;
        this.eventName = eventName;
        this.free = free;
        this.profilePic = profilePic;
        this.description = description;
        this.address = address;
    }

    public Event(int userId, String userName, String password, String fullName, String avatar, String phone, int businessUserId, int eventId, LocalDateTime holdTime, String eventName, long free, String profilePic, String description, String address) {
        super(userId, userName, password, fullName, avatar, phone, businessUserId);
        this.eventId = eventId;
        this.holdTime = holdTime;
        this.eventName = eventName;
        this.free = free;
        this.profilePic = profilePic;
        this.description = description;
        this.address = address;
    }

    public Event(String userName, String password, String fullName, String avatar, String phone, int businessUserId, int eventId, LocalDateTime holdTime, String eventName, long free, String profilePic, String description, String address) {
        super(userName, password, fullName, avatar, phone, businessUserId);
        this.eventId = eventId;
        this.holdTime = holdTime;
        this.eventName = eventName;
        this.free = free;
        this.profilePic = profilePic;
        this.description = description;
        this.address = address;
    }

    public Event(String userName, String password, int businessUserId, int eventId, LocalDateTime holdTime, String eventName, long free, String profilePic, String description, String address) {
        super(userName, password, businessUserId);
        this.eventId = eventId;
        this.holdTime = holdTime;
        this.eventName = eventName;
        this.free = free;
        this.profilePic = profilePic;
        this.description = description;
        this.address = address;
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

    public long getFree() {
        return free;
    }

    public void setFree(long free) {
        this.free = free;
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
