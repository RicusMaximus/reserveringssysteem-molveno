package com.hotel.reservationsystem.unittest;

import com.hotel.reservationsystem.controllers.ReservationController;
import org.junit.*;
import org.junit.Assert.*;

public class UtReservationController {

    public static ReservationController controller = null;

    public UtReservationController () {

    }

    @Before
    public void before() {
        this.controller = ReservationController.getInstance();
        // TODO Testing singletons is hard as it changes the instance itself during testing
        // Check if it can be done with Dependency injection
    }

    // TODO Add tests

}