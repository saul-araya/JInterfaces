package org.Interface.presentation.Control_View;

import org.Interface.logic.Person;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {
    private JTable table;
    private JLabel nameLabel;
    private JLabel idLabel;
    private JLabel ageLabel;
    private JLabel pNumberLabel;
    private JLabel emailLabel;
    private JLabel CLabel;
    private JTextField name_textField;
    private JTextField id_textField;
    private JTextField age_textField;
    private JTextField pNumber_textField;
    private JTextField email_textField;
    private JTextField civil_textField;
    private JButton deletebutton;
    private JButton cleanbutton;
    private JLabel dataLabel;
    private JPanel panel;

    Controller controller;
    Model model;
    public View(){
        deletebutton.setEnabled(false);
        name_textField.setEnabled(false);
        id_textField.setEnabled(false);
        email_textField.setEnabled(false);
        civil_textField.setEnabled(false);
        pNumber_textField.setEnabled(false);
        age_textField.setEnabled(false);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    int row = table.getSelectedRow();
                    Person p = controller.getSelect(row);
                    controller.setCurrent(p);
                    deletebutton.setEnabled(true);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(panel,ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        panel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                controller.shown();
            }
        });

        deletebutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    controller.delete();
                    controller.clear();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(panel,ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        cleanbutton.addMouseListener(new MouseAdapter() {
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
    public void setModel(Model model){
        this.model = model;
        model.addObserver(this);
    }
    public void setController(Controller controller){this.controller = controller;}
    @Override
    public void update(Observable updateModel, Object properties) {
        int changedProps = (int) properties;
        if((changedProps & Model.LIST) == Model.LIST){
            int[] cols = {TableModel.ID, TableModel.NAME, TableModel.EMAIL};
            table.setModel(new TableModel(cols, model.getList()));
            table.setRowHeight(30);
            TableColumnModel columnModel = table.getColumnModel();
            columnModel.getColumn(2).setPreferredWidth(200);
        }
        if((changedProps & Model.CURRENT) == Model.CURRENT){
            name_textField.setText(model.getCurrent().getName());
            id_textField.setText(model.getCurrent().getId());
            age_textField.setText(String.valueOf(model.getCurrent().getAge()));
            pNumber_textField.setText(model.getCurrent().getPhoneNumber());
            email_textField.setText(model.getCurrent().getEmail());
            civil_textField.setText(model.getCurrent().getCivilStatus());
        }
    }
}
