package org.randall.teagan.Repositories.RepositoryInterfaces.TripRepositoryInterface;

import org.randall.teagan.Domain.Trip.Passenger;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface PassengerRepository extends Repository<Passenger, String> {

    void removeAll();
    ArrayList<Passenger> getAll();
}
