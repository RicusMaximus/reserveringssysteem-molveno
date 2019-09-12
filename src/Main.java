import models.Reservation;

import java.text.ParseException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {


        Reservation res = new Reservation();

        while(true) {
            System.out.println("\nType 'Make reservation' to make a reservation.");

            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();

//            switch (userInput) {
//                case "Make reservation":
//                    res.createReservation();
//                    break;
//                default:
//                    System.out.println("Enter a valid input option!");
//                    break;
//            }
        }
    }
}
