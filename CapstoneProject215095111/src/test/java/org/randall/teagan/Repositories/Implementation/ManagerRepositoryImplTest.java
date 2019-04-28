package org.randall.teagan.Repositories.Implementation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.Manager;
import org.randall.teagan.Factory.EmployeeBuilders.ManagerBuilder;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ManagerRepositoryImplTest {

    private ManagerRepositoryImpl managerRepositoryImpl;

    ManagerBuilder managerBuilder = new ManagerBuilder();

    String jobTitle = "Manager";
    String positionCode = "IS002";
    String qualCode = "BTECH5520";
    String managerID = "48464";

    String updatedQualCode = "CD4FV";

    String jobTitle2 = "Manager";
    String positionCode2 = "IS005";
    String qualCode2 = "BTECH4420";
    String managerID2 = "56165";

    Manager firstManager = managerBuilder.getManager(jobTitle,positionCode,qualCode,managerID);
    Manager updatedFirstManager = managerBuilder.getManager(jobTitle,positionCode,updatedQualCode,managerID);
    Manager secondManager = managerBuilder.getManager(jobTitle2,positionCode2,qualCode2,managerID2);


    @Before
    public void setUp() throws Exception {
        this.managerRepositoryImpl = ManagerRepositoryImpl.getManagerRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstManager.hashCode(), this.managerRepositoryImpl.create(firstManager).hashCode());
        this.managerRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.managerRepositoryImpl.create(firstManager);
        this.managerRepositoryImpl.update(updatedFirstManager);
        Assert.assertEquals("CD4FV", this.managerRepositoryImpl.read(updatedFirstManager.getManagerID()).getQualCode());
        this.managerRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.managerRepositoryImpl.create(firstManager);
        this.managerRepositoryImpl.create(secondManager);
        this.managerRepositoryImpl.delete(firstManager.getManagerID());

        Assert.assertEquals(null, this.managerRepositoryImpl.read(firstManager.getManagerID()));
        this.managerRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.managerRepositoryImpl.create(firstManager);
        assertEquals(true, this.managerRepositoryImpl.read(firstManager.getManagerID()) instanceof Manager);
        System.out.println(this.managerRepositoryImpl.read(firstManager.getManagerID()));
        this.managerRepositoryImpl.removeAll();
    }

    @Test
    public void getAll() {
        this.managerRepositoryImpl.create(firstManager);
        ArrayList<Manager> managers = this.managerRepositoryImpl.getAll();
        assertEquals(1, managers.size());
        this.managerRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.managerRepositoryImpl.create(firstManager);
        ArrayList<Manager> managers = this.managerRepositoryImpl.getAll();
        this.managerRepositoryImpl.removeAll();
        assertEquals( 0,managers.size());
    }
}