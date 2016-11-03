package be.pxl.regendans.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
/**
 * Created by Frank on 3-11-2016.
 */
@Component
public class JMSMessageConsumer {

    @JmsListener(destination = "ItemLogQueue")
    public void onMessage(Message message) {
        System.out.println(message);
    }
}
