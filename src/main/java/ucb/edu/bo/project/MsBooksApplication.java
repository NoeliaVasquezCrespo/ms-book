package ucb.edu.bo.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBooksApplication.class, args);
	}

}
