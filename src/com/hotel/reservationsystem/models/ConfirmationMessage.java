package com.hotel.reservationsystem.models;

import com.hotel.reservationsystem.enums.BoardType;
import com.hotel.reservationsystem.enums.RoomType;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

public class ConfirmationMessage {

    int reservationNumber = 1;
    ArrayList<Room> rooms = new ArrayList<>();
    Date startDate = new Date();
    Date endDate = new Date();
    Customer customer = new Customer();
    BoardType boardtype = BoardType.HALF_BOARD;
    Reservation res = null;

    public ConfirmationMessage () {
        rooms.add(new Room(1,2, 0, "Double",
                RoomType.DOUBLE, true, true));
        rooms.add(new Room(2, 2, 2, "Double", RoomType.DOUBLE, true, true));
        res = new Reservation(1, rooms, startDate, endDate , customer, boardtype);
    }

    public void printToFile(){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("C:\\Users\\cosmit\\Documents\\test\\textfile.txt");
            writer.println("Your reservation with reservation number: " + res.getReservationNumber() + ", has been confirmed. See details below.");
            writer.println("Reservation number: " + res.getReservationNumber());

            // save room list in variable
            // create empty string for all room numbers
            // loop over room list
            // for every room in list, add room number to text
            // write string with all room numbers to file

            rooms = res.getRooms();

            String roomText = "";
                for(Room room : rooms) {
                    roomText += room.getRoomNumber() + ", ";
            }
            writer.println("Rooms: " + roomText.substring(0, roomText.length() - 2));
            writer.println("Check-in date: " + res.getStartDate());
            writer.println("Check-out date: " + res.getEndDate());
            writer.println("Guest name: " + res.getCustomer().getFirstName() + " " + res.getCustomer().getLastName());
            writer.println("Board type: " + res.getBoardType().name());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally{
            if(writer != null) {
                writer.close();
            }
        }
    }

}
