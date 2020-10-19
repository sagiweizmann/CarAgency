package gui;

import abstract_classes.AmphibiousVehicle;
import abstract_classes.Vehicle;
import abstract_classes.WaterVehicle;
import classes.HybridAircraft;
import enums.TypeVehicle;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import classes.CarAgency;
import java.util.LinkedList;

public class Insertion extends JFrame{
    public Insertion(LinkedList<WaterVehicle > waterVehicles, LinkedList<AmphibiousVehicle > amphibiousVehicle,LinkedList<HybridAircraft> HybridAircraft){
        this.setTitle("Car Agency");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                run2(waterVehicles,amphibiousVehicle,HybridAircraft);
            }
        });
    }
    public void run2( LinkedList<WaterVehicle> waterVehicles, LinkedList<AmphibiousVehicle> amphibiousVehicle,LinkedList<HybridAircraft> HybridAircraft){
        JPanel bgPanel = new BgPanel("./res/images/gui.png");
        final int SIZE =3;
        PlainJButton menu = new PlainJButton("");
        PlainJButton UPbutton[] = new PlainJButton[SIZE];
        PlainJButton MIDbutton[] = new PlainJButton[SIZE];
        PlainJButton BOTTOMbutton[] = new PlainJButton[SIZE];
        int i;
        for(i=0;i<SIZE;i++) {
            UPbutton[i]=new PlainJButton("");
            UPbutton[i].setBounds(new Rectangle(110+i*145,90,120,110));
            bgPanel.add(UPbutton[i]);
            BOTTOMbutton[i]=new PlainJButton("");
            BOTTOMbutton[i].setBounds(new Rectangle(110+i*145,320,120,110));
            bgPanel.add(BOTTOMbutton[i]);
            MIDbutton[i]=new PlainJButton("");
            MIDbutton[i].setBounds(new Rectangle(110+i*145,205,120,110));
            bgPanel.add(MIDbutton[i]);
            UPbutton[i].addActionListener(new ActionWithSend(i)
            {
                public void actionPerformed(ActionEvent e) {
                    TypeVehicle Selected = TypeVehicle.valueOf(i);
                    AddVehicle a = new AddVehicle(Selected,waterVehicles,amphibiousVehicle,HybridAircraft);

                }
            } );
            MIDbutton[i].addActionListener((new ActionWithSend(i+SIZE)
            {
                public void actionPerformed(ActionEvent e) {
                    TypeVehicle Selected = TypeVehicle.valueOf(i);
                    AddVehicle a = new AddVehicle(Selected,waterVehicles,amphibiousVehicle,HybridAircraft);

                }
            } ));
            BOTTOMbutton[i].addActionListener((new ActionWithSend(i+SIZE*2)
            {
                public void actionPerformed(ActionEvent e) {
                    TypeVehicle Selected = TypeVehicle.valueOf(i);
                    AddVehicle a = new AddVehicle(Selected,waterVehicles,amphibiousVehicle,HybridAircraft);

                }
            } ));


        }
        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu menu = Menu.getInstance();
                menu.setMenu(waterVehicles,amphibiousVehicle,HybridAircraft);
                menu.show();

            }
        } );
        this.setIconImage(new ImageIcon("./res/images/favicon.png").getImage());
        menu.setBounds(new Rectangle(560,30,40,32));
        bgPanel.add(menu);
        this.setResizable(false);
        bgPanel.setLayout(null);
        this.setMinimumSize(new Dimension(640,480));
        this.add(bgPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
