package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Vehicle.BusType;

import java.util.ArrayList;

public interface VehicleTypeRepository extends Repository<BusType, String> {

    void removeAll();
    ArrayList<BusType> getAll();

}
