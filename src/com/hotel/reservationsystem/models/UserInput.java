package com.hotel.reservationsystem.models;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserInput {

    public static String returnStringInput (String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        String returnValue = null;

        while(returnValue == null){
            try {
                returnValue = scanner.nextLine();
            } catch (Exception nfe) {
                System.out.println("Enter a valid number!");
            }
        }
        return returnValue;
    }

    public static int returnIntInput (String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        int returnValue = 0;

        while (returnValue == 0) {
            try {
                returnValue = Integer.parseInt(scanner.nextLine());
            } catch (Exception nfe) {
                System.out.println("Enter a valid number!");
            }
        }
        return returnValue;
    }

    public static boolean returnBoolInput (String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        boolean returnValue = false;

        while (returnValue == false) {
            try {
                returnValue = Boolean.parseBoolean(scanner.nextLine());
            } catch (Exception nfe) {
                System.out.println("Enter a valid number!");
            }
        }
        return returnValue;
    }

    public static Date returnDateInput (String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        Date returnValue = null;

        while (returnValue == null) {
            try {
                returnValue = new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine()); // Parse string input to date
            } catch (ParseException nfe) {
                System.out.println("Enter a valid date (dd-mm-yyyy)!");
            }
        }
        return returnValue;
    }
}
