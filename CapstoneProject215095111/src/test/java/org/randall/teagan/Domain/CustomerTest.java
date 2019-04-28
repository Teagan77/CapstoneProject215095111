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

    Customer firstCust = CustBuilder.getCustomer(id, phone, age, name, surname, credit, gender, membership) ;

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
        assertEquals("getCustName() will return String value 'Teagan'.","Teagan", firstCust.getName());
        assertEquals(firstCust.getName() instanceof String, true);
    }

    @Test
    public void getCustLastName() {
        assertEquals("getCustLastName() will return String value 'Randall'.","Randall", firstCust.getSurname());
        assertEquals(firstCust.getSurname() instanceof String, true);
    }

    @Test
    public void getAge() {
        assertEquals("getAge() will return an Integer value '22'.",22, firstCust.getAge());
        assertEquals(Integer.class.isInstance(firstCust.getAge()),true);
    }

    @Test
    public void getCredit() {
        final double delta = 1e-15;
        assertEquals("getCredit() will return an Double value '0.0'.",0.0, firstCust.getCredit(), delta);
        assertEquals(Double.class.isInstance(firstCust.getCredit()),true);
    }

    @Test
    public void getGender() {
        assertEquals("getGender() will return a String value 'male'.", "male",firstCust.getGender());
        assertEquals(firstCust.getGender() instanceof String, true);
    }

    @Test
    public void getMembership() {
        //TODO add tests for membership
    }
}