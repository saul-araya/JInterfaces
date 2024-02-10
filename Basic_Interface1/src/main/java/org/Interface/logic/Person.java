package org.Interface.logic;

public class Person {
    private String name;
    private String id;
    private String email;
    private String phoneNumber;
    private int age;
    private String civilStatus;
    public Person(String name, String id, String email, String phoneNumber, int age, String civilStatus){
        this.name = name;
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.civilStatus = civilStatus;
    }
    public Person(){
        this.name = "";
        this.id = "";
        this.email = "";
        this.phoneNumber = "";
        this.age = 0;
        this.civilStatus = "";
    }
    public String getName(){return this.name;}
    public String getId(){return this.id;}
    public String getEmail(){return this.email;}
    public String getPhoneNumber(){return this.phoneNumber;}
    public int getAge(){return this.age;}
    public String getCivilStatus(){return this.civilStatus;}
    public void setName(String name){this.name = name;}
    public void setId(String name){this.id = id;}
    public void setEmail(String email){this.email = email;}
    public void setPhoneNumber(String pNumber){this.phoneNumber = pNumber;}
    public void setAge(int age){this.age = age;}
    public void setCivilStatus(String civilStatus){this.civilStatus = civilStatus;}

    @Override
    public String toString(){
        return String.format(this.name + " " + this.id + " " + this.age + " " +
                this.phoneNumber + " " + this.email + " " + this.civilStatus);
    }
}
