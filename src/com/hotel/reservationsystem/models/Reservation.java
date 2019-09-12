package com.hotel.reservationsystem.models;

import enums.BoardType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Reservation {
    private int reservationNumber;
    private Date reservationDate;
    private Date startDate;
    private Date endDate;
    private double totalPrice;
    Customer customer;
    BoardType boardType;


    public Reservation (){

    }

    public Reservation(int reservationNumber, Date startDate, Date endDate, Customer customer, BoardType boardType) {
        this.reservationNumber = reservationNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.boardType = boardType;
    }

    public void createReservation () throws ParseException {

        System.out.println("Enter the start date (dd/mm/yyyy): ");
        startDate = getDateInput();

        System.out.println("Enter the end date (dd/mm/yyyy): ");
        endDate = getDateInput();

        System.out.println("Enter the board type (Bed and Breakfast, Half Board, Full Board, All-inclusive): ");
        boardType = getBoardTypeInput();

        reservationDate = new Date();
    }

    private BoardType getBoardTypeInput() {
        String input = getStringInput().toLowerCase();
        BoardType type = null;

        switch (input) {
            case "bed and breakfast":
                type = BoardType.BED_AND_BREAKFAST;
                break;
            case "half board":
                type = BoardType.HALF_BOARD;
                break;
            case "full board":
                type = BoardType.FULL_BOARD;
                break;
            case "all inclusive":
            case "all-inclusive":
                type = BoardType.ALL_INCLUSIVE;
                break;
            default:
                System.out.println("Please enter a valid board type.");
                getBoardTypeInput();
                break;
        }
        return type;
    }

    public String getStringInput () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int getIntInput () {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public Date getDateInput () throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return new SimpleDateFormat("dd/MM/yyyy").parse(input);
    }
}