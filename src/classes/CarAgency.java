package classes;

import abstract_classes.Vehicle;
import jdk.nashorn.internal.ir.CatchNode;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

public class CarAgency {
    private static CarAgency instance = new CarAgency();
    private static Hashtable<String, Vehicle> CarAgency ;

    private CarAgency(){
       CarAgency = new Hashtable<String,Vehicle>();
    }
    public static int size(){
        return CarAgency.size();
    }
    public static Iterator<Vehicle> iterator(){
        return CarAgency.values().iterator();
    }
    public static CarAgency getInstance(){
        return instance;
    }
    public static void setCarAgency(Hashtable<String, Vehicle> carAgency){ CarAgency=carAgency; }
    public static Hashtable<String, Vehicle> getCarAgency(){
        return CarAgency;
    }
    public static Vehicle get(Double val){
        return CarAgency.get(val.toString());
    }
    public static void put(Double id,Vehicle value){
        CarAgency.put(id.toString(),value);
    }
    public static void remove(Double id){
        CarAgency.remove(id.toString());
    }
}
