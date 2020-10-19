package factory;

public class FactoryProducer {
    static double[] parm1;
    static String[] parm2;
    static boolean[] parm3;
    public FactoryProducer(double[] parm1,String[] parm2,boolean[] parm3){
        this.parm1=parm1;
        this.parm2=parm2;
        this.parm3=parm3;
    }
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("VEHICLE")){
            return new VehicleFactory(parm1,parm2,parm3);
        }
        else if(choice.equalsIgnoreCase("WATERVEHICLE")){
            return new WaterVehicleFactory(parm1,parm2,parm3);
        }
        else if(choice.equalsIgnoreCase("AIRVEHICLE")){
            return new AirVehicleFactory(parm1,parm2,parm3);
        }
        else if(choice.equalsIgnoreCase("LANDVEHICLE")){
            return new LandVehicleFactory(parm1,parm2,parm3);
        }
        return null;
    }
}