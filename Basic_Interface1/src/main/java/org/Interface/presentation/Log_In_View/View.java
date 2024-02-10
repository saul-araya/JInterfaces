package org.Interface.presentation.Log_In_View;

import org.Interface.logic.Person;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {
    private JPanel panel;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;
    private JLabel idLabel;
    private JTextField name_textField;
    private JTextField id_textField;
    private JTextField age_textField;
    private JTextField pNumber_textField;
    private JTextField email_textField;
    private JLabel CstatedLabel;
    private JRadioButton single_radioButton;
    private JRadioButton married_radioButton;
    private JRadioButton W_radioButton;
    private JButton save_button;
    private JButton clean_button;
    private JLabel infoLabel;

    Controller controller;
    Model model;

    public View(){      //This is the View constructor, so here we do the listeners functions.
        save_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Person p = take();
                    controller.add(p);
                    controller.clear();
                    JOptionPane.showMessageDialog(panel,"Person Register!!", "Warning", JOptionPane.WARNING_MESSAGE);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(panel, ex.getMessage(), "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        clean_button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                controller.clear();
            }
        });
    }

    public JPanel getPanel(){return this.panel;}
    public Controller getController(){return this.controller;}
    public Model getModel(){return this.model;}
    public void setController(Controller controller){this.controller = controller;}
    public void setModel(Model model){
        this.model = model;
        model.addObserver(this);
    }

    @Override
    public void update(Observable updatedModel, Object properties) {
        int changedProps = (int) properties;
        if((changedProps & Model.CURRENT) == Model.CURRENT){
            name_textField.setText(model.getCurrent().getName());
            id_textField.setText(model.getCurrent().getId());
            pNumber_textField.setText(model.getCurrent().getPhoneNumber());
            email_textField.setText(model.getCurrent().getEmail());
            if(model.getCurrent().getAge() == 0){
                age_textField.setText("");
            }

            single_radioButton.setSelected(false);
            married_radioButton.setSelected(false);
            W_radioButton.setSelected(false);
        }
    }

    public Person take() throws Exception{
        String name, id, email, pNumber, age, civilStatus = "";
        int _age, _pNumber;

        name = name_textField.getText();
        id = id_textField.getText();
        email = email_textField.getText();
        pNumber = pNumber_textField.getText();
        age = age_textField.getText();
        _age = Integer.parseInt(age);   //change to Integer
        _pNumber = Integer.parseInt(pNumber); //change to Integer

        if(single_radioButton.isSelected()){
            civilStatus = "Single";
        }
        if(married_radioButton.isSelected()){
            civilStatus = "Married";
        }
        if(W_radioButton.isSelected()){
            civilStatus = "Widower";
        }

        if(name.isEmpty() || id.isEmpty() || email.isEmpty() || pNumber.isEmpty() || civilStatus.isEmpty()){
            throw new Exception("Please complete all spaces");
        }

        return new Person(name, id, email, pNumber, _age, civilStatus);
    }
}
