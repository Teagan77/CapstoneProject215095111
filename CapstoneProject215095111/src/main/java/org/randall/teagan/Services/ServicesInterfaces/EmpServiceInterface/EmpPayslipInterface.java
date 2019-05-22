package org.randall.teagan.Services.ServicesInterfaces.EmpServiceInterface;

import org.randall.teagan.Domain.Employee.EmployeePayslip;
import org.randall.teagan.Services.ServicesInterfaces.GenericService;

import java.util.ArrayList;

public interface EmpPayslipInterface extends GenericService<EmployeePayslip, String> {

     ArrayList<EmployeePayslip> getAll();
}
