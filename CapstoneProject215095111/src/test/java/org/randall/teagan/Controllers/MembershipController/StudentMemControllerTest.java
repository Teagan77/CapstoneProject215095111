package org.randall.teagan.Controllers.MembershipController;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Membership.StudentMember;
import org.randall.teagan.Factory.MembershipBuilders.StudentMemberBuilder;
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
public class StudentMemControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/student";

    @Test
    public void a_create() {

        StudentMember studentMember = StudentMemberBuilder.getStudMember("STD-090", "Student", "215095111");
        ResponseEntity<StudentMember> postResponse = restTemplate.postForEntity(baseURL + "/create", studentMember, StudentMember.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {

        String id = "215095222";
        StudentMember studentMember = restTemplate.getForObject(baseURL + "/student/" + id, StudentMember.class);

        restTemplate.put(baseURL + "/students/" + id, studentMember);
        StudentMember updatedStudentMember= restTemplate.getForObject(baseURL + "/update/" + id, StudentMember.class);
        assertNotNull(updatedStudentMember);
    }

    @Test
    public void e_delete() {

        String id = "215095222";
        StudentMember studentMember = restTemplate.getForObject(baseURL + "/students/" + id, StudentMember.class);
        assertNotNull(studentMember);
        restTemplate.delete(baseURL + "/students/" + id);
        try {
            studentMember = restTemplate.getForObject(baseURL + "/delete/" + id, StudentMember.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void b_read() {
        StudentMember readStudentMember = restTemplate.getForObject(baseURL + "/read/215095111", StudentMember.class);
        System.out.println(readStudentMember.toString());
        assertNotNull(readStudentMember);
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