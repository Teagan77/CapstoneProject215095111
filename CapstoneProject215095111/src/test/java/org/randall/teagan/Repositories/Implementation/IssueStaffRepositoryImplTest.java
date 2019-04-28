package org.randall.teagan.Repositories.Implementation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.IssueStaff;
import org.randall.teagan.Factory.EmployeeBuilders.IssueStaffBuilder;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class IssueStaffRepositoryImplTest {

    private IssueStaffRepositoryImpl issueStaffRepositoryImpl;

    private IssueStaffBuilder issueStaffBuilder = new IssueStaffBuilder();

    String jobTitle = "IssueStaff";
    String positionCode = "IS002";
    String issuerNo = "5520";

    String updatedPositionCode = "ISS05";

    String jobTitle2 = "IssueStaff";
    String positionCode2 = "IS002";
    String issuerNo2 = "5659";

    IssueStaff firstStaff = IssueStaffBuilder.getIssueStaff(jobTitle,positionCode,issuerNo);
    IssueStaff updatedFirstStaff = IssueStaffBuilder.getIssueStaff(jobTitle,updatedPositionCode,issuerNo);
    IssueStaff secondStaff = IssueStaffBuilder.getIssueStaff(jobTitle2,positionCode2,issuerNo2);


    @Before
    public void setUp() throws Exception {
        this.issueStaffRepositoryImpl = IssueStaffRepositoryImpl.getIssueStaffRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstStaff.hashCode(), this.issueStaffRepositoryImpl.create(firstStaff).hashCode());
        this.issueStaffRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.issueStaffRepositoryImpl.create(firstStaff);
        this.issueStaffRepositoryImpl.update(updatedFirstStaff);
        Assert.assertEquals("ISS05", this.issueStaffRepositoryImpl.read(updatedFirstStaff.getIssuerNo()).getPositionCode());
        this.issueStaffRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.issueStaffRepositoryImpl.create(firstStaff);
        this.issueStaffRepositoryImpl.create(secondStaff);
        this.issueStaffRepositoryImpl.delete(firstStaff.getIssuerNo());

        assertEquals(null, this.issueStaffRepositoryImpl.read(firstStaff.getIssuerNo()));
        this.issueStaffRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.issueStaffRepositoryImpl.create(firstStaff);
        assertEquals(true, this.issueStaffRepositoryImpl.read(firstStaff.getIssuerNo()) instanceof IssueStaff);
        System.out.println(this.issueStaffRepositoryImpl.read(firstStaff.getIssuerNo()));
        this.issueStaffRepositoryImpl.removeAll();
    }

    @Test
    public void getAll() {
        this.issueStaffRepositoryImpl.create(firstStaff);
        ArrayList<IssueStaff> issueStaffs = this.issueStaffRepositoryImpl.getAll();
        Assert.assertEquals(1, issueStaffs.size());
        this.issueStaffRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.issueStaffRepositoryImpl.create(firstStaff);
        ArrayList<IssueStaff> issueStaffs = this.issueStaffRepositoryImpl.getAll();
        this.issueStaffRepositoryImpl.removeAll();
        assertEquals( 0,issueStaffs.size());
    }
}