package org.randall.teagan.Factory.VehicleBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Vehicle.BusType;

import static org.junit.Assert.*;

public class BusTypeBuilderTest {

    @Test
    public void getBusType() {
        String busTypeCode = "L7676";
        String busTypeName = "CityLiner";

        BusType busType = BusTypeBuilder.getBusType(busTypeCode,busTypeName);
        System.out.println(busType);
        Assert.assertNotNull(busType.getBusTypeCode());
    }

}