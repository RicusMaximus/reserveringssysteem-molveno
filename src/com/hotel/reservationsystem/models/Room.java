package com.hotel.reservationsystem.models;
import com.hotel.reservationsystem.enums.RoomType;
import java.util.ArrayList;

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

    public Room() { }

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

    public void AddRoom(ArrayList<Room> room) {
        boolean completeRoom = false;

        //Room dingen
        int roomNumber = UserInput.returnIntInput("\nEnter a valid Room Number:");
        int price = UserInput.returnIntInput("\nEnter a valid price:");
        int maxAdults = UserInput.returnIntInput("\nEnter a valid maximum adults value:");
        int maxChildren = UserInput.returnIntInput("\nEnter a valid maximum children value:");
        String bedAmount = UserInput.returnStringInput("\nEnter a valid bed type/amount:");
        RoomType roomType = RoomType.SINGLE; //komt nog
        boolean disabledFriendly = UserInput.returnBoolInput("\nDisabled friendly yes/no?");
        boolean available = UserInput.returnBoolInput("\nRoom currently available yes/no?");

        room.add(new Room(roomNumber, price, maxAdults, maxChildren, bedAmount, roomType, disabledFriendly, available));

        System.out.println(room.get(room.size() - 1));

//        System.out.println("Added new room with the following details: " + room.getRoomNumber() + room.getRoomType()
//            + room.getBedAmount());
    }
}
