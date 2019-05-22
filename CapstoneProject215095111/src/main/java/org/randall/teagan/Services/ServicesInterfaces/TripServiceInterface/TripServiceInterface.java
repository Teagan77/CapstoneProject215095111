package org.randall.teagan.Services.ServicesInterfaces.TripServiceInterface;

import org.randall.teagan.Domain.Trip.Trip;
import org.randall.teagan.Services.ServicesInterfaces.GenericService;

import java.util.ArrayList;

public interface TripServiceInterface extends GenericService<Trip, String> {
    ArrayList<Trip> getAll();
}
