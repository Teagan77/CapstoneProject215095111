package org.randall.teagan.Factory.VehicleBuilders;

import org.randall.teagan.Domain.Vehicle.BusType;
import org.randall.teagan.Domain.Vehicle.Vehicle;

public class VehicleBuilder {

    public static Vehicle getVehicle(String registration , BusType busType, int capacity) {
        return new Vehicle.VehicleBuilder()
                .bustType(busType)
                .registration(registration)
                .capacity(capacity)
                .build();
    }
}
