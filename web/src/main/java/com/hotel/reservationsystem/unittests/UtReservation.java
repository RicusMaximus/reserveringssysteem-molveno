package com.hotel.reservationsystem.unittests;

import com.hotel.reservationsystem.models.Reservation;
import org.junit.*;
import org.junit.Assert.*;

public class UtReservation {

    public static Reservation reservation = null;

    public UtReservation () {

    }

    @Before
    public void before() {
        this.reservation = new Reservation(0,null,null,null,null,null);
    }

    // TODO Add tests

}