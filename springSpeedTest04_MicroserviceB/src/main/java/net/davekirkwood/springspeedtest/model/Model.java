package net.davekirkwood.springspeedtest.model;

public class Model {
	private int key;
	
	private String modelName;
	
	private int modelNumber;
	
	private double myDouble;
	
	private String myString;
	
	private int myInt;
	
	public Model() {
		super();
	}
	
	public Model(int key, String modelName, int modelNumber, double myDouble, String myString, int myInt) {
		super();
		this.key = key;
		this.modelName = modelName;
		this.modelNumber = modelNumber;
		this.myDouble = myDouble;
		this.myInt = myInt;
		this.myString = myString;
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

	/**
	 * @return the myDouble
	 */
	public synchronized double getMyDouble() {
		return myDouble;
	}

	/**
	 * @param myDouble the myDouble to set
	 */
	public synchronized void setMyDouble(double myDouble) {
		this.myDouble = myDouble;
	}

	/**
	 * @return the myString
	 */
	public synchronized String getMyString() {
		return myString;
	}

	/**
	 * @param myString the myString to set
	 */
	public synchronized void setMyString(String myString) {
		this.myString = myString;
	}

	/**
	 * @return the myInt
	 */
	public synchronized int getMyInt() {
		return myInt;
	}

	/**
	 * @param myInt the myInt to set
	 */
	public synchronized void setMyInt(int myInt) {
		this.myInt = myInt;
	}

	@Override
	public String toString() {
		return "Model [key=" + key + ", modelName=" + modelName + ", modelNumber=" + modelNumber + ", myDouble="
				+ myDouble + ", myString=" + myString + ", myInt=" + myInt + "]";
	}

	
	
	
}
