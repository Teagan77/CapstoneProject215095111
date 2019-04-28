package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Trip.Route;

import java.util.ArrayList;

public interface RouteRepository extends Repository<Route,String> {

    void removeAll();
    ArrayList<Route> getAll();
}
