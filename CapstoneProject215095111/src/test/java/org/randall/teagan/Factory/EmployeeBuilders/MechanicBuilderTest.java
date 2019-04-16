package org.randall.teagan.Factory.EmployeeBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.Mechanic;

import static org.junit.Assert.*;

public class MechanicBuilderTest {

    @Test
    public void getMechanic() {
        String jobTitle = "Mechanic";
        String positionCode = "ME003";
        String qualCode = "NDIPMECHENG";

        Mechanic firstMech = MechanicBuilder.getMechanic(jobTitle,positionCode,qualCode);

        System.out.println(firstMech);
        Assert.assertNotNull(firstMech.getQualCode());
    }
}