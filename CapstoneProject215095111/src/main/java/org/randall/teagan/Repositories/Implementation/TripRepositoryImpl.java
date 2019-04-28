package org.randall.teagan.Repositories.Implementation;

import org.randall.teagan.Domain.Trip.Trip;
import org.randall.teagan.Repositories.RepositoryInterfaces.TripRepository;

import java.util.ArrayList;

public class TripRepositoryImpl implements TripRepository {

    private ArrayList<Trip> trips;

    private static TripRepositoryImpl tripRepository = null;

    private TripRepositoryImpl(){
        trips = new ArrayList<>();
    }

    protected static TripRepositoryImpl getTripRepository(){
        if(tripRepository == null){
            tripRepository = new TripRepositoryImpl();
        }
        return tripRepository;
    }

    @Override
    public Trip create(Trip trip) {
        trips.add(trip);
        return trip;
    }

    @Override
    public Trip update(Trip trip) {

        boolean exists = false;
        int index = 0;

        for(int i = 0;i < trips.size();i++) {

            if (trips.get(i).getTripNo() == trip.getTripNo()) {
                exists = true;
                index = i;
                trips.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent trip.");
        }

        trips.add(index, trip);
        return trip;
    }

    @Override
    public void delete(String id) {

        for(int i = 0;i < trips.size();i++) {

            if (trips.get(i).getTripNo() == id) {
                trips.remove(i);
            }
        }

    }

    @Override
    public Trip read(String id) {

        int index = 0;
        boolean exists = false;

        for(int i = 0;i < trips.size();i++) {

            if (trips.get(i).getTripNo() == id) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }

        return trips.get(index);
    }

    @Override
    public void removeAllTrips() {
        trips.removeAll(trips);
    }

    @Override
    public ArrayList<Trip> getAllTrips() {
        return trips;
    }
}
