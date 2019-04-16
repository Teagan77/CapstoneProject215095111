package org.randall.teagan.Factory.EmployeeBuilders;

import org.randall.teagan.Domain.Employee.*;

public class EmpBuilder {

    public static Employee getEmployee(String empId, String empName, String empSurname, int empAge, String empGender, EmployeePosition empPos, EmployeePayslip empPay, EmpAddress empAddress, EmpContact empContact) {
        return new Employee.EmpBuilder()
                .empId(empId)
                .empName(empName)
                .empSurname(empSurname)
                .empAge(empAge)
                .empGender(empGender)
                .empPos(empPos)
                .empPay(empPay)
                .empAddress(empAddress)
                .empContact(empContact)
                .build();
    }
}
