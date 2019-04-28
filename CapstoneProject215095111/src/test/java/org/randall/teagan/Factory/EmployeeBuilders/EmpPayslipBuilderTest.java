package org.randall.teagan.Factory.EmployeeBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.EmployeePayslip;

import java.util.Date;

import static org.junit.Assert.*;

public class EmpPayslipBuilderTest {

    @Test
    public void getEmpPayslip() {

        double salary = 20000.00;
        Date date = new Date();
        String payslipID = "88844";

        EmployeePayslip firstPayslip = EmpPayslipBuilder.getEmpPayslip(salary,date,payslipID);

        System.out.println(firstPayslip);
        Assert.assertNotNull(firstPayslip.getPayDate());
    }
}