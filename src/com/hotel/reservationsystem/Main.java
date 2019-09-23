package com.hotel.reservationsystem;

import com.hotel.reservationsystem.controllers.ReservationController;
import com.hotel.reservationsystem.enums.RoomType;
import com.hotel.reservationsystem.models.ConfirmationMessage;
import com.hotel.reservationsystem.models.Customer;
import com.hotel.reservationsystem.models.Reservation;
import com.hotel.reservationsystem.models.Room;
import com.hotel.reservationsystem.views.ReservationView;
import com.hotel.reservationsystem.views.RoomView;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConfirmationMessage confirmationMessage = new ConfirmationMessage();
        confirmationMessage.printToFile();


        ReservationController reservationController = ReservationController.getInstance();
        ReservationView reservationView = new ReservationView();

        RoomView roomView = new RoomView();

        Reservation reservation = new Reservation();
        Customer customer = new Customer();
        Room room = new Room();

        ArrayList<Reservation> reservations = new ArrayList<>();


        while(true) {
            System.out.println("\nTyp '1' to list all available rooms.\nTyp '2' to list all rooms." +
                    "\nTyp '3' to add a new room.\nTyp '4' to make a reservation.\nTyp '5' to show all reservations." +
                    "\nTyp '6' to get reservations from file. \nTyp '7' to check-in or check-out.\nTyp '8' for a list of checked-out rooms.");

            Scanner scanner = new Scanner(System.in);
            int userInput = Integer.parseInt(scanner.nextLine());

            switch (userInput) {
                //List all available rooms
                case 1:
                    RoomView.showAllAvailableRooms();
                    break;
                //List all rooms
                case 2:
                    RoomView.showAllRooms();
                    break;
                //Add a new room
                case 3:
                    RoomView.addNewRoomByInput();
                    break;
                case 4:
                    reservationView.addNewReservationByInput();
                    break;
                case 5:
                    reservationView.showReservationNumberList();
                    reservationView.showReservationByInput();
                    break;
                case 6:
                    reservationController.getReservationListFromDatabase();
                    break;
                case 7:
                    Reservation.checking(reservations);
                    break;
                case 8:
                    Reservation.showCheckedOut(reservations);
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
