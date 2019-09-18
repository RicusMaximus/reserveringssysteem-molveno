package com.hotel.reservationsystem.views;

import com.hotel.reservationsystem.controllers.ReservationController;
import com.hotel.reservationsystem.enums.BoardType;
import com.hotel.reservationsystem.models.Reservation;
import com.hotel.reservationsystem.models.Room;
import com.hotel.reservationsystem.models.UserInput;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 */
public class ReservationView {
    ReservationController reservationController = ReservationController.getInstance();

    /**
     *
     */
    public void showReservationNumberList () {
        // Get all reservations from controller
        ArrayList<Reservation> reservations = reservationController.getReservations();

        // Loop over list and show reservation numbers
        String message = "";
        if (!reservations.isEmpty()) {
            for (Reservation res : reservations) {
                message += res.getReservationNumber() + ", ";
            }
        } else {
            message = "No reservations found.  ";
        }
        // Remove trailing comma from message
        if (message.contains(",")) message = message.substring(0, message.length() - 2);
        System.out.println(message + "\n");
    }

    /**
     *
     */
    public void getReservationByInput () {
        // Wait for input to show detail info or quit
        int input = UserInput.returnIntInput("Voer het reserveringsnummer in voor meer informatie");
        showReservationInformation(reservationController.getReservationByNumber(input));
    }

    public void addNewReservationByInput() {
        System.out.println("Enter the start date (dd/mm/yyyy): ");
        //Date startDate = getDateInput(); TODO Use UserInput method

        System.out.println("Enter the end date (dd/mm/yyyy): ");
        //Date endDate = getDateInput(); TODO Use UserInput method

        System.out.println("Enter the board type (Bed and Breakfast, Half Board, Full Board, All-inclusive): ");
        //BoardType boardType = getBoardTypeInput(); TODO Use UserInput method

        System.out.println("Which rooms do you want to reserve? These are available:\n");
        Room.showAvailableRooms();
        //rooms = getRoomsInput(); TODO Use UserInput method

        //reservationController.createReservation(rooms,startDate, endDate, null, boardType);
    }

    public void showReservationInformation (Reservation reservation) {
        System.out.println("Reserveringsnummer: " + reservation.getReservationNumber());
        System.out.println("Reserveringsdatum: " + reservation.getReservationDate());
        System.out.println("Datum van ingang: " + reservation.getStartDate());
        System.out.println("Einddatum: " + reservation.getEndDate());
        System.out.println("Totale kosten reservering: " + reservation.getTotalPrice());
        System.out.println("Naam hoofdboeker: " + reservation.getCustomer().getFirstName() + " " + reservation.getCustomer().getLastName());
        System.out.println("Verzorgingstype: " + reservation.getBoardType().getBoardType());
        String kamers = "";
        for (Room room : reservation.getRooms()) {
            kamers += room.getRoomNumber() + ", ";
        }
        System.out.println("Kamers: " + kamers.substring(0, kamers.length() - 2));
    }
}
