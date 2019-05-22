package org.randall.teagan.Repositories.RepositoryInterfaces.EmployeeRepositoryInterface;

import org.randall.teagan.Domain.Employee.EmployeePayslip;
import org.randall.teagan.Repositories.RepositoryInterfaces.Repository;

import java.util.ArrayList;

public interface EmpPayslipRepository extends Repository<EmployeePayslip, String> {

    void removeAll();
    ArrayList<EmployeePayslip> getAll();
}
