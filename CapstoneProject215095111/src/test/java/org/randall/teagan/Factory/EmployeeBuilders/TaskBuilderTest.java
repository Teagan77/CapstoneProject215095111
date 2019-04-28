package org.randall.teagan.Factory.EmployeeBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.*;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class TaskBuilderTest {

    @Test
    public void getEmpTask() {

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
        String qualCode = "BTECHBSMGM";
        String physicalAddress = "1 Gore Street, DeZonnebloem";
        int postalAddress = 5280;
        int postalCode = 4280;
        String contactNo = "0725986625";
        String taskDesc = "A task.";
        String taskNo = "76392";
        String managerID = "46846";
        String payslipID = "65464";

        EmployeePosition position = EmpPosBuilder.getEmpPos(jobTitle,posCode);
        EmployeePayslip payslip = EmpPayslipBuilder.getEmpPayslip(pay, date,payslipID);
        EmpAddress address = EmpAddressBuilder.getEmpAddress(physicalAddress, postalAddress, postalCode);
        EmpContact contact = EmpContactBuilder.getEmpContact(contactNo);

        Employee firstEmp = EmpBuilder.getEmployee(id,name,surname,age,gender,position,payslip,address,contact);
        Manager firstManager = ManagerBuilder.getManager(jobTitle,posCode,qualCode, managerID);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(firstEmp);

        Task task = TaskBuilder.getEmpTask(firstManager,employees, taskDesc,date,taskNo);

        System.out.println(task);
        Assert.assertNotNull(task.getEmployees());
    }
}