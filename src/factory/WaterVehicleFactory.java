package factory;

import abstract_classes.*;
import classes.*;
import enums.TypeVehicle;

public class WaterVehicleFactory extends AbstractFactory {
    double[] parm1;
    String[] parm2;
    boolean[] parm3;
    public WaterVehicleFactory(double[] parm1, String[] parm2, boolean[] parm3){
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
        if(vehicle == null){
            return null;
        }
        switch (vehicle){
            case Frigate:
                return new Frigate(parm2[0], (int) parm1[3], parm1[0], parm3[0], parm2[1], parm1[4], parm2[3]);
            case Crusie:
                return new Cruise(parm2[0], (int) parm1[3], parm1[0], parm3[0], parm2[1], parm1[4], parm2[3]);

        }
        return null;
    }

    @Override
    public AirVehicle getAirVehicle(TypeVehicle vehicle) {
        return null;
    }

    @Override
    public LandVehicle getLandVehicle(TypeVehicle vehicle) {
        return null;
    }
}
