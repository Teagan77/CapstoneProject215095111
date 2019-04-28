package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface CustomerRepository extends Repository<Customer, String> {

    ArrayList<Customer> getAll();
    void removeAll();
}
