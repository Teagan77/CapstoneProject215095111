package org.randall.teagan.Factory.VehicleBuilders;

import org.randall.teagan.Domain.Vehicle.Midibus;

public class MidibusBuilder {

    public static Midibus getMidibus(String busTypeCode, String busTypeName) {
        return new Midibus.MidibusBuilder()
                .busTypeCode(busTypeCode)
                .busTypeName(busTypeName)
                .build();
    }

}
