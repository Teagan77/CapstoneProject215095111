package org.randall.teagan.Services.ServicesInterfaces.CustServiceInterface;

import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Services.ServicesInterfaces.GenericService;
import java.util.ArrayList;

public interface CustomerService extends GenericService<Customer, String> {

        ArrayList<Customer> getAll();
}
