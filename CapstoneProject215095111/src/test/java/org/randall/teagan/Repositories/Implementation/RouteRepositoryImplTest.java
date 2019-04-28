package org.randall.teagan.Repositories.Implementation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Trip.Route;
import org.randall.teagan.Factory.TripBuilders.RouteBuilder;

import java.util.ArrayList;

public class RouteRepositoryImplTest {

    private RouteRepositoryImpl routeRepositoryImpl;

    private RouteBuilder routeBuilder = new RouteBuilder();

    String startLoc = "CapeTown";
    String endLoc = "Belville";
    String routeName = "BZ304";
    String routeID = "63636";

    String newRouteName = "ZZ111";

    String startLoc2 = "CapeTown";
    String endLoc2 = "Tygervalley";
    String routeName2 = "Z5824";
    String routeID2 = "85336";

    Route firstRoute = RouteBuilder.getRoute(startLoc,endLoc,routeName, routeID);
    Route updatedFirstRoute = RouteBuilder.getRoute(startLoc,endLoc,newRouteName, routeID);
    Route secondRoute = RouteBuilder.getRoute(startLoc2,endLoc2,routeName2, routeID2);

    @Before
    public void setUp() throws Exception {
        routeRepositoryImpl = RouteRepositoryImpl.getRouteRepositoryImpl();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstRoute.hashCode(), this.routeRepositoryImpl.create(firstRoute).hashCode());
        this.routeRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.routeRepositoryImpl.create(firstRoute);
        this.routeRepositoryImpl.update(updatedFirstRoute);
        Assert.assertEquals("ZZ111", this.routeRepositoryImpl.read(updatedFirstRoute.getRouteID()).getRouteName());
        this.routeRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.routeRepositoryImpl.create(firstRoute);
        this.routeRepositoryImpl.create(secondRoute);
        this.routeRepositoryImpl.delete(firstRoute.getRouteID());

        Assert.assertEquals(null, this.routeRepositoryImpl.read(firstRoute.getRouteID()));
        this.routeRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.routeRepositoryImpl.create(firstRoute);
        Assert.assertEquals(true, this.routeRepositoryImpl.read(firstRoute.getRouteID()) instanceof Route);
        System.out.println(this.routeRepositoryImpl.read(firstRoute.getRouteID()));
        this.routeRepositoryImpl.removeAll();
    }

    @Test
    public void removeAll() {
        this.routeRepositoryImpl.create(firstRoute);
        ArrayList<Route> routes = this.routeRepositoryImpl.getAll();
        this.routeRepositoryImpl.removeAll();
        Assert.assertEquals( 0,routes.size());
    }

    @Test
    public void getAll() {
        this.routeRepositoryImpl.create(firstRoute);
        ArrayList<Route> routes = this.routeRepositoryImpl.getAll();
        Assert.assertEquals(1, routes.size());
        this.routeRepositoryImpl.removeAll();
    }
}