package classes;

import abstract_classes.AirVehicle;
import enums.energticScore;
import interfaces.NonMotorized;

/**
 * The Class GameGlider.
 */
public class GameGlider extends AirVehicle implements NonMotorized  {
	
	/** The powersource. */
	private String powersource;
	
	/** The energtic. */
	private energticScore energtic;
	
	/**
	 * Instantiates a new game glider.
	 *
	 * @param model_name the model name
	 */
	public GameGlider(String model_name,double id,String img) {
		super(model_name, 0, 10, false,img,id);
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
		return "<html>******GameGlider******<br>"+super.toString()+String.format("<br>PowerSource:%s,EnrgeticScore:%s",this.powersource,this.energtic)+"<br>******GameGlider*******<br></html>";
	}
	
	/* (non-Javadoc)
	 * @see abstract_classes.AirVehicle#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		boolean t=other instanceof GameGlider;
		GameGlider s=null;
		if(t){s = (GameGlider)other;}
		return super.equals(other)&&t&&(this.energtic==s.energtic)&&(this.powersource.equals(s.powersource));
	}
}
