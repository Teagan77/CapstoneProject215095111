package org.randall.teagan.Repositories.Implementation;

import org.randall.teagan.Domain.Employee.EmployeePayslip;
import org.randall.teagan.Repositories.RepositoryInterfaces.EmpPayslipRepository;

import java.util.ArrayList;

public class EmpPayslipRepositoryImpl implements EmpPayslipRepository {

    private ArrayList<EmployeePayslip> employeePayslips;
    private static EmpPayslipRepositoryImpl empPayslipRepositoryImpl = null;

    private EmpPayslipRepositoryImpl(){
        this.employeePayslips = new ArrayList<>();
    }

    protected static EmpPayslipRepositoryImpl getEmpPayslipRepositoryImpl(){
        if(empPayslipRepositoryImpl == null){
            empPayslipRepositoryImpl = new EmpPayslipRepositoryImpl();
        }
        return empPayslipRepositoryImpl;
    }

    @Override
    public EmployeePayslip create(EmployeePayslip employeePayslip) {
        this.employeePayslips.add(employeePayslip);
        return employeePayslip;
    }

    @Override
    public EmployeePayslip update(EmployeePayslip employeePayslip) {
        boolean exists = false;
        int index = 0;

        for(int i = 0;i < employeePayslips.size();i++) {

            if (employeePayslips.get(i).getPayslipID() == employeePayslip.getPayslipID()) {
                exists = true;
                index = i;
                employeePayslips.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent customer.");
        }

        employeePayslips.add(index, employeePayslip);
        return employeePayslip;
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < employeePayslips.size();i++) {

            if (employeePayslips.get(i).getPayslipID() == id) {
                employeePayslips.remove(i);
            }
        }
    }

    @Override
    public EmployeePayslip read(String id) {
        int index = 0;
        boolean exists = false;

        for(int i = 0;i < employeePayslips.size();i++) {

            if (employeePayslips.get(i).getPayslipID() == id) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }
        return employeePayslips.get(index);
    }

    @Override
    public ArrayList<EmployeePayslip> getAll() {
        return employeePayslips;
    }

    @Override
    public void removeAll() {
        employeePayslips.removeAll(employeePayslips);
    }
}
