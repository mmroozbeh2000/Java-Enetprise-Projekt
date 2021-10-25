package com.example.usersystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Service
public class CustomerService {


    CustomerRepository customerRepository;
    @Autowired
    CustomerService(CustomerRepository customerRepository){

        this.customerRepository=customerRepository;

    }



    public List<Customer> getCustomers(){

        return customerRepository.findAll();
    }


    public Customer loadCustomerById(int id) {

        return customerRepository.findById(id).get();
    }

    public Customer saveCustomer(Customer customer) {

        customerRepository.save(customer);
        return loadCustomerById(customer.getId());
    }

    public void deleteCustomer(int id) {

        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Customer customer) {

        return customerRepository.save(customer);
    }




}