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
    private boolean checking;

public Reservation(){


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

        System.out.println("Enter the check-in date (dd/mm/yyyy): ");
        startDate = getDateInput();

        System.out.println("Enter the check-out date (dd/mm/yyyy): ");
        endDate = getDateInput();

        System.out.println("Enter the first name of the main booker");
        customer.firstName = getStringInput();

        System.out.println("Enter the last name of the main booker");
        customer.lastName = getStringInput();

        System.out.println("Enter the address of the main booker");
        customer.address = getStringInput();

        System.out.println("Enter the city of residence of the main booker");
        customer.city = getStringInput();

        System.out.println("Add the phonenumber of the main booker");//TODO regular expressions
        customer.phoneNumber = getStringInput();

        System.out.println("Add the email of the main booker");
        customer.email = getStringInput();

        System.out.println("Add the date of birth of the main booker (dd/mm/yyyy)");
        customer.birthday = getDateInput();

        System.out.println("Enter the board type (Bed and Breakfast, Half Board, Accommodations): ");
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
            case "accommodations":
                type = BoardType.ACCOMMODATIONS;
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
                    reservations.get(i).showReservationInfo();
                    break;
                }
            }
        }
    }
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



    private void showReservationInfo() {
        System.out.println("Reservationnumber: " + this.reservationNumber);
        System.out.println("Reservationdate: " + this.reservationDate);
        System.out.println("Check-in date: " + this.startDate);
        System.out.println("Check-out date: " + this.endDate);
        System.out.println("Total price booking: " + this.totalPrice);
        System.out.println("Name main booker: " + this.customer.firstName + " " + this.customer.lastName);
        System.out.println("Board type: " + this.boardType.getBoardType());
        System.out.println("Checked-in: " + this.checking);
        String kamers = "";
        for (Room room : rooms) {
            kamers += room.getRoomNumber() + ", ";
        }
        System.out.println("Rooms: " + kamers.substring(0, kamers.length() - 2));
    }

    public boolean isChecking() {
        return checking;
    }

    public void setChecking(boolean checking) {
        this.checking = checking;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }


}