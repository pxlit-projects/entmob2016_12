package be.regendans.spring.restcontrollers;

import be.regendans.spring.entities.AirPressure;
import be.regendans.spring.services.AirPressureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Joren
 */
@RestController
@RequestMapping("/airpressure")
@Secured("ROLE_USER")
public class AirPressureRestController {
    @Autowired
    private AirPressureService airPressureService;

    @RequestMapping(value ="/all",method = RequestMethod.GET, produces = "application/json")
    public List<AirPressure> getAll(){ return airPressureService.getAllAirPressures(); }

    @RequestMapping(value ="/all/{id}",method = RequestMethod.GET, produces = "application/json")
    public List<AirPressure> getAllByUserId(@PathVariable("id") int id){ return airPressureService.getAllUserAirPressures(id); }


    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public AirPressure getAirPressureById(@PathVariable("id") int id){ return airPressureService.getAirPressureById(id);}

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String delAirPressureById(@PathVariable("id") int id) { return airPressureService.delAirPressureById(id); }

    @RequestMapping(value = "/new", method = RequestMethod.POST , headers = "content-type=application/json", consumes = "application/json", produces = "application/json")
    public AirPressure newAirPressure(@RequestBody AirPressure ap) {return airPressureService.newAirPressure(ap); }
}
