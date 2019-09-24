package com.hotel.reservationsystem.controllers;

import com.hotel.reservationsystem.enums.BoardType;
import com.hotel.reservationsystem.enums.RoomType;
import com.hotel.reservationsystem.exceptions.NotFoundException;
import com.hotel.reservationsystem.models.*;
import com.hotel.reservationsystem.views.ReservationView;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * The REST API for Reservation CRUD
 */
@RestController
@RequestMapping("api/v1/reservations/")
public class ReservationController {

    private ArrayList<Reservation> reservations;
    private ReservationView view;
    private int reservationNumberCounter = 1;

    private static ReservationController instance = null;

    private ReservationController(){
        reservations = getReservationListFromDatabase();
        view = new ReservationView();
    }

    public static ReservationController getInstance() { // TODO Dependency injection rather than Singleton
        if (instance == null) {
            instance = new ReservationController();
        }
        return instance;
    }

    /**
     * Creates a new reservation object and commits to data source
     * @param rooms The list of Rooms in this reservation
     * @param startDate The start date of the reservation (dd-MM-yyyy)
     * @param endDate The end date of the reservation (dd-MM-yyyy)
     * @param customer The main customer
     * @param boardType The board type
     */
    public void createReservation (ArrayList<Room> rooms, Date startDate, Date endDate,
                                   Customer customer, BoardType boardType) {
        reservationNumberCounter++; // TODO Make reservation number the Database index
        Reservation newReservation = new Reservation(reservationNumberCounter, rooms, startDate, endDate, customer, boardType);
        // save to db
        addReservationToDatabase(newReservation);
        // update view
        //view.updateView("Reservation " + newReservation.getReservationNumber() + " has been created.");
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addNewReservation (@RequestBody Reservation newReservation) {
        reservations.add(newReservation);
        return "Successfully added new reservation";
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Reservation getReservation (@PathVariable int id) throws NotFoundException {
        for (Reservation res : reservations) {
            if (id == res.getReservationNumber()) {
                return res;
            }
        } throw new NotFoundException();
    }

    /**
     * Get all reservations
     * @return The current complete list of reservations
     */
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public ArrayList<Reservation> getReservations () {
        return reservations;
    }

    private void addReservationToDatabase(Reservation newReservation) {
        reservations.add(newReservation);
    }

    /**
     * Retrieve all Reservations from data source (Not implemented yet)
     * @return A list of reservation objects
     */
    public ArrayList<Reservation> getReservationListFromDatabase () {
        // FileParser parser = new CSVFileParser(); // CSV implementation of abstract File Parser
        // return parser.parseFile("./reservations.csv");
        return getMockReservationList();
    }

    /**
     * Retrieve a list of Reservations locally created instead of retrieving from database
     * @return Reservations
     */
    public ArrayList<Reservation> getMockReservationList() {
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
        ArrayList<Reservation> ress = new ArrayList<>();
        Date date = new Date();
        Customer cust = new Customer();
        BoardType brd = BoardType.BED_AND_BREAKFAST;
        ress.add(new Reservation(1, rooms, date, date, cust, brd));
        return ress; // TODO Actually get from file ( ͡° ͜ʖ ͡°)
    }

    /**
     * Loop over reservation list and return a reservation with corresponding reservation number
     * @param reservationNumber The reservation number of the reservation you want to retrieve
     * @return Reservation
     */
    public Reservation getReservationByNumber(int reservationNumber) {
        for (Reservation res : reservations) {
            if (reservationNumber == res.getReservationNumber()) {
                return res;
            }
        }
        return null; // TODO Handle exceptions
    }

    /**
     * Get all checked out reservations
     * @param reservations The list of reservations
     * @return A list of checked out reservations
     */
    @RequestMapping(value = "/checkedout/get", method = RequestMethod.GET)
    public ArrayList<Reservation> getCheckedOut(ArrayList<Reservation> reservations) {
        ArrayList<Reservation> checkedOutReservations = new ArrayList<>();
        for (Reservation res : reservations) {
            if (!res.isCheckedIn()) {
                checkedOutReservations.add(res);
            }
        }
        return checkedOutReservations; // TODO Maak een lijst van de kamers van de reserveringen, de reservering zelf is niet interessant voor Hoofd facilitair
    }
    /*public static void checking(ArrayList<Reservation> reservations){
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
            int reservationNumber = 0;
            try {
                reservationNumber = Integer.parseInt(input); // Create parse error throw
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a valid number.");
                break;
            }
            for (int i = 0; i < reservations.size(); i++) {
                if (reservationNumber == reservations.get(i).reservationNumber) {
                    int input2 = UserInput.returnIntInput("Type '1' to check-in and typ '2' to check-out.");

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
    }*/
}