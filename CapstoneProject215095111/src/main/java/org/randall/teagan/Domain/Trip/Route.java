package org.randall.teagan.Domain.Trip;

public class Route {

    private String startLocation, endLocation, routeName;

    public Route(){}

    public Route(RouteBuilder routeBuilder){
        this.startLocation = routeBuilder.startLocation;
        this.endLocation = routeBuilder.endLocation;
        this.routeName = routeBuilder.routeName;
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

    public static class RouteBuilder{

        private String startLocation, endLocation, routeName;

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

        public Route build() {
            return new Route(this);
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

