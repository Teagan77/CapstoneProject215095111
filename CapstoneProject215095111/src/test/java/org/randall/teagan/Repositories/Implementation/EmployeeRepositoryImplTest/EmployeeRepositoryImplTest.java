package org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImplTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.*;
import org.randall.teagan.Factory.EmployeeBuilders.*;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.EmployeeRepositoryImpl;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class EmployeeRepositoryImplTest {

    private EmployeeRepositoryImpl employeeRepositoryImpl;

    EmpBuilder empBuilder = new EmpBuilder();

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

    String updatedName = "Eric";
    String payslipID = "44994";

    EmployeePosition position = EmpPosBuilder.getEmpPos(jobTitle,posCode);
    EmployeePayslip payslip = EmpPayslipBuilder.getEmpPayslip(pay, date,payslipID);
    EmpAddress address = EmpAddressBuilder.getEmpAddress(physicalAddress, postalAddress, postalCode);
    EmpContact contact = EmpContactBuilder.getEmpContact(contactNo);

    String name2 = "DK";
    String surname2 = "Randall";
    String phone2 = "07256877989";
    int age2 = 20;
    String id2 = "214122253";
    double pay2 = 10000.00;
    String gender2 = "male";
    Date date2 = new Date();
    String jobTitle2 = "Driver";
    String posCode2 = "DR003";
    String physicalAddress2 = "12 Cherry Street, Sekunda";
    int postalAddress2 = 9824;
    int postalCode2 = 5698;
    String contactNo2 = "0725694545";
    String payslipID2 = "4658486";

    EmployeePosition position2 = EmpPosBuilder.getEmpPos(jobTitle2,posCode2);
    EmployeePayslip payslip2 = EmpPayslipBuilder.getEmpPayslip(pay2, date2,payslipID2);
    EmpAddress address2 = EmpAddressBuilder.getEmpAddress(physicalAddress2, postalAddress2, postalCode2);
    EmpContact contact2 = EmpContactBuilder.getEmpContact(contactNo2);

    Employee firstEmp = EmpBuilder.getEmployee(id,name,surname,age,gender,position,payslip,address,contact);
    Employee updatedFirstEmp = EmpBuilder.getEmployee(id,updatedName,surname,age,gender,position,payslip,address,contact);
    Employee secondEmp = EmpBuilder.getEmployee(id2,name2, surname2,age2, gender2, position2, payslip2, address2, contact2);


    @Before
    public void setUp() throws Exception {
        this.employeeRepositoryImpl = EmployeeRepositoryImpl.getEmployeeRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstEmp.hashCode(), this.employeeRepositoryImpl.create(firstEmp).hashCode());
        this.employeeRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.employeeRepositoryImpl.create(firstEmp);
        this.employeeRepositoryImpl.update(updatedFirstEmp);
        assertEquals("Eric", this.employeeRepositoryImpl.read(updatedFirstEmp.getEmpId()).getEmpName());
        this.employeeRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.employeeRepositoryImpl.create(firstEmp);
        this.employeeRepositoryImpl.create(secondEmp);
        this.employeeRepositoryImpl.delete(firstEmp.getEmpId());

        assertEquals(null, this.employeeRepositoryImpl.read(firstEmp.getEmpId()));
        this.employeeRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.employeeRepositoryImpl.create(firstEmp);
        assertEquals(true, this.employeeRepositoryImpl.read(firstEmp.getEmpId()) instanceof Employee);
        System.out.println(this.employeeRepositoryImpl.read(firstEmp.getEmpId()));
        this.employeeRepositoryImpl.removeAll();
    }

    @Test
    public void getAll() {
        this.employeeRepositoryImpl.create(firstEmp);
        ArrayList<Employee> employees = this.employeeRepositoryImpl.getAll();
        assertEquals(1, employees.size());
        this.employeeRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.employeeRepositoryImpl.create(firstEmp);
        ArrayList<Employee> employees = this.employeeRepositoryImpl.getAll();
        this.employeeRepositoryImpl.removeAll();
        assertEquals( 0,employees.size());
    }
}