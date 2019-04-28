package org.randall.teagan.Factory.TripBuilders;

import org.randall.teagan.Domain.Trip.Route;

public class RouteBuilder {

    public static Route getRoute(String startLoc, String endLoc, String routeName, String routeID) {
        return new Route.RouteBuilder()
                .startLocation(startLoc)
                .endLocation(endLoc)
                .routeName(routeName)
                .routeID(routeID)
                .build();
    }
}
