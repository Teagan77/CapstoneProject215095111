package org.randall.teagan.Controllers.EmployeeController;

import org.randall.teagan.Domain.Employee.Driver;
import org.randall.teagan.Services.ServiceImplementation.EmpServiceImpl.DriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

    @RestController
    @RequestMapping("/driver")
    public class DriverController {

        @Autowired
        @Qualifier("DriverServiceImpl")
        private DriverServiceImpl driverServiceImpl;

        @PostMapping("/createDriver")
        @ResponseBody
        public Driver create(@RequestBody Driver driver) {
            return driverServiceImpl.create(driver);
        }

        @PostMapping("/updateDriver/")
        @ResponseBody
        public Driver update(@RequestBody Driver driver) {
            return driverServiceImpl.update(driver);
        }

        @GetMapping("/deleteDriver/{id}")
        @ResponseBody
        public void delete(@PathVariable String id) {
            driverServiceImpl.delete(id);
        }

        @GetMapping("/read/{id}")
        @ResponseBody
        public Driver read(@PathVariable String id) {
            return driverServiceImpl.read(id);
        }

        @GetMapping("/readDriver/all")
        @ResponseBody
        public ArrayList<Driver> getAll() {
            return driverServiceImpl.getAll();
        }
    }
