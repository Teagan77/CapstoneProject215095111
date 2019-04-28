package org.randall.teagan.Repositories.Implementation;

import org.randall.teagan.Domain.Employee.Driver;
import org.randall.teagan.Repositories.RepositoryInterfaces.DriverRepository;

import java.util.ArrayList;

public class DriverRepositoryImpl implements DriverRepository {

    private ArrayList<Driver> drivers;

    private static DriverRepositoryImpl driverRepositoryImpl = null;

    private DriverRepositoryImpl(){
        this.drivers = new ArrayList<>();
    }

    protected static DriverRepositoryImpl getDriverRepositoryImpl(){
        if(driverRepositoryImpl == null){
            driverRepositoryImpl = new DriverRepositoryImpl();
        }
        return driverRepositoryImpl;
    }

    @Override
    public Driver create(Driver driver) {
        this.drivers.add(driver);
        return driver;
    }

    @Override
    public Driver update(Driver driver) {

        boolean exists = false;
        int index = 0;

        for(int i = 0;i < drivers.size();i++) {

            if (drivers.get(i).getDriverID() == driver.getDriverID()) {
                exists = true;
                index = i;
                drivers.remove(i);
            }
        }
        if(!exists) {
            System.out.println("Cannot update a non-existent driver");
        }

        drivers.add(index, driver);
        return driver;
    }

    @Override
    public void delete(String id) {

        for(int i = 0;i < drivers.size();i++) {

            if (drivers.get(i).getDriverID() == id) {
                drivers.remove(i);
            }
        }

    }

    @Override
    public Driver read(String id) {

        int index = 0;
        boolean exists = false;

        for(int i = 0;i < drivers.size();i++) {

            if (drivers.get(i).getDriverID() == id) {
                index = i;
                exists = true;
            }
        }

        if (!exists) {
            return null;
        }

        return drivers.get(index);
    }

    @Override
    public ArrayList<Driver> getAll() {
        return drivers;
    }

    @Override
    public void removeAll() {
        drivers.removeAll(drivers);
    }
}
