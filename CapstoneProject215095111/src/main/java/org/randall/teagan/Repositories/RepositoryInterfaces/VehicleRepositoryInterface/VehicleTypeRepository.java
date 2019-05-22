package org.randall.teagan.Repositories.RepositoryInterfaces.VehicleRepositoryInterface;

import org.randall.teagan.Domain.Vehicle.BusType;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface VehicleTypeRepository extends Repository<BusType, String> {

    void removeAll();
    ArrayList<BusType> getAll();

}
