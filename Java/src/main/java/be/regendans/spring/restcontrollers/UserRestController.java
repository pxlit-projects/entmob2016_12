package be.regendans.spring.restcontrollers;

import be.regendans.spring.entities.User;
import be.regendans.spring.services.UserService;
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
    private UserService service;

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public User getUserById(@PathVariable("id") int id){ return service.getUserById(id);}

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public List<User> getAll(){ return service.getAllUsers();}

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public String deleteUserById(@PathVariable("id") int id) { return service.deleteUserById(id); }

    @RequestMapping(value = "/update", method = RequestMethod.PUT , headers = "content-type=application/json" ,
            consumes = "application/json", produces = "application/json")
    public User updateUser(@RequestBody User u) { return service.updateUser(u); }

    @RequestMapping(value = "/new", method = RequestMethod.POST , headers = "content-type=application/json",
            consumes = "application/json", produces = "application/json")
    public User newUser(@RequestBody User n) { return service.newUser(n); }

}
