package gui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BgPanel extends JPanel  {
		Image bg;
		public BgPanel(String path) {
			   bg = new ImageIcon(path).getImage();
		}
	    @Override
	    public void paintComponent(Graphics g) {
	        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
	    }
	    
	
}
