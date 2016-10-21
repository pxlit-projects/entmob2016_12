package be.regendans.controllers;

import be.regendans.entities.UserLocation;
import be.regendans.repositories.UserLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bunyamin
 */

@RestController
@RequestMapping("/userlocation")
@Secured("ROLE_USER")
public class UserLocationRestController {

    @Autowired
    private UserLocationRepository service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public UserLocation getUserLocationById(@PathVariable("id") int id) {return service.findOne(id);}

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<UserLocation> getAllUserLocations() {return service.findAll();}

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET, produces = "application/json")
    public List<UserLocation> getUserLocationByUserId(@PathVariable("userId")int userId) {return service.findByUserId(userId);}

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public void deleteUserLocationById(@PathVariable("id") int id) { service.delete(id);}

    @RequestMapping(value = "/new", method = RequestMethod.POST , headers = "content-type=application/json",
            consumes = "application/json", produces = "application/json")
    public UserLocation newUserLocation(@RequestBody UserLocation ul) {return service.save(ul);}
}
