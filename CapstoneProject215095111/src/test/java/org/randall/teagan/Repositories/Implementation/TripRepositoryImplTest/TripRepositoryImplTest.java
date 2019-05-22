package org.randall.teagan.Repositories.Implementation.TripRepositoryImplTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Employee.Driver;
import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Domain.Trip.Route;
import org.randall.teagan.Domain.Trip.Trip;
import org.randall.teagan.Domain.Vehicle.BusType;
import org.randall.teagan.Domain.Vehicle.Vehicle;
import org.randall.teagan.Factory.CustomerBuilder.CustBuilder;
import org.randall.teagan.Factory.EmployeeBuilders.DriverBuilder;
import org.randall.teagan.Factory.TripBuilders.RouteBuilder;
import org.randall.teagan.Factory.TripBuilders.TripBuilder;
import org.randall.teagan.Factory.VehicleBuilders.BusTypeBuilder;
import org.randall.teagan.Factory.VehicleBuilders.VehicleBuilder;
import org.randall.teagan.Repositories.Implementation.TripRepositoryImpl.TripRepositoryImpl;

import java.util.ArrayList;
import java.util.Date;

public class TripRepositoryImplTest {

    private TripRepositoryImpl tripRepositoryImpl;

    TripBuilder tripBuilder = new TripBuilder();

    public Trip getFirstTrip() {
        String name = "Teagan";
        String surname = "Randall";
        String phone = "0734771369";
        int custAge = 22;
        String id = "215095111";
        double credit = 0.0;
        String gender = "male";
        Membership membership = new Membership();
        String tripNo = "Z34029";
        Date date = new Date();
        String jobTitle = "Driver";
        String posCode = "DR004";
        String licenseCode = "C";
        String startLoc = "CapeTown";
        String endLoc = "Belville";
        String routeName = "BZ304";
        String reg = "CT8393";
        int capacity = 40;
        String busTypeCode = "L839";
        String busTypeName = "MidiBus";
        String routeID = "371893";
        String driverID = "56468";

        Driver driver = DriverBuilder.getDriver(jobTitle, posCode, licenseCode, driverID);

        Customer firstCust = CustBuilder.getCustomer(id, name, surname, custAge, phone, credit, gender, membership);

        ArrayList<Customer> passengers = new ArrayList<>();
        passengers.add(firstCust);

        Route route = RouteBuilder.getRoute(startLoc, endLoc, routeName, routeID);

        BusType busType = BusTypeBuilder.getBusType(busTypeCode, busTypeName);

        Vehicle vehicle = VehicleBuilder.getVehicle(reg, busType, capacity);

        Trip trip = TripBuilder.getTrip(tripNo, date, driver, passengers, route, vehicle);

        return trip;
    }

    public Trip getUpdatedFirstTrip() {
        String name = "Teagan";
        String surname = "Eric";
        String phone = "0734771369";
        int custAge = 22;
        String id = "215095111";
        double credit = 0.0;
        String gender = "male";
        Membership membership = new Membership();
        String tripNo = "Z34029";
        Date date = new Date();
        String jobTitle = "Driver";
        String posCode = "DR004";
        String licenseCode = "C";
        String startLoc = "CapeTown";
        String endLoc = "Belville";
        String routeName = "BZ304";
        String reg = "CT8393";
        int capacity = 40;
        String busTypeCode = "L839";
        String busTypeName = "MidiBus";
        String routeID ="373737";
        String driverID = "098309";

        Driver driver = DriverBuilder.getDriver(jobTitle, posCode, licenseCode, driverID);

        Customer firstCust = CustBuilder.getCustomer(id, name, surname, custAge, phone, credit, gender, membership);

        ArrayList<Customer> passengers = new ArrayList<>();
        passengers.add(firstCust);

        Route route = RouteBuilder.getRoute(startLoc, endLoc, routeName, routeID);

        BusType busType = BusTypeBuilder.getBusType(busTypeCode, busTypeName);

        Vehicle vehicle = VehicleBuilder.getVehicle(reg, busType, capacity);

        Trip trip = TripBuilder.getTrip(tripNo, date, driver, passengers, route, vehicle);

        return trip;
    }

