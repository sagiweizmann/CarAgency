package classes;

import abstract_classes.WaterVehicle;
import interfaces.Motorized;


/**
 * The Class Frigate.
 */
public class Frigate extends WaterVehicle implements Motorized {
	
	/** The Fuel avg. */
	private double FuelAvg;
	
	/** The avglifespan. */
	private double avglifespan;
	
	/**
	 * Instantiates a new frigate.
	 *
	 * @param model_name the model name
	 * @param max_passngers the max passngers
	 * @param max_speed the max speed
	 * @param wind_direction the wind direction
	 * @param flag the flag
	 */
	public Frigate(String model_name,int max_passngers,double max_speed,boolean wind_direction,String flag,double id,String img) {
		super(model_name,max_passngers,max_speed,wind_direction,flag,id,img);
		this.FuelAvg=500;
		this.avglifespan=4;
	}
	
	/* (non-Javadoc)
	 * @see interfaces.Motorized#getFuelAvg()
	 */
	@Override
	public double getFuelAvg() {
		return this.FuelAvg;
	}

	/* (non-Javadoc)
	 * @see interfaces.Motorized#setFuelAvg(double)
	 */
	@Override
	public boolean setFuelAvg(double FuelAvg) {
		if(FuelAvg < 0) {
		this.FuelAvg=FuelAvg;
		return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see interfaces.Motorized#getAvgLifeSpan()
	 */
	@Override
	public double getAvgLifeSpan() {
		return this.avglifespan;
	}
	
	/* (non-Javadoc)
	 * @see abstract_classes.WaterVehicle#toString()
	 */
	public String toString() {
		return "<html>*****Frigate******<br>"+super.toString()+String.format("<br>Average Fuel:%s,Average LifeSpan:%s",this.FuelAvg,this.avglifespan)+"<br>*****Frigate******</html>";
	}
	
	/* (non-Javadoc)
	 * @see abstract_classes.WaterVehicle#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		boolean t=other instanceof Frigate;
		Frigate s=null;
		if(t){s = (Frigate)other;}
		return super.equals(other)&&t&&(this.avglifespan==s.avglifespan)&&(this.FuelAvg==s.FuelAvg);
	}
}
