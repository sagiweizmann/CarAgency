package classes;

import abstract_classes.LandVehicle;
import interfaces.Commercial;
import interfaces.Motorized;

// TODO: Auto-generated Javadoc
/**
 * The Class Jeep.
 */
public class Jeep extends LandVehicle implements Motorized,Commercial{
	
	/** The license. */
	private String license="MINI";
	
	/** The Fuel avg. */
	private double FuelAvg;
	
	/** The avglifespan. */
	private double avglifespan;
	
	/**
	 * Instantiates a new jeep.
	 *
	 * @param model_name the model name
	 * @param max_speed the max speed
	 * @param FuelAvg the fuel avg
	 * @param avglifespan the avglifespan
	 */
	public Jeep(String model_name,double max_speed,double FuelAvg,double avglifespan,double id,String img) {
	super(model_name,5,max_speed,4,true,true,id,img);
	this.avglifespan=avglifespan;
	}
	
	/* (non-Javadoc)
	 * @see interfaces.Commercial#getLicense()
	 */
	@Override
	public String getLicense() {
		return this.license;
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
	
	/**
	 * Sets the avg life span.
	 *
	 * @param avgLifeSpan the new avg life span
	 */
	public boolean setAvgLifeSpan(double avgLifeSpan) {
		if(avgLifeSpan < 0) {
		this.avglifespan=avgLifeSpan;
		return true;
		}
		return false;
	}
	
	/* (non-Javadoc)
	 * @see abstract_classes.LandVehicle#toString()
	 */
	public String toString() {
		return "<html>*****Jeep******<br>"+super.toString()+String.format("<br>Average Fuel:%s,Average LifeSpan:%s",this.FuelAvg,this.avglifespan)+"<br>*****Jeep******</html>";
	}
	
	/* (non-Javadoc)
	 * @see abstract_classes.LandVehicle#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		boolean t=other instanceof Jeep;
		Jeep s=null;
		if(t){s = (Jeep)other;}
		return super.equals(other)&&t&&(this.avglifespan==s.avglifespan)&&(this.license.equals(s.license))&&(this.FuelAvg==s.FuelAvg);
	}
}
