package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Employee.Mechanic;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface MechanicRepository extends Repository<Mechanic, String> {

    void removeAll();
    ArrayList<Mechanic> getAll();
}
