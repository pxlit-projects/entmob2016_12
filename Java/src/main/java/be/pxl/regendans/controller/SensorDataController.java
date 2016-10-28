package be.pxl.regendans.controller;

import be.pxl.regendans.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Frank on 28-10-2016.
 */
@RestController
@RequestMapping("sensordata")
public class SensorDataController {

    @Autowired
    SensorDataService sensorDataService;

    @GetMapping(value="/temperature")
    public void saveTemeperature(double temperature){
        sensorDataService.saveAirPressure()
}
}
