package org.randall.teagan.Repositories.Implementation.VehicleRepositoryImpTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Vehicle.BusType;
import org.randall.teagan.Factory.VehicleBuilders.BusTypeBuilder;
import org.randall.teagan.Repositories.Implementation.VehicleRepositoryImpl.VehicleTypeRepositoryImpl;

import java.util.ArrayList;

public class VehicleTypeRepositoryImplTest {

    private VehicleTypeRepositoryImpl vehicleRepositoryImpl;

    BusTypeBuilder busTypeBuilder = new BusTypeBuilder();

    String busTypeCode = "L7676";
    String busTypeName = "CityLiner";

    String updatedBusTypeName = "City Liner";

    String busTypeCode2 = "KL9088";
    String busTypeName2 = "Minibus";

    BusType firstBusType = BusTypeBuilder.getBusType(busTypeCode,busTypeName);
    BusType updatedFirstBusType = BusTypeBuilder.getBusType(busTypeCode, updatedBusTypeName);
    BusType secondBusType = BusTypeBuilder.getBusType(busTypeCode2,busTypeName2);


    @Before
    public void setUp() throws Exception {
        this.vehicleRepositoryImpl = VehicleTypeRepositoryImpl.getVehicleTypeRepositoryImpl();
    }

    @Test
    public void create() {
        Assert.assertEquals(firstBusType.hashCode(), this.vehicleRepositoryImpl.create(firstBusType).hashCode());
        this.vehicleRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.vehicleRepositoryImpl.create(firstBusType);
        this.vehicleRepositoryImpl.update(updatedFirstBusType);
        Assert.assertEquals("City Liner", this.vehicleRepositoryImpl.read(updatedFirstBusType.getBusTypeCode()).getBusTypeName());
        this.vehicleRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.vehicleRepositoryImpl.create(firstBusType);
        this.vehicleRepositoryImpl.create(secondBusType);
        this.vehicleRepositoryImpl.delete(firstBusType.getBusTypeCode());

        Assert.assertEquals(null, this.vehicleRepositoryImpl.read(firstBusType.getBusTypeCode()));
        this.vehicleRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.vehicleRepositoryImpl.create(firstBusType);
        Assert.assertEquals(true, this.vehicleRepositoryImpl.read(firstBusType.getBusTypeCode()) instanceof BusType);
        System.out.println(this.vehicleRepositoryImpl.read(firstBusType.getBusTypeCode()));
        this.vehicleRepositoryImpl.removeAll();
    }

    @Test
    public void getAll() {
        this.vehicleRepositoryImpl.create(firstBusType);
        ArrayList<BusType> busTypes = this.vehicleRepositoryImpl.getAll();
        Assert.assertEquals(1, busTypes.size());
        this.vehicleRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.vehicleRepositoryImpl.create(firstBusType);
        ArrayList<BusType> busTypes = this.vehicleRepositoryImpl.getAll();
        this.vehicleRepositoryImpl.removeAll();
        Assert.assertEquals( 0,busTypes.size());
    }
}