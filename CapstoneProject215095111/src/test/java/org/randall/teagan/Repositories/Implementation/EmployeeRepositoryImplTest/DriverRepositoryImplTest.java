package org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImplTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.Driver;
import org.randall.teagan.Factory.EmployeeBuilders.DriverBuilder;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.DriverRepositoryImpl;

import java.util.ArrayList;

public class DriverRepositoryImplTest {

    private DriverRepositoryImpl driverRepositoryImpl;

    DriverBuilder driverBuilder = new DriverBuilder();

    String jobTitle = "Driver", positionCode = "DRV001", licenseCode = "Code C", driverID = "00000";
    String updatedLicenseCode = "Code D";
    String jobTitle2 = "Driver", positionCode2 = "DRV001", licenseCode2 = "Code D", driverID2 = "054460";

    Driver firstDriver = driverBuilder.getDriver(jobTitle,positionCode,licenseCode,driverID);
    Driver updatedFirstDriver = driverBuilder.getDriver(jobTitle,positionCode,updatedLicenseCode,driverID);
    Driver secondDriver = driverBuilder.getDriver(jobTitle2,positionCode2,licenseCode2,driverID2);

    @Before
    public void setUp() throws Exception {
        this.driverRepositoryImpl = DriverRepositoryImpl.getDriverRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstDriver.hashCode(), this.driverRepositoryImpl.create(firstDriver).hashCode());
        this.driverRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.driverRepositoryImpl.create(firstDriver);
        this.driverRepositoryImpl.update(updatedFirstDriver);
        Assert.assertEquals("Code D", this.driverRepositoryImpl.read(updatedFirstDriver.getDriverID()).getDriverLicenseCode());
        this.driverRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.driverRepositoryImpl.create(firstDriver);
        this.driverRepositoryImpl.create(secondDriver);
        this.driverRepositoryImpl.delete(firstDriver.getDriverID());

        Assert.assertEquals(null, this.driverRepositoryImpl.read(firstDriver.getDriverID()));
        this.driverRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.driverRepositoryImpl.create(firstDriver);
        Assert.assertEquals(true, this.driverRepositoryImpl.read(firstDriver.getDriverID()) instanceof Driver);
        System.out.println(this.driverRepositoryImpl.read(firstDriver.getDriverID()));
        this.driverRepositoryImpl.removeAll();
    }

    @Test
    public void getAll() {
        this.driverRepositoryImpl.create(firstDriver);
        ArrayList<Driver> drivers = this.driverRepositoryImpl.getAll();
        Assert.assertEquals(1, drivers.size());
        this.driverRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.driverRepositoryImpl.create(firstDriver);
        ArrayList<Driver> drivers = this.driverRepositoryImpl.getAll();
        this.driverRepositoryImpl.removeAll();
        Assert.assertEquals( 0,drivers.size());
    }
}