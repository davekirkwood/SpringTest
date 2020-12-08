package net.davekirkwood.springspeedtest.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import net.davekirkwood.springspeedtest.model.Model;

@RestController
public class ModelController {

//	private static final String dbMicroserviceAddress = "http://serviceb/db/";
	private static final String dbMicroserviceAddress = "http://davekirkwood.net:8080/db/";
//	private static final String dbMicroserviceAddress = "http://localhost:8080/db/";
	@Autowired
	private RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(value="/model/size")
	public int getSize() {
		return restTemplate.getForObject(dbMicroserviceAddress + "model/size", Integer.class);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addmodels")
	public void addModel(@RequestBody List<Model> models) {
		restTemplate.postForObject(dbMicroserviceAddress + "addmodels", models, Void.class);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/model")
	public void addModel(@RequestBody Model model) {
		restTemplate.postForObject(dbMicroserviceAddress + "model", model, Void.class);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/model/{id}")
	public void deleteModel(@PathVariable int id) {
		restTemplate.delete(dbMicroserviceAddress + "model/" + id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/model/{id}/{newName}")
	public void updateModelName(@PathVariable int id, @PathVariable String newName) {
		restTemplate.put(dbMicroserviceAddress + "model/" + id + "/" + newName, null);
	}
	
	@RequestMapping("/model/{id}")
	public Model readModel(@PathVariable int id) {
		return restTemplate.getForObject(dbMicroserviceAddress + "model/" + id, Model.class);
	}
	
	@RequestMapping("/models")
	public Collection<Model> getAllModels() {
		return restTemplate.getForObject(dbMicroserviceAddress + "models", Collection.class);
	}
	
}
