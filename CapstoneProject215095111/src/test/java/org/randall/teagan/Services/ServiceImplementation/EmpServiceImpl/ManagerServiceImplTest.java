package org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Employee.Manager;
import org.randall.teagan.Factory.EmployeeBuilders.ManagerBuilder;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.ManagerRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.ListIterator;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ManagerServiceImplTest {

    private ManagerRepositoryImpl managerRepositoryImpl;
    private Manager firstManager;

    private Manager getSaved(){
        ListIterator<Manager> listItr = this.managerRepositoryImpl.getAll().listIterator();
        return listItr.next();
//        return this.customerRepositoryImpl.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.managerRepositoryImpl = ManagerRepositoryImpl.getManagerRepositoryImpl();
        this.firstManager = ManagerBuilder.getManager("Manager", "MGR005", "BTECHCOMMGM", "215095111");
    }

    @Test
    public void a_create() {
        Manager createdManager = this.managerRepositoryImpl.create(this.firstManager);
        System.out.println("In create, created = " + createdManager);
        Assert.assertNotNull(createdManager);
        Assert.assertSame(createdManager, this.firstManager);
    }

    @Test
    public void c_update() {
        String newManagerQualCode = "NDIP-Business";
        Manager updatedManager = new Manager.ManagerBuilder().copy(getSaved()).qualCode(newManagerQualCode).build();
        System.out.println("In update, updated = " + updatedManager);
        this.managerRepositoryImpl.update(updatedManager);
        Assert.assertSame(newManagerQualCode, updatedManager.getQualCode());
    }

    @Test
    public void e_delete() {
        Manager savedManager = getSaved();
        this.managerRepositoryImpl.delete(savedManager.getManagerID());
        d_getAll();
    }

    @Test
    public void b_read() {
        Manager savedManager = getSaved();
        Manager readManager = this.managerRepositoryImpl.read(savedManager.getManagerID());
        System.out.println("In read, read = "+ readManager);
        Assert.assertSame(readManager, savedManager);
    }

    @Test
    public void d_getAll() {
        ArrayList<Manager> managers = this.managerRepositoryImpl.getAll();
        System.out.println("In getall, all = " + managers);
    }
}