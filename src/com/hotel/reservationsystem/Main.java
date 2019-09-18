package com.hotel.reservationsystem;
import com.hotel.reservationsystem.controllers.ReservationController;
import com.hotel.reservationsystem.enums.RoomType;
import com.hotel.reservationsystem.models.Customer;
import com.hotel.reservationsystem.models.Reservation;
import com.hotel.reservationsystem.models.Room;
import com.hotel.reservationsystem.views.ReservationView;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        ReservationController resController = ReservationController.getInstance();
        ReservationView resView = new ReservationView();
        Reservation res = new Reservation();

        Customer customer = new Customer();
        ArrayList<Reservation> reservations = new ArrayList<>();

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
            System.out.println("\nTyp '1' to list all available rooms.\nTyp '2' to list all rooms." +
                    "\nTyp '3' to add a new room.\nTyp '4' to make a reservation.\nTyp '5' to show all reservations." +
                    "\nTyp '6' to get reservations from file. \nTyp '6' to check-in or check-out.\nTyp 7 for a list of checked-out rooms.");

            Scanner scanner = new Scanner(System.in);

            int userInput = Integer.parseInt(scanner.nextLine());

            switch (userInput) {
                //List all available rooms
                case 1:
                    Room.showAvailableRooms();
                    break;
                //List all rooms
                case 2:
                    for (Room room : rooms) {
                        // TODO: if/else statement voor available unavailable rooms
                        System.out.println("Room " + room.getRoomNumber() + " is available. This room is a " + room.getRoomType() + ".");
                    }
                    break;
                //Add a new room
                case 3:
                    Room room = new Room();
                    room.AddRoom(rooms);
                    break;
                case 4:
                    reservations.add(res.createReservation(customer));
                    break;
                case 5:
                    resView.showReservationNumberList();
                    resView.getReservationByInput();
                    break;
                case 6:
                    resController.getReservationsFromFile();
                    break;
                case 7:
                    Reservation.checking(reservations);
                default:
                    System.out.println("Enter a valid input option!");
                    break;

                case 8: Reservation.showCheckedOut(reservations);
                break;

            }
        }
    }
}
