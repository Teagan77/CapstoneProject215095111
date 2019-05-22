package org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl;

import org.randall.teagan.Domain.Employee.Driver;
import org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl.DriverRepositoryImpl;
import org.randall.teagan.Services.ServicesInterfaces.EmpServiceInterface.DriverServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("DriverServiceImpl")
public class DriverServiceImpl implements DriverServiceInterface {

    @Autowired
    @Qualifier("DriverRepository")
    private DriverRepositoryImpl driverRepositoryImpl;

    @Override
    public Driver create(Driver driver) {
        return driverRepositoryImpl.create(driver);
    }

    @Override
    public Driver update(Driver driver) {
        return driverRepositoryImpl.update(driver);
    }

    @Override
    public void delete(String driverId) {
        driverRepositoryImpl.delete(driverId);
    }

    @Override
    public Driver read(String driverId) {
        return driverRepositoryImpl.read(driverId);
    }

    @Override
    public ArrayList<Driver> getAll() {
        return driverRepositoryImpl.getAll();
    }
}
