package com.hotel.reservationsystem.services;

import com.hotel.reservationsystem.exceptions.NotFoundException;
import com.hotel.reservationsystem.models.Customer;
import com.hotel.reservationsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers () {
        return this.customerRepository.getCustomers();
    }

    public Customer getCustomerById (int id) throws NotFoundException {
        return this.customerRepository.getCustomerById(id);
    }

    public Customer addCustomer(Customer newCustomer) {
        // Validation
        // Business logic
        return this.customerRepository.addCustomer(newCustomer);
    }
}
