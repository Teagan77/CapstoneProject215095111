package org.randall.teagan.Factory.EmployeeBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.EmpContact;

import static org.junit.Assert.*;

public class EmpContactBuilderTest {

    @Test
    public void getEmpContact() {

        String phone = "0734771369";

        EmpContact firstContact = EmpContactBuilder.getEmpContact(phone);

        System.out.println(firstContact);
        Assert.assertNotNull(firstContact.getContactNo());
    }
}