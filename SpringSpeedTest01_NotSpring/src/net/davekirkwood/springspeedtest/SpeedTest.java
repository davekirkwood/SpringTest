package net.davekirkwood.springspeedtest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.davekirkwood.springspeedtest.database.ModelDatabase;
import net.davekirkwood.springspeedtest.model.Model;

public class SpeedTest {

	private static final int MODEL_COUNT = 1000000;
	
	private ModelDatabase modelDatabase = new ModelDatabase();
	
	public SpeedTest() {
		
		List<Model> myModels = new ArrayList<Model>();
		
		for(int i=0; i<MODEL_COUNT; i++) {
			Model model = new Model(i, "Model number " + (i+1), i+1);
			myModels.add(model);
		}
		
		Date startDate = new Date();
		
		for(Model model : myModels) {
			modelDatabase.addModel(model);
		}
		System.out.println(modelDatabase.getSize() + " records created.");
		
		Date createDate = new Date();
		
		List<Model> readModels = new ArrayList<>();
		for(Model model : myModels) {
			readModels.add(modelDatabase.readModel(model.getKey()));
		}
		System.out.println(readModels.size() + " records read.");
		
		Date readDate = new Date();
		
		for(Model model : myModels) {
			modelDatabase.updateModelName(model.getKey(), "New model " + (model.getKey() + 1));
		}
		System.out.println(modelDatabase.getSize() + " records updated.");
		
		Date updateDate = new Date();
		
		for(Model model : myModels) {
			modelDatabase.deleteModel(model.getKey());
		}
		System.out.println((myModels.size() - modelDatabase.getSize()) + " records deleted.");
		
		Date deleteDate = new Date();
		
		System.out.println("Create = " + (createDate.getTime() - startDate.getTime()));
		System.out.println("Read   = " + (readDate.getTime() - createDate.getTime()));
		System.out.println("Update = " + (updateDate.getTime() - readDate.getTime()));
		System.out.println("Delete = " + (deleteDate.getTime() - updateDate.getTime()));
		
	}
	
	public static void main(String[] args) {
		for(int i=0; i<100; i++) {
			new SpeedTest();
		}
	}

}
