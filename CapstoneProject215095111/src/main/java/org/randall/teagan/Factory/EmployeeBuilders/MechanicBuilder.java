package org.randall.teagan.Factory.EmployeeBuilders;

import org.randall.teagan.Domain.Employee.Mechanic;

public class MechanicBuilder {

    public static Mechanic getMechanic(String jobTitle, String positionCode, String qualCode) {
        return new Mechanic.MechanicBuilder()
                .jobTitle(jobTitle)
                .positionCode(positionCode)
                .qualCode(qualCode)
                .build();
    }
}
