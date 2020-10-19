package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import abstract_classes.Vehicle;

import javax.swing.*;

public class ActionWithSend implements ActionListener{
	int i;
	String img=null;
	Vehicle v;
	static Menu menu;
	JFrame mainFrame;
	public ActionWithSend(Vehicle v) {
		this.v=v;
	}
	public ActionWithSend(int i) {
	this.i=i;
	}	
	public ActionWithSend(String i) {
	this.img=i;
	}

	public ActionWithSend(String s, JFrame mainFrame) {
		this.img=s;
		this.mainFrame=mainFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	public ActionWithSend(Vehicle v,Menu menu) {
	this.v=v;
	this.menu=menu;
	}
}
