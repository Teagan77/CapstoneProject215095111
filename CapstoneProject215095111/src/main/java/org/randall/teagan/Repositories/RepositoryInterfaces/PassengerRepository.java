package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Trip.Passenger;

import java.util.ArrayList;

public interface PassengerRepository extends Repository<Passenger, String> {

    void removeAll();
    ArrayList<Passenger> getAll();
}
