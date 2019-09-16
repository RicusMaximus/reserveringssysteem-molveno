package com.hotel.reservationsystem.controllers;

import com.hotel.reservationsystem.enums.RoomType;
import com.hotel.reservationsystem.models.Room;

import java.util.ArrayList;

public class RoomController {
    private Room model;

    public RoomController(Room model) {
        this.model = model;
    }

    public static ArrayList<Room> getAvailableRooms (ArrayList<Room> rooms) {
        ArrayList<Room> availableRooms = new ArrayList<>();

        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public static void showAvailableRooms(ArrayList<Room> rooms) {
        for (Room room : rooms) {
            System.out.println("Kamer " + room.getRoomNumber() + " is beschikbaar. Deze kamer is een " + room.getRoomType() + ".");
        }
    }

    public static void showAllRooms(ArrayList<Room> rooms) {
        for (Room room : rooms) {
            if(room.isAvailable()){
                System.out.println("Kamer " + room.getRoomNumber() + " is beschikbaar. Deze kamer is een " + room.getRoomType() + ".");
            } else {
                System.out.println("Kamer " + room.getRoomNumber() + " is niet beschikbaar. Deze kamer is een " + room.getRoomType() + ".");
            }
        }
    }

    public void AddRoom(ArrayList<Room> room) {
        int roomNumber = UserInputController.returnIntInput("\nEnter a valid Room Number:");
        int maxAdults = UserInputController.returnIntInput("\nEnter a valid maximum adults value:");
        int maxChildren = UserInputController.returnIntInput("\nEnter a valid maximum children value:");
        String bedAmount = UserInputController.returnStringInput("\nEnter a valid bed type/amount:");
        RoomType roomType = RoomType.SINGLE; //komt nog
        boolean disabledFriendly = UserInputController.returnBoolInput("\nDisabled friendly yes/no?");
        boolean available = UserInputController.returnBoolInput("\nRoom currently available yes/no?");

        room.add(new Room(roomNumber, maxAdults, maxChildren, bedAmount, roomType, disabledFriendly, available));

        System.out.println(room.get(room.size() - 1));
    }
}
