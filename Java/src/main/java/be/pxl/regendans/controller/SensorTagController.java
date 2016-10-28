package be.pxl.regendans.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Frank on 28-10-2016.
 */
@RestController
@RequestMapping("sensorTag")
public class SensorTagController {
    @GetMapping(value="/doesItRain", produces = "application/json")
    public boolean doesItRain(){
      return false;
    }
}
