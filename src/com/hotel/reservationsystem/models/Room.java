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

    public Room(int roomNumber, int maxAdults, int maxChildren, String bedAmount, RoomType roomType, boolean disabledFriendly, boolean available) {
        this.roomNumber = roomNumber;
        this.price = setPrice(roomType);
        this.maxAdults = maxAdults;
        this.maxChildren = maxChildren;
        this.bedAmount = bedAmount;
        this.roomType = roomType;
        this.disabledFriendly = disabledFriendly;
        this.available = available;
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

    public static ArrayList<Room> getAvailableRooms () {
        // TECHNICAL DEBT - Should retrieve from database
        // List of Room objects
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1, 2, 0, "Double",
                RoomType.DOUBLE, true, true));
        rooms.add(new Room(2, 2, 1, "Single",
                RoomType.DOUBLE_2, false, true));
        rooms.add(new Room(3, 2, 0,"2x Double",
                RoomType.PENTHOUSE, true, false));
        rooms.add(new Room(4, 2, 5, "Penthouse",
                RoomType.SINGLE, false, false));
        rooms.add(new Room(5, 2, 4, "200",
                RoomType.SINGLE, false, true));

        ArrayList<Room> availableRooms = new ArrayList<>();

        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public static void showAvailableRooms() {
        ArrayList<Room> rooms = getAvailableRooms();
        for (Room room : rooms) {
            System.out.println(room.roomNumber + " ");
        }
    }


    public void AddRoom(ArrayList<Room> room) {
        //boolean completeRoom = false;

        //Room dingen
        int roomNumber = UserInput.returnIntInput("\nEnter a valid Room Number:");
        int maxAdults = UserInput.returnIntInput("\nEnter a valid maximum adults value:");
        int maxChildren = UserInput.returnIntInput("\nEnter a valid maximum children value:");
        String bedAmount = UserInput.returnStringInput("\nEnter a valid bed type/amount:");
        RoomType roomType = RoomType.SINGLE; //komt nog
        boolean disabledFriendly = UserInput.returnBoolInput("\nDisabled friendly yes/no?");
        boolean available = UserInput.returnBoolInput("\nRoom currently available yes/no?");

        room.add(new Room(roomNumber, maxAdults, maxChildren, bedAmount, roomType, disabledFriendly, available));

        System.out.println(room.get(room.size() - 1));
    }
}
