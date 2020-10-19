package abstract_classes;

/**
 * The Class WaterVehicle.
 */
public class WaterVehicle extends Vehicle {
	
	/** The wind direction. */
	private boolean wind_direction;
	/** The flag. */
	private String flag;
	
	/**
	 * Instantiates a new water vehicle.
	 *
	 * @param model_name the model name
	 * @param max_passngers the max passngers
	 * @param max_speed the max speed
	 * @param wind_direction the wind direction
	 * @param flag the flag
	 */
	public WaterVehicle(String model_name,int max_passngers,double max_speed,boolean wind_direction,String flag,double id,String img) {
		super(model_name,max_passngers,max_speed,id,img);
		this.wind_direction=wind_direction;
		this.flag=flag;
	}
	
	/**
	 * Gets the wind direction.
	 *
	 * @return true, if successful
	 */
	public boolean GetWindDirection() {
		return this.wind_direction;
	};
	
	/**
	 * Sets the wind direction.
	 *
	 * @param wind_direction the wind direction
	 */
	public boolean SetWindDirection(boolean wind_direction) {
		this.wind_direction=wind_direction;
		return true;
	};
	
	/**
	 * Gets the flag.
	 *
	 * @return the string
	 */
	public String GetFlag() {
		return this.flag;
	};
	
	/**
	 * Sets the flag.
	 *
	 * @param flag the flag
	 */
	public void SetFlag(String flag) {
		this.flag=flag;
	};
	
	/* (non-Javadoc)
	 * @see abstract_classes.Vehicle#toString()
	 */
	public String toString() {
		String wind;
		if(wind_direction==true) {
			wind="With the wind ";
		}
		else {
			wind="Against the wind ";
		}
		return super.toString() + String.format("<html><br> %s ,Under %s Flag ",wind,this.flag);
	}

	/* (non-Javadoc)
	 * @see abstract_classes.Vehicle#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		boolean t=other instanceof WaterVehicle;
		WaterVehicle s=null;
		if(t){s = (WaterVehicle)other;}
		return super.equals(other)&&t&&(this.wind_direction==s.wind_direction)&&(this.flag.equals(s.flag));
	}
}
