package com.hotel.reservationsystem.controllers;

import com.hotel.reservationsystem.exceptions.NotFoundException;

import com.hotel.reservationsystem.models.*;

import com.hotel.reservationsystem.models.Reservation;
import com.hotel.reservationsystem.services.ReservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The REST API for Reservation CRUD
 */
@RestController
@RequestMapping("api/v1/reservations/")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    private int reservationNumberCounter = 0;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String addNewReservation (@RequestBody Reservation newReservation) {
        this.reservationService.addReservation(newReservation);
        return "Successfully added new reservation";
    }

    /**
     * Get all reservations
     * @return The current complete list of reservations
     */
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public List<Reservation> getReservations () {
        return this.reservationService.getAllReservations();
    }

    /**
     * Get reservation by ID
     * @param id The reservation ID
     * @return The reservation
     * @throws NotFoundException
     */
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Reservation getReservation (@PathVariable int id) {
        Reservation res = null;
        try {
            res = this.reservationService.getReservationById(id);
        } catch (NotFoundException nfe) {
            return null;
        }
        return res;
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
}