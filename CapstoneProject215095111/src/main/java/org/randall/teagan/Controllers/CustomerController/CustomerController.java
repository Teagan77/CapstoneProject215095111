package org.randall.teagan.Controllers.CustomerController;


import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Request.NewCustomer;
import org.randall.teagan.Domain.Request.ResponseObject;
import org.randall.teagan.Factory.CustomerBuilder.CustBuilder;
import org.randall.teagan.Factory.Response.ResponseObjectFactory;
import org.randall.teagan.Services.ServiceImplementation.CustServiceImpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/capstone/customer")
public class CustomerController {

    private final CustomerServiceImpl customerServiceImpl;

    public CustomerController(CustomerServiceImpl customerServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createCustomer(@RequestBody NewCustomer customer) {
        System.out.println(customer);
        ResponseObject responseObject = ResponseObjectFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Customer has been successfully created.");
        if (customer.getCustName() == null || customer.getCustLastName() == null) {
            responseObject.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
            responseObject.setResponseDescription("Please provide customer's first & last name(s).");
        } else {
            Customer savedCustomer = saveCustomer(customer);
            responseObject.setResponse(savedCustomer);
        }
        return ResponseEntity.ok(responseObject);
    }

    @GetMapping(value = "/read", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity readCustomer(@RequestBody String cusomerID) {
        System.out.println(cusomerID);
        ResponseObject responseObject = ResponseObjectFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Successfully found customer.");
        Customer customer = customerServiceImpl.read(cusomerID);
        responseObject.setResponse(customer);
        return ResponseEntity.ok(customer);
    }

    @GetMapping(value = "/getall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll() {
        ResponseObject responseObject = ResponseObjectFactory.buildGenericResponseObj(HttpStatus.OK.toString(), "Successfully retrieved all customers.");
        List<Customer> customers = customerServiceImpl.getAll();
        responseObject.setResponse(customers);
        return ResponseEntity.ok(responseObject);
    }

    private Customer saveCustomer(NewCustomer customer) {
        Customer cust = CustBuilder.getCustomer(customer.getCustomerID(), customer.getCustName(), customer.getCustLastName(), customer.getCustAge(), customer.getCustPhone());
        return customerServiceImpl.create(cust);
    }


//
//
//
//    @PostMapping(value = "/update/")
//    @ResponseBody
//    public Customer update(@RequestBody Customer customer) {
//        return customerServiceImpl.update(customer);
//    }
//
//    @GetMapping(value = "/delete/{id}")
//    @ResponseBody
//    public void delete(@PathVariable String id) {
//        customerServiceImpl.delete(id);
//    }
//

}
