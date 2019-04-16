package org.randall.teagan.Factory.VehicleBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Vehicle.Midibus;

import static org.junit.Assert.*;

public class MidibusBuilderTest {

    @Test
    public void getMidibus() {

        String busTypeCode = "L7676";
        String busTypeName = "CityLiner";

        Midibus midibus = MidibusBuilder.getMidibus(busTypeCode,busTypeName);
        System.out.println(midibus);
        Assert.assertNotNull(midibus.getBusTypeCode());
    }
}