package abstract_classes;

/**
 * The Class LandVehicle.
 */
public class LandVehicle extends Vehicle {
	
	/** The num of wheels. */
	private int numOfWheels;
	/** The is dirt. */
	private boolean isDirt;
	
	/** The is paved. */
	private boolean isPaved;
	
	/**
	 * Instantiates a new land vehicle.
	 *
	 * @param name the name
	 * @param max_passngers the max passngers
	 * @param max_speed the max speed
	 * @param numOfWheels the num of wheels
	 * @param isDirt the is dirt
	 * @param isPaved the is paved
	 */
	public LandVehicle(String model_name,int max_passngers,double max_speed,int numOfWheels,boolean isDirt,boolean isPaved,double id,String img){
	super(model_name,max_passngers,max_speed,id,img);
	this.numOfWheels=numOfWheels;
	this.isDirt=isDirt;
	this.isPaved=isPaved;
	}
	
	/**
	 * Gets the num of wheels.
	 *
	 * @return the int
	 */
	public int GetNumOfWheels() {return this.numOfWheels;};
	
	/**
	 * Gets the is dirt.
	 *
	 * @return true, if successful
	 */
	public boolean GetIsDirt() {return this.isDirt;};
	
	/* (non-Javadoc)
	 * @see abstract_classes.Vehicle#toString()
	 */
	public String toString() {
		return super.toString()+String.format("<html><br>Num of wheels:%s,Can drive on dirt:%s,Can drive on paved road:%s", this.numOfWheels,this.isDirt,this.isPaved);
	}

	/* (non-Javadoc)
	 * @see abstract_classes.Vehicle#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		boolean t=other instanceof LandVehicle;
		LandVehicle s=null;
		if(t){s = (LandVehicle)other;}
		return super.equals(other)&&t&&(this.isDirt==s.isDirt)&&(this.isPaved==s.isPaved)&&(this.numOfWheels ==s.numOfWheels);
	}
}
