package org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImplTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Employee.Mechanic;
import org.randall.teagan.Factory.EmployeeBuilders.MechanicBuilder;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.MechanicRepositoryImpl;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MechanicRepositoryImplTest {

    private MechanicRepositoryImpl mechanicRepositoryImpl;
    private MechanicBuilder mechanicBuilder = new MechanicBuilder();

    String jobTitle = "Mechanic";
    String positionCode = "ME003";
    String qualCode = "NDIPMECHENG";
    String mechanicID = "UH087807";

    String updatedPosCode = "MECH09";

    String jobTitle2 = "Mechanic";
    String positionCode2 = "ME003";
    String qualCode2 = "NDIPMECHENG";
    String mechanicID2 = "HF09707";

    Mechanic firstMech = MechanicBuilder.getMechanic(jobTitle,positionCode,qualCode, mechanicID);
    Mechanic updatedFirstMecahnic = MechanicBuilder.getMechanic(jobTitle,updatedPosCode,qualCode, mechanicID);
    Mechanic secondMech = MechanicBuilder.getMechanic(jobTitle2,positionCode2,qualCode2, mechanicID2);


    @Before
    public void setUp() throws Exception {
        this.mechanicRepositoryImpl = MechanicRepositoryImpl.getMechanicRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstMech.hashCode(), this.mechanicRepositoryImpl.create(firstMech).hashCode());
        this.mechanicRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.mechanicRepositoryImpl.create(firstMech);
        this.mechanicRepositoryImpl.update(updatedFirstMecahnic);
        Assert.assertEquals("MECH09", this.mechanicRepositoryImpl.read(updatedFirstMecahnic.getMechanicID()).getPositionCode());
        this.mechanicRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.mechanicRepositoryImpl.create(firstMech);
        this.mechanicRepositoryImpl.create(secondMech);
        this.mechanicRepositoryImpl.delete(firstMech.getMechanicID());

        Assert.assertEquals(null, this.mechanicRepositoryImpl.read(firstMech.getMechanicID()));
        this.mechanicRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.mechanicRepositoryImpl.create(firstMech);
        assertEquals(true, this.mechanicRepositoryImpl.read(firstMech.getMechanicID()) instanceof Mechanic);
        System.out.println(this.mechanicRepositoryImpl.read(firstMech.getMechanicID()));
        this.mechanicRepositoryImpl.removeAll();
    }

    @Test
    public void getAll() {
        this.mechanicRepositoryImpl.create(firstMech);
        ArrayList<Mechanic> mechanics = this.mechanicRepositoryImpl.getAll();
        assertEquals(1, mechanics.size());
        this.mechanicRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.mechanicRepositoryImpl.create(firstMech);
        ArrayList<Mechanic> mechanics = this.mechanicRepositoryImpl.getAll();
        this.mechanicRepositoryImpl.removeAll();
        assertEquals( 0,mechanics.size());
    }
}