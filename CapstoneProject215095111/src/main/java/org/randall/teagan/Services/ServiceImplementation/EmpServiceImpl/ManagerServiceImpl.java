package org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl;

import org.randall.teagan.Domain.Employee.Manager;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.ManagerRepositoryImpl;
import org.randall.teagan.Services.ServicesInterfaces.EmpServiceInterface.ManagerServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("ManagerServiceImpl")
public class ManagerServiceImpl implements ManagerServiceInterface {

    @Autowired
    @Qualifier("ManagerRepository")
    private ManagerRepositoryImpl managerRepositoryImpl;

    @Override
    public Manager create(Manager manager) {
        return managerRepositoryImpl.create(manager);
    }

    @Override
    public Manager update(Manager manager) {
        return managerRepositoryImpl.update(manager);
    }

    @Override
    public void delete(String staffId) {
        managerRepositoryImpl.delete(staffId);
    }

    @Override
    public Manager read(String staffId) {
        return managerRepositoryImpl.read(staffId);
    }

    @Override
    public ArrayList<Manager> getAll() {
        return managerRepositoryImpl.getAll();
    }
}
