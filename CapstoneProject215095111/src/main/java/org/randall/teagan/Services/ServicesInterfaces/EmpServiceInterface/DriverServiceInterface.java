package org.randall.teagan.Services.ServicesInterfaces.EmpServiceInterface;

import org.randall.teagan.Domain.Employee.Driver;
import org.randall.teagan.Services.ServicesInterfaces.GenericService;

import java.util.ArrayList;

public interface DriverServiceInterface extends GenericService<Driver, String> {

    ArrayList<Driver>getAll();
}
