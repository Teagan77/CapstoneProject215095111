package org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImplTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.EmployeePayslip;
import org.randall.teagan.Factory.EmployeeBuilders.EmpPayslipBuilder;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.EmpPayslipRepositoryImpl;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class EmpPayslipRepositoryImplTest {

    private EmpPayslipRepositoryImpl empPayslipRepositoryImpl;
    private EmpPayslipBuilder empPayslipBuilder = new EmpPayslipBuilder();

    double salary = 20000.00;
    Date date = new Date();
    String payslipID = "88844";

    double updatedSalary = 9000.00;

    double salary2 = 10000.00;
    Date date2 = new Date();
    String payslipID2 = "585954";

    EmployeePayslip firstPayslip = EmpPayslipBuilder.getEmpPayslip(salary,date,payslipID);
    EmployeePayslip updatedFirstPayslip = EmpPayslipBuilder.getEmpPayslip(updatedSalary,date,payslipID);
    EmployeePayslip seccondPayslip = EmpPayslipBuilder.getEmpPayslip(salary2,date2,payslipID2);


    @Before
    public void setUp() throws Exception {
        this.empPayslipRepositoryImpl = EmpPayslipRepositoryImpl.getEmpPayslipRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstPayslip.hashCode(), this.empPayslipRepositoryImpl.create(firstPayslip).hashCode());
        this.empPayslipRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.empPayslipRepositoryImpl.create(firstPayslip);
        this.empPayslipRepositoryImpl.update(updatedFirstPayslip);
        Assert.assertEquals(9000.00, this.empPayslipRepositoryImpl.read(updatedFirstPayslip.getPayslipID()).getGrossPay(), 1e-8);
        this.empPayslipRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.empPayslipRepositoryImpl.create(firstPayslip);
        this.empPayslipRepositoryImpl.create(seccondPayslip);
        this.empPayslipRepositoryImpl.delete(firstPayslip.getPayslipID());

        Assert.assertEquals(null, this.empPayslipRepositoryImpl.read(firstPayslip.getPayslipID()));
        this.empPayslipRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.empPayslipRepositoryImpl.create(firstPayslip);
        assertEquals(true, this.empPayslipRepositoryImpl.read(firstPayslip.getPayslipID()) instanceof EmployeePayslip);
        System.out.println(this.empPayslipRepositoryImpl.read(firstPayslip.getPayslipID()));
        this.empPayslipRepositoryImpl.removeAll();
    }

    @Test
    public void getAll() {
        this.empPayslipRepositoryImpl.create(firstPayslip);
        ArrayList<EmployeePayslip> employeePayslips = this.empPayslipRepositoryImpl.getAll();
        Assert.assertEquals(1, employeePayslips.size());
        this.empPayslipRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.empPayslipRepositoryImpl.create(firstPayslip);
        ArrayList<EmployeePayslip> employeePayslips = this.empPayslipRepositoryImpl.getAll();
        this.empPayslipRepositoryImpl.removeAll();
        Assert.assertEquals( 0,employeePayslips.size());
    }
}