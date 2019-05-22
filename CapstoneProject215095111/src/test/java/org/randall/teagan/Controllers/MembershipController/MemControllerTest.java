package org.randall.teagan.Controllers.MembershipController;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Membership.MemberType;
import org.randall.teagan.Domain.Membership.Membership;
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
public class MemControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/member";

    @Test
    public void a_create() {

        MemberType memberType = MemTypeBuilder.getMemberType("STUD-004", "Student-Member");
        Membership membership = MembershipBuilder.getMembership(memberType, "215095111");
        ResponseEntity<Membership> postResponse = restTemplate.postForEntity(baseURL + "/create", membership, Membership.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {

        String id = "215095222";
        Membership membership = restTemplate.getForObject(baseURL + "/member/" + id, Membership.class);

        restTemplate.put(baseURL + "/members/" + id, membership);
        Membership updatedMembership = restTemplate.getForObject(baseURL + "/update/" + id, Membership.class);
        assertNotNull(updatedMembership);
    }

    @Test
    public void e_delete() {

        String id = "215095222";
        Membership membership = restTemplate.getForObject(baseURL + "/members/" + id, Membership.class);
        assertNotNull(membership);
        restTemplate.delete(baseURL + "/members/" + id);
        try {
            membership = restTemplate.getForObject(baseURL + "/delete/" + id, Membership.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void b_read() {
        Membership readMembership = restTemplate.getForObject(baseURL + "/read/215095111", Membership.class);
        System.out.println(readMembership.toString());
        assertNotNull(readMembership);
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