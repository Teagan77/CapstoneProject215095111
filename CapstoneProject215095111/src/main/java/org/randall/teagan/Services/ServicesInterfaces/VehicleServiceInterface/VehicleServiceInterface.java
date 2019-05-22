package org.randall.teagan.Services.ServicesInterfaces.VehicleServiceInterface;

import org.randall.teagan.Domain.Vehicle.Vehicle;
import org.randall.teagan.Services.ServicesInterfaces.GenericService;

import java.util.ArrayList;

public interface VehicleServiceInterface extends GenericService<Vehicle, String> {
    ArrayList<Vehicle> getAll();
}
