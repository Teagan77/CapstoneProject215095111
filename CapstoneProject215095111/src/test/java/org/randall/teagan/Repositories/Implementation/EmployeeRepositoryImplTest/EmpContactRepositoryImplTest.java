package org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImplTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.EmpContact;
import org.randall.teagan.Factory.EmployeeBuilders.EmpContactBuilder;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.EmpContactRepositoryImpl;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EmpContactRepositoryImplTest {

    private EmpContactRepositoryImpl empContactRepositoryImpl;

    EmpContactBuilder empContactBuilder = new EmpContactBuilder();

    String firstContactNo = "0734771369";
    String updatedContactNo = "0766259878";
    String secondContactNo = "0824915567";

    EmpContact firstEmpContact = empContactBuilder.getEmpContact(firstContactNo);
    EmpContact updatedFirstEmpContact = empContactBuilder.getEmpContact(updatedContactNo);
    EmpContact secondEmpContact = empContactBuilder.getEmpContact(secondContactNo);

    @Before
    public void setUp() throws Exception {
        this.empContactRepositoryImpl = EmpContactRepositoryImpl.getEmpContactRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstEmpContact.hashCode(), this.empContactRepositoryImpl.create(firstEmpContact).hashCode());
        this.empContactRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.empContactRepositoryImpl.create(firstEmpContact);
        this.empContactRepositoryImpl.update(firstEmpContact,updatedFirstEmpContact);
        Assert.assertEquals("0766259878", this.empContactRepositoryImpl.read(updatedFirstEmpContact).getContactNo());
        this.empContactRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.empContactRepositoryImpl.create(firstEmpContact);
        this.empContactRepositoryImpl.create(secondEmpContact);
        this.empContactRepositoryImpl.delete(firstEmpContact);

        assertEquals(null, this.empContactRepositoryImpl.read(firstEmpContact));
        this.empContactRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.empContactRepositoryImpl.create(firstEmpContact);
        assertEquals(true, this.empContactRepositoryImpl.read(firstEmpContact) instanceof EmpContact);
        System.out.println(this.empContactRepositoryImpl.read(firstEmpContact));
        this.empContactRepositoryImpl.removeAll();
    }

    @Test
    public void getAll() {
        this.empContactRepositoryImpl.create(firstEmpContact);
        ArrayList<EmpContact> empContacts = this.empContactRepositoryImpl.getAll();
        assertEquals(1, empContacts.size());
        this.empContactRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.empContactRepositoryImpl.create(firstEmpContact);
        ArrayList<EmpContact> empContacts = this.empContactRepositoryImpl.getAll();
        this.empContactRepositoryImpl.removeAll();
        assertEquals( 0,empContacts.size());
    }
}