package net.davekirkwood.springspeedtest.model;

public class Model {

	private int key;
	private String modelName;
	private int modelNumber;
	
	public Model() {
		super();
	}
	
	public Model(int key, String modelName, int modelNumber) {
		super();
		this.key = key;
		this.modelName = modelName;
		this.modelNumber = modelNumber;
	}
	
	/**
	 * @return the key
	 */
	public synchronized int getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public synchronized void setKey(int key) {
		this.key = key;
	}
	/**
	 * @return the modelName
	 */
	public synchronized String getModelName() {
		return modelName;
	}
	/**
	 * @param modelName the modelName to set
	 */
	public synchronized void setModelName(String modelName) {
		this.modelName = modelName;
	}
	/**
	 * @return the modelNumber
	 */
	public synchronized int getModelNumber() {
		return modelNumber;
	}
	/**
	 * @param modelNumber the modelNumber to set
	 */
	public synchronized void setModelNumber(int modelNumber) {
		this.modelNumber = modelNumber;
	}
	@Override
	public String toString() {
		return "MyModel [key=" + key + ", modelName=" + modelName + ", modelNumber=" + modelNumber + "]";
	}
	
	
	
}
