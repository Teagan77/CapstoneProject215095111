package org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl;

import org.randall.teagan.Domain.Employee.Mechanic;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.MechanicRepositoryImpl;
import org.randall.teagan.Services.ServicesInterfaces.EmpServiceInterface.MechanicServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("MechanicServiceImpl")
public class MechanicServiceImpl implements MechanicServiceInterface {

    @Autowired
    @Qualifier("MechanicRepository")
    private MechanicRepositoryImpl mechanicRepositoryImpl;

    @Override
    public Mechanic create(Mechanic mechanic) {
        return mechanicRepositoryImpl.create(mechanic);
    }

    @Override
    public Mechanic update(Mechanic mechanic) {
        return mechanicRepositoryImpl.update(mechanic);
    }

    @Override
    public void delete(String mechanicId) {
        mechanicRepositoryImpl.delete(mechanicId);
    }

    @Override
    public Mechanic read(String mechanicId) {
        return mechanicRepositoryImpl.read(mechanicId);
    }

    @Override
    public ArrayList<Mechanic> getAll() {
        return mechanicRepositoryImpl.getAll();
    }
}
