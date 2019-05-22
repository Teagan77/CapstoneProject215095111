package org.randall.teagan.Controllers.VehicleController;

import org.randall.teagan.Domain.Vehicle.Vehicle;
import org.randall.teagan.Services.ServiceImplementation.VehicleServiceImpl.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    @Qualifier("VehicleServiceImpl")
    VehicleServiceImpl vehicleServiceImpl;

    @PostMapping(value = "/create")
    @ResponseBody
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return vehicleServiceImpl.create(vehicle);
    }

    @PostMapping(value = "/update/")
    @ResponseBody
    public Vehicle update(@RequestBody Vehicle vehicle) {
        return vehicleServiceImpl.update(vehicle);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        vehicleServiceImpl.delete(id);
    }

    @GetMapping(value = "/read/{id}")
    @ResponseBody
    public Vehicle read(@PathVariable String id) {
        return vehicleServiceImpl.read(id);
    }

    @GetMapping(value = "/read/all")
    @ResponseBody
    public ArrayList<Vehicle> getAll() {
        return vehicleServiceImpl.getAll();
    }
}
