package be.pxl.regendans.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

/**
 * Created by Frank on 30-10-2016.
 */
@Aspect
public class RegenProxy {

    @After("execution(* be.pxl.regendans.service.SensorDataService.saveTemperature(..))")
    public void logTemperature(JoinPoint joinPoint){
        System.out.println("saving temperature with arguments");
        System.out.println(Arrays.toString(joinPoint.getArgs()));
    }
    @After("execution(* be.pxl.regendans.service.SensorDataService.saveHumidity(..))")
    public void logHumidity(JoinPoint joinPoint){
        System.out.println("saving humidity with arguments");
        System.out.println(Arrays.toString(joinPoint.getArgs()));
    }
    @After("execution(* be.pxl.regendans.service.SensorDataService.saveAirPressure(..))")
    public void logAirPressure(JoinPoint joinPoint){
        System.out.println("saving airPressure with arguments");
        System.out.println(Arrays.toString(joinPoint.getArgs()));
    }
}
