package org.randall.teagan.Controllers.VehicleController;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Vehicle.Midibus;
import org.randall.teagan.Factory.VehicleBuilders.MidibusBuilder;
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
public class MidibusControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/midibus";

    @Test
    public void a_create() {
        String busTypeCode = "215095111";
        String busTypeName = "Midibus";

        Midibus midibus = MidibusBuilder.getMidibus(busTypeCode,busTypeName);

        ResponseEntity<Midibus> postResponse = restTemplate.postForEntity(baseURL + "/create", midibus, Midibus.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {

        String id = "215095222";
        Midibus midibus = restTemplate.getForObject(baseURL + "/midibus/" + id, Midibus.class);

        restTemplate.put(baseURL + "/midibuses/" + id, midibus);
        Midibus updatedMinibus = restTemplate.getForObject(baseURL + "/update/" + id, Midibus.class);
        assertNotNull(updatedMinibus);
    }

    @Test
    public void e_delete() {

        String id = "215095222";
        Midibus midibus = restTemplate.getForObject(baseURL + "/midibuses/" + id, Midibus.class);
        assertNotNull(midibus);
        restTemplate.delete(baseURL + "/midibuses/" + id);
        try {
            midibus = restTemplate.getForObject(baseURL + "/delete/" + id, Midibus.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void b_read() {
        Midibus readMidibus = restTemplate.getForObject(baseURL + "/read/215095111", Midibus.class);
        System.out.println(readMidibus.toString());
        assertNotNull(readMidibus);
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