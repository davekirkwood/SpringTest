package net.davekirkwood.springspeedtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringSpeedTest04DisoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSpeedTest04DisoveryServerApplication.class, args);
	}

}
