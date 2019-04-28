package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Vehicle.Cityliner;

import java.util.ArrayList;

public interface CityLinerRepository extends Repository<Cityliner, String> {
    void removeAll();
    ArrayList<Cityliner> getAll();
}
