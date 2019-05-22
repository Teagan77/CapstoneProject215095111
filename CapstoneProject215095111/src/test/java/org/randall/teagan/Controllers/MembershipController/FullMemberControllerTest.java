package org.randall.teagan.Controllers.MembershipController;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Membership.FullTimeMember;
import org.randall.teagan.Factory.MembershipBuilders.FullTimeMemberBuilder;
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
public class FullMemberControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/fullmember";

    @Test
    public void a_create() {

        FullTimeMember fullTimeMember = FullTimeMemberBuilder.getFullTimeMember("FT-101", "Full-time", "215095111");
        ResponseEntity<FullTimeMember> postResponse = restTemplate.postForEntity(baseURL + "/create", fullTimeMember, FullTimeMember.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {

        String id = "215095222";
        FullTimeMember fullTimeMember = restTemplate.getForObject(baseURL + "/fullmember/" + id, FullTimeMember.class);

        restTemplate.put(baseURL + "/fullTimeMembers/" + id, fullTimeMember);
        FullTimeMember updatedFullTimeMember = restTemplate.getForObject(baseURL + "/update/" + id, FullTimeMember.class);
        assertNotNull(updatedFullTimeMember);
    }

    @Test
    public void e_delete() {

        String id = "215095222";
        FullTimeMember fullTimeMember = restTemplate.getForObject(baseURL + "/fullTimeMembers/" + id, FullTimeMember.class);
        assertNotNull(fullTimeMember);
        restTemplate.delete(baseURL + "/fullTimeMembers/" + id);
        try {
            fullTimeMember = restTemplate.getForObject(baseURL + "/delete/" + id, FullTimeMember.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void b_read() {
        FullTimeMember readFullTimeMember = restTemplate.getForObject(baseURL + "/read/215095111", FullTimeMember.class);
        System.out.println(readFullTimeMember.toString());
        assertNotNull(readFullTimeMember);
    }

    @Test
    public void d_getAll() {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers  );
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/readFT/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}