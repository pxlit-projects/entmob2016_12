package be.pxl.regendans.controller;

import be.pxl.regendans.entity.AirPressure;
import be.pxl.regendans.entity.Humidity;
import be.pxl.regendans.entity.Temperature;
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

    public static final String SENSORDATA_BASE_URL = "/sensordata";

    @PostMapping(value = "/temperature", produces="application/json", headers="Accept=application/json")
    public ResponseEntity saveTemeperature(@RequestBody Map<String, String> json) {
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        Temperature temp;
        try {
            double temperature = Double.parseDouble(json.get("temperature"));
            int userid = Integer.parseInt(json.get("userid"));
            temp = sensorDataService.saveTemperature(temperature,userid);
        }catch(Exception e){
            return new ResponseEntity(httpHeaders, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Temperature>(temp, httpHeaders, HttpStatus.CREATED);
    }

    @PostMapping(value = "/humidity", produces="application/json", headers="Accept=application/json")
    public ResponseEntity saveHumidity(@RequestBody Map<String, String> json) {
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        Humidity humidity;
        try {
            double temperature = Double.parseDouble(json.get("humidity"));
            int userid = Integer.parseInt(json.get("userid"));
            humidity = sensorDataService.saveHumidity(temperature,userid);
        }catch(Exception e){
            return new ResponseEntity(httpHeaders, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Humidity>(humidity, httpHeaders, HttpStatus.CREATED);
    }

    @PostMapping(value = "/airpressure", produces="application/json", headers="Accept=application/json")
    public ResponseEntity saveAirPressure(@RequestBody Map<String, String> json) {
        final HttpHeaders httpHeaders= new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        AirPressure airPressure;
        try {
            double temperature = Double.parseDouble(json.get("airpressure"));
            int userid = Integer.parseInt(json.get("userid"));
            airPressure = sensorDataService.saveAirPressure(temperature,userid);
        }catch(Exception e){
            return new ResponseEntity(httpHeaders, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(airPressure, httpHeaders, HttpStatus.CREATED);
    }
}
