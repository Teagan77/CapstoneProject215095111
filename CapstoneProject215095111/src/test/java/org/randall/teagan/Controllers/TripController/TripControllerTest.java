package org.randall.teagan.Controllers.TripController;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.Date;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TripControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/trip";

    @Test
    public void a_create() {

        String name = "Teagan";
        String surname = "Randall";
        String phone = "0734771369";
        int custAge = 22;
        String id = "115155666";
        String tripNo = "215095111";
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
        String routeID = "8380972";
        String driverID = "54654";

        Driver driver = DriverBuilder.getDriver(jobTitle,posCode,licenseCode, driverID);

        Customer firstCust = CustBuilder.getCustomer(id, name, surname, custAge, phone);

        ArrayList<Customer> passengers = new ArrayList<>();
        passengers.add(firstCust);

        Route route = RouteBuilder.getRoute(startLoc,endLoc,routeName,routeID);

        BusType busType = BusTypeBuilder.getBusType(busTypeCode,busTypeName);

        Vehicle vehicle = VehicleBuilder.getVehicle(reg,busType,capacity);

        Trip trip = TripBuilder.getTrip(tripNo,date,driver,passengers,route,vehicle);

        ResponseEntity<Trip> postResponse = restTemplate.postForEntity(baseURL + "/create", trip, Trip.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {

        String id = "215095222";
        Trip trip = restTemplate.getForObject(baseURL + "/trip/" + id, Trip.class);

        restTemplate.put(baseURL + "/trips/" + id, trip);
        Trip updatedTrip = restTemplate.getForObject(baseURL + "/update/" + id, Trip.class);
        assertNotNull(updatedTrip);
    }

    @Test
    public void e_delete() {

        String id = "215095222";
        Trip trip = restTemplate.getForObject(baseURL + "/trips/" + id, Trip.class);
        assertNotNull(trip);
        restTemplate.delete(baseURL + "/trips/" + id);
        try {
            trip = restTemplate.getForObject(baseURL + "/delete/" + id, Trip.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void b_read() {
        Trip readTrip = restTemplate.getForObject(baseURL + "/read/215095111", Trip.class);
        System.out.println(readTrip.toString());
        assertNotNull(readTrip);
    }

    @Test
    public void d_getAll() {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers  );
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}