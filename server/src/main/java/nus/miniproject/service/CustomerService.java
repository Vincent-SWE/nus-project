package nus.miniproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nus.miniproject.Exception.ResourceNotFoundException;
import nus.miniproject.model.Customer;
import nus.miniproject.repository.CustomerRepository;

@Service
public class CustomerService {
    
    @Autowired
    private CustomerRepository customerRepository;

       public String findAllCustomer(String request) {
        return customerRepository.findAllCustomer().toString();
    }

    
    public Customer findCustomerById(Integer id) throws ResourceNotFoundException {
        Customer customer = customerRepository.findCustomerById(id);
        return customer;
    }


    public Boolean insertCustomer(Customer customer) {
        return customerRepository.insertCustomer(customer);
    }


    public int deleteCustomerById(Integer id) {
        return customerRepository.deleteCustomerById(id);
    }


    public int deleteCustomerByFLName(String firstName, String lastName) {
        return customerRepository.deleteCustomerByFLName(firstName, lastName);
    }


    public Customer findCustomerLatest() {
        return customerRepository.findCustomerLatest();
    }

}
