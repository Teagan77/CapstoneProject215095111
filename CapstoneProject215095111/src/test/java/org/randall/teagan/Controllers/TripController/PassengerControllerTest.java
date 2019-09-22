package org.randall.teagan.Controllers.TripController;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PassengerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/passenger";

    @Test
    public void a_create() {

        String name = "Teagan";
        String surname = "Randall";
        String phone = "0734771369";
        int custAge = 22;
        String id = "215095111";
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
        String routeID = "87382";
        String driverID = "0051";

        Driver driver = DriverBuilder.getDriver(jobTitle,posCode,licenseCode, driverID);

        Customer firstCust = CustBuilder.getCustomer(id, name, surname, custAge, phone);

        ArrayList<Customer> passengers = new ArrayList<>();
        passengers.add(firstCust);

        Route route = RouteBuilder.getRoute(startLoc,endLoc,routeName, routeID);

        BusType busType = BusTypeBuilder.getBusType(busTypeCode,busTypeName);

        Vehicle vehicle = VehicleBuilder.getVehicle(reg,busType,capacity);

        Passenger passenger = PassengerBuilder.getPassenger(firstCust);
        ResponseEntity<Passenger> postResponse = restTemplate.postForEntity(baseURL + "/create", passenger, Passenger.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {

        String id = "215095222";
        Passenger passenger = restTemplate.getForObject(baseURL + "/passenger/" + id, Passenger.class);

        restTemplate.put(baseURL + "/passengers/" + id, passenger);
        Passenger updatedPassenger = restTemplate.getForObject(baseURL + "/update/" + id, Passenger.class);
        assertNotNull(updatedPassenger);
    }

    @Test
    public void e_delete() {

        String id = "215095222";
        Passenger passenger = restTemplate.getForObject(baseURL + "/passengers/" + id, Passenger.class);
        assertNotNull(passenger);
        restTemplate.delete(baseURL + "/passengers/" + id);
        try {
            passenger = restTemplate.getForObject(baseURL + "/delete/" + id, Passenger.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void b_read() {
        Passenger readPassenger = restTemplate.getForObject(baseURL + "/read/215095111", Passenger.class);
        System.out.println(readPassenger.getPassenger());
        assertNotNull(readPassenger);
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