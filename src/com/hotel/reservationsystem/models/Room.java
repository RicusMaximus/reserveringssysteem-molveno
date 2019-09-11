package com.hotel.reservationsystem.models;

public class Room
{
    public int roomNumber;
    public int price;
    public int maxAdults;
    public int maxChildren;
    public String bedAmount;
    public String roomType; //veranderen naar enum
    public boolean disabledRoom;
    public boolean availability;

    public Room(int roomNumber, int price, int maxAdults, int maxChildren, String bedAmount, String roomType, boolean disabledRoom, boolean availability) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.maxAdults = maxAdults;
        this.maxChildren = maxChildren;
        this.bedAmount = bedAmount;
        this.roomType = roomType;
        this.disabledRoom = disabledRoom;
        this.availability = availability;
    }
}
