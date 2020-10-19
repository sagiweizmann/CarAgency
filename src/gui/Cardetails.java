package gui;
import abstract_classes.AirVehicle;
import abstract_classes.LandVehicle;
import abstract_classes.Vehicle;
import abstract_classes.WaterVehicle;
import classes.CarAgency;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.util.Hashtable;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Cardetails extends  JFrame{
    public Cardetails(Vehicle vehicle){
        this.setTitle("Car Agency");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                run2(vehicle);
            }
        });
    }
    private void run2(Vehicle vehicle) {
        JFrame ref = this;
        JPanel bgPanel = new BgPanel("./res/images/cardetails.png");
        PlainJButton Reset = new PlainJButton("");
        PlainJButton Buy = new PlainJButton("");
        PlainJButton Test = new PlainJButton("");
        PlainJButton CarImage=new PlainJButton(new ImageIcon(vehicle.getImg()));
        Reset.setBounds(new Rectangle(340,30,80,80));
        Test.setBounds(new Rectangle(340,120,80,80));
        Buy.setBounds(new Rectangle(230,80,80,80));
        Buy.addActionListener(new ActionWithSend(vehicle) {
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                int randomNum;
                randomNum = 5000 + rand.nextInt((10000 - 5000) + 1);
                try {
                    Thread.sleep(randomNum);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                Buy(vehicle,CarImage,ref);
            }
        } );
        Test.addActionListener(new ActionWithSend(vehicle) {
            public void actionPerformed(ActionEvent e) {
            Test(vehicle,CarImage);
            }
        } );
        Reset.addActionListener(new ActionWithSend(vehicle) {
            public void actionPerformed(ActionEvent e) {
                Reset(vehicle,CarImage);
            }
        } );
        CarImage.setBounds(new Rectangle(20,40,150,150));
        CarImage.setToolTipText(vehicle.toString());
        CarImage.setOpaque(false);
        CarImage.setBorderPainted(false);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent winEvt) {
                vehicle.setLock(false);
            }
        });
        this.add(CarImage);
        this.add(Reset);
        this.add(Buy);
        this.add(Test);
        this.setIconImage(new ImageIcon("./res/images/favicon.png").getImage());
        this.setResizable(false);
        this.setMinimumSize(new Dimension(MainGui.width-200,MainGui.height-200));
        this.add(bgPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    private void Buy(Vehicle vehicle,PlainJButton CarImage,JFrame ref) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int reply = JOptionPane.showConfirmDialog(null, "Do you wanna buy this? \n" + vehicle.toString(), "Buy", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    try {
                            synchronized (vehicle) {
                                UpdatingVehicle("Bought Successfully!", 100);
                                CarAgency.remove(vehicle.getID());
                                CarImage.setToolTipText(vehicle.toString());
                                Menu.paintAgency();
                                ref.dispose();
                                ref.setVisible(false);
                            }
                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(null, e2.toString());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Thank you for your interst");
                }
            }
        };
        Thread t = new Thread(runnable);
        t.start();
    }
    private void Test(Vehicle vehicle,PlainJButton CarImage){
        try {
            String test = JOptionPane.showInputDialog(null, "How Much you drive?", "KM");
            ReentrantLock waterlock=new ReentrantLock();
            ReentrantLock airlock=new ReentrantLock();
            ReentrantLock landlock=new ReentrantLock();
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                        if(vehicle instanceof WaterVehicle){
                            waterlock.lock();
                        }
                        if(vehicle instanceof AirVehicle){
                            airlock.lock();
                        }
                        if(vehicle instanceof LandVehicle){
                            landlock.lock();
                        }
                        try {
                            vehicle.SetDistance(Double.parseDouble(test));
                            UpdatingVehicle("Test is over !",Integer.parseInt(test)*100);
                            MainGui.notifyAllObservers();
                            Thread.sleep(Integer.parseInt(test) * 100);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        finally {
                            if(waterlock.isHeldByCurrentThread()){
                                waterlock.unlock();
                            }
                            if(airlock.isHeldByCurrentThread()){
                                airlock.unlock();
                            }
                            if(landlock.isHeldByCurrentThread()){
                                landlock.unlock();
                            }
                            CarImage.setToolTipText(vehicle.toString());
                            Menu.paintAgency();
                        }
                }
            };
            Thread t = new Thread(runnable);
            t.start();

        }
        catch(Exception e2){
            JOptionPane.showMessageDialog(null, e2.toString());
        }
    }

    private void Reset(Vehicle vehicle,PlainJButton CarImage) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (vehicle) {
                        vehicle.SetDistance(0.0);
                        UpdatingVehicle("Reset Completed!", 100);
                        CarImage.setToolTipText(vehicle.toString());
                        Menu.paintAgency();
                    }
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(null, e2.toString());
                }
            }
        };
        Thread t = new Thread(runnable);
        t.start();
    }
    private static void UpdatingVehicle(String update,int seconds){
        Runnable runnable = new Runnable(){
            @Override
            public void run () {
                Random rand = new Random();
                int randomNum;
                randomNum = 3000 + rand.nextInt((8000 - 3000) + 1);
                Loading loading = new Loading("Updating Database...");
                try {
                    Thread.sleep(randomNum+seconds);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                loading.setText(update);
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
