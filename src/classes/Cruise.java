package classes;

import abstract_classes.WaterVehicle;
import interfaces.Commercial;
import interfaces.Motorized;

public class Cruise extends WaterVehicle implements Motorized,Commercial{
	private String license="Unlimited";
	
	/** The Fuel avg. */
	private double FuelAvg;
	
	/** The avglifespan. */
	private double avglifespan;
	public Cruise(String model_name, int max_passngers, double max_speed, boolean wind_direction, String flag,double id,String img) {
		super(model_name, max_passngers, max_speed, wind_direction, flag,id,img);
	}

	@Override
	public String getLicense() {
		// TODO Auto-generated method stub
		return this.license;
	}

	@Override
	public double getFuelAvg() {
		// TODO Auto-generated method stub
		return this.FuelAvg;
	}

	@Override
	public boolean setFuelAvg(double FuelAvg) {
		if(FuelAvg < 0) {
			this.FuelAvg=FuelAvg;
			return true;
			}
			return false;
	}

	@Override
	public double getAvgLifeSpan() {
		// TODO Auto-generated method stub
		return this.avglifespan;
	}

	@Override
	public String toString() {
		return "<html>*****Crusie******<br>"+super.toString()+"<br> Cruise [license=" + license + ", FuelAvg=" + FuelAvg + ", avglifespan=" + avglifespan + "]"+"<br>*****Cruise******</html>";
	}
	@Override
	public boolean equals(Object other) {
		boolean t=other instanceof Cruise;
		Cruise s=null;
		if(t){s = (Cruise)other;}
		return super.equals(other)&&t&&(this.avglifespan==s.avglifespan)&&(this.license.equals(s.license))&&(this.FuelAvg==s.FuelAvg);
	}
}

