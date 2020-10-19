package classes;

import abstract_classes.LandVehicle;
import interfaces.Motorized;

import java.util.Objects;

public class ElectricBicycle extends LandVehicle implements Motorized {
	/** The Fuel avg. */
	private double FuelAvg;
	/** The avglifespan. */
	private double avglifespan;
	public ElectricBicycle(String model_name, double max_speed,  boolean isDirt,
			boolean isPaved, double id, String img) {
		super(model_name, 1, max_speed, 2, isDirt, isPaved, id, img);
	}

	@Override
	public double getFuelAvg() {
		return this.FuelAvg;
	}

	@Override
	public boolean setFuelAvg(double FuelAvg) {
		this.FuelAvg=FuelAvg;
		return true;
	}

	@Override
	public double getAvgLifeSpan() {
		return this.avglifespan;
	}

	@Override
	public String toString() {
		return "<html>******ElectricBicycle******<br>" +
				"FuelAvg=" + FuelAvg +
				", avglifespan=" + avglifespan +
				 super.toString()+"<br>******ElectricBicycle******<br></html>";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		ElectricBicycle that = (ElectricBicycle) o;
		return Double.compare(that.FuelAvg, FuelAvg) == 0 &&
				Double.compare(that.avglifespan, avglifespan) == 0;
	}

}
