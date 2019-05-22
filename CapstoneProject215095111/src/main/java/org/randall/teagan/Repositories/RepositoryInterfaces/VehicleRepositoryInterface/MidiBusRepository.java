package org.randall.teagan.Repositories.RepositoryInterfaces.VehicleRepositoryInterface;

import org.randall.teagan.Domain.Vehicle.Midibus;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface MidiBusRepository extends Repository<Midibus, String> {
    void removeAll();
    ArrayList<Midibus> getAll();
}
