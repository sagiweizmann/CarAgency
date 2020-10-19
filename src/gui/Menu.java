package gui;

import abstract_classes.AmphibiousVehicle;
import abstract_classes.Vehicle;
import abstract_classes.WaterVehicle;
import classes.HybridAircraft;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import memento.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import classes.CarAgency;
public class Menu extends JFrame {
    static BgPanel jpanelscroll= new BgPanel("./res/images/panel.png");
    static JScrollPane jScrollPane=new JScrollPane(jpanelscroll);
    private static Menu instance=new Menu();;
    LinkedList<WaterVehicle > waterVehicles;
    LinkedList<AmphibiousVehicle > amphibiousVehicle;
    LinkedList<HybridAircraft> HybridAircraft;
    Originator originator = new Originator();
    Caretaker caretaker = new Caretaker();
    private Menu(){
        this.setTitle("Car Agency");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                run2(waterVehicles,amphibiousVehicle,HybridAircraft);
            }
        });
    }
    public void setMenu(LinkedList<WaterVehicle > waterVehicles, LinkedList<AmphibiousVehicle > amphibiousVehicle,LinkedList<HybridAircraft> HybridAircraft){
        this.HybridAircraft=HybridAircraft;
        this.waterVehicles=waterVehicles;
        this.amphibiousVehicle=amphibiousVehicle;
    }
    public static Menu getInstance(){
        return instance;
    }
    public void show(){
        this.setLocationRelativeTo(null);
        paintAgency();
        super.show();
    }
    public static void paintAgency(){
        try {
            JRadioButton[] selected = new JRadioButton[CarAgency.size()];
            JPanel bgPanel = new BgPanel("./res/images/menu.png");
            PlainJButton UPbutton[] = new PlainJButton[4];
            PlainJButton JBack = new PlainJButton("");
            PlainJButton report = new PlainJButton("");
            jpanelscroll.removeAll();
            int i = 0;
            Iterator<Vehicle> vehicles = CarAgency.iterator();
            while(vehicles.hasNext()) {
                Vehicle temp = vehicles.next();
                selected[i] = new JRadioButton(new ImageIcon(temp.getImg()));
                selected[i].setBounds(new Rectangle(20 + i * 100, 20, 150, 150));
                selected[i].setToolTipText(temp.toString());
                selected[i].setBorderPainted(true);
                selected[i].setOpaque(false);
                selected[i].addActionListener(new ActionWithSend(temp) {
                    public void actionPerformed(ActionEvent e) {
                        if(!v.getLock()) {
                            Cardetails cardetails = new Cardetails(v);
                            v.setLock(true);
                        }
                    }
                });
                jpanelscroll.add(selected[i]);
                i++;
            }
            jpanelscroll.updateUI();
            MainGui.notifyAllObservers();
        }
        catch (Exception e1){

        }
    }
    public void run2(LinkedList<WaterVehicle> waterVehicles, LinkedList<AmphibiousVehicle> amphibiousVehicle,LinkedList<HybridAircraft> HybridAircraft) {
        JPanel bgPanel = new BgPanel("./res/images/menu.png");
        PlainJButton UPbutton[] = new PlainJButton[2];
        PlainJButton save = new PlainJButton("");
        PlainJButton load= new PlainJButton("");
        int i;
        for(i=0;i<2;i++) {
            UPbutton[i]=new PlainJButton("");
            UPbutton[i].setBounds(new Rectangle(225+i*105,350,80,80));
            bgPanel.add(UPbutton[i]);
        }
        paintAgency();
        UPbutton[0].addActionListener(new ActionWithSend(i)
        {
            public void actionPerformed(ActionEvent e) {
              Reset();
            }
        } );
        UPbutton[1].addActionListener(new ActionWithSend(i)
        {
            public void actionPerformed(ActionEvent e) {
                ChangeFlag changeFlag = new ChangeFlag(waterVehicles, amphibiousVehicle,HybridAircraft);
            }
        } );
        jScrollPane.setBounds(new Rectangle(20,120,600,220));
        bgPanel.add(jScrollPane);
        bgPanel.add(MainGui.distanceObserver.getDistance());
        save.setBounds(new Rectangle(26,14,80,80));
        load.setBounds(new Rectangle(540,14,80,80));
        save.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                MementoSave();
            }
        } );
        load.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                try {
                    MementoLoad();
                    paintAgency();
                }
                catch(Exception e1) {
                    JOptionPane.showMessageDialog(null,"No Load Exist!");
                }
            }
        } );
        this.setResizable(false);
        bgPanel.add(save);
        bgPanel.add(load);
        bgPanel.setLayout(null);
        this.setIconImage(new ImageIcon("./res/images/favicon.png").getImage());
        this.setMinimumSize(new Dimension(640,480));
        this.add(bgPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
    }
    private void MementoSave(){
        originator.setState(CarAgency.getCarAgency());
        Memento memento = originator.createMemento();
        caretaker.addMemento(memento);
    }
    private void MementoLoad(){
        if(Caretaker.counter!=0) {
            Caretaker.counter--;
        }
        Memento memento = caretaker.getMemento(Caretaker.counter);
        CarAgency.setCarAgency(memento.getState());
        originator.setMemento(memento);
    }
    private void Reset(){
        int reply = JOptionPane.showConfirmDialog(null, "Are you sure you wanna RESET? ","RESET", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        synchronized (CarAgency.getInstance()) {
                            Random rand = new Random();
                            int randomNum;
                            randomNum = 3000 + rand.nextInt((8000 - 3000) + 1);
                            Loading loading = new Loading("Updating Database...");
                            Iterator<Vehicle> vehicles = CarAgency.iterator();
                            while (vehicles.hasNext()) {
                                Vehicle temp = vehicles.next();
                                temp.SetDistance(0.0);
                            }
                            Thread.sleep(randomNum);
                            loading.setText("Update Done!");
                            Thread.sleep(700);
                            loading.terminate();
                        }
                    }
                    catch(Exception e2) {
                        JOptionPane.showMessageDialog(null, e2.toString());
                    }
                }
            });
            t.start();
            Menu.paintAgency();
        }
        else {
            JOptionPane.showMessageDialog(null, "Reset Canceled !");
        }
    }

}
