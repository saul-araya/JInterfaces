package org.Interface;

import org.Interface.presentation.Log_In_View.Controller;
import org.Interface.presentation.Log_In_View.Model;
import org.Interface.presentation.Log_In_View.View;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        //Begin to start the app please be sure to have instaled the library "com.jtattoo:JTattoo:1.6.13" from maven.
        //This Library is for the texture look.

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");}
        catch (Exception ex) {};

        window = new JFrame();

        Model model = new Model();
        View view = new View();
        mainPageControl = new Controller(view, model);

        org.Interface.presentation.Control_View.Model model2 = new org.Interface.presentation.Control_View.Model();
        org.Interface.presentation.Control_View.View view2 = new org.Interface.presentation.Control_View.View();
        controlView = new org.Interface.presentation.Control_View.Controller(view2, model2);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Register Window", view.getPanel());
        tabs.add("Control Window", view2.getPanel());

        ImageIcon iconApp = new ImageIcon(Main.class.getResource("/iconApp.png"));

        window.add(tabs);
        window.setSize(800,500);
        window.setResizable(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setTitle("RA-Register Application");
        window.setIconImage(iconApp.getImage());
        window.setVisible(true);
    }
    public static Controller mainPageControl;
    public static org.Interface.presentation.Control_View.Controller controlView;
    public static JFrame window;
}