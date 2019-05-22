package org.randall.teagan.Repositories.RepositoryInterfaces.EmployeeRepositoryInterface;

import org.randall.teagan.Domain.Employee.Employee;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface EmployeeRepository extends Repository<Employee, String> {

    void removeAll();
    ArrayList<Employee> getAll();
}
