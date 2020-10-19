package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

import abstract_classes.*;
import decorator.StatusNColorVDecorator;
import factory.AbstractFactory;
import classes.*;
import enums.TypeVehicle;
import factory.FactoryProducer;
import factory.VehicleFactory;
import interfaces.IVehicle;

public class AddVehicle extends JFrame {

    public AddVehicle(TypeVehicle type, LinkedList<WaterVehicle > waterVehicles, LinkedList<AmphibiousVehicle > amphibiousVehicle,LinkedList<HybridAircraft> HybridAircraft){
        this.setTitle("Car Agency");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                run2(type,waterVehicles,amphibiousVehicle,HybridAircraft);
            }
        });
    }
    public void updateUI(){
        this.repaint();
        this.revalidate();
    }
    public void run2(TypeVehicle type, LinkedList<WaterVehicle > waterVehicles, LinkedList<AmphibiousVehicle > amphibiousVehicle,LinkedList<HybridAircraft> HybridAircraft){
		/*
		*parm1 - double array*
		parm1[0]=max_speed
		parm1[1]=FuelAvg
		parm1[2]=avglifespan
		parm1[3]=max_passangers
		parm1[4]=id;
		size - 4
		*parm2 - string array*
		parm2[0]=model_name
		parm2[1]=flag
		parm2[2]=powersource
		parm2[3]=img
		size - 3
		*parm3- boolean array*
		parm3[0]=wind_direction
		parm3[1]=is_paved
		parm3[2]=is_dirt
		size - 1
		 */
            double[] parm1 = new double[6];
            String[] parm2=new String[4];
            boolean[] parm3=new boolean[3];;
            JTextArea jText[]=new JTextArea[7];
            /*
             * Double /
             */
            JTextArea Field_max_speed= new JTextArea();
            JTextArea Field_FuelAvg= new JTextArea();
            JTextArea Field_avglifespan= new JTextArea();
            JTextArea Field_max_passangers= new JTextArea();
            JTextArea Field_id= new JTextArea();
            /*
             * String /
             */
            JTextArea Field_model_name= new JTextArea();
            JTextArea Field_flag= new JTextArea();
            JTextArea Field_powersource= new JTextArea();
            /*
             *Boolean /
             */
            JCheckBox Field_wind_dir = new JCheckBox();
            JCheckBox Field_is_paved = new JCheckBox();
            JCheckBox Field_is_dirt = new JCheckBox();

            /*/
             * Another
             */
            JPanel bgPanel = new BgPanel("./res/images/main.png");
            PlainJButton JBack= new PlainJButton("");
            PlainJButton jbtadd=new PlainJButton(new ImageIcon("./res/images/btns/add.png"));
            PlainJButton jbtaddimg=new PlainJButton(new ImageIcon("./res/images/btns/addimage.png"));
            JLabel jLabel[] = new JLabel[8];
            JLabel imglabel = new JLabel("Current Image: Default Image");
            String img = new String();
            ActionWithSend newimg=null;
            FactoryProducer factoryProducer = new FactoryProducer(parm1,parm2,parm3);
            AbstractFactory vehicleFactory = factoryProducer.getFactory("VEHICLE");
            AbstractFactory waterVehicleFactory = factoryProducer.getFactory("WATERVEHICLE");
            AbstractFactory airVehicleFactory = factoryProducer.getFactory("AIRVEHICLE");
            AbstractFactory landVehicleFactory = factoryProducer.getFactory("LANDVEHICLE");
        switch (type) {
            case Jeep:
                jText[0]=Field_id;
                jText[1]= Field_model_name;
                jText[2]= Field_max_speed;
                jText[3]= Field_FuelAvg;
                jText[4]= Field_avglifespan;
                for(int i=0;i<5;i++) {
                    jLabel[i] = new JLabel();
                    jLabel[i].setBounds(new Rectangle(29,100+i*40,250,20));
                    jText[i].setBounds(new Rectangle(250,100+i*40,250,20));
                    jLabel[i].setFont(new Font("Comic Sans",Font.BOLD,20));
                    jLabel[i].setForeground(Color.white);
                    bgPanel.add(jLabel[i]);
                    bgPanel.add(jText[i]);
                }
                jLabel[0].setText("Jeep ID");
                jLabel[1].setText("Model name:");
                jLabel[2].setText("Max Speed:");
                jLabel[3].setText("Fuel Average:");
                jLabel[4].setText("Avergae Life span:");
                jbtadd.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if(CarAgency.get(Double.parseDouble(jText[0].getText()))==null) {
                                IVehicle value = null;
                                parm2[0] = jText[1].getText();
                                parm1[0] = Double.parseDouble(jText[2].getText());
                                parm1[1] = Double.parseDouble(jText[3].getText());
                                parm1[2] = Double.parseDouble(jText[4].getText());
                                parm1[4] = Double.parseDouble(jText[0].getText());
                                parm2[3] = "./res/images/defaultimg/jeep.png";
                                value = new StatusNColorVDecorator(landVehicleFactory.getLandVehicle(TypeVehicle.Jeep));
                                CarAgency.put(parm1[4], ((StatusNColorVDecorator) value).getVehicle());
                                LoadingSuccess();
                                Menu.paintAgency();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "ID Already Exist");
                            }
                        }
                        catch(Exception e1) {
                            JOptionPane.showMessageDialog(null, e1.toString());
                        }
                    }
                } );

                break;
            case Frigate:
                jText[0]=Field_id;
                jText[1]= Field_model_name;
                jText[2]= Field_max_speed;
                jText[3]= Field_max_passangers;
                jText[4]= Field_flag;
                jLabel[5]=new JLabel();
                for(int i=0;i<5;i++) {
                    jLabel[i] = new JLabel();
                    jLabel[i].setBounds(new Rectangle(29,100+i*40,250,20));
                    jText[i].setBounds(new Rectangle(250,100+i*40,250,20));
                    jLabel[5].setBounds(new Rectangle(29,300,400,20));
                    jLabel[5].setFont(new Font("Comic Sans",Font.BOLD,20));
                    jLabel[5].setForeground(Color.white);
                    Field_wind_dir.setBounds(new Rectangle(250,300,20,20));
                    jLabel[i].setFont(new Font("Comic Sans",Font.BOLD,20));
                    jLabel[i].setForeground(Color.white);
                    bgPanel.add(jLabel[i]);
                    bgPanel.add(jText[i]);

                }
                jLabel[0].setText("Frigate ID:");
                jLabel[1].setText("Model name:");
                jLabel[2].setText("Max Passangers:");
                jLabel[3].setText("Max Speed:");
                jLabel[4].setText("Insert Flag:");
                jLabel[5].setText("Wind Direction:");
                jbtadd.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if(CarAgency.get(Double.parseDouble(jText[0].getText()))==null) {
                                WaterVehicle value = null;
                                parm1[4] = Double.parseDouble(jText[0].getText());
                                parm2[0] = jText[1].getText();
                                parm1[3] = Double.parseDouble(jText[2].getText());
                                parm1[0] = Double.parseDouble(jText[3].getText());
                                parm2[1] = jText[4].getText();
                                parm2[3] = "./res/images/defaultimg/frigate.png";
                                parm3[0] = Field_wind_dir.isSelected();
                                value = waterVehicleFactory.getWaterVehicle(TypeVehicle.Frigate);
                                CarAgency.put(parm1[4], value);
                                waterVehicles.add((WaterVehicle)value);
                                LoadingSuccess();
                                Menu.paintAgency();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "ID Already Exist");
                            }
                        }
                        catch(Exception e1) {
                            JOptionPane.showMessageDialog(null, e1.toString());
                        }
                    }
                } );
                bgPanel.add(jLabel[5]);
                bgPanel.add(Field_wind_dir);
                break;
            case SpyGlider:
                jText[1]=Field_powersource;
                jText[0]=Field_id;
                jLabel=new JLabel[3];
                for(int i=0;i<jLabel.length;i++) {
                    jLabel[i] = new JLabel();
                    jLabel[i].setBounds(new Rectangle(29,100+i*40,250,20));
                    Field_wind_dir.setBounds(new Rectangle(250,300,20,20));
                    jLabel[i].setFont(new Font("Comic Sans",Font.BOLD,20));
                    jLabel[i].setForeground(Color.white);
                    bgPanel.add(jLabel[i]);
                }
                for(int i=0 ; i<2;i++) {
                    jText[i] = new JTextArea();
                    jText[i].setBounds(new Rectangle(250,100+i*40,250,20));
                    bgPanel.add(jText[i]);

                }
                jLabel[0].setText("SpyGlider ID");
                jLabel[1].setText("Power Source:");
                jbtadd.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if(CarAgency.get(Double.parseDouble(jText[0].getText()))==null) {
                                AirVehicle value = null;
                                parm1[4] = Double.parseDouble(jText[0].getText());
                                parm2[2] = jText[1].getText();
                                parm2[3] = "./res/images/defaultimg/spyglider.png";
                                value = airVehicleFactory.getAirVehicle(TypeVehicle.SpyGlider);
                                CarAgency.put(parm1[4], value);
                                LoadingSuccess();
                                Menu.paintAgency();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "ID Already Exist");
                            }
                        }
                        catch(Exception e1) {
                            JOptionPane.showMessageDialog(null, e1.toString());
                        }
                    }
                } );
                break;
            case Amphibious:
                jLabel= new JLabel[8];
                for(int i=0;i<jLabel.length;i++) {
                    jLabel[i] = new JLabel();
                    jLabel[i].setBounds(new Rectangle(29,100+i*40,250,20));
                    Field_wind_dir.setBounds(new Rectangle(250,300,20,20));
                    jLabel[i].setFont(new Font("Comic Sans",Font.BOLD,20));
                    jLabel[i].setForeground(Color.white);
                    bgPanel.add(jLabel[i]);
                }
                for(int i=0 ; i<jText.length-2;i++) {
                    jText[i] = new JTextArea();
                    jText[i].setBounds(new Rectangle(250,100+i*40,250,20));
                    bgPanel.add(jText[i]);

                }
                jLabel[0].setText("Amphibious ID:");
                jLabel[1].setText("Model name:");
                jLabel[2].setText("Max Passangers:");
                jLabel[3].setText("Max Speed:");
                jLabel[4].setText("Insert Flag:");
                jLabel[5].setText("Wind Direction:");
                jLabel[6].setText("Is Paved:");
                jLabel[7].setText("Is Dirt:");
                jbtadd.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if(CarAgency.get(Double.parseDouble(jText[0].getText()))==null) {
                               Vehicle value = null;
                                parm1[4] = Double.parseDouble(jText[0].getText());
                                parm2[0] = jText[1].getText();
                                parm1[3] = Double.parseDouble(jText[2].getText());
                                parm1[0] = Double.parseDouble(jText[3].getText());
                                parm2[1] = jText[4].getText();
                                parm3[0] = Field_wind_dir.isSelected();
                                parm3[1] = Field_is_dirt.isSelected();
                                parm3[2] = Field_is_paved.isSelected();
                                parm2[3] = "./res/images/defaultimg/amphibious.png";
                                value = vehicleFactory.getVehicle(TypeVehicle.Amphibious);
                                CarAgency.put(parm1[4], value);
                                amphibiousVehicle.add((AmphibiousVehicle) value);
                                LoadingSuccess();
                                Menu.paintAgency();
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "ID Already Exist");
                            }
                        }
                        catch(Exception e1) {
                            JOptionPane.showMessageDialog(null, e1.toString());
                        }
                    }
                } );
                Field_wind_dir.setBounds(new Rectangle(250,300,20,20));
                bgPanel.add(Field_wind_dir);
                Field_is_dirt.setBounds(new Rectangle(250,340,20,20));
                bgPanel.add(Field_is_dirt);
                Field_is_paved.setBounds(new Rectangle(250,380,20,20));
                bgPanel.add(Field_is_paved);
                break;
            case Crusie:
                jText[0]=Field_id;
                jText[1]= Field_model_name;
                jText[2]= Field_max_speed;
                jText[3]= Field_max_passangers;
                jText[4]= Field_flag;
                jText[5]=Field_FuelAvg;
                jText[6]=Field_avglifespan;
                for(int i=0;i<jLabel.length;i++) {
                    jLabel[i] = new JLabel();
                    jLabel[i].setBounds(new Rectangle(29,100+i*40,250,20));
                    jLabel[i].setFont(new Font("Comic Sans",Font.BOLD,20));
                    Field_wind_dir.setBounds(new Rectangle(250,380,20,20));
                    jLabel[i].setForeground(Color.white);
                    bgPanel.add(jLabel[i]);
                }
                for(int i=0 ; i<jText.length;i++) {
                    jText[i] = new JTextArea();
                    jText[i].setBounds(new Rectangle(250,100+i*40,200,20));
                    bgPanel.add(jText[i]);

                }
                jLabel[0].setText("Crusie ID:");
                jLabel[1].setText("Model name:");
                jLabel[2].setText("Max Passangers:");
                jLabel[3].setText("Max Speed:");
                jLabel[4].setText("Insert Flag:");
                jLabel[5].setText("Fuel Average:");
                jLabel[6].setText("Avergae Life span:");
                jLabel[7].setText("Wind Direction:");
                jbtadd.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if(CarAgency.get(Double.parseDouble(jText[0].getText()))==null) {
                                WaterVehicle value = null;
                                parm1[4] = Double.parseDouble(jText[0].getText());
                                parm2[0] = jText[1].getText();
                                parm1[3] = Double.parseDouble(jText[2].getText());
                                parm1[0] = Double.parseDouble(jText[3].getText());
                                parm2[1] = jText[4].getText();
                                parm2[3] = "./res/images/defaultimg/crusie.png";
                                value = vehicleFactory.getWaterVehicle(TypeVehicle.Crusie);
                                CarAgency.put(parm1[4], value);
                                waterVehicles.add(value);
                                LoadingSuccess();
                                Menu.paintAgency();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "ID Already Exist");
                            }
                        }
                        catch(Exception e1) {
                            JOptionPane.showMessageDialog(null, e1.toString());
                        }
                    }
                } );
                bgPanel.add(Field_wind_dir);
                break;
            case Bicycle:
                jText[1]=Field_model_name;
                jText[0]=Field_id;
                for(int i=0;i<2;i++) {
                    jLabel[i] = new JLabel();
                    jLabel[i].setBounds(new Rectangle(29,100+i*40,250,20));
                    jText[i].setBounds(new Rectangle(250,100+i*40,250,20));
                    jLabel[i].setFont(new Font("Comic Sans",Font.BOLD,20));
                    jLabel[i].setForeground(Color.white);
                    bgPanel.add(jLabel[i]);
                    bgPanel.add(jText[i]);

                }
                jLabel[0].setText("Bicycle ID");
                jLabel[1].setText("Model name:");
                jbtadd.addActionListener(new ActionListener() {
                    public  void actionPerformed(ActionEvent e) {
                        try {
                            if(CarAgency.get(Double.parseDouble(jText[0].getText()))==null) {
                                LandVehicle value = null;
                                parm2[0] = jText[1].getText();
                                parm1[4] = Double.parseDouble(Field_id.getText());
                                parm2[3] = "./res/images/defaultimg/bicycle.png";
                                value = vehicleFactory.getLandVehicle(TypeVehicle.Bicycle);
                                CarAgency.put(parm1[4], value);
                                LoadingSuccess();
                                Menu.paintAgency();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "ID Already Exist");
                            }
                        }
                        catch(Exception e1) {
                            JOptionPane.showMessageDialog(null, e1.toString());
                        }
                    }
                } );
                break;
            case GameGlider:
                jText[1]=Field_model_name;
                jText[0]=Field_id;
                for(int i=0;i<2;i++) {
                    jLabel[i] = new JLabel();
                    jLabel[i].setBounds(new Rectangle(29,100+i*40,250,20));
                    jText[i].setBounds(new Rectangle(250,100+i*40,250,20));
                    jLabel[i].setFont(new Font("Comic Sans",Font.BOLD,20));
                    jLabel[i].setForeground(Color.white);
                    bgPanel.add(jLabel[i]);
                    bgPanel.add(jText[i]);
                }
                jLabel[0].setText("GameGlider ID");
                jLabel[1].setText("Model name:");
                jbtadd.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if(CarAgency.get(Double.parseDouble(jText[0].getText()))==null) {
                                AirVehicle value = null;
                                parm2[0] = jText[1].getText();
                                parm1[4] = Double.parseDouble(Field_id.getText());
                                parm2[3] = "./res/images/defaultimg/gameglider.png";
                                value = airVehicleFactory.getAirVehicle(TypeVehicle.GameGlider);
                                CarAgency.put(parm1[4], value);
                                LoadingSuccess();
                                Menu.paintAgency();
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "ID Already Exist");
                            }
                        }
                        catch(Exception e1) {
                            JOptionPane.showMessageDialog(null, e1.toString());
                        }
                    }
                } );
                break;
            case ElectricBicycle:
                jText[1]=Field_model_name;
                jText[0]=Field_id;
                jText[2]=Field_max_speed;
                for(int i=0;i<5;i++) {
                    jLabel[i] = new JLabel();
                    jLabel[i].setBounds(new Rectangle(29, 100 + i * 40, 250, 20));
                    jLabel[i].setFont(new Font("Comic Sans", Font.BOLD, 20));
                    jLabel[i].setForeground(Color.white);
                    bgPanel.add(jLabel[i]);
                }
                for(int i=0 ; i<jText.length-4;i++) {
                    jText[i].setBounds(new Rectangle(250,100+i*40,250,20));
                    bgPanel.add(jText[i]);

                }

                jLabel[0].setText("Electric Bicycle ID");
                jLabel[1].setText("Model name:");
                jLabel[2].setText("Max Speed:");
                jLabel[3].setText("Is Paved:");
                jLabel[4].setText("Is Dirt:");
                jbtadd.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if(CarAgency.get(Double.parseDouble(jText[0].getText()))==null) {
                                LandVehicle value = null;
                                parm2[0] = Field_model_name.getText();
                                parm1[0] = Double.parseDouble(Field_max_speed.getText());
                                parm1[4] = Double.parseDouble(Field_id.getText());
                                parm2[3] = "./res/images/defaultimg/electric.png";
                                parm3[1] = Field_is_dirt.isSelected();
                                parm3[2] = Field_is_paved.isSelected();
                                value = landVehicleFactory.getLandVehicle(TypeVehicle.ElectricBicycle);
                                CarAgency.put(parm1[4], value);
                                LoadingSuccess();
                            }
                            else {
                                JOptionPane.showMessageDialog(null, "ID Already Exist");
                            }
                        }
                        catch(Exception e1) {
                            JOptionPane.showMessageDialog(null, e1.toString());
                        }
                    }
                } );
                Field_is_paved.setBounds(new Rectangle(250,220,20,20));
                bgPanel.add(Field_is_paved);
                Field_is_dirt.setBounds(new Rectangle(250,260,20,20));
                bgPanel.add(Field_is_dirt);
                break;
            case HybridAircraft:
                jLabel= new JLabel[8];
                for(int i=0;i<jLabel.length;i++) {
                    jLabel[i] = new JLabel();
                    jLabel[i].setBounds(new Rectangle(29,100+i*40,250,20));
                    Field_wind_dir.setBounds(new Rectangle(250,300,20,20));
                    jLabel[i].setFont(new Font("Comic Sans",Font.BOLD,20));
                    jLabel[i].setForeground(Color.white);
                    bgPanel.add(jLabel[i]);
                }
                for(int i=0 ; i<jText.length-2;i++) {
                    jText[i] = new JTextArea();
                    jText[i].setBounds(new Rectangle(250,100+i*40,250,20));
                    bgPanel.add(jText[i]);

                }
                jLabel[0].setText("HybridAircraft ID:");
                jLabel[1].setText("Model name:");
                jLabel[2].setText("Max Passangers:");
                jLabel[3].setText("Max Speed:");
                jLabel[4].setText("Insert Flag:");
                jLabel[5].setText("Wind Direction:");
                jLabel[6].setText("Is Paved:");
                jLabel[7].setText("Is Dirt:");
                jbtadd.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            if(CarAgency.get(Double.parseDouble(jText[0].getText()))==null) {
                                HybridAircraft value = null;
                                parm1[4] = Double.parseDouble(jText[0].getText());
                                parm2[0] = jText[1].getText();
                                parm1[3] = Double.parseDouble(jText[2].getText());
                                parm1[0] = Double.parseDouble(jText[3].getText());
                                parm2[1] = jText[4].getText();
                                parm3[0] = Field_wind_dir.isSelected();
                                parm3[1] = Field_is_dirt.isSelected();
                                parm3[2] = Field_is_paved.isSelected();
                                parm2[3] = "./res/images/defaultimg/hybridair.png";
                                value = (HybridAircraft)vehicleFactory.getVehicle(TypeVehicle.HybridAircraft);
                                CarAgency.put(parm1[4], value);
                                HybridAircraft.add(value);
                                LoadingSuccess();

                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "ID Already Exist");
                            }
                        }
                        catch(Exception e1) {
                            JOptionPane.showMessageDialog(null, e1.toString());
                        }
                    }
                } );
                Field_wind_dir.setBounds(new Rectangle(250,300,20,20));
                bgPanel.add(Field_wind_dir);
                Field_is_dirt.setBounds(new Rectangle(250,340,20,20));
                bgPanel.add(Field_is_dirt);
                Field_is_paved.setBounds(new Rectangle(250,380,20,20));
                bgPanel.add(Field_is_paved);
                break;
        }
        jbtadd.setBounds(new Rectangle(540,350,80,80));
        jbtaddimg.setBounds(new Rectangle(450,350,80,80));
        jbtaddimg.addActionListener(newimg);
        imglabel.setBounds(new Rectangle(29,410,420,20));
        imglabel.setFont(new Font("Comic Sans",Font.BOLD,20));
        imglabel.setForeground(Color.white);
        jbtaddimg.addActionListener(new ActionWithSend(img) {
            public void actionPerformed(ActionEvent e) {
                img = ChooseImage();
                imglabel.setText(img);
            }
        } );
        bgPanel.add(imglabel);
        bgPanel.add(jbtaddimg);
        bgPanel.add(jbtadd);
            JBack.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Insertion in = new Insertion(waterVehicles,amphibiousVehicle,HybridAircraft);
                }
            } );
            JBack.setBounds(new Rectangle(565,25,50,50));
            this.setIconImage(new ImageIcon("./res/images/favicon.png").getImage());
            bgPanel.setLayout(null);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.add(bgPanel);
            this.setResizable(false);
            this.setMinimumSize(new Dimension(640,480));
            this.pack();
            this.setLocationRelativeTo(null);
            this.setVisible(true);
    }
    private void LoadingSuccess(){
        Runnable runnable = new Runnable(){
        @Override
        public void run () {
            Loading loading = new Loading("Added Successfully");
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            loading.terminate();
            }
        };
        Thread t = new Thread(runnable);
        t.start();
    }
    private static String ChooseImage() {
        FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        return dialog.getDirectory()+dialog.getFile();
    }
}
