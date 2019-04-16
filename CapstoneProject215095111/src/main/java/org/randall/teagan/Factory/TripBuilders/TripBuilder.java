package org.randall.teagan.Factory.TripBuilders;

import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Employee.Driver;
import org.randall.teagan.Domain.Trip.Route;
import org.randall.teagan.Domain.Trip.Trip;
import org.randall.teagan.Domain.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Date;

public class TripBuilder {
    public static Trip getTrip(String tripNo, Date tripDate, Driver tripDriver, ArrayList<Customer> passengers, Route tripRoute, Vehicle tripVehicle) {
        return new Trip.TripBuilder()
                .tripNo(tripNo)
                .tripDate(tripDate)
                .tripDriver(tripDriver)
                .tripPassengers(passengers)
                .tripRoute(tripRoute)
                .tripVehicle(tripVehicle)
                .build();
    }
}
