package gui;

import abstract_classes.AmphibiousVehicle;
import abstract_classes.Vehicle;
import abstract_classes.WaterVehicle;
import classes.HybridAircraft;
import com.sun.javaws.util.JfxHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class ChangeFlag extends JFrame {
    public ChangeFlag(LinkedList<WaterVehicle> waterVehicles, LinkedList<AmphibiousVehicle> amphibiousVehicle, LinkedList<HybridAircraft> hybridAircraft){
        this.setTitle("Car Agency");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FlagChooser(waterVehicles,amphibiousVehicle,hybridAircraft);
            }
        });
    }
    public void FlagChooser( LinkedList<WaterVehicle> waterVehicles, LinkedList<AmphibiousVehicle> amphibiousVehicle, LinkedList<HybridAircraft> hybridAircraft) {
        JPanel bgPanel = new BgPanel("./res/images/main.png");
        String st[] =  {"Greece","Germany","Israel","Italy","Pirates","Somalia","USA"};
        PlainJButton BuyButton = new PlainJButton(new ImageIcon("./res/images/btns/buy.png"));
        JRadioButton[] selected = new JRadioButton[st.length];
        ActionWithSend a =new ActionWithSend("");
        for(int i=0;i<st.length;i++) {
            selected[i]=new JRadioButton(new ImageIcon("./res/images/flags/"+st[i]+".png"));
            if(i%2==0) {
                selected[i].setBounds(new Rectangle(20+i*55,50,100,60));
            }
            else
            {
                selected[i].setBounds(new Rectangle(25+i*55,120,100,60));
            }
            selected[i].setToolTipText(st[i]);
            selected[i].setBorderPainted(true);
            bgPanel.add(selected[i]);
            a=new ActionWithSend(st[i],this) {
                public void actionPerformed(ActionEvent e) {
                    Iterator<WaterVehicle> watervehicles1 = waterVehicles.iterator();
                    Iterator<AmphibiousVehicle> amphibiousVehicles1 = amphibiousVehicle.iterator();
                    Iterator<HybridAircraft> hybridAircraftIterator = hybridAircraft.iterator();
                    synchronized (waterVehicles) {
                        while (watervehicles1.hasNext()) {
                            WaterVehicle temp = watervehicles1.next();
                            temp.SetFlag(img);
                        }
                    }
                    synchronized (amphibiousVehicle) {
                        while (amphibiousVehicles1.hasNext()) {
                            AmphibiousVehicle temp = amphibiousVehicles1.next();
                            temp.SetFlag(img);
                        }
                    }
                    synchronized (hybridAircraft) {
                        while (hybridAircraftIterator.hasNext()) {
                            HybridAircraft temp = hybridAircraftIterator.next();
                            temp.SetFlag(img);
                        }
                    }
                    UpdateDatabase();
                    Menu.paintAgency();
                    mainFrame.dispose();
                }
            } ;
            selected[i].addActionListener(a);
        }
        this.setIconImage(new ImageIcon("./res/images/favicon.png").getImage());
        this.setResizable(false);
        bgPanel.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setMinimumSize(new Dimension(480,240));
        this.add(bgPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    private static void UpdateDatabase(){
        Runnable runnable = new Runnable(){
            @Override
            public void run () {
                Random rand = new Random();
                int randomNum;
                randomNum = 3000 + rand.nextInt((8000 - 3000) + 1);
                Loading loading = new Loading("Updating Database...");
                try {
                    Thread.sleep(randomNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                loading.setText("Update Done!");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                loading.terminate();
            }
        };
        Thread t = new Thread(runnable);
        t.start();
    }
}
