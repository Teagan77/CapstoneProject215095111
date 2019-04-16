package org.randall.teagan.Factory.TripBuilders;

import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Trip.Passenger;
import org.randall.teagan.Domain.Trip.Trip;

public class PassengerBuilder {

    public static Passenger getPassenger(Customer passenger, Trip currentTrip) {
        return new Passenger.PassengerBuilder()
                .getPassenger(passenger)
                .getCurrentTrip(currentTrip)
                .build();
    }
}
