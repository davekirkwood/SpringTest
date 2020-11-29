package net.davekirkwood.springspeedtest.database;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.davekirkwood.springspeedtest.model.Model;

@Service
public class ModelDatabase {

	private Map<Integer, Model> models = new HashMap<Integer, Model>();
	
	public int getSize() {
		return models.size();
	}
	
	public void addModel(Model model) {
		models.put(model.getKey(), model);
	}
	
	public void deleteModel(int modelId) {
		models.remove(modelId);
	}
	
	public void updateModelName(int modelId, String newName) {
		if(models.containsKey(modelId)) {
			models.get(modelId).setModelName(newName);
		} else {
			System.err.println("Unable to update model.");
		}
	}
	
	public Model readModel(int modelId) {
		return models.get(modelId);
	}
	
	public Collection<Model> getAllModels() {
		return models.values();
	}
	
}
