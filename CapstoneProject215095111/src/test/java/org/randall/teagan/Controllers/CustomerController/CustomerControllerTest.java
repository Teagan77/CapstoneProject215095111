package org.randall.teagan.Controllers.CustomerController;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Membership.MemberType;
import org.randall.teagan.Domain.Membership.Membership;
import org.randall.teagan.Factory.CustomerBuilder.CustBuilder;
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
public class CustomerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/customer";

    @Test
    public void a_create() {

        MemberType memberType = MemTypeBuilder.getMemberType("STUD-004", "Student-Member");
        Membership membership = MembershipBuilder.getMembership(memberType, "09512830");
        Customer firstCustomer = CustBuilder.getCustomer("215095111", "Teagan","Randall",23, "0734771369",50.00, "Male", membership);
        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(baseURL + "/create", firstCustomer, Customer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {

        String id = "215095222";
        Customer customer = restTemplate.getForObject(baseURL + "/customer/" + id, Customer.class);

        restTemplate.put(baseURL + "/customers/" + id, customer);
        Customer updatedCustomer = restTemplate.getForObject(baseURL + "/update/" + id, Customer.class);
        assertNotNull(updatedCustomer);
    }

    @Test
    public void e_delete() {

        String id = "215095222";
        Customer customer = restTemplate.getForObject(baseURL + "/customers/" + id, Customer.class);
        assertNotNull(customer);
        restTemplate.delete(baseURL + "/customers/" + id);
        try {
            customer = restTemplate.getForObject(baseURL + "/delete/" + id, Customer.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void b_read() {
        Customer readCustomer = restTemplate.getForObject(baseURL + "/read/215095111", Customer.class);
        System.out.println(readCustomer.getCustId());
        assertNotNull(readCustomer);
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