package org.randall.teagan.Controllers.VehicleController;

import org.randall.teagan.Domain.Vehicle.Cityliner;
import org.randall.teagan.Services.ServiceImplementation.VehicleServiceImpl.CitylinerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/cityliner")
public class CityLinerController {

    @Autowired
    @Qualifier("CitylinerServiceImpl")
    CitylinerServiceImpl citylinerServiceImpl;


    @PostMapping(value = "/create")
    @ResponseBody
    public Cityliner create(@RequestBody Cityliner cityliner) {
        return citylinerServiceImpl.create(cityliner);
    }

    @PostMapping(value = "/update/")
    @ResponseBody
    public Cityliner update(@RequestBody Cityliner cityliner) {
        return citylinerServiceImpl.update(cityliner);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        citylinerServiceImpl.delete(id);
    }

    @GetMapping(value = "/read/{id}")
    @ResponseBody
    public Cityliner read(@PathVariable String id) {
        return citylinerServiceImpl.read(id);
    }

    @GetMapping(value = "/read/all")
    @ResponseBody
    public ArrayList<Cityliner> getAll() {
        return citylinerServiceImpl.getAll();
    }
}
