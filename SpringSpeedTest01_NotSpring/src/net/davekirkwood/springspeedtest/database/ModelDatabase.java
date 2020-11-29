package net.davekirkwood.springspeedtest.database;

import java.util.HashMap;
import java.util.Map;

import net.davekirkwood.springspeedtest.model.Model;

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
	
}