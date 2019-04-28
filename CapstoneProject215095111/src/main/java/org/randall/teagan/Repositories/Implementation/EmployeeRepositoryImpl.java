package org.randall.teagan.Repositories.Implementation;

import org.randall.teagan.Domain.Employee.Employee;
import org.randall.teagan.Repositories.RepositoryInterfaces.EmployeeRepository;

import java.util.ArrayList;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private ArrayList<Employee> employees;

    private static EmployeeRepositoryImpl employeeRepositoryImpl = null;

    private EmployeeRepositoryImpl(){
        this.employees = new ArrayList<>();
    }

    protected static EmployeeRepositoryImpl getEmployeeRepositoryImpl(){
        if(employeeRepositoryImpl == null){
            employeeRepositoryImpl = new EmployeeRepositoryImpl();
        }
        return employeeRepositoryImpl;
    }


    @Override
    public Employee create(Employee employee) {
        this.employees.add(employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        boolean exists = false;
        int index = 0;

        for(int i = 0;i < employees.size();i++) {

            if (employees.get(i).getId() == employee.getId()) {
                exists = true;
                index = i;
                employees.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent employee.");
        }

        employees.add(index, employee);
        return employee;
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < employees.size();i++) {

            if (employees.get(i).getId() == id) {
                employees.remove(i);
            }
        }
    }

    @Override
    public Employee read(String id) {

        int index = 0;
        boolean exists = false;

        for(int i = 0;i < employees.size();i++) {

            if (employees.get(i).getId() == id) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }

        return employees.get(index);
    }

    @Override
    public ArrayList<Employee> getAll() {
        return employees;
    }

    @Override
    public void removeAll() {
        employees.removeAll(employees);
    }
}
