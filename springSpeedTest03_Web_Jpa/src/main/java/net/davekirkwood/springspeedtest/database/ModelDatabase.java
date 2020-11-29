package net.davekirkwood.springspeedtest.database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.davekirkwood.springspeedtest.model.Model;

@Service
public class ModelDatabase {

	@Autowired
	ModelRepository modelRepository;
	
	public int getSize() {
		return (int)modelRepository.count();
	}
	
	public void addModel(Model model) {
		modelRepository.save(model);
	}
	
	public void deleteModel(int modelId) {
		modelRepository.deleteById(modelId);
	}
	
	public void updateModelName(int modelId, String newName) {
		Optional<Model> optModel = modelRepository.findById(modelId);
		if(optModel.isPresent()) {
			Model model = optModel.get();
			model.setModelName(newName);
			modelRepository.save(model);
		} else {
			System.err.println("Unable to update model.");
		}
	}
	
	public Model readModel(int modelId) {
		Optional<Model> optModel = modelRepository.findById(modelId);
		if(optModel.isPresent()) {
			return optModel.get();
		} else {
			return null;
		}
	}
	
	public Collection<Model> getAllModels() {
		List<Model> modelList = new ArrayList<Model>();
		modelRepository.findAll().forEach(modelList::add);
		return modelList;
	}
	
}
