package com.hotel.reservationsystem.controllers;

import com.hotel.reservationsystem.models.Customer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CustomerController {
    private ArrayList<Customer> customers;

    private CustomerController() {
        customers = getCustomerList();
    }

    private static CustomerController instance;

    public static CustomerController getInstance() {
        if (instance == null) {
            instance = new CustomerController();
        }
        return instance;
    }

    public ArrayList<Customer> getCustomerList() {
        fakeCustomerData();
        return customers;
    }

    public Customer addCustomer(String fname, String lname, String address, String phonenumber, String email) {
        Customer newCustomer = new Customer();

        newCustomer.setFirstName(fname);
        newCustomer.setLastName(lname);
        newCustomer.setAddress(address);
        newCustomer.setPhoneNumber(phonenumber);
        newCustomer.setEmail(email);

        customers.add(newCustomer);
        return newCustomer;
    }

    private void fakeCustomerData() {
        // Mocking customer list
        Customer cust1 = new Customer();
        cust1.setFirstName("Beau");
        cust1.setLastName("Ter Ham");
        cust1.setAddress("Straatweg 1");
        cust1.setPhoneNumber("0646374637");
        cust1.setEmail("beau.ter.ham@capgemini.com");
        try {
            cust1.setBirthday(new SimpleDateFormat("dd/MM/yyyy").parse("06/10/1992"));
        } catch (ParseException pe) {
            return;
        }

        Customer cust2 = new Customer();
        cust2.setFirstName("Jan");
        cust2.setLastName("Haan");
        cust2.setAddress("Bosweg 1");
        cust2.setPhoneNumber("0643889637");
        cust2.setEmail("jan.haan@capgemini.com");
        try {
            cust2.setBirthday(new SimpleDateFormat("dd/MM/yyyy").parse("06/12/1993"));
        } catch (ParseException pe) {
            return;
        }

        Customer cust3 = new Customer();
        cust3.setFirstName("Bart");
        cust3.setLastName("De Vries");
        cust3.setAddress("Hoofdstraat 1");
        cust3.setPhoneNumber("0643802637");
        cust3.setEmail("bart.devries@capgemini.com");
        try {
            cust3.setBirthday(new SimpleDateFormat("dd/MM/yyyy").parse("13/04/1990"));
        } catch (ParseException pe) {
            return;
        }

        Customer cust4 = new Customer();
        cust4.setFirstName("Johan");
        cust4.setLastName("Mens");
        cust4.setAddress("Doorweg 1");
        cust4.setPhoneNumber("0699889637");
        cust4.setEmail("johan.mens@capgemini.com");
        try {
            cust4.setBirthday(new SimpleDateFormat("dd/MM/yyyy").parse("24/07/1987"));
        } catch (ParseException pe) {
            return;
        }

        customers.add(cust1);
        customers.add(cust2);
        customers.add(cust3);
        customers.add(cust4);
    }
}
