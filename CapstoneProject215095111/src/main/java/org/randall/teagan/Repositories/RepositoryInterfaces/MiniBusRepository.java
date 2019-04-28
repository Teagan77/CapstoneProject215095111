package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Vehicle.Minibus;

import java.util.ArrayList;

public interface MiniBusRepository extends Repository<Minibus, String> {
    void removeAll();
    ArrayList<Minibus> getAll();
}
