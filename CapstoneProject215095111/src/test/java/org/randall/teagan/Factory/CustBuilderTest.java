package org.randall.teagan.Factory;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Customer;

import static org.junit.Assert.*;

public class CustBuilderTest {

    @Test
    public void getCustomer() {
        String name = "Teagan";
        String surname = "Randall";
        String phone = "0734771369";
        int age = 22;
        String id = "215095111";
        double credit = 0.0;

        Customer firstCust = CustBuilder.getCustomer(id,name,surname,phone,age,credit);

        System.out.println(firstCust);
        Assert.assertNotNull(firstCust.getCustId());
    }
}