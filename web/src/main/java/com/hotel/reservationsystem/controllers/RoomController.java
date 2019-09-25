package com.hotel.reservationsystem.controllers;

import com.hotel.reservationsystem.enums.RoomType;
import com.hotel.reservationsystem.models.Room;

import java.util.ArrayList;

public class RoomController {
    private static ArrayList<Room> rooms;
    private static RoomController instance = null;

    private RoomController(){
        this.rooms = retrieveRoomData();
    }

    public static RoomController getInstance() {
        if (instance == null) {
            instance = new RoomController();
        }
        return instance;
    }

    //TODO: Get rooms from Database
    public ArrayList<Room> getAllRooms() {
        ArrayList<Room> allRooms = new ArrayList<>();

        for (Room room : this.rooms) {
            allRooms.add(room);
        }
        return allRooms;
    }
    
    //TODO: Get rooms from Database
    public ArrayList<Room> getAllAvailableRooms() {
        ArrayList<Room> availableRooms = new ArrayList<>();

        for (Room room : this.rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    //TODO: Wegschrijven in database
    public static void createRoom(int roomNumber, int maxAdults, int maxChildren, String bedAmount, RoomType roomType, boolean disabledFriendly, boolean available) {
        rooms.add(new Room(roomNumber, maxAdults, maxChildren, bedAmount, roomType, disabledFriendly, available));
    }


    private ArrayList<Room> retrieveRoomData() { // TODO Retrieve from DB
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1,2, 0, "Double",
                RoomType.DOUBLE, true, true));
        rooms.add(new Room(2, 2, 1, "Single",
                RoomType.DOUBLE_2, false, true));
        rooms.add(new Room(3, 2, 0,"2x Double",
                RoomType.PENTHOUSE, true, false));
        rooms.add(new Room(4, 2, 5, "Penthouse",
                RoomType.SINGLE, false, false));
        rooms.add(new Room(5, 2, 4, "200",
                RoomType.SINGLE, false, true));
        return rooms;
    }
}
