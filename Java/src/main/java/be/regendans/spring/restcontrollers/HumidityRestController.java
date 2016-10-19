package be.regendans.spring.restcontrollers;

import be.regendans.spring.entities.Humidity;
import be.regendans.spring.services.HumidityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Joren
 */
@RestController
@RequestMapping("/humidity")
@Secured("ROLE_USER")
public class HumidityRestController {

    @Autowired
    private HumidityService humidityService;

    @RequestMapping(value ="/all",method = RequestMethod.GET, produces = "application/json")
    public List<Humidity> getAll(){ return humidityService.getAllHumidities(); }

    @RequestMapping(value ="/all/{id}",method = RequestMethod.GET, produces = "application/json")
    public List<Humidity> getAllByUserId(@PathVariable("id") int id){ return humidityService.getAllUserHumidities(id); }


    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public Humidity getAirPressureById(@PathVariable("id") int id){ return humidityService.gethumidityById(id);}

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String delAirPressureById(@PathVariable("id") int id) { return humidityService.delHumidityById(id); }

    @RequestMapping(value = "/new", method = RequestMethod.POST , headers = "content-type=application/json", consumes = "application/json", produces = "application/json")
    public Humidity newAirPressure(@RequestBody Humidity h) {return humidityService.newHumidity(h); }
}
