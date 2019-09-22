package org.randall.teagan.Factory.CustomerBuilder;

import org.randall.teagan.Domain.Customer.Customer;

public class CustBuilder {

    public static Customer getCustomer(String customerID, String custName, String custLastName, int age, String custPhone) {
        return new Customer.Builder()
                .customerID(customerID)
                .custName(custName)
                .custLastName(custLastName)
                .age(age)
                .custPhone(custPhone)
                .build();
    }
}
