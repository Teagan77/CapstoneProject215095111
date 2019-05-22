package org.randall.teagan.Controllers.EmployeeController;

import org.randall.teagan.Domain.Employee.Mechanic;
import org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl.MechanicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/mechanic")
public class MechanicController {

    @Autowired
    @Qualifier("MechanicServiceImpl")
    MechanicServiceImpl mechanicServiceImpl;

    @PostMapping(value = "/create")
    @ResponseBody
    public Mechanic create(@RequestBody Mechanic mechanic) {return mechanicServiceImpl.create(mechanic);}

    @PostMapping(value = "/update/")
    @ResponseBody
    public Mechanic update(@RequestBody Mechanic mechanic) {
        return mechanicServiceImpl.update(mechanic);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        mechanicServiceImpl.delete(id);
    }

    @GetMapping(value = "/read/{id}")
    @ResponseBody
    public Mechanic read(@PathVariable String id) {
        return mechanicServiceImpl.read(id);
    }

    @GetMapping(value = "/readMechanic/all")
    @ResponseBody
    public ArrayList<Mechanic> getAll() {
        return mechanicServiceImpl.getAll();
    }
}
