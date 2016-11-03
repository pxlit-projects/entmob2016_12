package be.pxl.regendans.jms;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * Created by Frank on 3-11-2016.
 */
@Component
public class JMSMessageLogger {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("JMSLoggerQueue")
    private Queue destination;

    public void log(String message){
        jmsTemplate.send(
                destination,
                (session) -> session.createMessage(message)
        );
    }
}