package org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl;

import org.randall.teagan.Domain.Employee.Employee;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.EmployeeRepositoryImpl;
import org.randall.teagan.Services.ServicesInterfaces.EmpServiceInterface.EmpServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("EmpServiceImpl")
public class EmpServiceImpl implements EmpServiceInterface {

    @Autowired
    @Qualifier("EmployeeRepository")
    private EmployeeRepositoryImpl employeeRepositoryImpl;

    @Override
    public Employee create(Employee employee) {
        return employeeRepositoryImpl.create(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepositoryImpl.update(employee);
    }

    @Override
    public void delete(String empId) {
        employeeRepositoryImpl.delete(empId);
    }

    @Override
    public Employee read(String empId) {
        return employeeRepositoryImpl.read(empId);
    }

    @Override
    public ArrayList<Employee> getAll() {
        return employeeRepositoryImpl.getAll();
    }
}
