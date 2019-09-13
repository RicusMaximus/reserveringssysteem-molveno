package com.hotel.reservationsystem;

import com.hotel.reservationsystem.enums.RoomType;
import com.hotel.reservationsystem.models.Room;

import java.util.ArrayList;
import java.util.Scanner;

public class AddRoom {
    public String returnStringInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String returnValue = null;

        try {
            returnValue = scanner.nextLine();
        }
        catch (Exception nfe) {
            System.out.println("Enter a valid number!");
        }
        return returnValue;
    }

    public int returnIntInput(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        int returnValue = 0;

        try {
            returnValue = Integer.parseInt(scanner.nextLine());
        }
        catch (Exception nfe) {
            System.out.println("Enter a valid number!");
        }
        return returnValue;
    }

    public boolean returnBoolInput(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        boolean returnValue = false;

        try {
            returnValue = Boolean.parseBoolean(scanner.nextLine());
        }
        catch (Exception nfe) {
            System.out.println("Enter a valid number!");
        }
        return returnValue;
    }

    public void AddRoom(ArrayList<Room> room) {
        boolean completeRoom = false;

        //Room dingen
        int roomNumber = returnIntInput("\nEnter a valid Room Number:");
        int price = returnIntInput("\nEnter a valid price:");
        int maxAdults = returnIntInput("\nEnter a valid maximum adults value:");
        int maxChildren = returnIntInput("\nEnter a valid maximum children value:");
        String bedAmount = returnStringInput("\nEnter a valid bed type/amount:");
        RoomType roomType = RoomType.SINGLE;//komt nog
        boolean disabledFriendly = returnBoolInput("\nDisabled friendly yes/no?");
        boolean available = returnBoolInput("\nRoom currently available yes/no?");

        room.add(new Room(roomNumber, price, maxAdults, maxChildren, bedAmount, roomType, disabledFriendly, available));


        System.out.println(room.get(room.size() - 1));

//        System.out.println("Added new room with the following details: " + room.getRoomNumber() + room.getRoomType()
//            + room.getBedAmount());
    }
}
