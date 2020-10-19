package factory;

import abstract_classes.*;
import classes.*;
import enums.TypeVehicle;

public class AirVehicleFactory extends AbstractFactory {
    double[] parm1;
    String[] parm2;
    boolean[] parm3;
    public AirVehicleFactory(double[] parm1, String[] parm2, boolean[] parm3){
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
        if(vehicle == null){
            return null;
        }
        switch (vehicle){
            case SpyGlider:
                return new SpyGlider(parm2[2], parm1[4], parm2[3]);
            case GameGlider:
                return new GameGlider(parm2[0], parm1[4], parm2[3]);
        }
        return null;
    }

    @Override
    public LandVehicle getLandVehicle(TypeVehicle vehicle) {
        return null;
    }
}
