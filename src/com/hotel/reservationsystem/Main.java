package com.hotel.reservationsystem;
import com.hotel.reservationsystem.enums.RoomType;
import com.hotel.reservationsystem.models.Room;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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

        while(true) {
            System.out.println("\nType '1' to list all available rooms, '2' to list all rooms and '3' to add a new room.");

            Scanner scanner = new Scanner(System.in);

            int userInput = Integer.parseInt(scanner.nextLine());

            switch (userInput) {
                //List all available rooms
                case 1:
                    for (Room room : rooms) {
                        if (room.isAvailable()) {
                            System.out.println("Kamer " + room.getRoomNumber() + " is beschikbaar. Deze kamer is een "
                                    + room.getRoomType() + ". Deze kamer kost " + room.getPrice() + " euro." );
                        }
                    }
                    break;
                //List all rooms
                case 2:
                    for (Room room : rooms) {
                        System.out.println("Kamer " + room.getRoomNumber() + " is beschikbaar. Deze kamer is een " + room.getRoomType() + ".");
                    }
                    break;
                //Add a new room
                case 3:
                    Room room = new Room();
                    room.AddRoom(rooms);
                    break;
                default:
                    System.out.println("Enter a valid input option!");
                    break;
            }
        }
    }
}
