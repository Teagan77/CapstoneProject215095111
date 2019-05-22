package org.randall.teagan.Factory.EmployeeBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.Driver;

import static org.junit.Assert.*;

public class DriverBuilderTest {

    @Test
    public void getDriver() {

        String jobTitle = "Driver", positionCode = "DRV001", licenseCode = "Code C", driverID = "00000";

        Driver firstDriver = DriverBuilder.getDriver(jobTitle,positionCode,licenseCode,driverID);

        System.out.println(firstDriver);
        Assert.assertNotNull(firstDriver.getDriverPositionCode());
    }
}