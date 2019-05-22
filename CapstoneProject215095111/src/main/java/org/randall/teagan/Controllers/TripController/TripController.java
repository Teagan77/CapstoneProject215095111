package org.randall.teagan.Controllers.TripController;

import org.randall.teagan.Domain.Trip.Trip;
import org.randall.teagan.Services.ServiceImplementation.TripServiceImpl.TripServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    @Qualifier("TripServiceImpl")
    TripServiceImpl tripServiceImpl;

    @PostMapping(value = "/create")
    @ResponseBody
    public Trip create(@RequestBody Trip trip) {
        return tripServiceImpl.create(trip);
    }

    @PostMapping(value = "/update/")
    @ResponseBody
    public Trip update(@RequestBody Trip trip) {
        return tripServiceImpl.update(trip);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        tripServiceImpl.delete(id);
    }

    @GetMapping(value = "/read/{id}")
    @ResponseBody
    public Trip read(@PathVariable String id) {
        return tripServiceImpl.read(id);
    }

    @GetMapping(value = "/read/all")
    @ResponseBody
    public ArrayList<Trip> getAll() {
        return tripServiceImpl.getAll();
    }
}
