package net.davekirkwood.springspeedtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient
public class SpringSpeedTest04MicroserviceBApplication {

	public static void main(String[] args) {
		System.out.println("*********** Running *************");
		SpringApplication.run(SpringSpeedTest04MicroserviceBApplication.class, args);
	}

}
