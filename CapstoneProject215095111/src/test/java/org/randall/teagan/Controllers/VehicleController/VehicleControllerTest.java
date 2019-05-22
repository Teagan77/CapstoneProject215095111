package org.randall.teagan.Controllers.VehicleController;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Vehicle.BusType;
import org.randall.teagan.Domain.Vehicle.Vehicle;
import org.randall.teagan.Factory.VehicleBuilders.BusTypeBuilder;
import org.randall.teagan.Factory.VehicleBuilders.VehicleBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VehicleControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/vehicle";

    @Test
    public void a_create() {

        String reg = "215095111";
        int capacity = 45;
        String busTypeCode = "L7676";
        String busTypeName = "CityLiner";

        BusType busType = BusTypeBuilder.getBusType(busTypeCode,busTypeName);

        Vehicle vehicle = VehicleBuilder.getVehicle(reg,busType,capacity);

        ResponseEntity<Vehicle> postResponse = restTemplate.postForEntity(baseURL + "/create", vehicle, Vehicle.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {

        String id = "215095222";
        Vehicle vehicle = restTemplate.getForObject(baseURL + "/vehicle/" + id, Vehicle.class);

        restTemplate.put(baseURL + "/vehicles/" + id, vehicle);
        Vehicle updatedVehicle = restTemplate.getForObject(baseURL + "/update/" + id, Vehicle.class);
        assertNotNull(updatedVehicle);
    }

    @Test
    public void e_delete() {

        String id = "215095222";
        Vehicle vehicle = restTemplate.getForObject(baseURL + "/vehicles/" + id, Vehicle.class);
        assertNotNull(vehicle);
        restTemplate.delete(baseURL + "/vehicles/" + id);
        try {
            vehicle = restTemplate.getForObject(baseURL + "/delete/" + id, Vehicle.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void b_read() {
        Vehicle readVehicle = restTemplate.getForObject(baseURL + "/read/215095111", Vehicle.class);
        System.out.println(readVehicle.toString());
        assertNotNull(readVehicle);
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