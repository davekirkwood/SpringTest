package net.davekirkwood.springspeedtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.davekirkwood.springspeedtest.model.Model;

public class SpringSpeedTestClient {
	
	private static String serviceAAddress = "http://localhost:8080/";

	private static final int MODEL_COUNT = 10000;

	private static Date startDate;
	
	public static void main(String[] args) {
		
		if(args.length > 0) {
			serviceAAddress = args[0];
		}
		
		for(int z=0; z<100; z++) {
				
			List<Model> myModels = new ArrayList<Model>();
	
			for (int i = 0; i < MODEL_COUNT; i++) {
				Model model = new Model(i + 1, "Model number " + (i + 1), i + 1, 123.4, "Another string", 123);
				myModels.add(model);
			}	
	
	//		for (Model model : myModels) {
	//			addModel(model);
	//		}
			addModels(myModels);
			System.out.println(getSize() + " records created.");
	
			Date createDate = new Date();
			
//			List<String> readModels = new ArrayList<>();
//			for(Model model : myModels) {
//				String m = readModel(model.getKey());
//	//			System.out.println(m);
//				readModels.add(m);
//			}
//			System.out.println(readModels.size() + " records read.");
//			
//			Date readDate = new Date();
			
			String allModels = readAllModels();
			System.out.println("All records read length = " + (allModels.length()));
			
			Date readAllDate = new Date();
//			
//			for(Model model : myModels) {
//				updateModelName(model.getKey(), "NewModel" + (model.getKey()));
//			}
//			System.out.println(getSize() + " records updated.");
//			
//			Date updateDate = new Date();
//			
//			for(Model model : myModels) {
//				deleteModel(model.getKey());
//			}
//			System.out.println((myModels.size() - Integer.valueOf(getSize())) + " records deleted.");
//			
			clear();
			Date deleteDate = new Date();

			
			
			System.out.println("Create   = " + (createDate.getTime() - startDate.getTime()));
//			System.out.println("Read     = " + (readDate.getTime() - createDate.getTime()));
			System.out.println("Real all = " + (readAllDate.getTime() - createDate.getTime()));
//			System.out.println("Update   = " + (updateDate.getTime() - readAllDate.getTime()));
			System.out.println("Delete   = " + (deleteDate.getTime() - readAllDate.getTime()));
		}		
	}

	private static void addModels(List<Model> models) {
		StringBuilder sb = new StringBuilder("[ ");
		for(Model model : models) {
			sb.append( "{\"key\": \"" + model.getKey() + "\", " 
					+ "\"modelName\": \"" + model.getModelName() + "\", "
					+ "\"myDouble\": \"" + model.getMyDouble() + "\", "
					+ "\"myString\": \"" + model.getMyString() + "\", "
					+ "\"myInt\": \"" + model.getMyInt() + "\", "
					+ "\"modelNumber\": \"" + model.getModelNumber() + "\"},");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
//		System.out.println(sb.toString());
		
		startDate = new Date();
		
		httpReq(serviceAAddress + "addmodels", "POST", sb.toString(), false);
	}
	
	
	private static void addModel(Model model) {
		String jsonInputString = "{\"key\": \"" + model.getKey() + "\", " + "\"modelName\": \"" + model.getModelName()
			+ "\", " + "\"modelNumber\": \"" + model.getModelNumber() + "\"}";
		httpReq(serviceAAddress + "model", "POST", jsonInputString, false);
	}
	
	private static String getSize() {
		return httpReq(serviceAAddress + "model/size", "GET", null, true);
	}
	
	private static String readModel(int id) {
		return httpReq(serviceAAddress + "model/" + id, "GET", null, true);
	}
	
	private static String readAllModels() {
		return httpReq(serviceAAddress + "models", "GET", null, true);
	}
	
	private static void updateModelName(int id, String newName) {
		httpReq(serviceAAddress + "model/" + id + "/" + newName + "", "PUT", null, false);
	}
	
	private static void deleteModel(int id) {
		httpReq(serviceAAddress + "model/" + id, "DELETE", null, false);
	}
	
	private static void clear() {
		httpReq(serviceAAddress + "clear", "GET", null, false);
	}
	
	private static String httpReq(String url, String method, String output, boolean responseRequired) {
		try {
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			con.setRequestMethod(method);
			if(output != null) {
				con.setRequestProperty("Content-Type", "application/json; utf-8");
			}
			if(responseRequired) {
				con.setRequestProperty("Accept", "application/json");
			}
			if(output != null) {
				con.setDoOutput(true);
				try (OutputStream os = con.getOutputStream()) {
					byte[] input = output.getBytes("utf-8");
					os.write(input, 0, input.length);
				}
			}
			StringBuilder response = null;
			try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))) {
				response = new StringBuilder();
				String responseLine = null;
				while ((responseLine = br.readLine()) != null) {
					response.append(responseLine.trim());
				}
			}
			con.disconnect();
			if(responseRequired) {
				return response.toString();
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
