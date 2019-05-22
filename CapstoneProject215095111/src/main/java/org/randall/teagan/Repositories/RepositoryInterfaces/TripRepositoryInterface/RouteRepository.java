package org.randall.teagan.Repositories.RepositoryInterfaces.TripRepositoryInterface;

import org.randall.teagan.Domain.Trip.Route;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface RouteRepository extends Repository<Route,String> {

    void removeAll();
    ArrayList<Route> getAll();
}
