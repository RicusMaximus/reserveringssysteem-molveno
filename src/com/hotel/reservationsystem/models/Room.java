package com.hotel.reservationsystem.models;

import com.hotel.reservationsystem.enums.RoomType;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Room
{
    private int roomNumber;
    private int price;
    private int maxAdults;
    private int maxChildren;
    private String bedAmount;
    private RoomType roomType;
    private boolean disabledFriendly;
    private boolean available;

    private Room() { }

    public Room(int roomNumber, int price, int maxAdults, int maxChildren, String bedAmount, RoomType roomType, boolean disabledFriendly, boolean availabile) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.maxAdults = maxAdults;
        this.maxChildren = maxChildren;
        this.bedAmount = bedAmount;
        this.roomType = roomType;
        this.disabledFriendly = disabledFriendly;
        this.available = availabile;
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

    public void setPrice(int price) {
        this.price = price;
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

    public String getRoomType() {
        switch(roomType){
            case SINGLE:
                return "Single Room";
            case DOUBLE :
                return "Double Room";
            case DOUBLE_2:
                return "2x Double Room";
            case PENTHOUSE:
                return "Penthouse";
            default:
                throw new IllegalStateException("Unexpected value: " + roomType);
        }
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
