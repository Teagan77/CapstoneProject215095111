package org.randall.teagan.Services.ServiceImplementation.TripServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Trip.Route;
import org.randall.teagan.Factory.TripBuilders.RouteBuilder;
import org.randall.teagan.Repositories.Implementation.TripRepositoryImpl.RouteRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.ListIterator;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RouteServiceImplTest {

    private RouteRepositoryImpl routeRepositoryImpl;
    private Route firstRoute;

    private Route getSaved(){
        ListIterator<Route> listItr = this.routeRepositoryImpl.getAll().listIterator();
        return listItr.next();
    }

    @Before
    public void setUp() throws Exception {
        this.routeRepositoryImpl = RouteRepositoryImpl.getRouteRepositoryImpl();
        this.firstRoute = RouteBuilder.getRoute("City Centre", "Ottery", "Cape Town 351", "CT351");
    }

    @Test
    public void a_create() {
        Route createdRoute = this.routeRepositoryImpl.create(this.firstRoute);
        System.out.println("In create, created = " + createdRoute);
        Assert.assertNotNull(createdRoute);
        Assert.assertSame(createdRoute, this.firstRoute);
    }

    @Test
    public void c_update() {
        String newStartLoc = "Observatory";
        Route updatedRoute = new Route.RouteBuilder().copy(getSaved()).startLocation(newStartLoc).build();
        System.out.println("In update, updated = " + updatedRoute);
        this.routeRepositoryImpl.update(updatedRoute);
        Assert.assertSame(newStartLoc, updatedRoute.getStartLocation());
    }

    @Test
    public void e_delete() {
        Route savedRoute = getSaved();
        this.routeRepositoryImpl.delete(savedRoute.getRouteID());
        d_getAll();
    }

    @Test
    public void b_read() {
        Route savedRoute = getSaved();
        Route readRoute = this.routeRepositoryImpl.read(savedRoute.getRouteID());
        System.out.println("In read, read = "+ readRoute);
        Assert.assertSame(readRoute, savedRoute);
    }

    @Test
    public void d_getAll() {
        ArrayList<Route> routes = this.routeRepositoryImpl.getAll();
        System.out.println("In getall, all = " + routes);
    }
}