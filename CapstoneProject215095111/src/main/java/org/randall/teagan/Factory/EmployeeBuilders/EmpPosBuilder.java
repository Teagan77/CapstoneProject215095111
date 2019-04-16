package org.randall.teagan.Factory.EmployeeBuilders;

import org.randall.teagan.Domain.Employee.EmployeePosition;

public class EmpPosBuilder {

    public static EmployeePosition getEmpPos(String jobTitle, String positionCode) {
        return new EmployeePosition.EmployeePositionBuilder()
                .jobTitle(jobTitle)
                .positionCode(positionCode)
                .build();
    }
}
