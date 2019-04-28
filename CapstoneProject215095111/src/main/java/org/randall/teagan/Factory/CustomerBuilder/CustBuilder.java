package org.randall.teagan.Factory.CustomerBuilder;

import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Membership.Membership;

public class CustBuilder {

    public static Customer getCustomer(String custId, String custPhone,int age, String custName, String custLastName, double custCredit, String custGender, Membership membership) {
        return new Customer.Builder()
                .custId(custId)
                .custPhone(custPhone)
                .age(age)
                .custName(custName)
                .custLastName(custLastName)
                .custCredit(custCredit)
                .custGender(custGender)
                .membership(membership)
                .build();
    }
}
