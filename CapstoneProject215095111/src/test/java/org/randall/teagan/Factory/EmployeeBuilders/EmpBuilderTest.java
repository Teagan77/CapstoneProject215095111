package org.randall.teagan.Factory.EmployeeBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.*;

import java.util.Date;

import static org.junit.Assert.*;

public class EmpBuilderTest {

    @Test
    public void getEmployee() {

        String name = "Teagan";
        String surname = "Randall";
        String phone = "0734771369";
        int age = 22;
        String id = "215095111";
        double pay = 20000.00;
        String gender = "male";
        Date date = new Date();
        String jobTitle = "Manager";
        String posCode = "MGR000";
        String physicalAddress = "1 Gore Street, DeZonnebloem";
        int postalAddress = 5280;
        int postalCode = 4280;
        String contactNo = "0725986625";
        String payslipID = "54655";

        EmployeePosition position = EmpPosBuilder.getEmpPos(jobTitle, posCode);
        EmployeePayslip payslip = EmpPayslipBuilder.getEmpPayslip(pay, date, payslipID);
        EmpAddress address = EmpAddressBuilder.getEmpAddress(physicalAddress, postalAddress, postalCode);
        EmpContact contact = EmpContactBuilder.getEmpContact(contactNo);

        Employee firstEmp = EmpBuilder.getEmployee(id, name, surname, age, gender, position, payslip, address, contact);

        System.out.println(firstEmp);
        Assert.assertNotNull(firstEmp.getEmpId());
    }
}