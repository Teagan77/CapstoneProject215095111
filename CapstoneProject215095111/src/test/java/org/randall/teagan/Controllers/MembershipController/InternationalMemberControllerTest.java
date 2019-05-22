package org.randall.teagan.Controllers.MembershipController;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Membership.InternationalMember;
import org.randall.teagan.Domain.Membership.MemberType;
import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Factory.CustomerBuilder.CustBuilder;
import org.randall.teagan.Factory.MembershipBuilders.InternationalMemBuilder;
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
public class InternationalMemberControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/internationalMember";

    @Test
    public void a_create() {

        InternationalMember internationalMember = InternationalMemBuilder.getInternationalMember("INT-001","International","French","215095111");
        ResponseEntity<InternationalMember> postResponse = restTemplate.postForEntity(baseURL + "/create", internationalMember, InternationalMember.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {

        String id = "215095222";
        InternationalMember internationalMember = restTemplate.getForObject(baseURL + "/internationalMember/" + id, InternationalMember.class);

        restTemplate.put(baseURL + "/internationalMembers/" + id, internationalMember);
        InternationalMember updatedInternationalMember = restTemplate.getForObject(baseURL + "/update/" + id, InternationalMember.class);
        assertNotNull(updatedInternationalMember);
    }

    @Test
    public void e_delete() {

        String id = "215095222";
        InternationalMember internationalMember = restTemplate.getForObject(baseURL + "/internationalMembers/" + id, InternationalMember.class);
        assertNotNull(internationalMember);
        restTemplate.delete(baseURL + "/internationalMembers/" + id);
        try {
            internationalMember = restTemplate.getForObject(baseURL + "/delete/" + id, InternationalMember.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void b_read() {
        InternationalMember readInternationalMember = restTemplate.getForObject(baseURL + "/read/215095111", InternationalMember.class);
        System.out.println(readInternationalMember.toString());
        assertNotNull(readInternationalMember);
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