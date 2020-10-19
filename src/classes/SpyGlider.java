package classes;

import abstract_classes.AirVehicle;
import enums.energticScore;
import interfaces.NonMotorized;

/**
 * The Class SpyGlider.
 */
public class SpyGlider extends AirVehicle implements NonMotorized {
	
	/** The powersource. */
	private String powersource;
	
	/** The energtic. */
	private energticScore energtic;
	
	/**
	 * Instantiates a new spy glider.
	 *
	 * @param powerSource the power source
	 */
	public SpyGlider(String powerSource,double id,String img) {
		super("Privileged", 1, 50,true,img,id);
		this.powersource=powerSource;
		energtic=energticScore.C;
	}
	
	/* (non-Javadoc)
	 * @see interfaces.NonMotorized#getPowerSource()
	 */
	@Override
	public String getPowerSource() {
		return powersource;
	}

	/* (non-Javadoc)
	 * @see interfaces.NonMotorized#enrgticScore()
	 */
	@Override
	public energticScore enrgticScore() {return this.energtic;};
	
	/* (non-Javadoc)
	 * @see abstract_classes.AirVehicle#toString()
	 */
	public String toString() {
		return "<html>******SpyGlider******<br>"+super.toString()+String.format("<br>PowerSource:%s,EnrgeticScore:%s",this.powersource,this.energtic)+"<br>******SpyGlider*******</html>";
	}
	
	/* (non-Javadoc)
	 * @see abstract_classes.AirVehicle#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		boolean t=other instanceof SpyGlider;
		SpyGlider s=null;
		if(t){s = (SpyGlider)other;}
		return super.equals(other)&&t&&(this.energtic==s.energtic)&&(this.powersource.equals(s.powersource));
	}
}
