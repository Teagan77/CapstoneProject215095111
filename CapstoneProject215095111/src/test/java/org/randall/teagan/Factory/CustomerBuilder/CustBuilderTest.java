package org.randall.teagan.Factory.CustomerBuilder;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Customer.Customer;

public class CustBuilderTest {

    @Test
    public void getCustomer() {
        String name = "Teagan";
        String surname = "Randall";
        String phone = "0734771369";
        int custAge = 22;
        String id = "215095111";

        Customer firstCust = CustBuilder.getCustomer(id, name, surname, custAge, phone);

        System.out.println(firstCust);
        Assert.assertNotNull(firstCust.getcustomerID());
    }
}