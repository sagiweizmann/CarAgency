package classes;

import abstract_classes.AirVehicle;
import abstract_classes.LandVehicle;
import enums.energticScore;
import interfaces.NonMotorized;

/**
 * The Class GameGlider.
 */
public class Bicycle extends LandVehicle implements NonMotorized  {
	
	/** The powersource. */
	private String powersource;
	
	/** The energtic. */
	private energticScore energtic;
	
	/**
	 * Instantiates a new Bicycle.
	 *
	 * @param model_name the model name
	 */
	public Bicycle(String model_name,double id,String img) {
		super(model_name,1,10,2,true,true,id,img);
		this.powersource="Manual";
		energtic=energticScore.A;
	}

	/* (non-Javadoc)
	 * @see interfaces.NonMotorized#getPowerSource()
	 */
	@Override
	public String getPowerSource() {return this.powersource;};

	/* (non-Javadoc)
	 * @see interfaces.NonMotorized#enrgticScore()
	 */
	@Override
	public energticScore enrgticScore() {return this.energtic;};
	
	/* (non-Javadoc)
	 * @see abstract_classes.AirVehicle#toString()
	 */
	public String toString() {
		return "<html>******Bicycle******<br>"+super.toString()+String.format("<html><br>PowerSource:%s,EnrgeticScore:%s</html>",this.powersource,this.energtic)+"<html><br>******Bicycle*******</html>";
	}
	
	/* (non-Javadoc)
	 * @see abstract_classes.AirVehicle#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		boolean t=other instanceof Bicycle;
		Bicycle s=null;
		if(t){s = (Bicycle)other;}
		return super.equals(other)&&t&&(this.energtic==s.energtic)&&(this.powersource.equals(s.powersource));
	}
}
