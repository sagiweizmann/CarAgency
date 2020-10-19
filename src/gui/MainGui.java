/*Sagi Weizmann 318194222
Zohar Admoni 316127778
 */
package gui;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import abstract_classes.AmphibiousVehicle;
import abstract_classes.Vehicle;
import abstract_classes.WaterVehicle;
import classes.HybridAircraft;
import observers.DistanceObserver;
import observers.Observer;

import javax.swing.*;


public class MainGui {
	final static int width=640;
	final static int height=480;
	public static DistanceObserver distanceObserver = new DistanceObserver(Vehicle.distanceall);
	public static void main(String[] args) {
		Hashtable<Double, Vehicle> CarAgency = new Hashtable<>();
		LinkedList<WaterVehicle> WaterVehicles = new LinkedList<>();
		LinkedList<AmphibiousVehicle> AmphibiousVehicle = new LinkedList<>();
		LinkedList<HybridAircraft> HybridAircraft = new LinkedList<>();
		Insertion in = new Insertion(WaterVehicles, AmphibiousVehicle,HybridAircraft);
	}
	public static void notifyAllObservers(){
		distanceObserver.update();
	}
}
