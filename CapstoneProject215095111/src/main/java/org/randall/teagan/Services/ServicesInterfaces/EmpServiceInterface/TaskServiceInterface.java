package org.randall.teagan.Services.ServicesInterfaces.EmpServiceInterface;

import org.randall.teagan.Domain.Employee.Task;
import org.randall.teagan.Services.ServicesInterfaces.GenericService;

import java.util.ArrayList;

public interface TaskServiceInterface extends GenericService<Task, String> {

    ArrayList<Task> getAll();
}
