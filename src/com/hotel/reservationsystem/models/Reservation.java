package com.hotel.reservationsystem.models;

import com.hotel.reservationsystem.Main;
import com.hotel.reservationsystem.controllers.RoomController;
import com.hotel.reservationsystem.controllers.UserInputController;
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
    private boolean checking;

    public Reservation(){ }

    public Reservation(int reservationNumber, ArrayList<Room> rooms, Date startDate, Date endDate, Customer customer, BoardType boardType) {
        this.reservationNumber = reservationNumber;
        this.rooms = rooms;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.boardType = boardType;
        this.reservationDate = new Date();
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BoardType getBoardType() {
        return boardType;
    }

    public void setBoardType(BoardType boardType) {
        this.boardType = boardType;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public Reservation createReservation (Customer customer) throws ParseException {
        int reservationNum = (int)Math.round(Math.random() * 100);
        startDate = UserInputController.returnDateInput("Enter the check-in date (dd/mm/yyyy): ");
        endDate = UserInputController.returnDateInput("Enter the check-out date (dd/mm/yyyy): ");
        customer.setFirstName(UserInputController.returnStringInput("Enter the first name of the main booker"));
        customer.setLastName(UserInputController.returnStringInput("Enter the last name of the main booker"));
        customer.setAddress(UserInputController.returnStringInput("Enter the address of the main booker"));
        customer.setAddress(UserInputController.returnStringInput("Enter the city of residence of the main booker"));
        customer.setPhoneNumber(UserInputController.returnStringInput("Add the phonenumber of the main booker"));
        customer.setEmail(UserInputController.returnStringInput("Add the email of the main booker"));
        customer.setBirthday(UserInputController.returnDateInput("Add the date of birth of the main booker (dd/mm/yyyy)"));
        boardType = UserInputController.returnBoardTypeInput("Enter the board type (Bed and Breakfast, Half Board, Accommodations): ");
        System.out.println("Which rooms do you want to reserve? These are available:\n");
        RoomController.showAvailableRooms(Main.retrieveRoomData());
        rooms = getRoomsInput();

        return new Reservation(reservationNum, rooms, startDate, endDate, customer, boardType);
    }

    private ArrayList<Room> getRoomsInput() {
        ArrayList<Room> availableRooms = RoomController.getInstance().getAllAvailableRooms(); //TODO fixen naar roomcontroller call
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
                    System.out.println("Room number " + availableRooms.get(i).getRoomNumber() + " is added to your reservation. " +
                            "Press 's' to go back to the main menu.");
                    break;
                }
            }
            if (!roomAdded) {
                System.out.println("Please enter the room number of an available room.");
            }

        }
        return enteredRooms;
    }

//    public static void showReservations (ArrayList<Reservation> reservations) {
//        String message = "";
//        if (!reservations.isEmpty()) {
//            for (Reservation res : reservations) {
//                message = res.reservationNumber + ", "; // TODO Accomodate for last item in list
//            }
//        } else {
//            message = "No reservations found.  ";
//        }
//        System.out.println(message.substring(0, message.length() - 2) + "\n");
//        while (true) {
//            System.out.println("Enter a reservation number to view details. Enter 's' to exit.");
//            Scanner scanner = new Scanner(System.in);
//            String input = scanner.nextLine();
//            //if ( !input.matches("[0-9]+") ) { // TODO
//                if (input.equals("s")) {
//                    break;
//                }
//            //}
//            int reservationNumber = 0;
//            try {
//                reservationNumber = Integer.parseInt(input); // Create parse error throw
//            } catch (NumberFormatException nfe) {
//                System.out.println("Please enter a valid entry.");
//                break;
//            }
//            for (int i = 0; i < reservations.size(); i++) {
//                if (reservationNumber == reservations.get(i).reservationNumber) {
//                    reservations.get(i).showReservationInfo();
//                    break;
//                }
//            }
//        }
//    }

    public static void checking(ArrayList<Reservation> reservations){
        String message = "";
        if (!reservations.isEmpty()) {
            for (Reservation res : reservations) {
                message = res.reservationNumber + ", "; // TODO Accomodate for last item in list
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
                System.out.println("Please enter a valid entry.");
                break;
            }
            for (int i = 0; i < reservations.size(); i++) {
                if (reservationNumber == reservations.get(i).reservationNumber) {
                    System.out.println("Typ '1' to check-in and typ '2' to check-out.");
                    int input2 = scanner.nextInt();

                    switch (input2){
                        case 1:
                            reservations.get(i).setChecking(true);
                            System.out.println("This room is successfully checked-in");
                            break;
                        case 2:
                            reservations.get(i).setChecking(false);
                            System.out.println("This room is successfully checked-out.");
                            break;
                        default:
                            System.out.println("Please typ a '1' for check-in or a '2' for check-out.");
                    }
                }
            }
        }
    }

    public static void showCheckedOut(ArrayList<Reservation> reservations) {
        for (Reservation reservation : reservations) {
            if (!reservation.isChecking()) {
                for (Room room : reservation.rooms) {
                    System.out.println("Kamer " + room.getRoomNumber() + " is klaar om schoongemaakt te worden.");
                }
            }
        }
    }

//    private void showReservationInfo() {
//        System.out.println("Reserveringsnummer: " + this.reservationNumber);
//        System.out.println("Reserveringsdatum: " + this.reservationDate);
//        System.out.println("Datum van ingang: " + this.startDate);
//        System.out.println("Einddatum: " + this.endDate);
//        System.out.println("Totale kosten reservering: " + this.totalPrice);
//        System.out.println("Naam hoofdboeker: " + this.customer.getFirstName() + " " + this.customer.getLastName());
//        System.out.println("Verzorgingstype: " + this.boardType.getBoardType());
//        String kamers = "";
//        for (Room room : rooms) {
//            kamers += room.getRoomNumber() + ", ";
//        }
//        System.out.println("Rooms: " + kamers.substring(0, kamers.length() - 2));
//    }

    public boolean isChecking() {
        return checking;
    }

    public void setChecking(boolean checking) {
        this.checking = checking;
    }
}