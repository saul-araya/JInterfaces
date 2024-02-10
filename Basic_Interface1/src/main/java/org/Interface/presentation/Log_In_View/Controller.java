package org.Interface.presentation.Log_In_View;

import org.Interface.logic.Person;
import org.Interface.logic.Service;

public class Controller {
    Model model;
    View view;
    public Controller(View view, Model model){
        try {
            this.view = view;
            this.model = model;
            view.setController(this);
            view.setModel(model);
        }catch (Exception io){}
    }
    public void add(Person p) throws Exception{
        Service.instance().add(p);
        model.commit();
    }
    public void clear(){
        model.setCurrent(new Person());
        model.commit();
    }
}
