package be.regendans.controllers;

import be.regendans.entities.Humidity;
import be.regendans.repositories.HumidityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Joren
 * @author Bunyamin
 */

@RestController
@RequestMapping("/humidity")
@Secured("ROLE_USER")
public class HumidityRestController {

    @Autowired
    private HumidityRepository humidityService;

    @RequestMapping(value ="/all",method = RequestMethod.GET, produces = "application/json")
    public List<Humidity> getAll(){ return humidityService.findAll(); }

    @RequestMapping(value ="/all/{id}",method = RequestMethod.GET, produces = "application/json")
    public List<Humidity> getAllByUserId(@PathVariable("id") int id){ return humidityService.findByUserId(id); }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public Humidity getAirPressureById(@PathVariable("id") int id){ return humidityService.findOne(id);}

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public void delAirPressureById(@PathVariable("id") int id) { humidityService.delete(id); }

    @RequestMapping(value = "/new", method = RequestMethod.POST , headers = "content-type=application/json", consumes = "application/json", produces = "application/json")
    public Humidity newAirPressure(@RequestBody Humidity h) {return humidityService.save(h); }
}
