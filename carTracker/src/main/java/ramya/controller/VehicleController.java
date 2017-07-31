package ramya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ramya.entity.Vehicle;
import ramya.service.VehicleService;

import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value="/vehicles")
public class VehicleController {

    @Autowired
    VehicleService service;

    //One Vehicle
    @RequestMapping(method = RequestMethod.GET, value="/{vin}" )
    public Vehicle findOne(@PathVariable("vin") String vehVin){
        return service.findOne(vehVin);
    }

    //All Vehicles
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
    public List<Vehicle> findAll(){return service.findAll();}

    //Create
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @CrossOrigin
    public Vehicle create(@RequestBody List<Vehicle> veh) {
        for(Vehicle veh1 : veh) {
            return service.create(veh1);
        }
        return null;
    }
    //Update
    @RequestMapping(method = RequestMethod.PUT, value="/{vin}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle update(@PathVariable("vin") String vehVin, Vehicle veh){

        return service.update(vehVin, veh);
    }
}
