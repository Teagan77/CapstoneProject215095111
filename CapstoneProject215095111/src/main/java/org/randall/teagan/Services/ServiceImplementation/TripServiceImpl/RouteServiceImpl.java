package org.randall.teagan.Services.ServiceImplementation.TripServiceImpl;

import org.randall.teagan.Domain.Trip.Route;
import org.randall.teagan.Repositories.Implementation.TripRepositoryImpl.RouteRepositoryImpl;
import org.randall.teagan.Services.ServicesInterfaces.TripServiceInterface.RouteServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service("RouteServiceImpl")
public class RouteServiceImpl implements RouteServiceInterface {

    @Autowired
    @Qualifier("RouteRepository")
    private RouteRepositoryImpl routeRepositoryImpl;

    @Override
    public Route create(Route route) {
        return routeRepositoryImpl.create(route);
    }

    @Override
    public Route update(Route route) {
        return routeRepositoryImpl.update(route);
    }

    @Override
    public void delete(String id) {
        routeRepositoryImpl.delete(id);
    }

    @Override
    public Route read(String id) {
        return routeRepositoryImpl.read(id);
    }

    @Override
    public ArrayList<Route> getAll() {
        return routeRepositoryImpl.getAll();
    }
}
