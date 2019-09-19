package com.hotel.reservationsystem.controllers;

import com.hotel.reservationsystem.enums.BoardType;
import com.hotel.reservationsystem.enums.RoomType;
import com.hotel.reservationsystem.models.*;
import com.hotel.reservationsystem.views.ReservationView;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 */
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
        view.updateView("Reservation " + newReservation.getReservationNumber() + " has been created.");

    }

    private void addReservationToDatabase(Reservation newReservation) {
        reservations.add(newReservation);
    }

    /**
     * Get all reservations
     * @return The current complete list of reservations
     */
    public ArrayList<Reservation> getReservations() {
        return reservations;
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
    private ArrayList<Reservation> getMockReservationList() {
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

}
