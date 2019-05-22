package org.randall.teagan.Repositories.RepositoryInterfaces.TripRepositoryInterface;

import org.randall.teagan.Domain.Trip.Trip;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface TripRepository extends Repository<Trip, String> {

    void removeAllTrips();
    ArrayList<Trip> getAllTrips();

}
