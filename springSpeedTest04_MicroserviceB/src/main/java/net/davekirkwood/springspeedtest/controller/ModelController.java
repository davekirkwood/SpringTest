package net.davekirkwood.springspeedtest.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.davekirkwood.springspeedtest.database.ModelDatabase;
import net.davekirkwood.springspeedtest.model.Model;

@RestController
@RequestMapping("/db")
public class ModelController {

	@Autowired
	private ModelDatabase database;
	
	@RequestMapping(value="/model/size")
	public int getSize() {
		return database.getSize();
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addmodels")
	public void addModel(@RequestBody List<Model> models) {
		System.out.println("Service B Add Model");
		for(Model model : models) {
			database.addModel(model);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/model")
	public void addModel(@RequestBody Model model) {
		database.addModel(model);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/model/{id}")
	public void deleteModel(@PathVariable int id) {
		database.deleteModel(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/clear")
	public void clear() {
		database.clear();
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/model/{id}/{newName}")
	public void updateModelName(@PathVariable int id, @PathVariable String newName) {
		database.updateModelName(id, newName);
	}
	
	@RequestMapping("/model/{id}")
	public Model readModel(@PathVariable int id) {
		return database.readModel(id);
	}
	
	@RequestMapping("/models")
	public Collection<Model> getAllModels() {
		return database.getAllModels();
	}
	
}
