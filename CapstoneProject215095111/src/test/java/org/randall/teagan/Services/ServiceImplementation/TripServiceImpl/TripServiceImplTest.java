package org.randall.teagan.Services.ServiceImplementation.TripServiceImpl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Employee.Driver;
import org.randall.teagan.Domain.Membership.MemberType;
import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Domain.Trip.Passenger;
import org.randall.teagan.Domain.Trip.Route;
import org.randall.teagan.Domain.Trip.Trip;
import org.randall.teagan.Domain.Vehicle.BusType;
import org.randall.teagan.Domain.Vehicle.Vehicle;
import org.randall.teagan.Factory.CustomerBuilder.CustBuilder;
import org.randall.teagan.Factory.EmployeeBuilders.DriverBuilder;
import org.randall.teagan.Factory.MembershipBuilders.MemTypeBuilder;
import org.randall.teagan.Factory.MembershipBuilders.MembershipBuilder;
import org.randall.teagan.Factory.TripBuilders.PassengerBuilder;
import org.randall.teagan.Factory.TripBuilders.RouteBuilder;
import org.randall.teagan.Factory.TripBuilders.TripBuilder;
import org.randall.teagan.Factory.VehicleBuilders.BusTypeBuilder;
import org.randall.teagan.Factory.VehicleBuilders.VehicleBuilder;
import org.randall.teagan.Repositories.Implementation.TripRepositoryImpl.TripRepositoryImpl;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TripServiceImplTest {

    private TripRepositoryImpl tripRepositoryImpl;
    private Driver firstDriver;
    private Route firstRoute;
    private MemberType memberType;
    private Membership membership;
    private Customer firstCust;
    private Passenger firstPassenger;
    private Trip firstTrip;
    private Date date = new Date();
    private BusType busType;
    private Vehicle firstVehicle;


    private ArrayList<Customer> passengers;

    private Trip getSaved(){
        ListIterator<Trip> listItr = this.tripRepositoryImpl.getAllTrips().listIterator();
        return listItr.next();
    }

    @Before
    public void setUp() throws Exception {
        this.tripRepositoryImpl = TripRepositoryImpl.getTripRepository();
        this.membership = MembershipBuilder.getMembership(memberType, "10111");
        this.memberType = MemTypeBuilder.getMemberType("10211", "Full-Time");
        this.firstCust = CustBuilder.getCustomer("215095111", "Jeff", "Saunders",25, "0729865543",  50.00, "Male", membership);
        this.firstPassenger = PassengerBuilder.getPassenger(firstCust);
        this.passengers = new ArrayList<>();
        passengers.add(firstCust);
        this.busType = BusTypeBuilder.getBusType("CTY-008","Minibus");
        this.firstVehicle = VehicleBuilder.getVehicle("CT 00983",busType,50);
        this.firstRoute = RouteBuilder.getRoute("City Centre", "Ottery", "Cape Town 351", "CT351");
        this.firstDriver = DriverBuilder.getDriver("Driver", "DRV002", "C", "218952678");
        this.firstTrip = TripBuilder.getTrip("215095111", date, firstDriver, passengers, firstRoute, firstVehicle);
    }

    @Test
    public void a_create() {
        Trip createdTrip = this.tripRepositoryImpl.create(this.firstTrip);
        System.out.println("In create, created = " + createdTrip);
        Assert.assertNotNull(createdTrip);
        Assert.assertSame(createdTrip, this.firstTrip);
    }

    @Test
    public void c_update() {
        String newTripNo = "88992548";
        Trip updatedTrip = new Trip.TripBuilder().copy(getSaved()).tripNo(newTripNo).build();
        System.out.println("In update, updated = " + updatedTrip);
        this.tripRepositoryImpl.update(updatedTrip);
        Assert.assertSame(newTripNo, updatedTrip.getTripNo());
    }

    @Test
    public void e_delete() {
        Trip savedTrip = getSaved();
        this.tripRepositoryImpl.delete(savedTrip.getTripNo());
        d_getAll();
    }

    @Test
    public void b_read() {
        Trip savedTrip = getSaved();
        Trip readTrip = this.tripRepositoryImpl.read(savedTrip.getTripNo());
        System.out.println("In read, read = "+ readTrip);
        Assert.assertSame(readTrip, savedTrip);
    }

    @Test
    public void d_getAll() {
        ArrayList<Trip> trips = this.tripRepositoryImpl.getAllTrips();
        System.out.println("In getall, all = " + trips);
    }
}