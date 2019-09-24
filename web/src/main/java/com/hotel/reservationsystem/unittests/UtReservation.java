package com.hotel.reservationsystem.unittest;

import com.hotel.reservationsystem.models.Reservation;
import org.junit.*;
import org.junit.Assert.*;

public class UtReservation {

    public static Reservation reservation = null;

    public UtReservation () {

    }

    @Before
    public void before() {
        this.reservation = new Reservation();
    }

    // TODO Add tests

}