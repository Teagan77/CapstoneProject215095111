package org.randall.teagan.Repositories.RepositoryInterfaces.VehicleRepositoryInterface;

import org.randall.teagan.Domain.Vehicle.Cityliner;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface CityLinerRepository extends Repository<Cityliner, String> {
    void removeAll();
    ArrayList<Cityliner> getAll();
}
