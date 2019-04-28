package org.randall.teagan.Repositories.Implementation;

import org.randall.teagan.Domain.Trip.Route;
import org.randall.teagan.Repositories.RepositoryInterfaces.RouteRepository;

import java.util.ArrayList;

public class RouteRepositoryImpl implements RouteRepository {

    private ArrayList<Route> routes;

    private static RouteRepositoryImpl routeRepositoryImpl = null;

    private RouteRepositoryImpl(){
        routes = new ArrayList<>();
    }

    protected static RouteRepositoryImpl getRouteRepositoryImpl(){
        if(routeRepositoryImpl == null){
            routeRepositoryImpl = new RouteRepositoryImpl();
        }
        return routeRepositoryImpl;
    }


    @Override
    public Route create(Route route) {
        this.routes.add(route);
        return route;
    }

    @Override
    public Route update(Route route) {

        boolean exists = false;
        int index = 0;

        for(int i = 0;i < routes.size();i++) {

            if (routes.get(i).getRouteID() == route.getRouteID()) {
                exists = true;
                index = i;
                routes.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent route.");
        }
        routes.add(index, route);
        return route;
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < routes.size();i++) {

            if (routes.get(i).getRouteID() == id) {
                routes.remove(i);
            }
        }

    }

    @Override
    public Route read(String id) {

        int index = 0;
        boolean exists = false;

        for(int i = 0;i < routes.size();i++) {

            if (routes.get(i).getRouteID() == id) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }

        return routes.get(index);
    }

    @Override
    public void removeAll() {
        routes.removeAll(routes);
    }

    @Override
    public ArrayList<Route> getAll() {
        return routes;
    }
}
