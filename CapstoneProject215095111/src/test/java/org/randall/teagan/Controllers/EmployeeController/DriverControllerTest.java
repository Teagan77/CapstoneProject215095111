package org.randall.teagan.Controllers.EmployeeController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.randall.teagan.Domain.Employee.Driver;
import org.randall.teagan.Factory.EmployeeBuilders.DriverBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class DriverControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL="http://localhost:8080/driver";

    @Test
    public void create() {
        Driver driver = DriverBuilder.getDriver("Driver","DR-005","C", "1");

        ResponseEntity<Driver> postResponse = restTemplate.postForEntity(baseURL + "/createDriver", driver, Driver.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void update() {
        int id = 1;
        Driver driver = restTemplate.getForObject(baseURL + "/driver/" + id, Driver.class);

        restTemplate.put(baseURL + "/drivers/" + id, driver);
        Driver updatedDriver = restTemplate.getForObject(baseURL + "/updateDriver/" + id, Driver.class);
        assertNotNull(updatedDriver);
    }

    @Test
    public void delete() {
        int id = 2;
        Driver driver = restTemplate.getForObject(baseURL + "/drivers/" + id, Driver.class);
        assertNotNull(driver);
        restTemplate.delete(baseURL + "/drivers/" + id);
        try {
            driver = restTemplate.getForObject(baseURL + "/deleteDriver/" + id, Driver.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void read() {
        Driver driver = restTemplate.getForObject(baseURL + "/read/1", Driver.class);
        System.out.println(driver.toString());
        assertNotNull(driver);
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/readDriver/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}