package be.pxl.regendans.annotation;

import java.lang.annotation.*;

/**
 * @author Bunyamin
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserAccessLogger {
    String message() default "Accessed";
}
