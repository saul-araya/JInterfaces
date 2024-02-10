package org.Interface.presentation.Control_View;

import org.Interface.logic.Person;
import org.Interface.logic.Service;

public class Controller {
    Model model;
    View view;
    public Controller(View view, Model model){
        model.init(Service.instance().getData().getData());
        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }
    public Person getSelect(int row) throws Exception{
        return model.getList().get(row);
    }
    public void setCurrent(Person p){
        model.setCurrent(p);
        model.commit();
    }
    public void shown(){
        model.setList(Service.instance().getData().getData());
        model.commit();
    }
    public void delete() throws Exception{
        Service.instance().remove(model.getCurrent());
        model.setList(Service.instance().getData().getData());
        model.commit();
    }
    public void clear(){
        model.setCurrent(new Person());
        model.commit();
    }
}
