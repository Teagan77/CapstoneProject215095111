package org.randall.teagan.Factory.VehicleBuilders;

import org.randall.teagan.Domain.Vehicle.Cityliner;

public class CitylinerBuilder {
    public static Cityliner getCityliner(String busTypeCode, String busTypeName) {
        return new Cityliner.CitylinerBuilder()
                .busTypeCode(busTypeCode)
                .busTypeName(busTypeName)
                .build();
    }
}
