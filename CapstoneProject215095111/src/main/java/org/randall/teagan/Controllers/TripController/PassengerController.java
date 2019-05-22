package org.randall.teagan.Controllers.TripController;

import org.randall.teagan.Domain.Trip.Passenger;
import org.randall.teagan.Services.ServiceImplementation.TripServiceImpl.PassengerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    @Qualifier("PassengerServiceImpl")
    PassengerServiceImpl passengerServiceImpl;


    @PostMapping(value = "/create")
    @ResponseBody
    public Passenger create(@RequestBody Passenger passenger) {
        return passengerServiceImpl.create(passenger);
    }

    @PostMapping(value = "/update/")
    @ResponseBody
    public Passenger update(@RequestBody Passenger passenger) {
        return passengerServiceImpl.update(passenger);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        passengerServiceImpl.delete(id);
    }

    @GetMapping(value = "/read/{id}")
    @ResponseBody
    public Passenger read(@PathVariable String id) {
        return passengerServiceImpl.read(id);
    }

    @GetMapping(value = "/read/all")
    @ResponseBody
    public ArrayList<Passenger> getAll() {
        return passengerServiceImpl.getAll();
    }
}
