package org.randall.teagan.Services.ServicesInterfaces.TripServiceInterface;

import org.randall.teagan.Domain.Trip.Passenger;
import org.randall.teagan.Services.ServicesInterfaces.GenericService;

import java.util.ArrayList;

public interface PassengerServiceInterface extends GenericService<Passenger, String> {

    ArrayList<Passenger> getAll();
}
