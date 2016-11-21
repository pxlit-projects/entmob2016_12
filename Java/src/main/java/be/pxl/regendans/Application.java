package be.pxl.regendans;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;

@SpringBootApplication
@EnableJms
public class Application {

    @Bean(name = "JMSLoggerQueue")
    public Queue jmsLoggerQueue() {
        return new ActiveMQQueue("ItemLogQueue");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
