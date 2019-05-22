package org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl;

import org.randall.teagan.Domain.Employee.EmployeePosition;
import org.randall.teagan.Repositories.RepositoryInterfaces.EmployeeRepositoryInterface.EmpPositionRepository;

import java.util.ArrayList;

public class EmpPositionRepositoryImpl implements EmpPositionRepository {

    private ArrayList<EmployeePosition> employeePositions;
    private static EmpPositionRepositoryImpl empPositionRepositoryImpl = null;

    private EmpPositionRepositoryImpl(){
        this.employeePositions = new ArrayList<>();
    }

    public static EmpPositionRepositoryImpl getEmpPositionRepositoryImpl(){
        if(empPositionRepositoryImpl == null){
            empPositionRepositoryImpl = new EmpPositionRepositoryImpl();
        }
        return empPositionRepositoryImpl;
    }

    @Override
    public EmployeePosition create(EmployeePosition employeePosition) {
        this.employeePositions.add(employeePosition);
        return employeePosition;
    }

    @Override
    public EmployeePosition update(EmployeePosition employeePosition) {

        boolean exists = false;
        int index = 0;

        for(int i = 0;i < employeePositions.size();i++) {

            if (employeePositions.get(i).getPositionCode() == employeePosition.getPositionCode()) {
                exists = true;
                index = i;
                employeePositions.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent position.");
        }

        employeePositions.add(index, employeePosition);
        return employeePosition;
    }

    @Override
    public void delete(String id) {

        for(int i = 0;i < employeePositions.size();i++) {

            if (employeePositions.get(i).getPositionCode() == id) {
                employeePositions.remove(i);
            }
        }

    }

    @Override
    public EmployeePosition read(String id) {

        int index = 0;
        boolean exists = false;

        for(int i = 0;i < employeePositions.size();i++) {

            if (employeePositions.get(i).getPositionCode() == id) {
                index = i;
                exists = true;
            }
        }
        if (!exists) {
            return null;
        }
        return employeePositions.get(index);
    }

    @Override
    public ArrayList<EmployeePosition> getAll() {
        return employeePositions;
    }

    @Override
    public void removeAll() {
        employeePositions.removeAll(employeePositions);
    }
}
