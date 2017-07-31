package ramya.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ramya.entity.Readings;
import ramya.service.VehicleService;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/readings")
public class ReadingsController {

    @Autowired
    VehicleService service;

    //One Reading
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Readings> findAll() {
        return service.findAllReadings();
    }

    //All Reading
    @RequestMapping(value ="/{id}", method = RequestMethod.OPTIONS, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Readings findOneReadings(@PathVariable("id") String id) {
        return service.findOneReadings(id);
    }

    //Create
    @RequestMapping( method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Readings createReadings(@RequestBody Readings reads) {
        System.out.println("Create reading !!");
        return service.createReadings(reads);
    }

    //Update
    @RequestMapping(value = "/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Readings updateReadings(@PathVariable("id") String id, @RequestBody Readings reads) {
        return service.updateReadings(id, reads);
    }
}




