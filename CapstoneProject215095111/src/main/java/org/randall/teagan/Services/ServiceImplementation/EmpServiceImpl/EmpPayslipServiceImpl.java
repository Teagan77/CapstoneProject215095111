package org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl;

import org.randall.teagan.Domain.Employee.EmployeePayslip;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.EmpPayslipRepositoryImpl;
import org.randall.teagan.Services.ServicesInterfaces.EmpServiceInterface.EmpPayslipInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("EmpPayslipServiceImpl")
public class EmpPayslipServiceImpl implements EmpPayslipInterface {

    @Autowired
    @Qualifier("EmployeePayslipRepository")
    private EmpPayslipRepositoryImpl empPayslipRepositoryImpl;

    @Override
    public EmployeePayslip create(EmployeePayslip employeePayslip) {
        return empPayslipRepositoryImpl.create(employeePayslip);
    }

    @Override
    public EmployeePayslip update(EmployeePayslip employeePayslip) {
        return empPayslipRepositoryImpl.update(employeePayslip);
    }

    @Override
    public void delete(String payslipID) {
        empPayslipRepositoryImpl.delete(payslipID);
    }

    @Override
    public EmployeePayslip read(String payslipID) {
        return empPayslipRepositoryImpl.read(payslipID);
    }

    @Override
    public ArrayList<EmployeePayslip> getAll() {
        return empPayslipRepositoryImpl.getAll();
    }
}
