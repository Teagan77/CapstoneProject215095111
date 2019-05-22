package org.randall.teagan.Domain;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Domain.Membership.StudentMember;
import org.randall.teagan.Factory.CustomerBuilder.CustBuilder;

public class CustomerTest {

    String name = "Teagan";
    String surname = "Randall";
    String phone = "0734771369";
    int age = 22;
    String id = "215095111";
    double credit = 0.0;
    String gender = "male";
    Membership membership = new Membership();

    Customer firstCust = CustBuilder.getCustomer(id, name, surname, age, phone, credit, gender, membership) ;

    @Test
    public void getCustId() {
        assertEquals("getCustId() will return String value '215095111'.","215095111", firstCust.getCustId());
        assertEquals(firstCust.getCustId() instanceof String, true);
    }

    @Test
    public void getCustPhone() {
        assertEquals("getCustPhone() will return String value '0734771369'.","0734771369", firstCust.getCustPhone());
        assertEquals(firstCust.getCustPhone() instanceof String, true);
    }

    @Test
    public void getCustName() {
        assertEquals("getCustName() will return String value 'Teagan'.","Teagan", firstCust.getCustName());
        assertEquals(firstCust.getCustName() instanceof String, true);
    }

    @Test
    public void getCustLastName() {
        assertEquals("getCustLastName() will return String value 'Randall'.","Randall", firstCust.getCustLastName());
        assertEquals(firstCust.getCustLastName() instanceof String, true);
    }

    @Test
    public void getAge() {
        assertEquals("getAge() will return an Integer value '22'.",22, firstCust.getCustAge());
        assertEquals(Integer.class.isInstance(firstCust.getCustAge()),true);
    }

    @Test
    public void getCredit() {
        final double delta = 1e-15;
        assertEquals("getCredit() will return an Double value '0.0'.",0.0, firstCust.getCustCredit(), delta);
        assertEquals(Double.class.isInstance(firstCust.getCustCredit()),true);
    }

    @Test
    public void getGender() {
        assertEquals("getGender() will return a String value 'male'.", "male",firstCust.getCustGender());
        assertEquals(firstCust.getCustGender() instanceof String, true);
    }

    @Test
    public void getMembership() {
        //TODO add tests for membership
    }
}