package org.randall.teagan.Factory.EmployeeBuilders;

import org.randall.teagan.Domain.Employee.EmployeePayslip;

import java.util.Date;

public class EmpPayslipBuilder {

    public static EmployeePayslip getEmpPayslip(double grossPay, Date payDate, String payslipID) {
        return new EmployeePayslip.EmpPayslipBuilder()
                .grossPay(grossPay)
                .payDate(payDate)
                .payslipID(payslipID)
                .build();
    }
}
