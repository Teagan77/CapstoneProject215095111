package org.randall.teagan.Services.ServiceImplementation.VehicleServiceImpl;

import org.randall.teagan.Domain.Vehicle.Vehicle;
import org.randall.teagan.Repositories.Implementation.VehicleRepositoryImpl.VehicleRepositoryImpl;
import org.randall.teagan.Services.ServicesInterfaces.VehicleServiceInterface.VehicleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service("VehicleServiceImpl")
public class VehicleServiceImpl implements VehicleServiceInterface {

    @Autowired
    @Qualifier("VehicleRepository")
    private VehicleRepositoryImpl vehicleRepositoryImpl;

    @Override
    public Vehicle create(Vehicle vehicle) {
        return vehicleRepositoryImpl.create(vehicle);
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        return vehicleRepositoryImpl.update(vehicle);
    }

    @Override
    public void delete(String regNo) {
        vehicleRepositoryImpl.delete(regNo);
    }

    @Override
    public Vehicle read(String regNo) {
        return vehicleRepositoryImpl.read(regNo);
    }

    @Override
    public ArrayList<Vehicle> getAll() {
        return vehicleRepositoryImpl.getAll();
    }
}
