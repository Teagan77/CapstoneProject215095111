package org.randall.teagan.Repositories.Implementation;

import org.randall.teagan.Domain.Vehicle.Vehicle;
import org.randall.teagan.Repositories.RepositoryInterfaces.VehicleRepository;

import java.util.ArrayList;

public class VehicleRepositoryImpl implements VehicleRepository {

    private ArrayList<Vehicle> vehicles;

    private static VehicleRepositoryImpl vehicleRepositoryImpl = null;

    private VehicleRepositoryImpl(){
        vehicles = new ArrayList<>();
    }

    protected static VehicleRepositoryImpl getVehicleRepositoryImpl(){
        if(vehicleRepositoryImpl == null){
            vehicleRepositoryImpl = new VehicleRepositoryImpl();
        }
        return vehicleRepositoryImpl;
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        this.vehicles.add(vehicle);
        return vehicle;
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        boolean exists = false;
        int index = 0;

        for(int i = 0;i < vehicles.size();i++) {

            if (vehicles.get(i).getRegistration() == vehicle.getRegistration()) {
                exists = true;
                index = i;
                vehicles.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent vehicle.");
        }

        vehicles.add(index, vehicle);
        return vehicle;
    }

    @Override
    public void delete(String id) {
        for(int i = 0;i < vehicles.size();i++) {

            if (vehicles.get(i).getRegistration() == id) {
                vehicles.remove(i);
            }
        }
    }

    @Override
    public Vehicle read(String id) {
        int index = 0;
        boolean exists = false;

        for(int i = 0;i < vehicles.size();i++) {

            if (vehicles.get(i).getRegistration() == id) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }

        return vehicles.get(index);
    }

    @Override
    public ArrayList<Vehicle> getAll() {
        return vehicles;
    }

    @Override
    public void removeAll() {
        vehicles.removeAll(vehicles);
    }
}
