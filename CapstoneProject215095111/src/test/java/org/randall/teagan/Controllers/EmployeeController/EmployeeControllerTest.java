package org.randall.teagan.Controllers.EmployeeController;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.randall.teagan.Domain.Customer.Customer;
import org.randall.teagan.Domain.Employee.*;
import org.randall.teagan.Factory.EmployeeBuilders.*;
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
public class EmployeeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/employee";

    @Test
    public void a_create() {

        EmpContact empContact = EmpContactBuilder.getEmpContact("0749876643");
        EmpAddress empAddress = EmpAddressBuilder.getEmpAddress("1 Dezonnebloem Rd, Cavendish", 2150, 9872);
        Date date = new Date();
        EmployeePayslip payslip = EmpPayslipBuilder.getEmpPayslip(9500,date , "215095111");
        EmployeePosition employeePosition = EmpPosBuilder.getEmpPos("Driver", "DRV-005");
        Employee firstEmployee = EmpBuilder.getEmployee("215095111", "Teagan","Randall",23, "Male", employeePosition, payslip, empAddress, empContact);
        ResponseEntity<Employee> postResponse = restTemplate.postForEntity(baseURL + "/create", firstEmployee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {

        String id = "215095222";
        Employee employee = restTemplate.getForObject(baseURL + "/employee/" + id, Employee.class);
        restTemplate.put(baseURL + "/employees/" + id, employee);
        Employee updatedEmployee = restTemplate.getForObject(baseURL + "/update/" + id, Employee.class);
        assertNotNull(updatedEmployee);
    }

    @Test
    public void e_delete() {

        String id = "215095222";
        Employee employee = restTemplate.getForObject(baseURL + "/employees/" + id, Employee.class);
        assertNotNull(employee);
        restTemplate.delete(baseURL + "/employees/" + id);
        try {
            employee = restTemplate.getForObject(baseURL + "/delete/" + id, Employee.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void b_read() {
        Employee readEmployee = restTemplate.getForObject(baseURL + "/read/215095111", Employee.class);
        System.out.println(readEmployee.getEmpName());
        assertNotNull(readEmployee);
    }

    @Test
    public void d_getAll() {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers  );
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/readEmp/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}