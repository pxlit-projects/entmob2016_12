package be.regendans.controllers;

import be.regendans.entities.Temperature;
import be.regendans.repositories.TemperatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Joren
 * @author Bunyamin
 */

@RestController
@RequestMapping("/temperature")
@Secured("ROLE_USER")
public class TemperatureRestController {

    @Autowired
    private TemperatureRepository temperatureService;

    @RequestMapping(value ="/all",method = RequestMethod.GET, produces = "application/json")
    public List<Temperature> getAll(){ return temperatureService.findAll(); }

    @RequestMapping(value ="/all/{id}",method = RequestMethod.GET, produces = "application/json")
    public List<Temperature> getAllByUserId(@PathVariable("id") int id){ return temperatureService.findByUserId(id); }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public Temperature getTemperatureById(@PathVariable("id") int id){ return temperatureService.findOne(id);}

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public void delTemperatureById(@PathVariable("id") int id) { temperatureService.delete(id); }

    @RequestMapping(value = "/new", method = RequestMethod.POST , headers = "content-type=application/json", consumes = "application/json", produces = "application/json")
    public Temperature newTemperature(@RequestBody Temperature t) {return temperatureService.save(t); }
}
