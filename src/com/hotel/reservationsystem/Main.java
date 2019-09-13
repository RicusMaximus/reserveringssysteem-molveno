package com.hotel.reservationsystem;

import com.hotel.reservationsystem.enums.RoomType;
import com.hotel.reservationsystem.models.Customer;
import com.hotel.reservationsystem.models.Reservation;
import com.hotel.reservationsystem.models.Room;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Reservation res = new Reservation();
        Customer customer = new Customer();
        ArrayList<Reservation> reservations = new ArrayList<>();

        while(true) {
            System.out.println("\nType '1' to list all available rooms. Type '2' to make a reservation. " +
                    "Type '3' to show all current reservations.");

            Scanner scanner = new Scanner(System.in);

            int userInput = Integer.parseInt(scanner.nextLine());

            switch (userInput) {
                case 1:
                    Room.showAvailableRooms();
                    break;
                case 2:
                    reservations.add(res.createReservation(customer));
                    break;
                case 3:
                    Reservation.showReservations(reservations);
                    break;
                default:
                    System.out.println("Enter a valid input option!");
                    break;
            }
        }
    }
}
