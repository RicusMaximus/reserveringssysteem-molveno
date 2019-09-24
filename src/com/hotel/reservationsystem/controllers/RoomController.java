package com.hotel.reservationsystem.controllers;

import com.hotel.reservationsystem.enums.RoomType;
import com.hotel.reservationsystem.models.Room;

import java.util.ArrayList;

public class RoomController {
    private static ArrayList<Room> rooms;
    private static RoomController instance = null;

    private RoomController(){
        this.rooms = Room.retrieveRoomData();
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
}
