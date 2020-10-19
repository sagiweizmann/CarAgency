/*Sagi Weizmann 318194222
Zohar Admoni 316127778
 */
package classes;
import java.util.Scanner;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

import abstract_classes.AmphibiousVehicle;
import abstract_classes.Vehicle;
import abstract_classes.WaterVehicle;
// TODO: Auto-generated Javadoc

/**
 * The Class Main.
 */
public class Main {
	
	/** The sc. */
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Hashtable<String,Vehicle> CarAgency =new Hashtable<String,Vehicle>();
		LinkedList<WaterVehicle> WaterVehicles= new LinkedList<WaterVehicle>();
		LinkedList<AmphibiousVehicle> AmphibiousVehicle = new LinkedList<AmphibiousVehicle>();
		
		Insertion(CarAgency,WaterVehicles,AmphibiousVehicle);
		Menu(CarAgency,WaterVehicles,AmphibiousVehicle);
		
		print("GOOD BYE");
	}
	
	/**
	 * Insertion.
	 *
	 * @param CarAgency the car agency
	 * @param waterVehicles the water vehicles
	 * @param amphibiousVehicle 
	 */
	public static void Insertion(Hashtable<String,Vehicle> CarAgency, LinkedList<WaterVehicle> waterVehicles, LinkedList<AmphibiousVehicle> amphibiousVehicle) {
		String newcar;
		boolean done=false;
		int type;
		System.out.println("Welcome to S&A Car Agency!");
		while(done!=true) {
			System.out.println("Do you wanna add a new car ? y/n");
			newcar=sc.next();
			if(newcar.equals("y")) 
			{
				print("Choose:1.Jeep,2.Frigate,3.SpyGlider,4.GameGlider");
				type=sc.nextInt();
				if(type>=1&&type<=4)
				{
					CreateVehicle(type,CarAgency,waterVehicles);
					continue;
				}
				else
					print("Wrong choise buddy");
					continue;
			}
			else if(newcar.equals("n"))
			{
				print("Done insertion!");
				done=true;
			}
			else
			{
				print("Wrong choise buddy");
				continue;
			}
		}
	}
	
	/**
	 * Menu.
	 *
	 * @param CarAgency the car agency
	 * @param waterVehicles the water vehicles
	 * @param amphibiousVehicle 
	 */
	public static void Menu(Hashtable<String,Vehicle> CarAgency, LinkedList<WaterVehicle> waterVehicles, LinkedList<AmphibiousVehicle> amphibiousVehicle) {
		boolean done = false,found = false;
		int menu,type;
		Vehicle buy,temp=null;
		Iterator<Vehicle> vehicles= CarAgency.values().iterator();
		String str; 
		while(done!=true){
			print("Welcome To the Car Agency Store!");
			print("Here your options:");
			print("1.Buy a new car");
			print("2.Test a car");
			print("3.Reset all vehicles distance");
			print("4.Change flag for a cretain water vehicle");
			print("5.Exit");
			print("Your option:");
			found=false;
			menu = sc.nextInt();
			switch(menu) {
			case 1:
				print("~~~List of vehicles!~~~");
				vehicles= CarAgency.values().iterator();
				while(vehicles.hasNext()) {
					str = vehicles.next().toString();
				print(str);
				}
				type=0;
				while(!(type>=1&&type<=4)){
				print("Choose:1.Jeep,2.Frigate,3.SpyGlider,4.GameGlider");
				type=sc.nextInt();
				if(type>=1&&type<=4){
					buy=CreateTemp(type);
					if(CarAgency.get(buy.GetModelName())!=null&&CarAgency.get(buy.GetModelName()).equals(buy)){
							CarAgency.remove(buy.GetModelName());
							print("Car bought!");
							print("Car Removed Successfully!");
							found=true;
							break;
					}
					if(found==false) {
						print("No such car!");
					}
				}
				else{
					print("Wrong choise buddy");
					continue;
				}
				}
				break;
			case 2:
				type=0;
				double distance;
				while(!(type>=1&&type<=4)){
				print("Choose:1.Jeep,2.Frigate,3.SpyGlider,4.GameGlider");
				type=sc.nextInt();
				if(type>=1&&type<=4){
					buy=CreateTemp(type);
					print("Insert Distnace");
					distance=sc.nextDouble();
					vehicles = CarAgency.values().iterator();
					if(CarAgency.get(buy.GetModelName())!=null&&CarAgency.get(buy.GetModelName()).equals(buy)){
							CarAgency.get(buy.GetModelName()).SetDistance(distance);
							print("Distance Updated Sucessfully");
							found=true;
							break;
						}
					if(found==false) {
						print("No such car!");
					}
				}
				else{
					print("Wrong choise buddy");
					continue;
				}
				}
				break;
			case 3:
				vehicles = CarAgency.values().iterator();
				while(vehicles.hasNext()) {
					vehicles.next().SetDistance(0.0);
				}
				print("Reset done!");
				break;
			case 4:
				temp=CreateTemp(2);
				for(int i=0;i<waterVehicles.size();i++) {
					if(waterVehicles.get(i).equals(temp)){
						print("Insert a flag");
						waterVehicles.get(i).SetFlag(sc.next());
						print("Flag Changed Successfully");
						found=true;
						break;
					}
				}
				
				break;
			case 5:
				done=true;
				break;
			}
			
		}
	}
	
	/**
	 * Creates the vehicle.
	 *
	 * @param type the type
	 * @param CarAgency the car agency
	 * @param waterVehicles the water vehicles
	 */
	public static void CreateVehicle(int type,Hashtable<String,Vehicle> CarAgency, LinkedList<WaterVehicle> waterVehicles) {
		/*
		*parm1 - double array*
		parm1[0]=max_speed
		parm1[1]=FuelAvg
		parm1[2]=avglifespan
		parm1[3]=max_passangers
		size - 4
		*parm2 - string array*
		parm2[0]=model_name
		parm2[1]=flag
		parm2[2]=powersource
		size - 3 
		*parm3- boolean array*
		parm3[0]=wind_direction 
		size - 1
		 */
		double[] parm1 = new double[5];
		String[] parm2=new String[4];
		boolean[] parm3=new boolean[1];; 
		Vehicle value=null;
		WaterVehicle value2 =null;
		switch (type) {
			case 1:
				print("Jeep Insertion");
				print("Model name:");
				parm2[0]=sc.next();
				print("Max Speed:");
				parm1[0]=sc.nextDouble();
				print("Fuel Average:");	
				parm1[1]=sc.nextDouble();
				print("Avergae Life span:");
				parm1[2]=sc.nextDouble();
				value = new Jeep(parm2[0],parm1[0],parm1[1],parm1[2],parm1[4],parm2[3]);
			    CarAgency.put(parm2[0], value);
				break;
			case 2:
				print("Frigate Insertion");
				print("Model name:");
				parm2[0]=sc.next();
				print("Max Passangers:");
				parm1[3]=sc.nextDouble();
				print("Max Speed:");		
				parm1[0]=sc.nextDouble();
				print("Wind direction? true/false");
				parm3[0]=sc.nextBoolean();
				print("Insert Flag");
				parm2[1]=sc.next();
			    value2 = new Frigate(parm2[0],(int)parm1[3],parm1[0],parm3[0],parm2[1],parm1[4],parm2[3]);
			    CarAgency.put(parm2[0], value2);
			    waterVehicles.add(value2);
				break;
			case 3:
				print("Spy Glider Insertion");
				print("Power Source:");
				parm2[2]=sc.next();
				value = new SpyGlider(parm2[2],parm1[4],parm2[3]);
			    CarAgency.put(value.GetModelName(), value);
				break;
			case 4:
				print("Game Glider Insertion");
				print("Model name:");
				parm2[0]=sc.next();
				value= new GameGlider(parm2[0],parm1[4],parm2[3]);
			    CarAgency.put(parm2[0], value);
				break;
		}
		
	}
	
	/**
	 * Creates the temp.
	 *
	 * @param type the type
	 * @return the vehicle
	 */
	public static Vehicle CreateTemp(int type) {
		/*
		*parm1 - double array*
		parm1[0]=max_speed
		parm1[1]=FuelAvg
		parm1[2]=avglifespan
		parm1[3]=max_passangers
		size - 4
		*parm2 - string array*
		parm2[0]=model_name
		parm2[1]=flag
		parm2[2]=powersource
		size - 3 
		*parm3- boolean array*
		parm3[0]=wind_direction 
		size - 1
		 */
		double[] parm1 = new double[5];
		String[] parm2=new String[4];
		boolean[] parm3=new boolean[1];; 
		Vehicle value=null;
		switch (type) {
			case 1:
				print("Jeep Insertion");
				print("Model name:");
				parm2[0]=sc.next();
				print("Max Speed:");
				parm1[0]=sc.nextDouble();
				print("Fuel Average:");	
				parm1[1]=sc.nextDouble();
				print("Avergae Life span:");
				parm1[2]=sc.nextDouble();
				value = new Jeep(parm2[0],parm1[0],parm1[1],parm1[2],parm1[4],parm2[3]);
				break;
			case 2:
				print("Frigate Insertion");
				print("Model name:");
				parm2[0]=sc.next();
				print("Max Passangers:");
				parm1[3]=sc.nextDouble();
				print("Max Speed:");		
				parm1[0]=sc.nextDouble();
				print("Wind direction? true/false");
				parm3[0]=sc.nextBoolean();
				print("Insert Flag");
				parm2[1]=sc.next();
				value = new Frigate(parm2[0],(int)parm1[3],parm1[0],parm3[0],parm2[1],parm1[4],parm2[3]);
				break;
			case 3:
				print("Spy Glider Insertion");
				print("Power Source:");
				parm2[2]=sc.next();
				value = new SpyGlider(parm2[2],parm1[4],parm2[3]);
				break;
			case 4:
				print("Game Glider Insertion");
				print("Model name:");
				parm2[0]=sc.next();
				value= new GameGlider(parm2[0],parm1[4],parm2[3]);
				break;
		}
		return value;
	}
	
	/**
	 * Prints the.
	 *
	 * @param s the s
	 */
	public static void print(String s) 	{System.out.println(s);};
}
