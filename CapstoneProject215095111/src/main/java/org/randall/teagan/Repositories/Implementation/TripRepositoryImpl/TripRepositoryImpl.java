package org.randall.teagan.Repositories.Implementation.TripRepositoryImpl;

import org.randall.teagan.Domain.Trip.Trip;
import org.randall.teagan.Repositories.RepositoryInterfaces.TripRepositoryInterface.TripRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("TripRepository")
public class TripRepositoryImpl implements TripRepository {

    private ArrayList<Trip> trips;

    private static TripRepositoryImpl tripRepository = null;

    private TripRepositoryImpl(){
        trips = new ArrayList<>();
    }

    public static TripRepositoryImpl getTripRepository(){
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
        Trip toDelete = findCourse(trip.getTripNo());
        if(toDelete != null) {
            this.trips.remove(toDelete);
            return create(trip);
        }
        return null;
    }

    private Trip findCourse(String tripNo) {
        return this.trips.stream()
                .filter(trip -> trip.getTripNo().trim().equals(tripNo))
                .findAny()
                .orElse(null);
    }

    @Override
    public void delete(String id) {

        for(int i = 0;i < trips.size();i++) {

            if (trips.get(i).getTripNo().equals(id)) {
                trips.remove(i);
            }
        }

    }

    @Override
    public Trip read(String id) {

        int index = 0;
        boolean exists = false;

        for(int i = 0;i < trips.size();i++) {

            if (trips.get(i).getTripNo().equals(id)) {
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
