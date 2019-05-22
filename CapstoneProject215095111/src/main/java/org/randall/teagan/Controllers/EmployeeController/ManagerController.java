package org.randall.teagan.Controllers.EmployeeController;

import org.randall.teagan.Domain.Employee.Manager;
import org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl.ManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    @Qualifier("ManagerServiceImpl")
    ManagerServiceImpl managerServiceImpl;

    @PostMapping(value = "/create")
    @ResponseBody
    public Manager create(@RequestBody Manager manager) {
        return managerServiceImpl.create(manager);
    }

    @PostMapping(value = "/update/")
    @ResponseBody
    public Manager update(@RequestBody Manager manager) {
        return managerServiceImpl.update(manager);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        managerServiceImpl.delete(id);
    }

    @GetMapping(value = "/read/{id}")
    @ResponseBody
    public Manager read(@PathVariable String id) {
        return managerServiceImpl.read(id);
    }

    @GetMapping(value = "/readManager/all")
    @ResponseBody
    public ArrayList<Manager> getAll() {
        return managerServiceImpl.getAll();
    }
}
