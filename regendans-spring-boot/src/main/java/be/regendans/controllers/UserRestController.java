package be.regendans.controllers;

import be.regendans.entities.User;
import be.regendans.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bunyamin
 */

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserRepository service;

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public User getUserById(@PathVariable("id") int id){ return service.findOne(id);}

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<User> getAll(){ return service.findAll();}

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public void deleteUserById(@PathVariable("id") int id) { service.delete(id); }

    @RequestMapping(value = "/update", method = RequestMethod.PUT , headers = "content-type=application/json" ,
            consumes = "application/json", produces = "application/json")
    public User updateUser(@RequestBody User u) { return service.save(u); }

    @RequestMapping(value = "/new", method = RequestMethod.POST , headers = "content-type=application/json",
            consumes = "application/json", produces = "application/json")
    public User newUser(@RequestBody User n) { return service.save(n); }

}