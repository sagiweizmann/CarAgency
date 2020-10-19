package factory;

import abstract_classes.*;
import classes.*;
import enums.TypeVehicle;

public class LandVehicleFactory extends AbstractFactory {
    double[] parm1;
    String[] parm2;
    boolean[] parm3;
    public LandVehicleFactory(double[] parm1, String[] parm2, boolean[] parm3){
        this.parm1=parm1;
        this.parm2=parm2;
        this.parm3=parm3;
    }
    @Override
    public Vehicle getVehicle(TypeVehicle vehicle){
        return null;
    }

    @Override
    public WaterVehicle getWaterVehicle(TypeVehicle vehicle) {
        return null;
    }

    @Override
    public AirVehicle getAirVehicle(TypeVehicle vehicle) {
        return null;
    }

    @Override
    public LandVehicle getLandVehicle(TypeVehicle vehicle) {
        if(vehicle == null){
            return null;
        }
        switch (vehicle){
            case Bicycle:
                return new Bicycle(parm2[0], parm1[4], parm2[3]);
            case ElectricBicycle:
                return new ElectricBicycle(parm2[0], parm1[0], parm3[1], parm3[2], parm1[4], parm2[3]);
            case Jeep:
                return new Jeep(parm2[0], parm1[0], parm1[1], parm1[2], parm1[4], parm2[3]);

        }
        return null;
    }
}
