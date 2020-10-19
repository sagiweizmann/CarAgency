package observers;


import abstract_classes.Vehicle;

import javax.swing.*;
import java.awt.*;

public class DistanceObserver extends Observer {
    protected JLabel distance;
    public DistanceObserver(Double dist){
        distance=new JLabel("Distance:"+dist.toString());
        distance.setFont(new Font("TimesRoman", Font.BOLD, 12));
        distance.setForeground(Color.white);
        distance.setBounds(new Rectangle(20,400,200,40));

    }
    @Override
    public void update() {
        distance.setText("Distance:"+Vehicle.distanceall.toString());
    }
    public JLabel getDistance() {
        return distance;
    }
}
