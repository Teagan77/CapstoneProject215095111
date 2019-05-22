package org.randall.teagan.Repositories.Implementation.CustomerRepositoryImpl;

import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Repositories.RepositoryInterfaces.CustomerRepositoryInterface.CustomerRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository("CustomerRepository")
public class CustomerRepositoryImpl implements CustomerRepository {

    private static CustomerRepositoryImpl customerRepositoryImpl = null;
    private ArrayList<Customer> customers;

    private CustomerRepositoryImpl() {
        this.customers = new ArrayList<>();
    }

    public static CustomerRepositoryImpl getCustomerRepositoryImpl() {

        if (customerRepositoryImpl == null) {
            customerRepositoryImpl = new CustomerRepositoryImpl();
        }
        return customerRepositoryImpl;
    }

    @Override
    public Customer create(Customer cust) {
        this.customers.add(cust);
        return cust;
    }

    @Override
    public Customer update(Customer cust) {

        Customer toDelete = getCust(cust.getCustId());
        if (toDelete != null) {
            this.customers.remove(toDelete);
            return create(cust);
        }
        return null;
    }

    @Override
    public void delete(String id) {

        for (int i = 0; i < customers.size(); i++) {

            if (customers.get(i).getCustId().equals(id)) {
                customers.remove(i);
            }
        }
    }

    @Override
    public Customer read(String id) {

        for (Customer customer : customers) {
            if (customer.getCustId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    //TODO remove redundant method
    public Customer getCust(String custId) {

        return this.customers.stream()
                .filter(customer -> customer.getCustId().trim().equals(custId))
                .findAny()
                .orElse(null);
    }

    @Override
    public ArrayList<Customer> getAll() {
        return customers;
    }

    @Override
    public void removeAll() {
        customers.removeAll(customers);
    }
}
