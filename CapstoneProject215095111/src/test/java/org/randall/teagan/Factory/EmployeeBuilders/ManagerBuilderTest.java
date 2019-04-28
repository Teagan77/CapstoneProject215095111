package org.randall.teagan.Factory.EmployeeBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.Manager;

import static org.junit.Assert.*;

public class ManagerBuilderTest {

    @Test
    public void getManager() {
        String jobTitle = "IssueStaff";
        String positionCode = "IS002";
        String qualCode = "BTECH5520";
        String managerID = "48464";

        Manager firstManager = ManagerBuilder.getManager(jobTitle,positionCode,qualCode,managerID);

        System.out.println(firstManager);
        Assert.assertNotNull(firstManager.getQualCode());
    }
}