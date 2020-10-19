package interfaces;

/**
 * The Interface IVehicle.
 */
public interface IVehicle {
	public double getID();
	public void setImg(double id );
	public boolean getLock();
	public void setLock(boolean lock);
	public String getImg();
	public void setImg(String img);
	public double GetDistance();
	public boolean SetDistance(Double distance);
	public String GetModelName();
	public boolean SetName(String model_name) ;
	public int GetMaxPassangers();
	public boolean SetMaxPassangers(int max_passangers);
	public double GetSpeed();
	public boolean SetSpeed(double max_speed);

}
