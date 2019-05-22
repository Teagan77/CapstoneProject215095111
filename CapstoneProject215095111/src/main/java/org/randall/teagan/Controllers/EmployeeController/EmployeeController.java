package org.randall.teagan.Controllers.EmployeeController;

import org.randall.teagan.Domain.Employee.Employee;
import org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    @Qualifier("EmpServiceImpl")
    EmpServiceImpl empServiceImpl;

    @PostMapping(value = "/create")
    @ResponseBody
    public Employee create(@RequestBody Employee employee) {
        return empServiceImpl.create(employee);
    }

    @PostMapping(value = "/update/")
    @ResponseBody
    public Employee update(@RequestBody Employee employee) {
        return empServiceImpl.update(employee);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        empServiceImpl.delete(id);
    }

    @GetMapping(value = "/read/{id}")
    @ResponseBody
    public Employee read(@PathVariable String id) {
        return empServiceImpl.read(id);
    }

    @GetMapping(value = "/readEmp/all")
    @ResponseBody
    public ArrayList<Employee> getAll() {
        return empServiceImpl.getAll();
    }
}
