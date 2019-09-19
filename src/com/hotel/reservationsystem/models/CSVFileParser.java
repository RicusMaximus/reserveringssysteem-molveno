package com.hotel.reservationsystem.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVFileParser extends FileParser {
    @Override
    public ArrayList<Reservation> parseFile(String filePath) {
        ArrayList<Reservation> reservations = null;
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] reservationData = line.split(cvsSplitBy);
                Reservation res = new Reservation();
                res.setReservationNumber(Integer.parseInt(reservationData[0]));


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return reservations;
    }
}
