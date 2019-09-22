package org.randall.teagan.Controllers.EmployeeController;

import org.randall.teagan.Domain.Employee.Employee;
import org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/capstone/employee")
public class EmployeeController {

    @Autowired
    @Qualifier("EmpServiceImpl")
    EmpServiceImpl empServiceImpl;

    @PostMapping(value = "/create")
    @ResponseBody
    public Employee create(@RequestBody Employee employee) {
        return empServiceImpl.create(employee);
    }

}
