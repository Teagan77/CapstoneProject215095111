package org.randall.teagan.Factory.EmployeeBuilders;

import org.randall.teagan.Domain.Employee.EmpContact;

public class EmpContactBuilder {

    public static EmpContact getEmpContact(String contactNo) {
        return new EmpContact.EmpContactBuilder()
                .contactNo(contactNo)
                .build();
    }
}
