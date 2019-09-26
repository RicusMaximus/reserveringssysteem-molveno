package com.hotel.reservationsystem.models;

import com.hotel.reservationsystem.enums.RoomType;

import java.util.ArrayList;

public class Room
{
    private int roomNumber;
    private int price;
    private int maxAdults;
    private int maxChildren;
    private String bedAmount; //TODO amount???
    private RoomType roomType;
    private boolean disabledFriendly;
    private boolean available;

    public Room(int roomNumber, int maxAdults, int maxChildren, String bedAmount, RoomType roomType, boolean disabledFriendly, boolean available) {
        this.roomNumber = roomNumber;
        this.price = setPrice(roomType);
        this.maxAdults = maxAdults;
        this.maxChildren = maxChildren;
        this.bedAmount = bedAmount;
        this.roomType = roomType;
        this.disabledFriendly = disabledFriendly;
        this.available = available; // TODO Availabilty niet in constructor setten, maar defaulten naar false en setten bij reserveringen en datum ranges
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getPrice() {
        return price;
    }

    private int setPrice(RoomType roomType) {
        switch (roomType) {
            case SINGLE:
                price = 100;
                break;
            case DOUBLE:
                price = 200;
                break;
            case DOUBLE_2:
                price = 400;
                break;
            case PENTHOUSE:
                price = 600;
                break;
        }
        return this.price;
    }

    public int getMaxAdults() {
        return maxAdults;
    }

    public void setMaxAdults(int maxAdults) {
        this.maxAdults = maxAdults;
    }

    public int getMaxChildren() {
        return maxChildren;
    }

    public void setMaxChildren(int maxChildren) {
        this.maxChildren = maxChildren;
    }

    public String getBedAmount() {
        return bedAmount;
    }

    public void setBedAmount(String bedAmount) {
        this.bedAmount = bedAmount;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public boolean isDisabledFriendly() {
        return disabledFriendly;
    }

    public void setDisabledFriendly(boolean disabledFriendly) {
        this.disabledFriendly = disabledFriendly;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean availability) {
        this.available = availability;
    }
}
