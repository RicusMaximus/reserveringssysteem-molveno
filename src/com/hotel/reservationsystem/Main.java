package com.hotel.reservationsystem;

import com.hotel.reservationsystem.models.Room;
import java.util.ArrayList;
import java.util.Scanner;

//test

public class Main {
    public static void main(String[] args) {
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1, 300, 2, 0, "Double",
                "2 single bed", true, true));
        rooms.add(new Room(2, 200, 2, 1, "Single",
                "single", false, true));
        rooms.add(new Room(3, 600, 2, 0,"2x Double",
                "2 double, 1 single, 1 baby", true, false));
        rooms.add(new Room(4, 900, 2, 5, "Penthouse",
                "2x double, 4x single, 2 baby", false, false));

        while(true) {
            System.out.println("\nType '1' to list all available rooms.");

            Scanner scanner = new Scanner(System.in);
            int userInput = Integer.parseInt(scanner.nextLine());

            switch (userInput) {
                case 1:
                    for (Room room : rooms) {
                        if (room.availability) {
                            System.out.println("Kamer " + room.roomNumber + " is beschikbaar. Deze kamer is een " + room.roomType + ".");
                        }
                    }
                    break;
                default:
                    System.out.println("Enter a valid input option!");
                    break;
            }
        }
    }
}
