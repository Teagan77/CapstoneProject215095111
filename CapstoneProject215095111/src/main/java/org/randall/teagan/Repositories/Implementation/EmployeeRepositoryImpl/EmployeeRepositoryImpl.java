package org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl;

import org.randall.teagan.Domain.Employee.Employee;
import org.randall.teagan.Repositories.RepositoryInterfaces.EmployeeRepositoryInterface.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("EmployeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private ArrayList<Employee> employees;

    private static EmployeeRepositoryImpl employeeRepositoryImpl = null;

    private EmployeeRepositoryImpl() {
        this.employees = new ArrayList<>();
    }

    public static EmployeeRepositoryImpl getEmployeeRepositoryImpl() {
        if (employeeRepositoryImpl == null) {
            employeeRepositoryImpl = new EmployeeRepositoryImpl();
        }
        return employeeRepositoryImpl;
    }

    private Employee findEmp(String id) {
        return this.employees.stream()
                .filter(employee -> employee.getEmpId().trim().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public Employee create(Employee employee) {
        this.employees.add(employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {


        Employee toDelete = findEmp(employee.getEmpId());
        if (toDelete != null) {
            this.employees.remove(toDelete);
            return create(employee);
        }
        return null;

         /*
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
         */
    }


        @Override
        public void delete (String id){
            for (int i = 0; i < employees.size(); i++) {

                if (employees.get(i).getEmpId() == id) {
                    employees.remove(i);
                }
            }
        }

        @Override
        public Employee read (String id){

            for (Employee employee : employees) {
                if (employee.getEmpId().equals(id)) {
                    return employee;
                }
            }
            return null;
        }

        @Override
        public ArrayList<Employee> getAll () {
            return employees;
        }

        @Override
        public void removeAll () {
            employees.removeAll(employees);
        }
}
