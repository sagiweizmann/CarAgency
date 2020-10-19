package gui;

import javax.swing.*;
import java.awt.*;

class MyCustomToolTip extends JToolTip {
    public MyCustomToolTip(JComponent component) {
        super();
        setComponent(component);
        setBackground(Color.white);
        setForeground(Color.blue);
    }
}
public class PlainJButton extends JButton{

    public PlainJButton (String text){
        super(text);
        setBorder(null);
       setBorderPainted(false);
        setContentAreaFilled(false);
       setOpaque(false);
    }

	public PlainJButton(ImageIcon imageIcon) {
        super(imageIcon);
         setBorder(null);
        setBorderPainted(false);
        setContentAreaFilled(false);
       setOpaque(false);
	}
    @Override
    public JToolTip createToolTip() {
        return (new MyCustomToolTip(this));
    }
}

