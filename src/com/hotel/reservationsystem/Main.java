package com.hotel.reservationsystem;
import com.hotel.reservationsystem.controllers.RoomController;
import com.hotel.reservationsystem.enums.RoomType;
import com.hotel.reservationsystem.models.Customer;
import com.hotel.reservationsystem.models.Reservation;
import com.hotel.reservationsystem.models.Room;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Reservation reservation = new Reservation();
        Customer customer = new Customer();
        Room room = new Room();

        ArrayList<Reservation> reservations = new ArrayList<>();


        while(true) {
            System.out.println("\nType '1' to list all available rooms, Type '2' to list all rooms, Type '3' to add a new room, " +
                            "type '4' to make a reservation, Type '5' to show all reservations.");

            Scanner scanner = new Scanner(System.in);
            int userInput = Integer.parseInt(scanner.nextLine());

            switch (userInput) {
                //List all available rooms
                case 1:
                    RoomController.showAvailableRooms();
                    break;
                //List all rooms
                case 2:
                    RoomController.showAllRooms(retrieveRoomData());
                    break;
                //Add a new room
                case 3:
                    RoomController model = new RoomController(room);
                    model.AddRoom(retrieveRoomData());
                    break;
                case 4:
                    //reservations.add(reservation.createReservation(customer));
                    break;
                case 5:
                    //Reservation.showReservations(reservations);
                    break;
                default:
                    System.out.println("Enter a valid input option!");
                    break;
            }
        }
    }

    public static ArrayList<Room> retrieveRoomData() {
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
