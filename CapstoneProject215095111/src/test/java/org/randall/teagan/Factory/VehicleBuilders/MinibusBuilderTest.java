package org.randall.teagan.Factory.VehicleBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Vehicle.Minibus;

import static org.junit.Assert.*;

public class MinibusBuilderTest {

    @Test
    public void getMinibus() {
        String busTypeCode = "L7676";
        String busTypeName = "CityLiner";

        Minibus minibus = MinibusBuilder.getMinibus(busTypeCode,busTypeName);
        System.out.println(minibus);
        Assert.assertNotNull(minibus.getBusTypeCode());
    }
}