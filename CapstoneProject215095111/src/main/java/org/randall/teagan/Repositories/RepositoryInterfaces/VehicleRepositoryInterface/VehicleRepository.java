package org.randall.teagan.Repositories.RepositoryInterfaces.VehicleRepositoryInterface;

import org.randall.teagan.Domain.Vehicle.Vehicle;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface VehicleRepository extends Repository<Vehicle, String> {

    void removeAll();
    ArrayList<Vehicle> getAll();
}
