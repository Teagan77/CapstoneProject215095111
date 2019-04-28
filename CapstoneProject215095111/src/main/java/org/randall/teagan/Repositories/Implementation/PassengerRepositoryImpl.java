package org.randall.teagan.Repositories.Implementation;

import org.randall.teagan.Domain.Trip.Passenger;
import org.randall.teagan.Repositories.RepositoryInterfaces.PassengerRepository;

import java.util.ArrayList;

public class PassengerRepositoryImpl implements PassengerRepository {

    private ArrayList<Passenger> passengers;

    private static PassengerRepositoryImpl passengerRepositoryImpl = null;

    private PassengerRepositoryImpl(){
        passengers = new ArrayList<>();
    }

    protected static PassengerRepositoryImpl getPassengerRepositoryImpl(){
        if(passengerRepositoryImpl == null){
            passengerRepositoryImpl = new PassengerRepositoryImpl();
        }
        return passengerRepositoryImpl;
    }

    @Override
    public void removeAll() {
        passengers.removeAll(passengers);
    }

    @Override
    public ArrayList<Passenger> getAll() {
        return passengers;
    }


    @Override
    public Passenger create(Passenger passenger) {
        passengers.add(passenger);
        return passenger;
    }

    @Override
    public Passenger update(Passenger passenger) {
        boolean exists = false;
        int index = 0;

        for(int i = 0;i < passengers.size();i++) {

            if (passengers.get(i).getPassenger().getCustId() == passenger.getPassenger().getCustId()){
                exists = true;
                index = i;
                passengers.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent passenger");
        }

        passengers.add(index, passenger);
        return passenger;
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < passengers.size();i++) {

            if (passengers.get(i).getPassenger().getCustId() == id) {
                passengers.remove(i);
            }
        }
    }

    @Override
    public Passenger read(String id) {
        int index = 0;
        boolean exists = false;

        for(int i = 0;i < passengers.size();i++) {

            if (passengers.get(i).getPassenger().getCustId() == id) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }
        return passengers.get(index);
    }
}
