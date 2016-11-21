package be.regendans.controllers;

import be.regendans.entities.AirPressure;
import be.regendans.repositories.AirPressureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Joren
 * @author Bunyamin
 */

@RestController
@RequestMapping("/airpressure")
@Secured("ROLE_USER")
public class AirPressureRestController {

    @Autowired
    private AirPressureRepository airPressureService;

    @RequestMapping(value ="/all",method = RequestMethod.GET, produces = "application/json")
    public List<AirPressure> getAll(){ return airPressureService.findAll(); }

    @RequestMapping(value ="/all/{id}",method = RequestMethod.GET, produces = "application/json")
    public List<AirPressure> getAllByUserId(@PathVariable("id") int id){ return airPressureService.findByUserId(id); }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public AirPressure getAirPressureById(@PathVariable("id") int id){ return airPressureService.findOne(id);}

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public void delAirPressureById(@PathVariable("id") int id) { airPressureService.delete(id); }

    @RequestMapping(value = "/new", method = RequestMethod.POST , headers = "content-type=application/json", consumes = "application/json", produces = "application/json")
    public AirPressure newAirPressure(@RequestBody AirPressure ap) {return airPressureService.save(ap); }
}
