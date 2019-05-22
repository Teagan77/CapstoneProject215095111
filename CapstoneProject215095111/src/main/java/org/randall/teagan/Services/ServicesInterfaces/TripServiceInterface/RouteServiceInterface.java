package org.randall.teagan.Services.ServicesInterfaces.TripServiceInterface;

import org.randall.teagan.Domain.Trip.Route;
import org.randall.teagan.Services.ServicesInterfaces.GenericService;
import java.util.ArrayList;

public interface RouteServiceInterface extends GenericService<Route, String> {

    ArrayList<Route> getAll();
}
