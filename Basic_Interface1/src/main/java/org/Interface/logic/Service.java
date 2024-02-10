package org.Interface.logic;

import org.Interface.data.Data;

public class Service {
    private Data data;
    private static Service instance;
    public static Service instance(){
        if(instance == null){
            instance = new Service();
        }
        return instance;
    }
    public Service(){
        data = new Data();
    }
    public Data getData(){
        return this.data;
    }

    public void add(Person p) throws Exception{
        if(verify(p) == -1) {
            data.getData().add(p);
        }
        else{
            throw new Exception("THIS PERSON ALLREADY REGISTER");
        }
    }
    public void remove(Person p) throws Exception{
        int index = verify(p);
        if(index > -1){
            data.getData().remove(index);
        }
        else{
            throw new Exception("THIS PERSON DOES NOT EXIST YET");
        }
    }

    public int verify(Person p){
        int flag = -1;
        for(int i = 0; i < data.getData().size(); i++){
            if(data.getData().get(i).getId().equals(p.getId())){
                flag = i;
                break;
            }
        }
        return flag;
    }
}
