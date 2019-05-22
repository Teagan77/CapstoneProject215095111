package org.randall.teagan.Controllers.EmployeeController;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Employee.EmployeePayslip;
import org.randall.teagan.Factory.EmployeeBuilders.EmpPayslipBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import java.util.Date;
import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmpPayslipControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/payslip";

    @Test
    public void a_create() {
        Date date = new Date();
        EmployeePayslip payslip = EmpPayslipBuilder.getEmpPayslip(9500,date , "215095111");
        ResponseEntity<EmployeePayslip> postResponse = restTemplate.postForEntity(baseURL + "/create", payslip, EmployeePayslip.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {

        String id = "215095222";
        EmployeePayslip payslip = restTemplate.getForObject(baseURL + "/payslip/" + id, EmployeePayslip.class);

        restTemplate.put(baseURL + "/payslips/" + id, payslip);
        EmployeePayslip updatedEmployeePayslip = restTemplate.getForObject(baseURL + "/update/" + id, EmployeePayslip.class);
        assertNotNull(updatedEmployeePayslip);
    }

    @Test
    public void e_delete() {

        String id = "215095222";
        EmployeePayslip payslip = restTemplate.getForObject(baseURL + "/payslips/" + id, EmployeePayslip.class);

        assertNotNull(payslip);
        restTemplate.delete(baseURL + "/payslips/" + id);
        try {
            payslip = restTemplate.getForObject(baseURL + "/delete/" + id, EmployeePayslip.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void b_read() {
        EmployeePayslip payslip = restTemplate.getForObject(baseURL + "/read/215095111", EmployeePayslip.class);
        System.out.println(payslip.toString());
        assertNotNull(payslip);
    }

    @Test
    public void d_getAll() {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers  );
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/readPayslip/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}