package org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Employee.Driver;
import org.randall.teagan.Factory.EmployeeBuilders.DriverBuilder;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.DriverRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.ListIterator;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DriverServiceImplTest {

    private DriverRepositoryImpl driverRepositoryImpl;
    private Driver firstDriver;

    private Driver getSaved(){
        ListIterator<Driver> listItr = this.driverRepositoryImpl.getAll().listIterator();
        return listItr.next();
//        return this.customerRepositoryImpl.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.driverRepositoryImpl = DriverRepositoryImpl.getDriverRepositoryImpl();
        this.firstDriver = DriverBuilder.getDriver("Driver", "DRV002", "C", "218952678");
    }

    @Test
    public void a_create() {
        Driver createdDriver = this.driverRepositoryImpl.create(this.firstDriver);
        System.out.println("In create, created = " + createdDriver);
        Assert.assertNotNull(createdDriver);
        Assert.assertSame(createdDriver, this.firstDriver);
    }

    @Test
    public void c_update() {
        String newDriverID = "21595444";
        Driver updatedDriver = new Driver.DriverBuilder().copy(getSaved()).driverID(newDriverID).build();
        System.out.println("In update, updated = " + updatedDriver);
        this.driverRepositoryImpl.update(updatedDriver);
        Assert.assertSame(newDriverID, updatedDriver.getDriverID());
    }

    @Test
    public void e_delete() {
        Driver savedDriver = getSaved();
        this.driverRepositoryImpl.delete(savedDriver.getDriverID());
        d_getAll();
    }

    @Test
    public void b_read() {
        Driver savedDriver = getSaved();
        Driver readDriver = this.driverRepositoryImpl.read(savedDriver.getDriverID());
        System.out.println("In read, read = "+ readDriver);
        Assert.assertSame(readDriver, savedDriver);
    }

    @Test
    public void d_getAll() {
        ArrayList<Driver> drivers = this.driverRepositoryImpl.getAll();
        System.out.println("In getall, all = " + drivers);
    }
}