package com.hotel.reservationsystem.repositories;

import com.hotel.reservationsystem.enums.BoardType;
import com.hotel.reservationsystem.enums.RoomType;
import com.hotel.reservationsystem.enums.Title;
import com.hotel.reservationsystem.exceptions.NotFoundException;
import com.hotel.reservationsystem.models.Address;
import com.hotel.reservationsystem.models.Customer;
import com.hotel.reservationsystem.models.Reservation;
import com.hotel.reservationsystem.models.Room;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ReservationRepository {

    public List<Reservation> reservations = new ArrayList<>();

    public List<Reservation> getReservations() { // TODO Remove mock data when we use a database
        return this.reservations;
    }

    public Reservation getReservationById (int id) throws NotFoundException {
        for (Reservation res : this.getReservations()) {
            if (id == res.getReservationNumber()) {
                return res;
            }
        } throw new NotFoundException();
    }

    public Reservation addReservation (Reservation newReservation) {
        newReservation.setReservationNumber(this.getReservations().size() + 1); // TODO Use database ID's later on
        this.reservations.add(newReservation);
        return newReservation;
    }
}
