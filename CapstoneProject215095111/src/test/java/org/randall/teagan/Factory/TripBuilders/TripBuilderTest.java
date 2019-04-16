package org.randall.teagan.Factory.TripBuilders;

import org.junit.Assert;
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
import org.randall.teagan.Factory.VehicleBuilders.BusTypeBuilder;
import org.randall.teagan.Factory.VehicleBuilders.VehicleBuilder;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

public class TripBuilderTest {

    @Test
    public void getTrip() {

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

        Driver driver = DriverBuilder.getDriver(jobTitle,posCode,licenseCode);

        Customer firstCust = CustBuilder.getCustomer(id,name,surname,phone,custAge,credit,gender, membership);

        ArrayList<Customer> passengers = new ArrayList<>();
        passengers.add(firstCust);

        Route route = RouteBuilder.getRoute(startLoc,endLoc,routeName);

        BusType busType = BusTypeBuilder.getBusType(busTypeCode,busTypeName);

        Vehicle vehicle = VehicleBuilder.getVehicle(reg,busType,capacity);

        Trip trip = TripBuilder.getTrip(tripNo,date,driver,passengers,route,vehicle);

        System.out.println(trip);
        Assert.assertNotNull(trip.getPassengers());
    }
}