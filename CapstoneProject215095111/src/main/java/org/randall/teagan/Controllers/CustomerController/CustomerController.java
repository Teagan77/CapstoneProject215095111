package org.randall.teagan.Controllers.CustomerController;

import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Services.ServiceImplementation.CustServiceImpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    @Qualifier("CustomerServiceImpl")
    CustomerServiceImpl customerServiceImpl;


    @PostMapping(value = "/create")
    @ResponseBody
    public Customer create(@RequestBody Customer customer) {
        return customerServiceImpl.create(customer);
    }

    @PostMapping(value = "/update/")
    @ResponseBody
    public Customer update(@RequestBody Customer customer) {
        return customerServiceImpl.update(customer);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        customerServiceImpl.delete(id);
    }

    @GetMapping(value = "/read/{id}")
    @ResponseBody
    public Customer read(@PathVariable String id) {
        return customerServiceImpl.read(id);
    }

    @GetMapping(value = "/read/all")
    @ResponseBody
    public ArrayList<Customer> getAll() {
        return customerServiceImpl.getAll();
    }
}
