package org.randall.teagan.Factory.VehicleBuilders;

import org.randall.teagan.Domain.Vehicle.Minibus;

public class MinibusBuilder {

    public static Minibus getMinibus(String busTypeCode, String busTypeName) {
        return new Minibus.MinibusBuilder()
                .busTypeCode(busTypeCode)
                .busTypeName(busTypeName)
                .build();
    }
}
