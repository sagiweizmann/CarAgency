package memento;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
public class Caretaker {
    public static int counter=0;
    private ArrayList<Memento> statesList = new ArrayList<Memento>();
    public void addMemento(Memento m) {
        if(counter<3) {
            statesList.add(m);
            counter++;
        }
        else{
            JOptionPane.showMessageDialog(null,"3 Saves Already!");
        }
    }
    public Memento getMemento(int index) {
        return statesList.get(index);
    }
}