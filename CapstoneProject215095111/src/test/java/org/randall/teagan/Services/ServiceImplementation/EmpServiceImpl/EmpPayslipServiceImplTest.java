package org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Employee.EmployeePayslip;
import org.randall.teagan.Factory.EmployeeBuilders.EmpPayslipBuilder;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.EmpPayslipRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpPayslipServiceImplTest {

    private EmpPayslipRepositoryImpl empPayslipRepositoryImpl;
    private EmployeePayslip firstPayslip;
    private Date date = new Date();

    private EmployeePayslip getSaved(){
        ListIterator<EmployeePayslip> listItr = this.empPayslipRepositoryImpl.getAll().listIterator();
        return listItr.next();
//        return this.customerRepositoryImpl.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.empPayslipRepositoryImpl = empPayslipRepositoryImpl.getEmpPayslipRepositoryImpl();
        this.firstPayslip = EmpPayslipBuilder.getEmpPayslip(9500.00, date, "ZXY775");
    }

    @Test
    public void a_create() {
        EmployeePayslip createdPayslip = this.empPayslipRepositoryImpl.create(this.firstPayslip);
        System.out.println("In create, created = " + createdPayslip);
        Assert.assertNotNull(createdPayslip);
        Assert.assertSame(createdPayslip, this.firstPayslip);
    }

    @Test
    public void c_update() {
        double newPay = 20000.00;
        EmployeePayslip updatedDriver = new EmployeePayslip.EmpPayslipBuilder().copy(getSaved()).grossPay(newPay).build();
        System.out.println("In update, updated = " + updatedDriver);
        this.empPayslipRepositoryImpl.update(updatedDriver);
        Assert.assertEquals(newPay, updatedDriver.getGrossPay(),1e-8);
    }

    @Test
    public void e_delete() {
        EmployeePayslip savedPayslip = getSaved();
        this.empPayslipRepositoryImpl.delete(savedPayslip.getPayslipID());
        d_getAll();
    }

    @Test
    public void b_read() {
        EmployeePayslip savedPayslip = getSaved();
        EmployeePayslip readPayslip = this.empPayslipRepositoryImpl.read(savedPayslip.getPayslipID());
        System.out.println("In read, read = "+ readPayslip);
        Assert.assertSame(readPayslip, savedPayslip);
    }

    @Test
    public void d_getAll() {
        ArrayList<EmployeePayslip> payslips = this.empPayslipRepositoryImpl.getAll();
        System.out.println("In getall, all = " + payslips);
    }
}