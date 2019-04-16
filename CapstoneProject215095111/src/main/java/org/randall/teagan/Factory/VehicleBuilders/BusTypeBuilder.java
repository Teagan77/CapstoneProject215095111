package org.randall.teagan.Factory.VehicleBuilders;

import org.randall.teagan.Domain.Vehicle.BusType;

public class BusTypeBuilder {


    public static BusType getBusType(String busTypeCode, String busTypeName) {
        return new BusType.BusTypeBuilder()
                .busTypeCode(busTypeCode)
                .busTypeName(busTypeName)
                .build();
    }
}
