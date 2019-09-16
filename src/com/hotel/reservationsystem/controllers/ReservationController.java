package com.hotel.reservationsystem.controllers;

import com.hotel.reservationsystem.enums.BoardType;
import com.hotel.reservationsystem.models.Customer;
import com.hotel.reservationsystem.models.Reservation;
import com.hotel.reservationsystem.models.Room;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class ReservationController {
    private Reservation model;

    public ReservationController(Reservation model) {
        this.model = model;
    }

    public Reservation createReservation (Customer customer) throws ParseException {
        int reservationNum = (int)Math.round(Math.random() * 100);

        Date startDate = UserInputController.returnDateInput("Enter the start date (dd/mm/yyyy): "))
        Date endDate = UserInputController.returnDateInput("Enter the end date (dd/mm/yyyy): ")

        System.out.println("Enter the board type (Bed and Breakfast, Half Board, Full Board, All-inclusive): ");
        BoardType boardType = getBoardTypeInput();

        System.out.println("Which rooms do you want to reserve? These are available:\n");
        RoomController.showAvailableRooms();
        ArrayList<Room> rooms = getRoomsInput();

        return new Reservation(reservationNum, rooms, startDate, endDate, customer, boardType) ;
    }

    private ArrayList<Room> getRoomsInput() {
        ArrayList<Room> availableRooms = RoomController.getAvailableRooms();
        ArrayList<Room> enteredRooms = new ArrayList<>();
        String input = null;
        while (true) {
            boolean roomAdded = false;
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            if ( !input.matches("[0-9]+") ) { // TODO
                if (input.equals("s")) {
                    break;
                }
            }
            int roomNumber = 0;
            try {
                roomNumber = Integer.parseInt(input); // Create parse error throw
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a valid input.");
                break;
            }
            for (int i = 0; i < availableRooms.size(); i++) {
                if (roomNumber == availableRooms.get(i).getRoomNumber()) {
                    enteredRooms.add(availableRooms.get(i));
                    roomAdded = true;
                    System.out.println("Added room #" + availableRooms.get(i).getRoomNumber());
                    break;
                }
            }
            if (!roomAdded) {
                System.out.println("Please enter the room number of an available room.");
            }

        }
        return enteredRooms;
    }

    private BoardType getBoardTypeInput() {
        String input = UserInputController.returnStringInput("Enter a valid Board Type").toLowerCase();
        BoardType type = null;

        switch (input) {
            case "bed and breakfast":
                type = BoardType.BED_AND_BREAKFAST;
                break;
            case "half board":
                type = BoardType.HALF_BOARD;
                break;
            case "full board":
                type = BoardType.FULL_BOARD;
                break;
            case "all inclusive":
                type = BoardType.ALL_INCLUSIVE;
                break;
            default:
                System.out.println("Please enter a valid board type.");
                getBoardTypeInput();
                break;
        }
        return type;
    }

    public static void showReservations (ArrayList<Reservation> reservations) {
        String message = "";
        if (!reservations.isEmpty()) {
            for (Reservation res : reservations) {
                message = res.getReservationNumber() + ", "; // TODO Accomodate for last item in list
            }
        } else {
            message = "No reservations found.  ";
        }
        System.out.println(message.substring(0, message.length() - 2) + "\n");
        while (true) {
            System.out.println("Enter a reservation number to view details. Enter 's' to exit.");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            //if ( !input.matches("[0-9]+") ) { // TODO
            if (input.equals("s")) {
                break;
            }
            //}
            int reservationNumber = 0;
            try {
                reservationNumber = Integer.parseInt(input); // Create parse error throw
            } catch (NumberFormatException nfe) {
                System.out.println("Geef een geldige invoer aub.");
                break;
            }
            for (int i = 0; i < reservations.size(); i++) {
                if (reservationNumber == reservations.get(i).getReservationNumber()) {
                    reservations.get(i).showReservationInfo();
                    break;
                }
            }
        }
    }

    private void showReservationInfo() {
        System.out.println("Reserveringsnummer: " + model.getReservationNumber());
        System.out.println("Reserveringsdatum: " + model.getReservationDate());
        System.out.println("Datum van ingang: " + model.getStartDate());
        System.out.println("Einddatum: " + model.getEndDate());
        System.out.println("Totale kosten reservering: " + model.getTotalPrice());
        System.out.println("Naam hoofdboeker: " + model.getCustomer().firstName + " " + model.getCustomer().lastName);
        System.out.println("Verzorgingstype: " + model.getBoardType());
        String kamers = "";
        for (Room room : rooms) {
            kamers += room.getRoomNumber() + ", ";
        }
        System.out.println("Kamers: " + kamers.substring(0, kamers.length() - 2));
    }
}
