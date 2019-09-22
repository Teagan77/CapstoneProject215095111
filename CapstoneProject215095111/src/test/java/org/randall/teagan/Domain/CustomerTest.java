package org.randall.teagan.Domain;

import org.junit.Test;

import static org.junit.Assert.*;

import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Factory.CustomerBuilder.CustBuilder;

public class CustomerTest {

    private String name = "Teagan";
    private String surname = "Randall";
    private String phone = "0734771369";
    private int age = 22;
    private String id = "215095111";

    private Customer firstCust = CustBuilder.getCustomer(id, name, surname, age, phone);

    @Test
    public void getcustomerID() {
        assertEquals("getcustomerID() will return String value '215095111'.", "215095111", firstCust.getcustomerID());
        assertNotNull(firstCust.getcustomerID());
    }

    @Test
    public void getCustPhone() {
        assertEquals("getCustPhone() will return String value '0734771369'.", "0734771369", firstCust.getCustPhone());
        assertNotNull(firstCust.getCustPhone());
    }

    @Test
    public void getCustName() {
        assertEquals("getCustName() will return String value 'Teagan'.", "Teagan", firstCust.getCustName());
        assertNotNull(firstCust.getCustName());
    }

    @Test
    public void getCustLastName() {
        assertEquals("getCustLastName() will return String value 'Randall'.", "Randall", firstCust.getCustLastName());
        assertNotNull(firstCust.getCustLastName());
    }

    @Test
    public void getAge() {
        assertEquals("getAge() will return an Integer value '22'.", 22, firstCust.getCustAge());
        assertTrue(Integer.class.isInstance(firstCust.getCustAge()));
    }
}