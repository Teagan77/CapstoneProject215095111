package org.randall.teagan.Services.ServiceImplementation.TripServiceImpl;

import org.randall.teagan.Domain.Trip.Trip;
import org.randall.teagan.Repositories.Implementation.TripRepositoryImpl.TripRepositoryImpl;
import org.randall.teagan.Services.ServicesInterfaces.TripServiceInterface.TripServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("TripServiceImpl")
public class TripServiceImpl implements TripServiceInterface {

    @Autowired
    @Qualifier("TripRepository")
    private TripRepositoryImpl tripRepositoryImpl;

    @Override
    public Trip create(Trip trip) {
        return tripRepositoryImpl.create(trip);
    }

    @Override
    public Trip update(Trip trip) {
        return tripRepositoryImpl.update(trip);
    }

    @Override
    public void delete(String tripId) {
        tripRepositoryImpl.delete(tripId);
    }

    @Override
    public Trip read(String tripId) {
        return tripRepositoryImpl.read(tripId);
    }

    @Override
    public ArrayList<Trip> getAll() {
        return tripRepositoryImpl.getAllTrips();
    }
}
