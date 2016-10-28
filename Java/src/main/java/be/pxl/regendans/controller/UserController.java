package be.pxl.regendans.controller;

import be.pxl.regendans.entity.User;
import be.pxl.regendans.service.UserService;
import be.pxl.regendans.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Bunyamin
 */

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

//    @Secured("ROLE_ADMIN")
    @GetMapping(value = "user/{id}", produces = "application/json")
    public User findUserById(@PathVariable("id") int id){ return userService.findUserById(id);}
//
//    @Secured("ROLE_ADMIN")
//    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
//    public List<User> getAll(){ return userService.getAllUsers();}
//
//    @Secured("ROLE_ADMIN")
//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
//    public String deleteUserById(@PathVariable("id") int id) { return userService.deleteUserById(id); }
//
//    @RequestMapping(value = "/update", method = RequestMethod.PUT , headers = "content-type=application/json" ,
//            consumes = "application/json", produces = "application/json")
//    public User updateUser(@RequestBody User u) { return userService.updateUser(u); }
//
//    @RequestMapping(value = "/new", method = RequestMethod.POST , headers = "content-type=application/json",
//            consumes = "application/json", produces = "application/json")
//    public User newUser(@RequestBody User n) {
//        return userService.newUser(n);
//    }

}
