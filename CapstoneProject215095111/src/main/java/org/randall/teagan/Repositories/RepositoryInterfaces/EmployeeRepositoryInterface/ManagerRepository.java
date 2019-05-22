package org.randall.teagan.Repositories.RepositoryInterfaces.EmployeeRepositoryInterface;

import org.randall.teagan.Domain.Employee.Manager;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface ManagerRepository extends Repository<Manager, String> {

    void  removeAll();
    ArrayList<Manager> getAll();
}
