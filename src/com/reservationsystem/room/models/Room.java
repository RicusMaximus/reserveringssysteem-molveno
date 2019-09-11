package com.reservationsystem.room.models;

public class Room
{
    public int roomNumber;
    public int price;
    public int adults;
    public int children;
    public String bed;
    public String roomType;
    public boolean disabledRoom;
    public boolean availability;

    public Room(int roomNumber, int price, int adults, int children, String bed, String roomType, boolean disabledRoom, boolean availability) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.adults = adults;
        this.children = children;
        this.bed = bed;
        this.roomType = roomType;
        this.disabledRoom = disabledRoom;
        this.availability = availability;
    }
}
