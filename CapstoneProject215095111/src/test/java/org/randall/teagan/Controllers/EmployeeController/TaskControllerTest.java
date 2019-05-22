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

import java.util.ArrayList;
import java.util.Date;

import static org.junit.Assert.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TaskControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/task";

    @Test
    public void a_create() {

        String name = "Teagan";
        String surname = "Randall";
        String phone = "0734771369";
        int age = 22;
        String id = "2181593";
        double pay = 20000.00;
        String gender = "male";
        Date date = new Date();
        String jobTitle = "Manager";
        String posCode = "MGR000";
        String qualCode = "BTECHBSMGM";
        String physicalAddress = "1 Gore Street, DeZonnebloem";
        int postalAddress = 5280;
        int postalCode = 4280;
        String contactNo = "0725986625";
        String taskDesc = "A task.";
        String taskNo = "215095111";
        String managerID = "46846";
        String payslipID = "65464";

        EmployeePosition position = EmpPosBuilder.getEmpPos(jobTitle,posCode);
        EmployeePayslip payslip = EmpPayslipBuilder.getEmpPayslip(pay, date,payslipID);
        EmpAddress address = EmpAddressBuilder.getEmpAddress(physicalAddress, postalAddress, postalCode);
        EmpContact contact = EmpContactBuilder.getEmpContact(contactNo);

        Employee firstEmp = EmpBuilder.getEmployee(id,name,surname,age,gender,position,payslip,address,contact);
        Manager firstManager = ManagerBuilder.getManager(jobTitle,posCode,qualCode, managerID);

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(firstEmp);

        Task task = TaskBuilder.getEmpTask(firstManager,employees, taskDesc,date,taskNo);

        ResponseEntity<Task> postResponse = restTemplate.postForEntity(baseURL + "/create", task, Task.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void c_update() {

        String id = "215095111";
        Task task = restTemplate.getForObject(baseURL + "/task/" + id, Task.class);

        restTemplate.put(baseURL + "/tasks/" + id, task);
        Task updatedTask = restTemplate.getForObject(baseURL + "/update/" + id, Task.class);
        assertNotNull(updatedTask);
    }

    @Test
    public void e_delete() {

        String id = "215095222";
        Task task = restTemplate.getForObject(baseURL + "/tasks/" + id, Task.class);
        assertNotNull(task);
        restTemplate.delete(baseURL + "/tasks/" + id);
        try {
            task = restTemplate.getForObject(baseURL + "/delete/" + id, Task.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void b_read() {
        Task readTask= restTemplate.getForObject(baseURL + "/read/215095111", Task.class);
        System.out.println(readTask.toString());
        assertNotNull(readTask);
    }

    @Test
    public void d_getAll() {

        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<String>(null, headers  );
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/readTask/all",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}