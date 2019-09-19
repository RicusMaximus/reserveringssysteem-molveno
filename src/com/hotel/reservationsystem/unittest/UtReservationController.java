package com.hotel.reservationsystem.unittest;

import com.hotel.reservationsystem.controllers.ReservationController;
import com.hotel.reservationsystem.enums.BoardType;
import com.hotel.reservationsystem.enums.RoomType;
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

    @Before
    public void reflectOnSingletonAndReset() throws NoSuchFieldException, IllegalAccessException {
        Field instance = ReservationController.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance.setAccessible(false);
    }

    // TODO Add tests
    @Test
    public void getReservationByNumber_ValidReservationID_ReturnsValidReservation () {
        ReservationController controller = ReservationController.getInstance();
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
        Date date = new Date();
        Customer cust = new Customer();
        BoardType brd = BoardType.BED_AND_BREAKFAST;
        Reservation expectedRes = new Reservation(1, rooms, date, date, cust, brd);

        Reservation actualRes = controller.getReservationByNumber(1);

        assertEquals(expectedRes.getReservationNumber(), actualRes.getReservationNumber());
        assertEquals(expectedRes.getCustomer().getFirstName(), actualRes.getCustomer().getFirstName());
        assertEquals(expectedRes.getBoardType(), actualRes.getBoardType());
        assertEquals(expectedRes.getStartDate().toString(), actualRes.getStartDate().toString());
        assertEquals(expectedRes.getEndDate().toString(), actualRes.getEndDate().toString());
    }

    @Test
    public void getReservationByNumber_InvalidReservationID_ReturnsNull () {
        ReservationController controller = ReservationController.getInstance();
        Reservation actualRes = controller.getReservationByNumber(-1);

        assertEquals(null, actualRes);
    }

    @Test
    public void getReservationByNumber_ValidReservationID_ReturnsNull () { // TODO returns exception
        ReservationController controller = ReservationController.getInstance();
        Reservation actualRes = controller.getReservationByNumber(controller.getReservationListFromDatabase().size() + 1);

        assertEquals(null, actualRes);
    }

}