package net.davekirkwood.springspeedtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringSpeedTest04MicroserviceAApplication {

	@Bean
	public RestTemplate getRestTemplate() {
//		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();        
//		//Add the Jackson Message converter
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//
//		// Note: here we are making this converter to process any kind of response, 
//		// not only application/*json, which is the default behaviour
//		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));        
//		messageConverters.add(converter); 
//		
		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.setMessageConverters(messageConverters); 
		
		return restTemplate;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSpeedTest04MicroserviceAApplication.class, args);
	}

}
