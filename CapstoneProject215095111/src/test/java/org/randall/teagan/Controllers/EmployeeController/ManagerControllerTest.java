package org.randall.teagan.Controllers.EmployeeController;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Employee.Manager;
import org.randall.teagan.Domain.Membership.MemberType;
import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Factory.CustomerBuilder.CustBuilder;
import org.randall.teagan.Factory.EmployeeBuilders.ManagerBuilder;
import org.randall.teagan.Factory.MembershipBuilders.MemTypeBuilder;
import org.randall.teagan.Factory.MembershipBuilders.MembershipBuilder;
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
public class ManagerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/manager";

    @Test
    public void a_create() {

        Manager manager = ManagerBuilder.getManager("Manager", "MGR-001", "BTECH BSNS", "215095111");
        ResponseEntity<Manager> postResponse = restTemplate.postForEntity(baseURL + "/create", manager, Manager.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {

        String id = "215095222";
        Manager manager = restTemplate.getForObject(baseURL + "/manager/" + id, Manager.class);

        restTemplate.put(baseURL + "/managers/" + id, manager);
        Manager updatedManager = restTemplate.getForObject(baseURL + "/update/" + id, Manager.class);
        assertNotNull(updatedManager);
    }

    @Test
    public void e_delete() {

        String id = "215095222";
        Manager manager = restTemplate.getForObject(baseURL + "/managers/" + id, Manager.class);
        assertNotNull(manager);
        restTemplate.delete(baseURL + "/managers/" + id);
        try {
            manager = restTemplate.getForObject(baseURL + "/delete/" + id, Manager.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void b_read() {
        Manager readManager = restTemplate.getForObject(baseURL + "/read/215095111", Manager.class);
        System.out.println(readManager.toString());
        assertNotNull(readManager);
    }

    @Test
    public void d_getAll() {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers  );
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/readManager/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}