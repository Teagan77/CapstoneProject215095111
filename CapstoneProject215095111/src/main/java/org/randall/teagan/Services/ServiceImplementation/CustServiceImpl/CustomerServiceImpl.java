package org.randall.teagan.Services.ServiceImplementation.CustServiceImpl;

import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Repositories.Implementation.CustomerRepositoryImpl.CustomerRepositoryImpl;
import org.randall.teagan.Services.ServicesInterfaces.CustServiceInterface.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService {

        @Autowired
        @Qualifier("CustomerRepository")
        private CustomerRepositoryImpl customerRepositoryImpl;

        @Override
        public Customer create(Customer customer) { return customerRepositoryImpl.create(customer); }

        @Override
        public Customer update(Customer customer) { return customerRepositoryImpl.update(customer); }

        @Override
        public void delete(String custNo) { customerRepositoryImpl.delete(custNo); }

        @Override
        public Customer read(String custNo) { return customerRepositoryImpl.read(custNo); }

        @Override
        public ArrayList<Customer> getAll() {
            return customerRepositoryImpl.getAll();
        }
}

