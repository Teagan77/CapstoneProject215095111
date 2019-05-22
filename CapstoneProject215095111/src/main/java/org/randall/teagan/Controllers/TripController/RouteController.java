package org.randall.teagan.Controllers.TripController;

import org.randall.teagan.Domain.Trip.Route;
import org.randall.teagan.Services.ServiceImplementation.TripServiceImpl.RouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    @Qualifier("RouteServiceImpl")
    RouteServiceImpl routeServiceImpl;

    @PostMapping(value = "/create")
    @ResponseBody
    public Route create(@RequestBody Route route) {
        return routeServiceImpl.create(route);
    }

    @PostMapping(value = "/update/")
    @ResponseBody
    public Route update(@RequestBody Route route) {
        return routeServiceImpl.update(route);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        routeServiceImpl.delete(id);
    }

    @GetMapping(value = "/read/{id}")
    @ResponseBody
    public Route read(@PathVariable String id) {
        return routeServiceImpl.read(id);
    }

    @GetMapping(value = "/read/all")
    @ResponseBody
    public ArrayList<Route> getAll() {
        return routeServiceImpl.getAll();
    }
}
