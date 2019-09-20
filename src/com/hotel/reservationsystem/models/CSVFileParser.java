package com.hotel.reservationsystem.models;

import com.hotel.reservationsystem.controllers.ReservationController;
import com.hotel.reservationsystem.enums.BoardType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class CSVFileParser extends FileParser {

    private ReservationController reservationController;

    @Override
    public ArrayList<Reservation> parseFile(String filePath) {
        ArrayList<Reservation> reservations = null;
        String line, csvSplitSymbol = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            while ((line = br.readLine()) != null) {

                //System.out.println(line);
                // use comma as separator
                String[] reservationData = line.split(csvSplitSymbol);

                // Parse room numbers to ArrayList<Room> rooms

                // Parse startDate to Date object

                // Parse endDate to Date object

                // Parse customer to Customer object

                // Parse boardType to BoardType enumeration

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reservations;
    }
}
