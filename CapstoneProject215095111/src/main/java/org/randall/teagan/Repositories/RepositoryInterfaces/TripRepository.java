package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Trip.Trip;

import java.util.ArrayList;

public interface TripRepository extends Repository<Trip, String> {

    void removeAllTrips();
    ArrayList<Trip> getAllTrips();

}
