package org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Employee.*;
import org.randall.teagan.Factory.EmployeeBuilders.*;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.EmployeeRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;


@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpServiceImplTest {

    private EmployeeRepositoryImpl employeeRepositoryImpl;
    private Employee firstEmp;
    private EmployeePosition employeePosition;
    private EmployeePayslip employeePayslip;
    private EmpAddress empAddress;
    private EmpContact empContact;

    private Employee getSaved(){
        ListIterator<Employee> listItr = this.employeeRepositoryImpl.getAll().listIterator();
        return listItr.next();
//        return this.customerRepositoryImpl.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {

        this.employeeRepositoryImpl = EmployeeRepositoryImpl.getEmployeeRepositoryImpl();
        this.employeePosition = EmpPosBuilder.getEmpPos("Driver", "DRV005");
        Date date = new Date();
        this.employeePayslip = EmpPayslipBuilder.getEmpPayslip(10000.00, date, "BTFO96");
        this.empContact = EmpContactBuilder.getEmpContact("076258973");
        this.empAddress = EmpAddressBuilder.getEmpAddress("1 Plein St Zonnebloem", 5205, 4209);
        this.firstEmp = EmpBuilder.getEmployee("215095111", "Teagan", "Randall", 23, "Male",employeePosition, employeePayslip, empAddress, empContact);
    }

    @Test
    public void a_create() {
        Employee createdEmployee = this.employeeRepositoryImpl.create(this.firstEmp);
        System.out.println("In create, created = " + createdEmployee);
        Assert.assertNotNull(createdEmployee);
        Assert.assertSame(createdEmployee, this.firstEmp);
    }

    @Test
    public void c_update() {
        String newName = "Jeff";
        Employee updatedEmp = new Employee.EmpBuilder().copy(getSaved()).empName(newName).build();
        System.out.println("In update, updated = " + updatedEmp);
        this.employeeRepositoryImpl.update(updatedEmp);
        Assert.assertSame(newName, updatedEmp.getEmpName());
    }

    @Test
    public void e_delete() {
        Employee savedEmployee = getSaved();
        this.employeeRepositoryImpl.delete(savedEmployee.getEmpId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Employee savedEmployee = getSaved();
        Employee readEmployee = this.employeeRepositoryImpl.read(savedEmployee.getEmpId());
        System.out.println("In read, read = "+ readEmployee);
        Assert.assertSame(readEmployee, savedEmployee);
    }

    @Test
    public void d_getAll() {
        ArrayList<Employee> employees = this.employeeRepositoryImpl.getAll();
        System.out.println("In getall, all = " + employees);
    }
}