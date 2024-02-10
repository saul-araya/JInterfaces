package org.Interface.presentation.Control_View;

import org.Interface.logic.Person;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Model extends Observable {
    List<Person> list;
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
    public void init(List<Person> list){
        setList(list);
        setCurrent(new Person());
    }
    public List<Person> getList(){return this.list;}
    public void setList(List<Person> list){
        this.list = list;
        changedProps += LIST;
    }
    public Person getCurrent(){return this.current;}
    public void setCurrent(Person current){
        this.current = current;
        changedProps += CURRENT;
    }

    int changedProps = NONE;
    public static  int NONE = 0;
    public static int LIST = 1;
    public static int CURRENT = 2;
}
