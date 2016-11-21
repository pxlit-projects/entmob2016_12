package be.pxl.regendans.controller;

import be.pxl.regendans.entity.AirPressure;
import be.pxl.regendans.entity.Humidity;
import be.pxl.regendans.entity.Temperature;
import be.pxl.regendans.jms.JMSMessageLogger;
import be.pxl.regendans.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static be.pxl.regendans.controller.SensorDataController.SENSORDATA_BASE_URL;

/**
 * Created by Frank on 28-10-2016.
 */
@RestController
@RequestMapping(SENSORDATA_BASE_URL)
public class SensorDataController {

    @Autowired
    SensorDataService sensorDataService;
    @Autowired
    private JMSMessageLogger logger;

    public static final String SENSORDATA_BASE_URL = "/sensordata";

    @PostMapping(value = "/temperature", produces="application/json", headers="Accept=application/json")
    public ResponseEntity saveTemeperature(@RequestBody Temperature temperature) {
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        logger.log("temperature is being saved");

        Temperature temp;
        try {

            temp = sensorDataService.saveTemperature(temperature);
        }catch(Exception e){
            return new ResponseEntity(httpHeaders, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Temperature>(temp, httpHeaders, HttpStatus.CREATED);
    }

    @PostMapping(value = "/humidity", produces="application/json", headers="Accept=application/json")
    public ResponseEntity saveHumidity(@RequestBody Humidity humidity) {
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        logger.log("Humidity is being saved");
        Humidity hum;
        try {
            hum = sensorDataService.saveHumidity(humidity);
        }catch(Exception e){
            return new ResponseEntity(httpHeaders, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Humidity>(hum, httpHeaders, HttpStatus.CREATED);
    }

    @PostMapping(value = "/airpressure", produces="application/json", headers="Accept=application/json")
    public ResponseEntity saveAirPressure(@RequestBody AirPressure airPressure) {
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        logger.log("airpressure is being saved");

        AirPressure pressure;
        try {
            pressure = sensorDataService.saveAirPressure(airPressure);
        }catch(Exception e){
            return new ResponseEntity(httpHeaders, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(pressure, httpHeaders, HttpStatus.CREATED);
    }
}
