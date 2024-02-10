package org.Interface.data;

import org.Interface.logic.Person;

import java.util.ArrayList;
import java.util.List;

public class Data {
    List<Person> data;
    public Data(){
        this.data = new ArrayList<>();
    }
    public List<Person> getData(){return this.data;}
}
