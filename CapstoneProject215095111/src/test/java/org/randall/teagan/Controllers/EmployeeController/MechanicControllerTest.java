package org.randall.teagan.Controllers.EmployeeController;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Employee.Mechanic;
import org.randall.teagan.Factory.EmployeeBuilders.MechanicBuilder;
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
public class MechanicControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/mechanic";

    @Test
    public void a_create() {

        Mechanic mechanic = MechanicBuilder.getMechanic("Mechanic", "MECH-080", "NDIP-MECH-ENG", "215095111");
        ResponseEntity<Mechanic> postResponse = restTemplate.postForEntity(baseURL + "/create", mechanic, Mechanic.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {

        String id = "215095222";
        Mechanic mechanic = restTemplate.getForObject(baseURL + "/mechanic/" + id, Mechanic.class);

        restTemplate.put(baseURL + "/mechanics/" + id, mechanic);
        Mechanic updatedMechanic = restTemplate.getForObject(baseURL + "/update/" + id, Mechanic.class);
        assertNotNull(updatedMechanic);
    }

    @Test
    public void e_delete() {

        String id = "215095222";
        Mechanic mechanic = restTemplate.getForObject(baseURL + "/mechanics/" + id, Mechanic.class);
        assertNotNull(mechanic);
        restTemplate.delete(baseURL + "/mechanics/" + id);
        try {
            mechanic = restTemplate.getForObject(baseURL + "/delete/" + id, Mechanic.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void b_read() {
        Mechanic readMechanic = restTemplate.getForObject(baseURL + "/read/215095111", Mechanic.class);
        System.out.println(readMechanic.toString());
        assertNotNull(readMechanic);
    }

    @Test
    public void d_getAll() {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers  );
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/readMechanic/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}