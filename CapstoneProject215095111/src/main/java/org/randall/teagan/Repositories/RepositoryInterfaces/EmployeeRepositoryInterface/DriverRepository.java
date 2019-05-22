package org.randall.teagan.Repositories.RepositoryInterfaces.EmployeeRepositoryInterface;

import org.randall.teagan.Domain.Employee.Driver;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface DriverRepository extends Repository<Driver, String> {

    void removeAll();
    ArrayList<Driver> getAll();
}
