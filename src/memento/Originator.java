package memento;

import abstract_classes.Vehicle;
import classes.CarAgency;
import gui.Menu;

import java.util.Hashtable;
import java.util.Iterator;

public class Originator {
    private Hashtable<String, Vehicle> state;
    public void setState(Hashtable<String, Vehicle> state) {
        this.state=new Hashtable<>(state);
        Menu.paintAgency();
    }
    public Hashtable<String, Vehicle> getState() { return state; }
    public Memento createMemento() { return new Memento(state); }
    public void setMemento(Memento memento) { state = memento.getState(); }
}