package factory;

import abstract_classes.*;
import classes.*;
import factory.AbstractFactory;
import enums.TypeVehicle;

public class VehicleFactory extends AbstractFactory {
    double[] parm1;
    String[] parm2;
    boolean[] parm3;
    public VehicleFactory(double[] parm1,String[] parm2,boolean[] parm3){
        this.parm1=parm1;
        this.parm2=parm2;
        this.parm3=parm3;
    }
    @Override
    public Vehicle getVehicle(TypeVehicle vehicle){
        if(vehicle == null){
            return null;
        }
        switch (vehicle){
            case Frigate:
                    return new Frigate(parm2[0], (int) parm1[3], parm1[0], parm3[0], parm2[1], parm1[4], parm2[3]);
            case SpyGlider:
                    return new SpyGlider(parm2[2], parm1[4], parm2[3]);
            case Amphibious:
                    return new AmphibiousVehicle(parm2[0], (int) parm1[3], parm1[0], parm3[0], parm2[1], (int) parm1[5], parm3[1], parm3[2], parm1[4], parm2[3]);

            case Bicycle:
                    return new Bicycle(parm2[0], parm1[4], parm2[3]);

            case GameGlider:
                    return new GameGlider(parm2[0], parm1[4], parm2[3]);

            case Crusie:
                    return new Cruise(parm2[0], (int) parm1[3], parm1[0], parm3[0], parm2[1], parm1[4], parm2[3]);

            case ElectricBicycle:
                    return new ElectricBicycle(parm2[0], parm1[0], parm3[1], parm3[2], parm1[4], parm2[3]);

            case HybridAircraft:
                    return new HybridAircraft(parm2[0], (int) parm1[3], parm1[0], parm3[0], parm2[1], (int) parm1[5], parm3[1], parm3[2], parm1[4], parm2[3]);

            case Jeep:
                    return new Jeep(parm2[0], parm1[0], parm1[1], parm1[2], parm1[4], parm2[3]);

        }
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
        return null;
    }
}
