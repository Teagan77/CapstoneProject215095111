package org.randall.teagan.Repositories.Implementation;

import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Repositories.RepositoryInterfaces.CustomerRepository;

import java.util.ArrayList;

public class CustomerRepositoryImpl implements CustomerRepository {

    private ArrayList<Customer> customers;

    private static CustomerRepositoryImpl customerRepositoryImpl = null;

    private CustomerRepositoryImpl(){
        this.customers = new ArrayList<>();
    }

    protected static CustomerRepositoryImpl getCustomerRepositoryImpl(){
        if(customerRepositoryImpl == null){
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

        boolean exists = false;
        int index = 0;

        for(int i = 0;i < customers.size();i++) {

            if (customers.get(i).getCustId() == cust.getCustId()) {
                exists = true;
                index = i;
                customers.remove(i);
            }
        }
            if(!exists) {
                System.out.println("Cannot update a non-existent customer.");
            }

        customers.add(index, cust);
        return cust;
    }

    @Override
    public void delete(String id) {

        for(int i = 0;i < customers.size();i++) {

            if (customers.get(i).getCustId() == id) {
                customers.remove(i);
            }
        }
    }

    @Override
    public Customer read(String id) {

        int index = 0;
        boolean exists = false;

        for(int i = 0;i < customers.size();i++) {

            if (customers.get(i).getCustId() == id) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
                return null;
            }

        return customers.get(index);
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
