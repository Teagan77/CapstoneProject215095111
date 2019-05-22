package org.randall.teagan.Services.ServiceImplementation.VehicleServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Vehicle.BusType;
import org.randall.teagan.Domain.Vehicle.Vehicle;
import org.randall.teagan.Factory.VehicleBuilders.BusTypeBuilder;
import org.randall.teagan.Factory.VehicleBuilders.VehicleBuilder;
import org.randall.teagan.Repositories.Implementation.VehicleRepositoryImpl.VehicleRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.ListIterator;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VehicleServiceImplTest {

    private VehicleRepositoryImpl vehicleRepositoryImpl;
    private BusType busType;
    private Vehicle firstVehicle;

    private Vehicle getSaved(){
        ListIterator<Vehicle> listItr = this.vehicleRepositoryImpl.getAll().listIterator();
        return listItr.next();
    }

    @Before
    public void setUp() throws Exception {
        this.vehicleRepositoryImpl = VehicleRepositoryImpl.getVehicleRepositoryImpl();
        this.busType = BusTypeBuilder.getBusType("CTY-009", "Minibus");
        this.firstVehicle = VehicleBuilder.getVehicle("215095111", busType, 25);
    }

    @Test
    public void a_create() {
        Vehicle createdVehicle = this.vehicleRepositoryImpl.create(this.firstVehicle);
        System.out.println("In create, created = " + createdVehicle);
        Assert.assertNotNull(createdVehicle);
        Assert.assertSame(createdVehicle, this.firstVehicle);
    }

    @Test
    public void c_update() {
        int newCapacity = 15 ;
        Vehicle updatedVehicle = new Vehicle.VehicleBuilder().copy(getSaved()).capacity(newCapacity).build();
        System.out.println("In update, updated = " + updatedVehicle);
        this.vehicleRepositoryImpl.update(updatedVehicle);
        Assert.assertSame(newCapacity, updatedVehicle.getCapacity());
    }

    @Test
    public void e_delete() {
        Vehicle savedVehicle = getSaved();
        this.vehicleRepositoryImpl.delete(savedVehicle.getRegistration());
        d_getAll();
    }

    @Test
    public void b_read() {
        Vehicle savedVehicle = getSaved();
        Vehicle readVehicle = this.vehicleRepositoryImpl.read(savedVehicle.getRegistration());
        System.out.println("In read, read = "+ readVehicle);
        Assert.assertSame(readVehicle, savedVehicle);
    }

    @Test
    public void d_getAll() {
        ArrayList<Vehicle> vehicles = this.vehicleRepositoryImpl.getAll();
        System.out.println("In getall, all = " + vehicles);
    }
}