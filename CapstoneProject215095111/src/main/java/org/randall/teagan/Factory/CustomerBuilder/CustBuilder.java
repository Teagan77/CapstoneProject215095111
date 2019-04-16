package org.randall.teagan.Factory.CustomerBuilder;

import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Membership.Membership;

public class CustBuilder {

    public static Customer getCustomer(String custId, String custPhone, String custName, String custLastName, int age, double custCredit, String custGender, Membership membership) {
        return new Customer.Builder()
                .age(age)
                .custId(custId)
                .custPhone(custPhone)
                .custName(custName)
                .custLastName(custLastName)
                .custCredit(custCredit)
                .custGender(custGender)
                .membership(membership)
                .build();
    }
}
