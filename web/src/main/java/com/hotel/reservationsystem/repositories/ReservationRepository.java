package com.hotel.reservationsystem.repositories;

import com.hotel.reservationsystem.enums.BoardType;
import com.hotel.reservationsystem.enums.RoomType;
import com.hotel.reservationsystem.enums.Title;
import com.hotel.reservationsystem.exceptions.NotFoundException;
import com.hotel.reservationsystem.models.Customer;
import com.hotel.reservationsystem.models.Reservation;
import com.hotel.reservationsystem.models.Room;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ReservationRepository {

    public List<Reservation> reservations = new ArrayList<>();

    public List<Reservation> getReservations() { // TODO Remove mock data when we use a database
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(1,2, 0, "Double",
                RoomType.DOUBLE, true, true));
        rooms.add(new Room(4, 2, 5, "Penthouse",
                RoomType.SINGLE, false, false));
        rooms.add(new Room(5, 2, 4, "200",
                RoomType.SINGLE, false, true));
        ArrayList<Reservation> ress = new ArrayList<>();
        Date date = new Date();
        Customer cust = new Customer();
        cust.setCustomerId(1);
        cust.setTitle(Title.MR);
        cust.setFirstName("Conny");
        cust.setLastName("Feer");
        cust.setBirthday(date);
        cust.setEmail("conny.feer@coniferenwinkel.nu");
        cust.setPhoneNumber("0664646464");
        cust.setAddress("Straatlaanweg 1");
        BoardType brd = BoardType.BED_AND_BREAKFAST;
        ress.add(new Reservation(1, rooms, date, date, cust, brd));


        ArrayList<Room> rooms2 = new ArrayList<>();
        rooms2.add(new Room(1,2, 0, "Double",
                RoomType.DOUBLE, true, true));
        rooms2.add(new Room(4, 2, 5, "Penthouse",
                RoomType.SINGLE, false, false));
        rooms2.add(new Room(5, 2, 4, "200",
                RoomType.SINGLE, false, true));
        Customer cust2 = new Customer();
        cust2.setCustomerId(2);
        cust2.setTitle(Title.MR);
        cust2.setFirstName("Anna");
        cust2.setLastName("Nas");
        cust2.setBirthday(date);
        cust2.setEmail("anna.nas@pineapple.nu");
        cust2.setPhoneNumber("+31645654585");
        cust2.setAddress("Straatstadweg 2");
        BoardType brd2 = BoardType.ACCOMMODATIONS;
        ress.add(new Reservation(2, rooms2, date, date, cust2, brd2));

        return ress;
        //return this.reservations;
    }

    public Reservation getReservationById (int id) throws NotFoundException {
        for (Reservation res : reservations) {
            if (id == res.getReservationNumber()) {
                return res;
            }
        } throw new NotFoundException();
    }

    public Reservation addReservation (Reservation newReservation) {
        newReservation.setReservationNumber(reservations.size() + 1); // TODO Use database ID's later on
        this.reservations.add(newReservation);
        return newReservation;
    }
}
