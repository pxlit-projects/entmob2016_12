package be.pxl.regendans.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Base64;

/**
 * Created by Frank on 30-10-2016.
 */
@Component
@Aspect
public class RegenProxy {

    @After("execution(* be.pxl.regendans.service.SensorDataService.*(..))")
    public void logTemperature(JoinPoint joinPoint){
        System.out.println("saving" + joinPoint.getSignature()  +" with arguments");
        System.out.println(Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* be.pxl.regendans.service.UserService.*(..))")
    public void logUsers(JoinPoint joinPoint){
        System.out.println("access to " + joinPoint.getSignature()  +" with arguments");
        System.out.println(Arrays.toString(joinPoint.getArgs()));
    }
}
