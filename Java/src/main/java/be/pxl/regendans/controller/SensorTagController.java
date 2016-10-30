package be.pxl.regendans.controller;

import be.pxl.regendans.service.SensorTagService;
import be.pxl.regendans.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static be.pxl.regendans.controller.SensorTagController.SENSORTAG_BASE_URL;

/**
 * Created by Frank on 28-10-2016.
 */
@RestController
@RequestMapping(SENSORTAG_BASE_URL)
public class SensorTagController {

    public static final String SENSORTAG_BASE_URL = "/sensortag";

    @Autowired
    SensorTagService sensorTagService;

    @GetMapping(value="/doesItRain/{userid}", produces = "text/plain")
    public boolean doesItRain(@PathVariable int userid){
      return sensorTagService.doesItRain(userid);
    }
}
