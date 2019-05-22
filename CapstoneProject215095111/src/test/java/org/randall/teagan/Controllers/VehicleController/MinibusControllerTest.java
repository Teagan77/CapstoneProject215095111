package org.randall.teagan.Controllers.VehicleController;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Vehicle.Minibus;
import org.randall.teagan.Factory.VehicleBuilders.MinibusBuilder;
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
public class MinibusControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/minibus";

    @Test
    public void a_create() {
        String busTypeCode = "215095111";
        String busTypeName = "Minibus";

        Minibus minibus = MinibusBuilder.getMinibus(busTypeCode,busTypeName);

        ResponseEntity<Minibus> postResponse = restTemplate.postForEntity(baseURL + "/create", minibus, Minibus.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {

        String id = "215095222";
        Minibus minibus = restTemplate.getForObject(baseURL + "/minibus/" + id, Minibus.class);

        restTemplate.put(baseURL + "/minibuses/" + id, minibus);
        Minibus updatedMinibus = restTemplate.getForObject(baseURL + "/update/" + id, Minibus.class);
        assertNotNull(updatedMinibus);
    }

    @Test
    public void e_delete() {

        String id = "215095222";
        Minibus minibus = restTemplate.getForObject(baseURL + "/minibuses/" + id, Minibus.class);
        assertNotNull(minibus);
        restTemplate.delete(baseURL + "/minibuses/" + id);
        try {
            minibus = restTemplate.getForObject(baseURL + "/delete/" + id, Minibus.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void b_read() {
        Minibus readMinibus = restTemplate.getForObject(baseURL + "/read/215095111", Minibus.class);
        System.out.println(readMinibus.toString());
        assertNotNull(readMinibus);
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