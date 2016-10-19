package be.regendans.spring.restcontrollers;

import be.regendans.spring.entities.UserLocation;
import be.regendans.spring.services.UserLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bunyamin
 */

@RestController
@RequestMapping("/userlocation")
public class UserLocationRestController {

    @Autowired
    private UserLocationService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public UserLocation getUserLocationById(@PathVariable("id") int id) {return service.getUserLocationById(id);}

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<UserLocation> getAllUserLocations() {return service.getAllUserLocations();}

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = "application/json")
    public List<UserLocation> getUserLocationByUserId(@PathVariable("userId")int userId) {return service.getUserLocationByUserId(userId);}

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteUserLocationById(@PathVariable("id") int id) {return service.deleteUserLocationById(id);}

    @RequestMapping(value = "/new", method = RequestMethod.POST , headers = "content-type=application/json",
            consumes = "application/json", produces = "application/json")
    public UserLocation newUserLocation(@RequestBody UserLocation ul) {return service.newUserLocation(ul);}
}
