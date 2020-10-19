package abstract_classes;

import interfaces.IVehicle;

/**
 * The Class Vehicle.
 */
public abstract class Vehicle implements IVehicle {
	/*
	 * 
	 * /
	 */
	private double id;
	private String img;
	/** The distance. */
	private double distance;
	private boolean lock;
	/*  */
	public static Double distanceall=0.0;
	/** The model name. */
	private String model_name;
	
	/** The max passngers. */
	private int max_passngers;
	
	/** The max speed. */
	private double max_speed;
	
	/**
	 * Instantiates a new vehicle.
	 *
	 * @param model_name the model name
	 * @param max_passngers the max passngers
	 * @param max_speed the max speed
	 */
	public Vehicle(String model_name,int max_passngers,double max_speed,double id,String img) {
		this.distance=0;
		this.model_name=model_name;
		this.max_passngers=max_passngers;
		this.max_speed=max_speed;
		this.id=id;
		this.img=img;
		lock = false;
	};
	public double getID() {
		return id;
	}

	public void setImg(double id ) {
		this.id = id;
	}
	public boolean getLock(){
		return this.lock;
	}
	public void setLock(boolean lock){
		this.lock=lock;
	}
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	/**
	 * Gets the distance.
	 *
	 * @return the double
	 */
	public double GetDistance() {
		return this.distance;
	};
	
	/**
	 * Sets the distance.
	 *
	 * @param distance the distance
	 */
	public boolean SetDistance(Double distance)
	{
			if (distance >= 0) {
				this.distance += distance;
				distanceall+=distance;
				return true;
			}
			return false;
	}
	
	/**
	 * Gets the model name.
	 *
	 * @return the string
	 */
	public String GetModelName() {
		return this.model_name;
	};
	
	/**
	 * Sets the name.
	 *
	 * @param model_name the model name
	 */
	public boolean SetName(String model_name) {
		if(model_name instanceof String) {this.model_name=model_name;
		return true;
		}
		return false;
	};
	
	/**
	 * Gets the max passangers.
	 *
	 * @return the int
	 */
	public int GetMaxPassangers() {
		return this.max_passngers;
	};
	
	/**
	 * Sets the max passangers.
	 *
	 * @param max_passangers the max passangers
	 */
	public boolean SetMaxPassangers(int max_passangers) {
		if(max_passangers>0) {
		this.max_passngers=max_passangers;
		return true;
		}
		return false;
	};
	
	/**
	 * Gets the speed.
	 *
	 * @return the double
	 */
	public double GetSpeed() {
		return this.max_speed;
	};
	
	/**
	 * Sets the speed.
	 *
	 * @param max_speed the max speed
	 */
	public boolean SetSpeed(double max_speed) {
		if(max_speed>=0){this.max_speed=max_speed;
		return true;
		}
		return false;
	};
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
			return String.format("<html>Model:%s,traveled:%s,Max speed of %s,can carry max of %s pepole",model_name,distance,max_speed,max_passngers);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		boolean t=other instanceof Vehicle;
		Vehicle s=null;
		if(t){s = (Vehicle)other;}
		return t && (this.distance==s.distance)&&(this.model_name.equals(s.model_name))&&(this.max_speed==s.max_speed)&&(this.max_passngers==s.max_passngers); 
	}
}
