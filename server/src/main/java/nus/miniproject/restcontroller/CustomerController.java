package nus.miniproject.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nus.miniproject.model.Customer;
import nus.miniproject.service.CustomerService;

@RestController
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

        // GET all customer
    @GetMapping("/customer")
    public ResponseEntity<String> findAllCustomer(@RequestBody String request) {
        String response = customerService.findAllCustomer(request);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }


    // GET customer by id
    @GetMapping("/customer/{customer-id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable("customer-id") Integer id) {
        Customer customer = customerService.findCustomerById(id);

        if (customer == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(customer);
    }


    // INSERT new customer
    @PostMapping("/customer")
    public ResponseEntity<Boolean> insertCustomer(@RequestBody Customer customer) {
        Boolean bSaved = customerService.insertCustomer(customer);
        
        return new ResponseEntity<Boolean>(bSaved, HttpStatus.OK);
    }

    // DELETE customer by id
    @DeleteMapping("/customer/{customer-id}")
    public ResponseEntity<Integer> deleteCustomerById(@PathVariable("customer-id") Integer id) {
        int deletedId = customerService.deleteCustomerById(id);
        return ResponseEntity.ok().body(deletedId);
    }

    // DELETE customer by first name and last name via PathVariable
    @DeleteMapping("/customer/{first-name}/{last-name}")
    public ResponseEntity<Integer> deleteCustomerByFLName(@PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName) {
        int deletedId = customerService.deleteCustomerByFLName(firstName, lastName);
        return ResponseEntity.ok().body(deletedId);
    }

    // DELETE customer by first name and last name via RequestBody
    @DeleteMapping("/customer")
    public ResponseEntity<Integer> deleteCustomerByFLName2(@RequestBody Customer customer) {
        int deletedId = customerService.deleteCustomerByFLName(customer.getFirstName(), customer.getLastName());
        return ResponseEntity.ok().body(deletedId);
    }





}
