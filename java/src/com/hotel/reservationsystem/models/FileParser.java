package com.hotel.reservationsystem.models;

import java.util.ArrayList;

public abstract class FileParser {
    public abstract ArrayList<Reservation> parseFile(String filePath);
}
