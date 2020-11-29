package net.davekirkwood.springspeedtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringSpeedTest04MicroserviceBApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSpeedTest04MicroserviceBApplication.class, args);
	}

}
