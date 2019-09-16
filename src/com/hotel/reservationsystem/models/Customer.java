package com.hotel.reservationsystem.models;
import com.hotel.reservationsystem.enums.Title;

import java.util.Date;

public class Customer {
    public int customerId;
    public Title title;
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String phoneNumber;
    public String email;
    public Date birthday;
}