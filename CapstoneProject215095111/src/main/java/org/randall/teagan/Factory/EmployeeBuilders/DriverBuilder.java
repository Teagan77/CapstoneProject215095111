package org.randall.teagan.Factory.EmployeeBuilders;

import org.randall.teagan.Domain.Employee.Driver;

public class DriverBuilder {

    public static Driver getDriver(String jobTitleDriver, String positionCodeDriver, String licenseCode, String driverID) {
        return new Driver.DriverBuilder()
                .jobTitleDriver(jobTitleDriver)
                .positionCodeDriver(positionCodeDriver)
                .licenseCode(licenseCode)
                .driverID(driverID)
                .build();
    }
}
