/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package karaokie;

/**
 *
 * @author mansu
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import karaokie.room.*;

public class karaOkie_main implements WindowListener{
    private JFrame ma;
    private CardLayout cd;
    private JPanel main_panel;
    private Loginpage lg;
    private main mp;
    private mainUser mu;
    
    karaOkie_main(){
        ma = new JFrame();
        cd = new CardLayout();
        main_panel = new JPanel(cd);
        
        mp = new main(); 
        CardLayout cardLayout = (CardLayout) main_panel.getLayout();
        lg = new Loginpage(cardLayout, main_panel);
        mu = new mainUser();
        main_panel.add(lg, "pg1");
        main_panel.add(mp, "pg2");
//        main_panel.add(mu, "pg3");
        
        
        ma.add(main_panel);
        ma.setPreferredSize(new Dimension(1280,720));
        ma.setVisible(true);
        ma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ma.pack();
        
        
        //controller
        
        Controller.openFile();
        
        // Listener
        ma.addWindowListener(this);
        
    }
    public static void main(String[] args) {
        try {
            String systemLookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(systemLookAndFeelClassName);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new karaOkie_main();
    }

    @Override
    public void windowOpened(WindowEvent e) {
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Closing");
        mp.sentClosing();
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
}
