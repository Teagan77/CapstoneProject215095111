package org.randall.teagan.Factory.TripBuilders;

import org.junit.Assert;
import org.junit.Test;
import org.randall.teagan.Domain.Trip.Route;

import static org.junit.Assert.*;

public class RouteBuilderTest {

    @Test
    public void getRoute() {

        String startLoc = "CapeTown";
        String endLoc = "Belville";
        String routeName = "BZ304";
        String routeID = "63636";

        Route route = RouteBuilder.getRoute(startLoc,endLoc,routeName, routeID);

        System.out.println(route);
        Assert.assertNotNull(route.getRouteName());

    }
}