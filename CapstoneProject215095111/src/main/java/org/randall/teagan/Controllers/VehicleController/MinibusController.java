package org.randall.teagan.Controllers.VehicleController;

import org.randall.teagan.Domain.Vehicle.Minibus;
import org.randall.teagan.Services.ServiceImplementation.VehicleServiceImpl.MiniBusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/minibus")
public class MinibusController {

    @Autowired
    @Qualifier("MiniBusServiceImpl")
    MiniBusServiceImpl miniBusServiceImpl;


    @PostMapping(value = "/create")
    @ResponseBody
    public Minibus create(@RequestBody Minibus minibus) {
        return miniBusServiceImpl.create(minibus);
    }

    @PostMapping(value = "/update/")
    @ResponseBody
    public Minibus update(@RequestBody Minibus minibus) {
        return miniBusServiceImpl.update(minibus);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        miniBusServiceImpl.delete(id);
    }

    @GetMapping(value = "/read/{id}")
    @ResponseBody
    public Minibus read(@PathVariable String id) {
        return miniBusServiceImpl.read(id);
    }

    @GetMapping(value = "/read/all")
    @ResponseBody
    public ArrayList<Minibus> getAll() {
        return miniBusServiceImpl.getAll();
    }
}
