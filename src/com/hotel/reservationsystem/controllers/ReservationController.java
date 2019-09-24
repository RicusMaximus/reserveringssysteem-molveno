package com.hotel.reservationsystem.controllers;

import com.hotel.reservationsystem.enums.BoardType;
import com.hotel.reservationsystem.models.*;
import com.hotel.reservationsystem.views.ReservationView;
import com.hotel.reservationsystem.views.RoomView;

import java.util.ArrayList;
import java.util.Date;

public class ReservationController {
    private static ArrayList<Reservation> reservations;
    private static ReservationController instance = null;

    private ReservationView view;
    private int reservationNumberCounter = 1;

    private ReservationController(){
        this.reservations = Reservation.retrieveReservationData();
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
    public void createReservation (ArrayList<Room> rooms, Date startDate, Date endDate, Customer customer, BoardType boardType) {

        reservationNumberCounter++; // TODO Make reservation number the Database index

        reservations.add(new Reservation(reservationNumberCounter, rooms, startDate, endDate, customer, boardType));
    }

    /**
     * Get all reservations
     * @return The current complete list of reservations
     */
    public ArrayList<Reservation> getAllReservations() {
        ArrayList<Reservation> allReservations = new ArrayList<>();

        for (Reservation reservation : this.reservations) {
            allReservations.add(reservation);
        }
        return allReservations;
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
