package net.davekirkwood.springspeedtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class SpringSpeedTest04MicroserviceAApplication {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
//		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
//		//Add the Jackson Message converter
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//
//		// Note: here we are making this converter to process any kind of response, 
//		// not only application/*json, which is the default behaviour
//		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
//		
//		messageConverters.add(converter); 
////		
		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.setMessageConverters(messageConverters); 
		
		return restTemplate;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSpeedTest04MicroserviceAApplication.class, args);
	}

}
