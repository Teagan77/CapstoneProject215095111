package org.randall.teagan.Controllers.VehicleController;

import org.randall.teagan.Domain.Vehicle.Midibus;
import org.randall.teagan.Services.ServiceImplementation.VehicleServiceImpl.MidibusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/midibus")
public class MidibusController {

    @Autowired
    @Qualifier("MidibusServiceImpl")
    MidibusServiceImpl midibusServiceImpl;


    @PostMapping(value = "/create")
    @ResponseBody
    public Midibus create(@RequestBody Midibus midibus) {
        return midibusServiceImpl.create(midibus);
    }

    @PostMapping(value = "/update/")
    @ResponseBody
    public Midibus update(@RequestBody Midibus midibus) {
        return midibusServiceImpl.update(midibus);
    }

    @GetMapping(value = "/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        midibusServiceImpl.delete(id);
    }

    @GetMapping(value = "/read/{id}")
    @ResponseBody
    public Midibus read(@PathVariable String id) {
        return midibusServiceImpl.read(id);
    }

    @GetMapping(value = "/read/all")
    @ResponseBody
    public ArrayList<Midibus> getAll() {
        return midibusServiceImpl.getAll();
    }
}
