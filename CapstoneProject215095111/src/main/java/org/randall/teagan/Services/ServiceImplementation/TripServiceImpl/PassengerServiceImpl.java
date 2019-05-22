package org.randall.teagan.Services.ServiceImplementation.TripServiceImpl;

import org.randall.teagan.Domain.Trip.Passenger;
import org.randall.teagan.Repositories.Implementation.TripRepositoryImpl.PassengerRepositoryImpl;
import org.randall.teagan.Services.ServicesInterfaces.TripServiceInterface.PassengerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service("PassengerServiceImpl")
public class PassengerServiceImpl implements PassengerServiceInterface {

    @Autowired
    @Qualifier("PassengerRepository")
    private PassengerRepositoryImpl passengerRepositoryImpl;

    @Override
    public Passenger create(Passenger passenger) {
        return passengerRepositoryImpl.create(passenger);
    }

    @Override
    public Passenger update(Passenger passenger) {
        return passengerRepositoryImpl.update(passenger);
    }

    @Override
    public void delete(String passenger) {
        passengerRepositoryImpl.delete(passenger);
    }

    @Override
    public Passenger read(String passenger) {
        return passengerRepositoryImpl.read(passenger);
    }

    @Override
    public ArrayList<Passenger> getAll() {
        return passengerRepositoryImpl.getAll();
    }
}
