package org.randall.teagan.Controllers.CustomerController;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Request.NewCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
public class CustomerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/capstone/customer";

    @Test
    public void a_createEmployee() {
        NewCustomer cust = new NewCustomer("215095111", "0734771369", "Teagan", "Randall", 23);
        ResponseEntity result = restTemplate.withBasicAuth("admin", "admin")
                .postForEntity(baseURL + "/create/", cust, String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

//    @Test
//    public void b_read() {
//        String customerID = "215095111";
//        ResponseEntity result = restTemplate.withBasicAuth("admin", "admin")
//                .getForEntity(baseURL + "/read/" + customerID, String.class);
//        System.out.println(result.getBody());
//        assertEquals(HttpStatus.OK, result.getStatusCode());
//    }

    @Test
    public void c_getAll() {
        ResponseEntity<String> result = restTemplate.withBasicAuth("admin", "admin")
                .getForEntity(baseURL + "/getall", String.class);
        System.out.println(result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

//    @Test
//    public void d_update() {
//        String id = "215095222";
//        Customer customer = restTemplate.getForObject(baseURL + "/customer/" + id, Customer.class);
//        restTemplate.put(baseURL + "/customers/" + id, customer);
//        Customer updatedCustomer = restTemplate.getForObject(baseURL + "/update/" + id, Customer.class);
//        assertNotNull(updatedCustomer);
//    }
//
//    @Test
//    public void e_delete() {
//        String id = "215095222";
//        Customer customer = restTemplate.getForObject(baseURL + "/customers/" + id, Customer.class);
//        assertNotNull(customer);
//        restTemplate.delete(baseURL + "/customers/" + id);
//        try {
//            customer = restTemplate.getForObject(baseURL + "/delete/" + id, Customer.class);
//        } catch (final HttpClientErrorException e) {
//            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
//        }
//    }
//

//
//    @Test
//    public void c_getAll() {
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/read/all",
//                HttpMethod.GET, entity, String.class);
//        assertNotNull(response.getBody());
//    }
}