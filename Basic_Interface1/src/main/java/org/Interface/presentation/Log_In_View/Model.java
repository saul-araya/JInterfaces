package org.Interface.presentation.Log_In_View;

import org.Interface.logic.Person;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Model extends Observable {
    Person current;
    public Model(){}
    @Override
    public void addObserver(Observer o) {
        super.addObserver(o);
        commit();
    }
    public void commit(){
        setChanged();
        notifyObservers(changedProps);
        changedProps = NONE;
    }
    public void setCurrent(Person person){
        this.current = person;
        changedProps += CURRENT;
    }
    public Person getCurrent(){return this.current;}
    int changedProps = NONE;
    public static int CURRENT = 2;
    public static int NONE = 0;
}
