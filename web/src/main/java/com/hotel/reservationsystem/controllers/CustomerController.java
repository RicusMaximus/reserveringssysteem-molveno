package com.hotel.reservationsystem.controllers;

import com.hotel.reservationsystem.models.Customer;

import java.util.ArrayList;

public class CustomerController {
    private ArrayList<Customer> customers;

    private CustomerController () {
        // customers = getCustomerList();
    }
    private static CustomerController instance;
    public static CustomerController getInstance () {
        if (instance == null) {
            instance = new CustomerController();
        }
        return instance;
    }
}
