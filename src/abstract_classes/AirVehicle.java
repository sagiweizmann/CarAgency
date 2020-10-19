package abstract_classes;

/**
 * The Class AirVehicle.
 */
public class AirVehicle extends Vehicle {
	
	/** The is army. */
	private boolean isArmy;

	/**
	 * Instantiates a new air vehicle.
	 *
	 * @param model_name the model name
	 * @param max_passngers the max passngers
	 * @param max_speed the max speed
	 * @param isArmy the is army
	 */
	public AirVehicle(String model_name,int max_passngers,double max_speed,boolean isArmy,String img,double id) {
		super(model_name,max_passngers,max_speed,id,img);
		this.isArmy=isArmy;
		
	};
	
	/**
	 * Sets the army.
	 *
	 * @param army the army
	 */
	public boolean SetArmy(boolean army) {
		this.isArmy=army;
		return true;
	};
	
	/**
	 * Gets the army.
	 *
	 * @return true, if successful
	 */
	public boolean GetArmy() {
		return this.isArmy;
	};
	
	/* (non-Javadoc)
	 * @see abstract_classes.Vehicle#toString()
	 */
	public String toString() {
		return super.toString()+String.format("<html>,Army:%s ",isArmy);
	}
	/* (non-Javadoc)
	 * @see abstract_classes.Vehicle#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		boolean t=other instanceof AirVehicle;
		AirVehicle s=null;
		if(t){s = (AirVehicle)other;}
		return super.equals(other)&&t&&(this.isArmy==s.isArmy);
	}
}
