package memento;
import abstract_classes.Vehicle;
import classes.CarAgency;

import java.util.Hashtable;
import java.util.Iterator;

public class Memento {
    private Hashtable<String, Vehicle> state;
    public Memento(Hashtable<String, Vehicle> state){
    this.state=state;
    }
    public Hashtable<String, Vehicle> getState() { return state; }
}