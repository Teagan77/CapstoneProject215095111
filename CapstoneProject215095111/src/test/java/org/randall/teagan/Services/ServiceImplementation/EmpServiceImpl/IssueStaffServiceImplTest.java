package org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Employee.IssueStaff;
import org.randall.teagan.Factory.EmployeeBuilders.IssueStaffBuilder;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.IssueStaffRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.ListIterator;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class IssueStaffServiceImplTest {

    private IssueStaffRepositoryImpl issueStaffRepositoryImpl;
    private IssueStaff firstIssueStaff;

    private IssueStaff getSaved(){
        ListIterator<IssueStaff> listItr = this.issueStaffRepositoryImpl.getAll().listIterator();
        return listItr.next();
//        return this.customerRepositoryImpl.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.issueStaffRepositoryImpl = IssueStaffRepositoryImpl.getIssueStaffRepositoryImpl();
        this.firstIssueStaff = IssueStaffBuilder.getIssueStaff("IssueStaff", "ISS002", "18152987");
    }
    @Test
    public void a_create() {
        IssueStaff createdIssueStaff = this.issueStaffRepositoryImpl.create(this.firstIssueStaff);
        System.out.println("In create, created = " + createdIssueStaff);
        Assert.assertNotNull(createdIssueStaff);
        Assert.assertSame(createdIssueStaff, this.firstIssueStaff);
    }

    @Test
    public void c_update() {
        String newPosCode = "ISS989";
        IssueStaff updatedDriver = new IssueStaff.IssueStaffBuilder().copy(getSaved()).positionCodeIssueStaff(newPosCode).build();
        System.out.println("In update, updated = " + updatedDriver);
        this.issueStaffRepositoryImpl.update(updatedDriver);
        Assert.assertSame(newPosCode, updatedDriver.getPositionCodeIssueStaff());
    }

    @Test
    public void e_delete() {
        IssueStaff savedIssueStaff = getSaved();
        this.issueStaffRepositoryImpl.delete(savedIssueStaff.getIssuerNo());
        d_getAll();
    }

    @Test
    public void b_read() {
        IssueStaff savedIssueStaff = getSaved();
        IssueStaff readIssueStaff = this.issueStaffRepositoryImpl.read(savedIssueStaff.getIssuerNo());
        System.out.println("In read, read = "+ readIssueStaff);
        Assert.assertSame(readIssueStaff, savedIssueStaff);
    }

    @Test
    public void d_getAll() {
        ArrayList<IssueStaff> issueStaff = this.issueStaffRepositoryImpl.getAll();
        System.out.println("In getall, all = " + issueStaff);
    }
}