package org.randall.teagan.Controllers.EmployeeController;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Employee.*;
import org.randall.teagan.Factory.EmployeeBuilders.*;
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
public class IssueStaffControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/issueStaff";

    @Test
    public void a_create() {

        IssueStaff issueStaff = IssueStaffBuilder.getIssueStaff("IssueStaff", "ISS-004","215095111");
        ResponseEntity<IssueStaff> postResponse = restTemplate.postForEntity(baseURL + "/create", issueStaff, IssueStaff.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {

        String id = "215095222";
        IssueStaff issueStaff = restTemplate.getForObject(baseURL + "/issueStaff/" + id, IssueStaff.class);

        restTemplate.put(baseURL + "/customers/" + id, issueStaff);
        IssueStaff updatedIssueStaff = restTemplate.getForObject(baseURL + "/update/" + id, IssueStaff.class);
        assertNotNull(updatedIssueStaff);
    }

    @Test
    public void e_delete() {

        String id = "215095222";
        IssueStaff issueStaff = restTemplate.getForObject(baseURL + "/issueStaffs/" + id, IssueStaff.class);
        assertNotNull(issueStaff);
        restTemplate.delete(baseURL + "/issueStaffs/" + id);
        try {
            issueStaff = restTemplate.getForObject(baseURL + "/delete/" + id, IssueStaff.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void b_read() {
        IssueStaff readIssueStaff = restTemplate.getForObject(baseURL + "/read/215095111", IssueStaff.class);
        System.out.println(readIssueStaff.toString());
        assertNotNull(readIssueStaff);
    }

    @Test
    public void d_getAll() {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers  );
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/readIssueStaff/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}