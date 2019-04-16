package org.randall.teagan.Factory.VehicleBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Vehicle.Cityliner;

import static org.junit.Assert.*;

public class CitylinerBuilderTest {

    @Test
    public void getCityliner() {
        String busTypeCode = "L7676";
        String busTypeName = "CityLiner";

        Cityliner cityliner = CitylinerBuilder.getCityliner(busTypeCode,busTypeName);
        System.out.println(cityliner);
        Assert.assertNotNull(cityliner.getBusTypeCode());
    }
}