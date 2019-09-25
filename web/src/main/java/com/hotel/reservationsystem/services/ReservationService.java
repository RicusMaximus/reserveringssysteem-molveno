package com.hotel.reservationsystem.services;

import com.hotel.reservationsystem.exceptions.NotFoundException;
import com.hotel.reservationsystem.models.Reservation;
import com.hotel.reservationsystem.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations () {
        return this.reservationRepository.getReservations();
    }

    public Reservation getReservationById (int id) throws NotFoundException {
        return this.reservationRepository.getReservationById(id);
    }

    public Reservation addReservation(Reservation newReservation) {
        // Validation
        // Business logic
        return this.reservationRepository.addReservation(newReservation);
    }
}
