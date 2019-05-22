package org.randall.teagan.Controllers.VehicleController;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Vehicle.Cityliner;
import org.randall.teagan.Factory.VehicleBuilders.CitylinerBuilder;
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
public class CityLinerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/cityliner";

    @Test
    public void a_create() {
        String busTypeCode = "215095111";
        String busTypeName = "CityLiner";

        Cityliner cityliner = CitylinerBuilder.getCityliner(busTypeCode,busTypeName);

        ResponseEntity<Cityliner> postResponse = restTemplate.postForEntity(baseURL + "/create", cityliner, Cityliner.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {

        String id = "215095222";
        Cityliner cityliner = restTemplate.getForObject(baseURL + "/cityliner/" + id, Cityliner.class);

        restTemplate.put(baseURL + "/cityliners/" + id, cityliner);
        Cityliner updatedCityliner = restTemplate.getForObject(baseURL + "/update/" + id, Cityliner.class);
        assertNotNull(updatedCityliner);
    }

    @Test
    public void e_delete() {

        String id = "215095222";
        Cityliner cityliner = restTemplate.getForObject(baseURL + "/cityliners/" + id, Cityliner.class);
        assertNotNull(cityliner);
        restTemplate.delete(baseURL + "/cityliners/" + id);
        try {
            cityliner = restTemplate.getForObject(baseURL + "/delete/" + id, Cityliner.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void b_read() {
        Cityliner readCityliner = restTemplate.getForObject(baseURL + "/read/215095111", Cityliner.class);
        System.out.println(readCityliner.toString());
        assertNotNull(readCityliner);
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