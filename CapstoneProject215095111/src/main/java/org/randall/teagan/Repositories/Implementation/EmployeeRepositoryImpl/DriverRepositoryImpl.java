package org.randall.teagan.Repositories.Implementation.EmployeeRepositoryImpl;

import org.randall.teagan.Domain.Employee.Driver;
import org.randall.teagan.Repositories.RepositoryInterfaces.EmployeeRepositoryInterface.DriverRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository("DriverRepository")
public class DriverRepositoryImpl implements DriverRepository {

    private ArrayList<Driver> drivers;
    private static DriverRepositoryImpl driverRepositoryImpl = null;

    private DriverRepositoryImpl(){
        this.drivers = new ArrayList<>();
    }

    public static DriverRepositoryImpl getDriverRepositoryImpl(){
        if(driverRepositoryImpl == null){
            driverRepositoryImpl = new DriverRepositoryImpl();
        }
        return driverRepositoryImpl;
    }

    public Driver create(Driver driver) {
        this.drivers.add(driver);
        return driver;
    }

    public Driver read(String id) {

        for (Driver driver : drivers) {
            if (driver.getDriverID().equals(id)) {
                return driver;
            }
        }
        return null;
    }

    public Driver update(Driver driver) {

        Driver toDelete = findDriver(driver.getDriverID());
        if(toDelete != null) {
            this.drivers.remove(toDelete);
            return create(driver);
        }
        return null;
    }

    public void delete(String id) {

        for(int i = 0;i < drivers.size();i++) {

            if (drivers.get(i).getDriverID().equals(id)) {
                drivers.remove(i);
            }
        }
    }

    private Driver findDriver(String driverID) {
        return this.drivers.stream()
                .filter(driver -> driver.getDriverID().trim().equals(driverID))
                .findAny()
                .orElse(null);
    }

    public ArrayList<Driver> getAll() {
        return drivers;
    }


    public void removeAll() {
        drivers.removeAll(drivers);
    }
}
