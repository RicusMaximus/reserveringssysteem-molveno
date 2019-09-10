package com.reservationsystem.room;

public class Room
{
    int roomNumber;
    int price;
    int adults;
    int children;
    String bed;
    String roomType;
    boolean disabledRoom;
    boolean availability;

    Room(int roomNumber, int price, int adults, int children, String bed, String roomType, boolean disabledRoom, boolean availability) {
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
