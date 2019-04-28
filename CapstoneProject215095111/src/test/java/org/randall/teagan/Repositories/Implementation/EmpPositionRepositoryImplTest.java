package org.randall.teagan.Repositories.Implementation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.EmployeePosition;
import org.randall.teagan.Factory.EmployeeBuilders.EmpPosBuilder;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class EmpPositionRepositoryImplTest {

    EmpPositionRepositoryImpl empPositionRepositoryImpl;
    EmpPosBuilder empPosBuilder = new EmpPosBuilder();

    String jobTitle = "Manager", posCode = "MGR001";
    String updatedJobTitle = "Mechanic";
    String jobTitle2 = "IssueStaff", posCode2 = "ISS004";

    EmployeePosition firstEmpPos = empPosBuilder.getEmpPos(jobTitle,posCode);
    EmployeePosition updatedFirstEmpPos = empPosBuilder.getEmpPos(updatedJobTitle,posCode);
    EmployeePosition secondEmpPos = empPosBuilder.getEmpPos(jobTitle2,posCode2);

    @Before
    public void setUp() throws Exception {
        this.empPositionRepositoryImpl = EmpPositionRepositoryImpl.getEmpPositionRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstEmpPos.hashCode(), this.empPositionRepositoryImpl.create(firstEmpPos).hashCode());
        this.empPositionRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.empPositionRepositoryImpl.create(firstEmpPos);
        this.empPositionRepositoryImpl.update(updatedFirstEmpPos);
        Assert.assertEquals("Mechanic", this.empPositionRepositoryImpl.read(updatedFirstEmpPos.getPositionCode()).getJobTitle());
        this.empPositionRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.empPositionRepositoryImpl.create(firstEmpPos);
        this.empPositionRepositoryImpl.create(secondEmpPos);
        this.empPositionRepositoryImpl.delete(firstEmpPos.getPositionCode());

        Assert.assertEquals(null, this.empPositionRepositoryImpl.read(firstEmpPos.getPositionCode()));
        this.empPositionRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.empPositionRepositoryImpl.create(firstEmpPos);
        assertEquals(true, this.empPositionRepositoryImpl.read(firstEmpPos.getPositionCode()) instanceof EmployeePosition);
        System.out.println(this.empPositionRepositoryImpl.read(firstEmpPos.getPositionCode()));
        this.empPositionRepositoryImpl.removeAll();
    }

    @Test
    public void getAll() {
        this.empPositionRepositoryImpl.create(firstEmpPos);
        ArrayList<EmployeePosition> empPos = this.empPositionRepositoryImpl.getAll();
        assertEquals(1, empPos.size());
        this.empPositionRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.empPositionRepositoryImpl.create(firstEmpPos);
        ArrayList<EmployeePosition> empPos = this.empPositionRepositoryImpl.getAll();
        this.empPositionRepositoryImpl.removeAll();
        assertEquals( 0,empPos.size());
    }
}