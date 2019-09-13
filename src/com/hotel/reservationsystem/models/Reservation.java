package com.hotel.reservationsystem.models;

import com.hotel.reservationsystem.enums.BoardType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Reservation {
    private int reservationNumber;
    private Date reservationDate;
    private Date startDate;
    private Date endDate;
    private double totalPrice;
    private Customer customer;
    private BoardType boardType;
    private ArrayList<Room> rooms;

    public Reservation (){

    }

    public Reservation(int reservationNumber, ArrayList<Room> rooms, Date startDate, Date endDate, Customer customer, BoardType boardType) {
        this.reservationNumber = reservationNumber;
        this.rooms = rooms;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.boardType = boardType;
        this.reservationDate = new Date();
    }

    public Reservation createReservation (Customer customer) throws ParseException {
        int reservationNum = (int)Math.round(Math.random() * 100);

        System.out.println("Enter the start date (dd/mm/yyyy): ");
        startDate = getDateInput();

        System.out.println("Enter the end date (dd/mm/yyyy): ");
        endDate = getDateInput();

        System.out.println("Enter the board type (Bed and Breakfast, Half Board, Full Board, All-inclusive): ");
        boardType = getBoardTypeInput();

        System.out.println("Which rooms do you want to reserve? These are available:\n");
        Room.showAvailableRooms();
        rooms = getRoomsInput();

        return new Reservation(reservationNum, rooms, startDate, endDate, customer, boardType) ;
    }

    private ArrayList<Room> getRoomsInput() {
        ArrayList<Room> availableRooms = Room.getAvailableRooms();
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
        String input = getStringInput().toLowerCase();
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

    public String getStringInput () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int getIntInput () {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public Date getDateInput () throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new SimpleDateFormat("dd/MM/yyyy").parse(input);
    }

    public static void showReservations (ArrayList<Reservation> reservations) {
        String message = "";
        if (!reservations.isEmpty()) {
            for (Reservation res : reservations) {
                message = res.reservationNumber + ", "; // TODO Accomodate for last item in list
            }
        } else {
            message = "No reservations found.";
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
                if (reservationNumber == reservations.get(i).reservationNumber) {
                    reservations.get(i).showReservationInfo();
                    break;
                }
            }
        }
    }

    private void showReservationInfo() {
        System.out.println("Reserveringsnummer: " + this.reservationNumber);
        System.out.println("Reserveringsdatum: " + this.reservationDate);
        System.out.println("Datum van ingang: " + this.startDate);
        System.out.println("Einddatum: " + this.endDate);
        System.out.println("Totale kosten reservering: " + this.totalPrice);
        System.out.println("Naam hoofdboeker: " + this.customer.firstName + " " + this.customer.lastName);
        System.out.println("Verzorgingstype: " + this.boardType.getBoardType());
        String kamers = "";
        for (Room room : rooms) {
            kamers += room.getRoomNumber() + ", ";
        }
        System.out.println("Kamers: " + kamers.substring(0, kamers.length() - 2));
    }
}