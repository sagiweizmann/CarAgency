package decorator;

import abstract_classes.Vehicle;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class StatusNColorVDecorator extends VehicleDecorator {
    private String status;
    Color myColor;
    Font myFont = new Font("SansSerif", Font.PLAIN, 10);
    TitledBorder titledBorder = BorderFactory.createTitledBorder(null, " Text 1    Text 2", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, myFont, myColor);
    public StatusNColorVDecorator(Vehicle decoratedVehicle) {
        super(decoratedVehicle);
        setRedBorder(decoratedVehicle);
        this.status="";
    }
    public Vehicle getVehicle(){
        return decoratedVehicle;
    }
    private void setRedBorder(Vehicle decoratedVehicle){
        System.out.println("Red!");
    }
    
}
