package be.regendans.spring.restcontrollers;

import be.regendans.spring.entities.Temperature;
import be.regendans.spring.services.TemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Joren 
 */
@RestController
@RequestMapping("/temperature")
public class TemperatureRestController {
    @Autowired
    private TemperatureService temperatureService;

    @RequestMapping(value ="/all",method = RequestMethod.GET, produces = "application/json")
    public List<Temperature> getAll(){ return temperatureService.getAllTemperatures(); }


    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public Temperature getTemperatureById(@PathVariable("id") int id){ return temperatureService.getTemperatureById(id);}

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String delTemperatureById(@PathVariable("id") int id) { return temperatureService.deltemperatureById(id); }

    @RequestMapping(value = "/upd", method = RequestMethod.PUT , headers = "content-type=application/json" , consumes = "application/json", produces = "application/json")
    public Temperature updateTemperature(@RequestBody Temperature t) {return temperatureService.updateTemperature(t); }

    @RequestMapping(value = "/new", method = RequestMethod.POST , headers = "content-type=application/json", consumes = "application/json", produces = "application/json")
    public Temperature newTemperature(@RequestBody Temperature t) {return temperatureService.newTemperature(t); }

}
