package com.hotel.reservationsystem.unittests;

import com.hotel.reservationsystem.controllers.ReservationController;
import com.hotel.reservationsystem.enums.BoardType;
import com.hotel.reservationsystem.enums.RoomType;
import com.hotel.reservationsystem.enums.Title;
import com.hotel.reservationsystem.exceptions.NotFoundException;
import com.hotel.reservationsystem.models.Customer;
import com.hotel.reservationsystem.models.Reservation;
import com.hotel.reservationsystem.models.Room;
import org.junit.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;

public class UtReservationController {

    private ReservationController reservationController;

    @Before
    public void setUp() throws Exception {
        this.reservationController = new ReservationController();
    }

    @Test
    public void getReservationByNumber_ValidReservationID_ReturnsValidReservation () { // TODO
    }

    @Test
    public void getReservationByNumber_InvalidReservationID_ReturnsNull () { // TODO
    }

//    @Test
//    public void getReservationByNumber_ValidReservationID_ReturnsNull () { // TODO returns exception
//        ReservationController controller = ReservationController.getInstance();
//        Reservation actualRes = controller.getReservationByNumber(controller.getReservationListFromDatabase().size() + 1);
//
//        assertEquals(null, actualRes);
//    }

}