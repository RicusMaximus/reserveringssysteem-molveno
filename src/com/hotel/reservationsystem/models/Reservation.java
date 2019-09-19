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
    private boolean babyBed;

    public Reservation(){ }

    public Reservation(int reservationNumber, ArrayList<Room> rooms, Date startDate, Date endDate, Customer customer, BoardType boardType, boolean babyBed) {
        this.reservationNumber = reservationNumber;
        this.rooms = rooms;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.boardType = boardType;
        this.reservationDate = new Date();
        this.babyBed = babyBed;
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

        System.out.println("Enter the check-in date (dd/mm/yyyy): ");
        startDate = getDateInput();

        System.out.println("Enter the check-out date (dd/mm/yyyy): ");
        endDate = getDateInput();

        System.out.println("Enter the first name of the main booker");
        customer.setFirstName(getStringInput());

        System.out.println("Enter the last name of the main booker");
        customer.setLastName(getStringInput());

        System.out.println("Enter the address of the main booker");
        customer.setAddress(getStringInput());

        System.out.println("Enter the city of residence of the main booker");
        customer.setCity(getStringInput());

        System.out.println("Add the phone number of the main booker");//TODO regular expressions
        customer.setPhoneNumber(getStringInput());

        System.out.println("Add the email of the main booker");
        customer.setEmail(getStringInput());

        System.out.println("Add the date of birth of the main booker (dd/mm/yyyy)");
        customer.setBirthday(getDateInput());

        System.out.println("Enter the board type (Bed and Breakfast, Half Board, Accommodations): ");
        boardType = getBoardTypeInput();

        System.out.println("Which rooms do you want to reserve? These are available:\n");
        Room.showAvailableRooms();
        rooms = getRoomsInput();

        return new Reservation(reservationNum, rooms, startDate, endDate, customer, boardType, true);
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
                            "Press 's' to save reservation.");
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
                    System.out.println("Type '1' to check-in and typ '2' to check-out.");
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
                            System.out.println("Please type a '1' for check-in or a '2' for check-out.");
                    }
                }
            }
        }
    }

    public static void showCheckedOut(ArrayList<Reservation> reservations) {
        for (Reservation reservation : reservations) {
            if (!reservation.isChecking()) {
                for (Room room : reservation.rooms) {
                    System.out.println("Room " + room.getRoomNumber() + " is ready to be cleaned.");
                }
            }
        }
    }

    private void showReservationInfo() {
        System.out.println("Reservation number: " + this.reservationNumber);
        System.out.println("Reservation date: " + this.reservationDate);
        System.out.println("Check-in date: " + this.startDate);
        System.out.println("Check-out date: " + this.endDate);
        System.out.println("Total costs reservation: " + this.totalPrice);
        System.out.println("Name main booker: " + this.customer.getFirstName() + " " + this.customer.getLastName());
        System.out.println("Address main booker:" + this.customer.getAddress());
        System.out.println("City of residence:" + this.customer.getCity());
        System.out.println("Phone number:" + this.customer.getPhoneNumber());
        System.out.println("Email of main booker:" + this.customer.getEmail());
        System.out.println("Date of birth of main booker:" + this.customer.getBirthday());
        System.out.println("Board type: " + this.boardType.getBoardType());
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

    public void makeReservationAsCustomer() throws ParseException{
        System.out.println("Please fill in your check-in date: ");
        Date startDate = getDateInput();

        System.out.println("Please fill in your check-out date: ");
        Date endDate = getDateInput();

        System.out.println("How many adults will be staying at Molveno?: ");
        int adultAmount = getIntInput();

        System.out.println("How many children will be staying at Molveno?: ");
        int childrenAmount = getIntInput();

        boolean babyBed = false;
        if (childrenAmount > 0) {
            babyBed = UserInput.returnBoolInput("Do you need a baby bed for your child(ren)?: ");
        } else {
            babyBed = false;
        }

        System.out.println("Please enter the board type (Bed and Breakfast, Half Board, Accommodations): ");
        BoardType boardType = getBoardTypeInput();

        System.out.println("Please choose the room you'd like to reserve. These rooms are available for you: ");
        int amountTotal = adultAmount + childrenAmount;

        ArrayList<Room> listToAdd = new ArrayList<>();

        for (int i = 0; i < amountTotal; i++) {
            Room.showAvailableRooms();
            int roomChoice = getIntInput();
            Room selectedRoom = new Room();

            for(Room room : Room.getAvailableRooms()){
                if(room.getRoomNumber() == roomChoice) {
                    selectedRoom = room;
                }
            }

            System.out.println("How many guests will stay in this room?"); //TODO
            int guestAmount = getIntInput();

            if(guestAmount > selectedRoom.getRawRoomType().maxGuests) {
                System.out.println("This type of room cannot hold this much guests. Please choose another room.");
            } else {
                amountTotal = amountTotal - guestAmount;
                System.out.println(selectedRoom.getRoomNumber());
                listToAdd.add(selectedRoom);
            }
        }

        Customer customer = new Customer();

        System.out.println("First name main booker :");
        customer.setFirstName(getStringInput());

        System.out.println("Last name main booker");
        customer.setLastName(getStringInput());

        System.out.println("Address main booker");
        customer.setAddress(getStringInput());

        System.out.println("City of residence main booker");
        customer.setCity(getStringInput());

        System.out.println("Phone number main booker");
        customer.setPhoneNumber(getStringInput());

        System.out.println("Email main booker");
        customer.setEmail(getStringInput());

        System.out.println("Date of birth main booker (dd/mm/yyyy)");
        customer.setBirthday(getDateInput());

        Reservation reservation = new Reservation(1, listToAdd, startDate, endDate, customer, boardType, babyBed);
        System.out.println(reservation.getRooms());
    }
}






