package org.randall.teagan.Repositories.RepositoryInterfaces.EmployeeRepositoryInterface;

import org.randall.teagan.Domain.Employee.EmployeePosition;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface EmpPositionRepository extends Repository<EmployeePosition, String> {

    public void removeAll();
    ArrayList<EmployeePosition> getAll();
}