    public Trip getSecondTrip() {
        String name = "DK";
        String surname = "Basson";
        String phone = "0253671869";
        int custAge = 20;
        String id = "216158911";
        double credit = 0.0;
        String gender = "male";
        Membership membership = new Membership();
        String tripNo = "Z34429";
        Date date = new Date();
        String jobTitle = "Driver";
        String posCode = "DR004";
        String licenseCode = "C";
        String startLoc = "CapeTown";
        String endLoc = "Belville";
        String routeName = "BZ304";
        String reg = "CT8393";
        int capacity = 40;
        String busTypeCode = "L839";
        String busTypeName = "MidiBus";
        String routeID = "73737";
        String driverID = "98390";

        Driver driver = DriverBuilder.getDriver(jobTitle, posCode, licenseCode,driverID);

        Customer firstCust = CustBuilder.getCustomer(id, name, surname, custAge, phone, credit, gender, membership);

        ArrayList<Customer> passengers = new ArrayList<>();
        passengers.add(firstCust);

        Route route = RouteBuilder.getRoute(startLoc, endLoc, routeName, routeID);

        BusType busType = BusTypeBuilder.getBusType(busTypeCode, busTypeName);

        Vehicle vehicle = VehicleBuilder.getVehicle(reg, busType, capacity);

        Trip trip = TripBuilder.getTrip(tripNo, date, driver, passengers, route, vehicle);

        return trip;
    }

    Trip firstTrip = getFirstTrip();
    Trip secondTrip = getSecondTrip();
    Trip updatedFirstTrip = getUpdatedFirstTrip();

    @Before
    public void setUp() throws Exception {
        this.tripRepositoryImpl = TripRepositoryImpl.getTripRepository();
    }
    @Test
    public void create() {
        Assert.assertEquals(firstTrip.hashCode(), this.tripRepositoryImpl.create(firstTrip).hashCode());
        this.tripRepositoryImpl.removeAllTrips();
    }

    @Test
    public void update() {
        this.tripRepositoryImpl.create(firstTrip);
        this.tripRepositoryImpl.update(updatedFirstTrip);
        Assert.assertEquals("Eric", this.tripRepositoryImpl.read(updatedFirstTrip.getTripNo()).getPassengers().get(0).getCustLastName());
        this.tripRepositoryImpl.removeAllTrips();
    }

    @Test
    public void delete() {
        this.tripRepositoryImpl.create(firstTrip);
        this.tripRepositoryImpl.create(secondTrip);
        this.tripRepositoryImpl.delete(firstTrip.getTripNo());

        Assert.assertEquals(null, this.tripRepositoryImpl.read(firstTrip.getTripNo()));
        this.tripRepositoryImpl.removeAllTrips();
    }

    @Test
    public void read() {
        this.tripRepositoryImpl.create(firstTrip);
        Assert.assertEquals(true, this.tripRepositoryImpl.read(firstTrip.getTripNo()) instanceof Trip);
        System.out.println(this.tripRepositoryImpl.read(firstTrip.getTripNo()));
        this.tripRepositoryImpl.removeAllTrips();
    }

    @Test
    public void removeAllTrips() {
        this.tripRepositoryImpl.create(firstTrip);
        ArrayList<Trip> trips = this.tripRepositoryImpl.getAllTrips();
        this.tripRepositoryImpl.removeAllTrips();
        Assert.assertEquals( 0,trips.size());
    }

    @Test
    public void getAllTrips() {
        this.tripRepositoryImpl.create(firstTrip);
        ArrayList<Trip> trips = this.tripRepositoryImpl.getAllTrips();
        Assert.assertEquals(1, trips.size());
        this.tripRepositoryImpl.removeAllTrips();
    }
}