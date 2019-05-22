package org.randall.teagan.Domain.Trip;

import org.randall.teagan.Domain.Customer.Customer;

public class Route {

    private String startLocation, endLocation, routeName, routeID;

    public Route(){}

    public Route(RouteBuilder routeBuilder){
        this.startLocation = routeBuilder.startLocation;
        this.endLocation = routeBuilder.endLocation;
        this.routeName = routeBuilder.routeName;
        this.routeID = routeBuilder.routeID;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public String getRouteName() {
        return routeName;
    }

    public String getRouteID() {
        return routeID;
    }

    public static class RouteBuilder{

        private String startLocation, endLocation, routeName, routeID;

        public RouteBuilder startLocation(String startLocation){
            this.startLocation = startLocation;
            return this;
        }

        public RouteBuilder endLocation(String endLocation){
            this.endLocation = endLocation;
            return this;
        }

        public RouteBuilder routeName(String routeName){
            this.routeName = routeName;
            return this;
        }

        public RouteBuilder routeID(String routeID){
            this.routeID = routeID;
            return this;
        }

        public Route build() {
            return new Route(this);
        }

        public Route.RouteBuilder copy(Route saved) {
            this.endLocation = saved.endLocation;
            this.routeID = saved.routeID;
            this.routeName = saved.routeName;
            this.startLocation = saved.startLocation;

            return this;
        }
    }
    @Override
    public String toString() {
        return "Route{" +
                "startLocation ='" + getStartLocation() + '\'' +
                ", endLocation ='" + getEndLocation() + '\'' +
                ", routeName ='" + getRouteName() + '\'' +
                '}';
    }
}

