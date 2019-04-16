package org.randall.teagan.Factory.EmployeeBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.IssueStaff;

import static org.junit.Assert.*;

public class IssueStaffBuilderTest {

    @Test
    public void getIssueStaff() {

        String jobTitle = "IssueStaff";
        String positionCode = "IS002";
        String issuerNo = "5520";

        IssueStaff firstStaff = IssueStaffBuilder.getIssueStaff(jobTitle,positionCode,issuerNo);

        System.out.println(firstStaff);
        Assert.assertNotNull(firstStaff.getIssuerNo());
    }
}