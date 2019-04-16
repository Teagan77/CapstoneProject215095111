package org.randall.teagan.Factory.VehicleBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Vehicle.BusType;
import org.randall.teagan.Domain.Vehicle.Vehicle;

import static org.junit.Assert.*;

public class VehicleBuilderTest {

    @Test
    public void getVehicle() {

        String reg = "CT9803";
        int capacity = 45;
        String busTypeCode = "L7676";
        String busTypeName = "CityLiner";

        BusType busType = BusTypeBuilder.getBusType(busTypeCode,busTypeName);

        Vehicle vehicle = VehicleBuilder.getVehicle(reg,busType,capacity);
        System.out.println(vehicle);
        Assert.assertNotNull(vehicle.getCapacity());
    }
}