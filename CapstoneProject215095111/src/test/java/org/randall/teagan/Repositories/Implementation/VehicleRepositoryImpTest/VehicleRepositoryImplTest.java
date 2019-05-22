package org.randall.teagan.Repositories.Implementation.VehicleRepositoryImpTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Vehicle.BusType;
import org.randall.teagan.Domain.Vehicle.Vehicle;
import org.randall.teagan.Factory.VehicleBuilders.BusTypeBuilder;
import org.randall.teagan.Factory.VehicleBuilders.VehicleBuilder;
import org.randall.teagan.Repositories.Implementation.VehicleRepositoryImpl.VehicleRepositoryImpl;

import java.util.ArrayList;

public class VehicleRepositoryImplTest {

    private VehicleRepositoryImpl vehicleRepositoryImpl;

    VehicleBuilder vehicleBuilder = new VehicleBuilder();

    String reg = "CT9803";
    int capacity = 28;
    String busTypeCode = "L7676";
    String busTypeName = "CityLiner";

    String updatedTypeName = "City Liner";

    String reg2 = "GP0015";
    int capacity2 = 8;
    String busTypeCode2 = "QZ4F5";
    String busTypeName2 = "Minibus";

    BusType busType = BusTypeBuilder.getBusType(busTypeCode,busTypeName);
    BusType updatedBusType = BusTypeBuilder.getBusType(busTypeCode,updatedTypeName);
    BusType busType2 = BusTypeBuilder.getBusType(busTypeCode2,busTypeName2);

    Vehicle firstVehicle = VehicleBuilder.getVehicle(reg,busType,capacity);
    Vehicle updatedFirstVehicle = VehicleBuilder.getVehicle(reg, updatedBusType, capacity);
    Vehicle secondVehicle = VehicleBuilder.getVehicle(reg2,busType2,capacity2);


    @Before
    public void setUp() throws Exception {
        this.vehicleRepositoryImpl = VehicleRepositoryImpl.getVehicleRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstVehicle.hashCode(), this.vehicleRepositoryImpl.create(firstVehicle).hashCode());
        this.vehicleRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.vehicleRepositoryImpl.create(firstVehicle);
        this.vehicleRepositoryImpl.update(updatedFirstVehicle);
        Assert.assertEquals("City Liner", this.vehicleRepositoryImpl.read(updatedFirstVehicle.getRegistration()).getBustType().getBusTypeName());
        this.vehicleRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.vehicleRepositoryImpl.create(firstVehicle);
        this.vehicleRepositoryImpl.create(secondVehicle);
        this.vehicleRepositoryImpl.delete(firstVehicle.getRegistration());

        Assert.assertEquals(null, this.vehicleRepositoryImpl.read(firstVehicle.getRegistration()));
        this.vehicleRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.vehicleRepositoryImpl.create(firstVehicle);
        Assert.assertEquals(true, this.vehicleRepositoryImpl.read(firstVehicle.getRegistration())instanceof Vehicle);
        System.out.println(this.vehicleRepositoryImpl.read(firstVehicle.getRegistration()));
        this.vehicleRepositoryImpl.removeAll();
    }

    @Test
    public void getAll() {
        this.vehicleRepositoryImpl.create(firstVehicle);
        ArrayList<Vehicle> vehicles = this.vehicleRepositoryImpl.getAll();
        Assert.assertEquals(1, vehicles.size());
        this.vehicleRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.vehicleRepositoryImpl.create(firstVehicle);
        ArrayList<Vehicle> vehicles = this.vehicleRepositoryImpl.getAll();
        this.vehicleRepositoryImpl.removeAll();
        Assert.assertEquals( 0,vehicles.size());
    }
}