package org.randall.teagan.Factory.CustomerBuilder;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Factory.CustomerBuilder.CustBuilder;

public class CustBuilderTest {

    @Test
    public void getCustomer() {
        String name = "Teagan";
        String surname = "Randall";
        String phone = "0734771369";
        int custAge = 22;
        String id = "215095111";
        double credit = 0.0;
        String gender = "male";
        Membership membership = new Membership();

        Customer firstCust = CustBuilder.getCustomer(id, name, surname, custAge, phone, credit, gender, membership);

        System.out.println(firstCust);
        Assert.assertNotNull(firstCust.getCustId());
    }
}