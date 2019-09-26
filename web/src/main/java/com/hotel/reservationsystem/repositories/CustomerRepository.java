package com.hotel.reservationsystem.repositories;

import com.hotel.reservationsystem.enums.Title;
import com.hotel.reservationsystem.exceptions.NotFoundException;
import com.hotel.reservationsystem.models.Address;
import com.hotel.reservationsystem.models.Customer;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CustomerRepository {

    public List<Customer> customerList;

    public List<Customer> getCustomers() { // TODO Remove mock data when we use a database
        // Mocking customer list
        customerList = new ArrayList<>();
        Address address1 = new Address("Eendekotsweg", 13, "", "4352 JD", "Gapinge", "Nederland");
        Date bday1;
        try {
             bday1 = new SimpleDateFormat("dd/MM/yyyy").parse("06/10/1992");
        } catch (ParseException pe) {
            return null;
        }
        Customer cust1 = new Customer(Title.MS, "Beau", "Ter Ham", address1,  "+31686043697", "beau.ter.ham@capgemini.com", bday1);
        cust1.setCustomerId(1);

        Address address2 = new Address("P.C. Hooftstraat", 28, "", "4819 HK", "Breda", "Nederland");
        Date bday2;
        try {
            bday2 = new SimpleDateFormat("dd/MM/yyyy").parse("06/10/1982");
        } catch (ParseException pe) {
            return null;
        }
        Customer cust2 = new Customer(Title.MR, "Jan", "Haan", address2,  "+4475940357", "jan.haancapgemini.com", bday2);
        cust2.setCustomerId(2);

        Address address3 = new Address("Hoofdstraat", 1, "F", "8329 GB", "Groningen", "Nederland");
        Date bday3;
        try {
            bday3 = new SimpleDateFormat("dd/MM/yyyy").parse("14/12/2001");
        } catch (ParseException pe) {
            return null;
        }
        Customer cust3 = new Customer(Title.MR, "Bart", "de Vries", address3,  "+31686043697", "bart.de.vries@capgemini.com", bday3);
        cust3.setCustomerId(3);

        customerList.add(cust1);
        customerList.add(cust2);
        customerList.add(cust3);

        return customerList;
    }

    public Customer getCustomerById (int id) throws NotFoundException {
        for (Customer customer : customerList) {
            if (id == customer.getCustomerId()) {
                return customer;
            }
        } throw new NotFoundException();
    }

    public Customer addCustomer (Customer newCustomer) {
        newCustomer.setCustomerId(customerList.size() + 1); // TODO Use database ID's later on
        this.customerList.add(newCustomer);
        return newCustomer;
    }
}
