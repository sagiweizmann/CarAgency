package factory;

import abstract_classes.AirVehicle;
import abstract_classes.LandVehicle;
import abstract_classes.Vehicle;
import abstract_classes.WaterVehicle;
import enums.TypeVehicle;

public abstract class AbstractFactory {
    public abstract Vehicle getVehicle(TypeVehicle vehicle);
    public abstract WaterVehicle getWaterVehicle(TypeVehicle vehicle);
    public abstract AirVehicle getAirVehicle(TypeVehicle vehicle);
    public abstract LandVehicle getLandVehicle(TypeVehicle vehicle);
}