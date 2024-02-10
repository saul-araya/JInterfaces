package org.Interface.presentation.Control_View;

import org.Interface.logic.Person;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel implements javax.swing.table.TableModel {
    List<Person> rows;
    int[] cols;

    public TableModel(int[] cols, List<Person> rows){
        this.cols=cols;
        this.rows=rows;
        initColNames();
    }

    public int getColumnCount() {
        return cols.length;
    }

    public String getColumnName(int col){
        return colNames[cols[col]];
    }

    public Class<?> getColumnClass(int col){
        switch (cols[col]){
            default: return super.getColumnClass(col);
        }
    }

    public int getRowCount() {
        return rows.size();
    }

    public Object getValueAt(int row, int col) {
        Person sucursal = rows.get(row);
        switch (cols[col]){
            case ID: return sucursal.getId();
            case NAME: return sucursal.getName();
            case EMAIL: return sucursal.getEmail();
            default: return "";
        }
    }

    public Person getRowAt(int row) {
        return rows.get(row);
    }

    public static final int ID=0;
    public static final int NAME=1;
    public static final int EMAIL=2;

    String[] colNames = new String[6];
    private void initColNames(){
        colNames[ID]= "Id";
        colNames[NAME]= "Name";
        colNames[EMAIL]= "Email";
    }
}
