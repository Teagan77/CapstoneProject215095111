package org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Employee.Mechanic;
import org.randall.teagan.Factory.EmployeeBuilders.MechanicBuilder;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.MechanicRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.ListIterator;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MechanicServiceImplTest {

    private MechanicRepositoryImpl mechanicRepositoryImpl;
    private Mechanic firstMechanic;

    private Mechanic getSaved(){
        ListIterator<Mechanic> listItr = this.mechanicRepositoryImpl.getAll().listIterator();
        return listItr.next();
//        return this.customerRepositoryImpl.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.mechanicRepositoryImpl = MechanicRepositoryImpl.getMechanicRepositoryImpl();
        this.firstMechanic = MechanicBuilder.getMechanic("Mechanic", "MECH005", "NDIP-Engineering", "215095111");
    }

    @Test
    public void a_create() {
        Mechanic createdMechanic = this.mechanicRepositoryImpl.create(this.firstMechanic);
        System.out.println("In create, created = " + createdMechanic);
        Assert.assertNotNull(createdMechanic);
        Assert.assertSame(createdMechanic, this.firstMechanic);
    }

    @Test
    public void c_update() {
        String newPosCode = "MECH-002";
        Mechanic updatedMechanic = new Mechanic.MechanicBuilder().copy(getSaved()).positionCode(newPosCode).build();
        System.out.println("In update, updated = " + updatedMechanic);
        this.mechanicRepositoryImpl.update(updatedMechanic);
        Assert.assertSame(newPosCode, updatedMechanic.getPositionCode());
    }

    @Test
    public void e_delete() {
        Mechanic savedMechanic = getSaved();
        this.mechanicRepositoryImpl.delete(savedMechanic.getMechanicID());
        d_getAll();
    }

    @Test
    public void b_read() {
        Mechanic savedMechanic = getSaved();
        Mechanic readMechanic = this.mechanicRepositoryImpl.read(savedMechanic.getMechanicID());
        System.out.println("In read, read = "+ readMechanic);
        Assert.assertSame(readMechanic, savedMechanic);
    }

    @Test
    public void d_getAll() {
        ArrayList<Mechanic> mechanics = this.mechanicRepositoryImpl.getAll();
        System.out.println("In getall, all = " + mechanics);
    }
}