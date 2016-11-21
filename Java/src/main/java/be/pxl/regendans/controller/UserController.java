package be.pxl.regendans.controller;

import be.pxl.regendans.entity.User;
import be.pxl.regendans.service.UserService;
import be.pxl.regendans.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.List;

import static be.pxl.regendans.controller.UserController.USER_BASE_URL;

/**
 * @author Bunyamin
 */

// TODO: HTTP header and return
@RestController
@RequestMapping(USER_BASE_URL)
public class UserController {

    private String password = "rand&om";
    private String username = "usersomething";

    public static final String USER_BASE_URL = "/user";

    @Autowired
    private UserServiceImpl userService;

    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity findUserById(@PathVariable("id") int id) {
        final HttpHeaders httpHeaders = createAuthenticationHeader(username, password);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        User user;

        try {
            user = userService.findUserById(id);
        } catch (Exception e) {
            return new ResponseEntity(httpHeaders, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user,httpHeaders, HttpStatus.NOT_FOUND);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity getAll() {
        final HttpHeaders httpHeaders = createAuthenticationHeader(username, password);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        List<User> user;

        try {
            user = userService.findAll();
        } catch (Exception e) {
            return new ResponseEntity(httpHeaders, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, httpHeaders, HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteUserById(@PathVariable("id") int id) {
        final HttpHeaders httpHeaders = createAuthenticationHeader(username, password);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        User user;

        try {
            user = userService.deleteUserById(id);
        } catch (Exception e) {
            return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user, httpHeaders, HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, headers = "content-type=application/json",
            consumes = "application/json", produces = "application/json")
    public ResponseEntity updateUser(@RequestBody User u) {
        final HttpHeaders httpHeaders = createAuthenticationHeader(username, password);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        User user;

        try {
            user = userService.updateUser(u);
        } catch (Exception e) {
            return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user,httpHeaders,HttpStatus.OK);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST, headers = "content-type=application/json",
            consumes = "application/json", produces = "application/json")
    public ResponseEntity newUser(@RequestBody User u) {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        User user;

        try {
            user = userService.updateUser(u);
        } catch (Exception e) {
            return new ResponseEntity<>(httpHeaders, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user,httpHeaders,HttpStatus.OK);
    }

    private HttpHeaders createAuthenticationHeader(String username, String password) {
        String auth = username + ":" + password;
        String encodedAuth = Base64.getEncoder().encodeToString(auth.getBytes(Charset.forName("UTF-8")));
        String authHeader = "Basic " + encodedAuth;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", authHeader);
        return headers;
    }
}
