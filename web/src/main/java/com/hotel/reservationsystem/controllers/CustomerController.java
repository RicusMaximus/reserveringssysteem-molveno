package com.hotel.reservationsystem.controllers;

import com.hotel.reservationsystem.exceptions.NotFoundException;
import com.hotel.reservationsystem.models.Customer;
import com.hotel.reservationsystem.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return this.customerService.getAllCustomers();
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Customer getCustomerById( @PathVariable int id) throws NotFoundException {
        return this.customerService.getCustomerById(id);
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public Customer addCustomer( @RequestBody Customer newCustomer) {
        return this.customerService.addCustomer(newCustomer);
    }
}
