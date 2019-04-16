package org.randall.teagan.Factory.EmployeeBuilders;

import org.randall.teagan.Domain.Employee.Manager;

public class ManagerBuilder {

    public static Manager getManager(String jobTitle, String positionCode, String qualCode) {
        return new Manager.ManagerBuilder()
                .jobTitle(jobTitle)
                .positionCode(positionCode)
                .qualCode(qualCode)
                .build();
    }
}
