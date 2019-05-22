package org.randall.teagan.Services.ServicesInterfaces.EmpServiceInterface;

import org.randall.teagan.Domain.Employee.Employee;
import org.randall.teagan.Services.ServicesInterfaces.GenericService;

import java.util.ArrayList;

public interface EmpServiceInterface extends GenericService<Employee, String> {

    ArrayList<Employee> getAll();
}
