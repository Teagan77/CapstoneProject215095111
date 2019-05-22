package org.randall.teagan.Factory.CustomerBuilder;

import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Membership.Membership;

public class CustBuilder {

    public static Customer getCustomer(String custId, String custName, String custLName, int age, String custPhone, double custCredit, String custGender, Membership membership) {
        return new Customer.Builder()
                .custId(custId)
                .custName(custName)
                .custLName(custLName)
                .age(age)
                .custPhone(custPhone)
                .custCredit(custCredit)
                .custGender(custGender)
                .membership(membership)
                .build();
    }
}
