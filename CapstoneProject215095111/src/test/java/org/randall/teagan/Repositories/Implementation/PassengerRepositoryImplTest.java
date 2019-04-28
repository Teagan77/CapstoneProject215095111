package org.randall.teagan.Repositories.Implementation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Employee.Driver;
import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Domain.Trip.Passenger;
import org.randall.teagan.Domain.Trip.Route;
import org.randall.teagan.Domain.Trip.Trip;
import org.randall.teagan.Domain.Vehicle.BusType;
import org.randall.teagan.Domain.Vehicle.Vehicle;
import org.randall.teagan.Factory.CustomerBuilder.CustBuilder;
import org.randall.teagan.Factory.EmployeeBuilders.DriverBuilder;
import org.randall.teagan.Factory.TripBuilders.PassengerBuilder;
import org.randall.teagan.Factory.TripBuilders.RouteBuilder;
import org.randall.teagan.Factory.TripBuilders.TripBuilder;
import org.randall.teagan.Factory.VehicleBuilders.BusTypeBuilder;
import org.randall.teagan.Factory.VehicleBuilders.VehicleBuilder;

import java.util.ArrayList;
import java.util.Date;

public class PassengerRepositoryImplTest {

    private PassengerRepositoryImpl passengerRepositoryImpl;

    PassengerBuilder passengerBuilder = new PassengerBuilder();

    public Passenger createPassenger() {
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
        String routeID = "83883";
        String driverID = "5464";

        Driver driver = DriverBuilder.getDriver(jobTitle, posCode, licenseCode, driverID);

        Customer firstCust = CustBuilder.getCustomer(id, phone, custAge, name, surname, credit, gender, membership);

        ArrayList<Customer> passengers = new ArrayList<Customer>();
        passengers.add(firstCust);

        Route route = RouteBuilder.getRoute(startLoc, endLoc, routeName, routeID);

        BusType busType = BusTypeBuilder.getBusType(busTypeCode, busTypeName);

        Vehicle vehicle = VehicleBuilder.getVehicle(reg, busType, capacity);

        Trip trip = TripBuilder.getTrip(tripNo, date, driver, passengers, route, vehicle);

        Passenger firstPassenger = PassengerBuilder.getPassenger(firstCust, trip);

        return firstPassenger;
    }

    public Passenger createUpdatedPassenger() {
        String name = "Teagan";
        String surname = "Jefferson";
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
        String routeID = "903809";
        String driverID ="56465";

        Driver driver = DriverBuilder.getDriver(jobTitle, posCode, licenseCode,driverID);

        Customer firstCust = CustBuilder.getCustomer(id, phone, custAge, name, surname, credit, gender, membership);

        ArrayList<Customer> passengers = new ArrayList<Customer>();
        passengers.add(firstCust);

        Route route = RouteBuilder.getRoute(startLoc, endLoc, routeName, routeID);

        BusType busType = BusTypeBuilder.getBusType(busTypeCode, busTypeName);

        Vehicle vehicle = VehicleBuilder.getVehicle(reg, busType, capacity);

        Trip trip = TripBuilder.getTrip(tripNo, date, driver, passengers, route, vehicle);

        Passenger firstPassenger = PassengerBuilder.getPassenger(firstCust, trip);

        return firstPassenger;
    }

    public Passenger createSecondPassenger() {
        String name = "DK";
        String surname = "Basson";
        String phone = "0725576169";
        int custAge = 20;
        String id = "216151411";
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
        String routeID = "878722";
        String driverID = "88382";

        Driver driver = DriverBuilder.getDriver(jobTitle, posCode, licenseCode,driverID);

        Customer firstCust = CustBuilder.getCustomer(id, phone, custAge, name, surname, credit, gender, membership);

        ArrayList<Customer> passengers = new ArrayList<Customer>();
        passengers.add(firstCust);

        Route route = RouteBuilder.getRoute(startLoc, endLoc, routeName, routeID);

        BusType busType = BusTypeBuilder.getBusType(busTypeCode, busTypeName);

        Vehicle vehicle = VehicleBuilder.getVehicle(reg, busType, capacity);

        Trip trip = TripBuilder.getTrip(tripNo, date, driver, passengers, route, vehicle);

        Passenger firstPassenger = PassengerBuilder.getPassenger(firstCust, trip);

        return firstPassenger;
    }

    Passenger firstPassenger = createPassenger();
    Passenger secondPassenger = createSecondPassenger();
    Passenger updatedFirstPassenger = createUpdatedPassenger();

    @Before
    public void setUp(){
        this.passengerRepositoryImpl = PassengerRepositoryImpl.getPassengerRepositoryImpl();
    }

    @Test
    public void removeAll() {
        this.passengerRepositoryImpl.create(firstPassenger);
        ArrayList<Passenger> pass = this.passengerRepositoryImpl.getAll();
        this.passengerRepositoryImpl.removeAll();
        Assert.assertEquals( 0,pass.size());
    }

    @Test
    public void getAll() {
        this.passengerRepositoryImpl.create(firstPassenger);
        ArrayList<Passenger> pass = this.passengerRepositoryImpl.getAll();
        Assert.assertEquals(1, pass.size());
        this.passengerRepositoryImpl.removeAll();
    }

    @Test
    public void create() {
        Assert.assertEquals(firstPassenger.hashCode(), this.passengerRepositoryImpl.create(firstPassenger).hashCode());
        this.passengerRepositoryImpl.removeAll();
    }

    @Test
    public void update() {
        this.passengerRepositoryImpl.create(firstPassenger);
        this.passengerRepositoryImpl.update(updatedFirstPassenger);
        Assert.assertEquals("Jefferson", this.passengerRepositoryImpl.read(updatedFirstPassenger.getPassenger().getCustId()).getPassenger().getSurname());
        this.passengerRepositoryImpl.removeAll();
    }

    @Test
    public void delete() {
        this.passengerRepositoryImpl.create(firstPassenger);
        this.passengerRepositoryImpl.create(secondPassenger);
        this.passengerRepositoryImpl.delete(firstPassenger.getPassenger().getCustId());

        Assert.assertEquals(null, this.passengerRepositoryImpl.read(firstPassenger.getPassenger().getCustId()));
        this.passengerRepositoryImpl.removeAll();
    }

    @Test
    public void read() {
        this.passengerRepositoryImpl.create(firstPassenger);
        Assert.assertEquals(true, this.passengerRepositoryImpl.read(firstPassenger.getPassenger().getCustId()) instanceof Passenger);
        System.out.println(this.passengerRepositoryImpl.read(firstPassenger.getPassenger().getCustId()));
        this.passengerRepositoryImpl.removeAll();
    }
}