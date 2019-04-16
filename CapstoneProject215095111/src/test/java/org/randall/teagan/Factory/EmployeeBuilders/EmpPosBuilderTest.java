package org.randall.teagan.Factory.EmployeeBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.EmployeePosition;

import static org.junit.Assert.*;

public class EmpPosBuilderTest {

    @Test
    public void getEmpPos() {
        String jobTitle = "Default Jobtitle.", posCode = "DEF0000";

        EmployeePosition position = EmpPosBuilder.getEmpPos(jobTitle,posCode);

        System.out.println(position);
        Assert.assertNotNull(position.getJobTitle());
    }
}