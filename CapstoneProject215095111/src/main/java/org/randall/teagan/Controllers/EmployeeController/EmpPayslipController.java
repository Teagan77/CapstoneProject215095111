package org.randall.teagan.Controllers.EmployeeController;

import org.randall.teagan.Domain.Employee.EmployeePayslip;
import org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl.EmpPayslipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/payslip")
public class EmpPayslipController {

    @Autowired
    @Qualifier("EmpPayslipServiceImpl")
    EmpPayslipServiceImpl empPayslipServiceImpl;

    @PostMapping(value = "/create")
    @ResponseBody
    public EmployeePayslip create(@RequestBody EmployeePayslip employeePayslip) {
        return empPayslipServiceImpl.create(employeePayslip);
    }

    @PostMapping(value = "/update/")
    @ResponseBody
    public EmployeePayslip update(@RequestBody EmployeePayslip employeePayslip) {
        return empPayslipServiceImpl.update(employeePayslip);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        empPayslipServiceImpl.delete(id);
    }

    @GetMapping(value = "/read/{id}")
    @ResponseBody
    public EmployeePayslip read(@PathVariable String id) {
        return empPayslipServiceImpl.read(id);
    }

    @GetMapping(value = "/readPayslip/all")
    @ResponseBody
    public ArrayList<EmployeePayslip> getAll() {
        return empPayslipServiceImpl.getAll();
    }
}
