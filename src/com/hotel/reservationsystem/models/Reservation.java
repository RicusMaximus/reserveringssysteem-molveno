package com.hotel.reservationsystem.models;
import com.hotel.reservationsystem.enums.BoardType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Reservation {
    private int reservationNumber;
    private Date reservationDate;
    private Date startDate;
    private Date endDate;
    private double totalPrice;
    private Customer customer;
    private BoardType boardType;
    private ArrayList<Room> rooms;

    public Reservation (){ }

    public Reservation(int reservationNumber, ArrayList<Room> rooms, Date startDate, Date endDate, Customer customer, BoardType boardType) {
        this.reservationNumber = reservationNumber;
        this.rooms = rooms;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.boardType = boardType;
        this.reservationDate = new Date();
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BoardType getBoardType() {
        return boardType;
    }

    public void setBoardType(BoardType boardType) {
        this.boardType = boardType;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
}