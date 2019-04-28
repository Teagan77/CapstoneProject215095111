package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Vehicle.Vehicle;

import java.util.ArrayList;

public interface VehicleRepository extends Repository<Vehicle, String> {

    void removeAll();
    ArrayList<Vehicle> getAll();
}
