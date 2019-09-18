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
    private ArrayList<ReservationView> views;
    int reservationNumberCounter = 1;

    private static ReservationController instance = null;

    private ReservationController(){
        reservations = getReservationsFromFile();
    }

    public static ReservationController getInstance() {
        if (instance == null) {
            instance = new ReservationController();
        }
        return instance;
    }

    public void createReservation (ArrayList<Room> rooms, Date startDate, Date endDate,
                                   Customer customer, BoardType boardType) {
        reservationNumberCounter++;
        new Reservation(reservationNumberCounter, rooms, startDate, endDate, customer, boardType);
        // save to db
        // update view
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public ArrayList<Reservation> getReservationsFromFile () {
        FileParser parser = new CSVFileParser(); // CSV implementation of abstract File Parser
        //return parser.parseFile("./reservations.csv");

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
        ress.add(new Reservation(2, rooms, date, date, cust, brd));
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
        return null; // TODO Handle empty return
    }

}
