package abstract_classes;

import interfaces.Motorized;

public class AmphibiousVehicle extends Vehicle implements Motorized{
	
	LandVehicle landVehicle;
	WaterVehicle waterVehicle;
	/** The Fuel avg. */
	private double FuelAvg;
	/** The AvgLifeSpan **/
	private double avglifespan;
	public AmphibiousVehicle(String model_name,int max_passngers,double max_speed,boolean wind_direction,String flag,int numOfWheels,boolean isDirt,boolean isPaved,double id,String img) {
		super(model_name,max_passngers,max_speed,id,img);
		landVehicle = new LandVehicle(model_name,max_passngers, max_speed, numOfWheels, isDirt, isPaved,id,img);
		waterVehicle=new WaterVehicle(model_name, max_passngers, max_speed, wind_direction, flag,id,img);
	}
	public int GetNumOfWheels() {return landVehicle.GetNumOfWheels();};
	public boolean GetIsDirt() {return landVehicle.GetIsDirt();};
	public void SetFlag(String flag) {
		waterVehicle.SetFlag(flag);
	};
	public String GetFlag() {
		return waterVehicle.GetFlag();
	};
	public boolean SetWindDirection(boolean wind_direction) {
		waterVehicle.SetWindDirection(wind_direction);
		return true;
	};
	public boolean GetWindDirection() {
		return waterVehicle.GetWindDirection();
	};
	
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
		return "<html>*****Amphibious******<br>"+super.toString()+" <html><br> Amphibious [FuelAvg=" + FuelAvg + "<html><br>, avglifespan=" + avglifespan + "<html><br> Flag:"+this.waterVehicle.GetFlag() +"]"+"<html><br>*****Amphibious******";
	}
	
	

}
