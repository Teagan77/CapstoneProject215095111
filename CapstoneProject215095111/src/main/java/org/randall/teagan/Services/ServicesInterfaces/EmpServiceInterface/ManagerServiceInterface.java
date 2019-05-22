package org.randall.teagan.Services.ServicesInterfaces.EmpServiceInterface;

import org.randall.teagan.Domain.Employee.Manager;
import org.randall.teagan.Services.ServicesInterfaces.GenericService;

import java.util.ArrayList;

public interface ManagerServiceInterface extends GenericService<Manager, String> {

    ArrayList<Manager>getAll();
}
