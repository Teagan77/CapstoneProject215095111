package org.randall.teagan.Repositories.RepositoryInterfaces.VehicleRepositoryInterface;

import org.randall.teagan.Domain.Vehicle.Minibus;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface MiniBusRepository extends Repository<Minibus, String> {
    void removeAll();
    ArrayList<Minibus> getAll();
}
