package org.randall.teagan.Factory;

import org.randall.teagan.Domain.Customer;

public class CustBuilder {

    public static Customer getCustomer(String custId, String custPhone,String custName, String custLastName, int age, double custCredit) {
        return new Customer.Builder()
                .age(age)
                .custId(custId)
                .custPhone(custPhone)
                .custName(custName)
                .custLastName(custLastName)
                .custCredit(custCredit)
                .build();
    }
}
