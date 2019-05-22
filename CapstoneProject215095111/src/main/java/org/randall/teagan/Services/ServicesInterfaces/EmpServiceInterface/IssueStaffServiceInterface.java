package org.randall.teagan.Services.ServicesInterfaces.EmpServiceInterface;

import org.randall.teagan.Domain.Employee.IssueStaff;
import org.randall.teagan.Services.ServicesInterfaces.GenericService;

import java.util.ArrayList;

public interface IssueStaffServiceInterface extends GenericService<IssueStaff, String> {

    ArrayList<IssueStaff> getAll();
}
