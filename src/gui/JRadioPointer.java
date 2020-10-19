package gui;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

import abstract_classes.Vehicle;

public class JRadioPointer extends JRadioButton{
	Vehicle pointer;
	public JRadioPointer(Vehicle p) {
		this.pointer=p;
	}
	public JRadioPointer(ImageIcon imageIcon,Vehicle p) {
		super(imageIcon);
		this.pointer=p;
	}
	public Vehicle getPointer() {
		return this.pointer;
	
}
}
