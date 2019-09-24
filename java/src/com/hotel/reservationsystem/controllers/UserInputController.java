package com.hotel.reservationsystem.controllers;
import com.hotel.reservationsystem.enums.BoardType;
import com.hotel.reservationsystem.enums.RoomType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserInputController {
    public static String returnStringInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String returnValue = null;

        while(returnValue == null){
            try {
                returnValue = scanner.nextLine();
            }
            catch (Exception nfe) {
                System.out.println("Enter valid text!");
            }
        }
        return returnValue;
    }

    public static int returnIntInput(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        int returnValue = 0;

        while (returnValue == 0) {
            try {
                returnValue = scanner.nextInt(); //TODO
            }
            catch (Exception nfe) {
                System.out.println("Enter a valid number!");
            }
        }
        return returnValue;
    }

    public static boolean returnBoolInput(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        boolean returnValue = false;

        while (returnValue == false) {
            try {
                returnValue = Boolean.parseBoolean(scanner.nextLine()); //TODO
            }
            catch (Exception nfe) {
                System.out.println("Enter a valid type!");
            }
        }
        return returnValue;
    }

    public static Date returnDateInput(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        Date returnValue = null;

        while (returnValue == null) {
            try {
                returnValue = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine());
            }
            catch (ParseException nfe) {
                System.out.println("Enter a valid type!");
            }
        }
        return returnValue;
    }

    public static BoardType returnBoardTypeInput(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        BoardType returnValue = null;

        while (returnValue == null) {
            try {
                String input = scanner.nextLine();

                switch(input) {
                    case "bed and breakfast":
                        returnValue = BoardType.BED_AND_BREAKFAST;
                    case "half board":
                        returnValue = BoardType.HALF_BOARD;
                    case "accomodations" :
                        returnValue = BoardType.ACCOMMODATIONS;
                }
            }
            catch (Exception e) {
                System.out.println("Enter a valid type!");
            }
        }
        return returnValue;
    }

    public static RoomType returnRoomTypeInput(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        RoomType returnValue = null;

        while (returnValue == null) {
            try {
                String input = scanner.nextLine();

                switch(input) {
                    case "single":
                        returnValue = RoomType.SINGLE;
                    case "double":
                        returnValue = RoomType.DOUBLE;
                    case "2x double" :
                        returnValue = RoomType.DOUBLE_2;
                    case "penthouse" :
                        returnValue = RoomType.PENTHOUSE;
                }
            }
            catch (Exception e) {
                System.out.println("Enter a valid type!");
            }
        }
        return returnValue;
    }
}
