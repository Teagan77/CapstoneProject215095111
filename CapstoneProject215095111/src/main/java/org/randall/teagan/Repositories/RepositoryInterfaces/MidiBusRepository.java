package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Vehicle.Midibus;

import java.util.ArrayList;

public interface MidiBusRepository extends Repository<Midibus, String> {
    void removeAll();
    ArrayList<Midibus> getAll();
}
