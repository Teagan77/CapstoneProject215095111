package org.randall.teagan.Services.ServicesInterfaces.EmpServiceInterface;

import org.randall.teagan.Domain.Employee.Mechanic;
import org.randall.teagan.Services.ServicesInterfaces.GenericService;

import java.util.ArrayList;

public interface MechanicServiceInterface extends GenericService<Mechanic, String> {

    ArrayList<Mechanic> getAll();
}
