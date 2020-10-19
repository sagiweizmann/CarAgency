package interfaces;

import enums.energticScore;


/**
 * The Interface NonMotorized.
 */
public interface NonMotorized {
	
	/**
	 * Gets the power source.
	 *
	 * @return the power source
	 */
	public String getPowerSource();
	
	/**
	 * Enrgtic score.
	 *
	 * @return the energtic score
	 */
	public energticScore enrgticScore();
}
