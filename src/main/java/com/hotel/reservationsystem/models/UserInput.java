package com.hotel.reservationsystem.models;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserInput {

    private static Scanner getInputValue(String message) {
        System.out.println(message);
        return new Scanner(System.in);
    }

    public static String returnStringInput (String message) {
        Scanner scanner = getInputValue(message);
        String returnValue = null;

        while(returnValue == null || returnValue.matches("")){
            try {
                returnValue = scanner.nextLine();
            } catch (Exception nfe) {
                System.out.println("That's not valid, please enter some text");
            }
        }
        return returnValue;
    }

    public static int returnIntInput (String message) {
        Scanner scanner = getInputValue(message);
        int returnValue = 0;

        while (returnValue == 0) {
            try {
                returnValue = Integer.parseInt(scanner.nextLine());
            } catch (Exception nfe) {
                System.out.println("That's not a number, please enter a valid number");
            }
        }
        return returnValue;
    }

    public static Date returnDateInput (String message) {
        Scanner scanner = getInputValue(message);
        Date returnValue = null;

        while (returnValue == null) {
            try {
                returnValue = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine()); // Parse string input to date
            } catch (ParseException nfe) {
                System.out.println("That's an incorrect date format, please enter a valid date (dd-mm-yyyy)");
            }
        }
        return returnValue;
    }

    public static boolean returnBoolInput (String message) {
        throw new UnsupportedOperationException();
//        System.out.println(message);
//        Scanner scanner = new Scanner(System.in);
//        boolean returnValue = false;
//
//        while (returnValue == false) {
//            try {
//                returnValue = Boolean.parseBoolean(scanner.nextLine());
//            } catch (Exception nfe) {
//                System.out.println("Enter a valid number!");
//            }
//        }
//        return returnValue;
    }
}
