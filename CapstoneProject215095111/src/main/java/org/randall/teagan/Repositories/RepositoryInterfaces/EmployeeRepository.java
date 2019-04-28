package org.randall.teagan.Repositories.RepositoryInterfaces;

import org.randall.teagan.Domain.Employee.Employee;

import java.util.ArrayList;

public interface EmployeeRepository extends Repository<Employee, String> {

    void removeAll();
    ArrayList<Employee> getAll();
}
