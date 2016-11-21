package be.pxl.regendans.aspect;

import be.pxl.regendans.annotation.UserAccessLogger;
import be.pxl.regendans.jms.JMSMessageLogger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Bunyamin
 */

@Component
@Aspect
public class UserAccessInterceptor {

    private JMSMessageLogger logger;

    @Before(value="be.pxl.regendans.aspect.RegenProxy.userMethodsAccessed()" +
            "&& target(bean)" +
            "&& @annotation(be.pxl.regendans.annotation.UserAccessLogger)" +
            "&& @annotation(intercepted)",
        argNames="bean, intercepted")
    public void performIntercept(Object bean, UserAccessLogger intercepted) {

        logger.log(intercepted.message());

    }
}
