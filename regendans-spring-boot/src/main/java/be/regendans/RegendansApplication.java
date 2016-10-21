package be.regendans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("be.regendans")
public class RegendansApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegendansApplication.class, args);
	}
}