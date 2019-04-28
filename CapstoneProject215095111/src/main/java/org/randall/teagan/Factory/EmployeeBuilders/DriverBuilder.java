package org.randall.teagan.Factory.EmployeeBuilders;

import org.randall.teagan.Domain.Employee.Driver;

public class DriverBuilder {

    public static Driver getDriver(String jobTitle, String positionCode, String licenseCode, String driverID) {
        return new Driver.DriverBuilder()
                .jobTitle(jobTitle)
                .positionCode(positionCode)
                .licenseCode(licenseCode)
                .driverID(driverID)
                .build();
    }
}
