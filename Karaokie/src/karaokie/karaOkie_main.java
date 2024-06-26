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
import java.io.*;
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
        //       font
        try{
            Font Montserrat = Font.createFont(Font.TRUETYPE_FONT, new File(System.getProperty("user.dir") + "/src/karaokie/font/Montserrat-Bold.ttf")).deriveFont(Font.PLAIN, 12);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Montserrat);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        ma = new JFrame();
        cd = new CardLayout();
        main_panel = new JPanel(cd);

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        
        mp = new main(); 
        CardLayout cardLayout = (CardLayout) main_panel.getLayout();
        lg = new Loginpage(cardLayout, main_panel);
        mu = new mainUser();
        main_panel.add(lg, "pg1");
        main_panel.add(mp, "pg2");
        main_panel.add(mu, "pg3");
        
        
        ma.add(main_panel);
        ma.setSize(screenSize);
        ma.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ma.setUndecorated(true);
        ma.setVisible(true);
        ma.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ma.pack();
        
        
        //controller
        
//        Controller.openFile();
        
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
        System.out.println("Open");
        Controller controller = new Controller();
        Thread controllerThread = new Thread(controller);
        controllerThread.start();
    
        Controller.openFile();
        mp.sentOpen();

    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("Closing");
        mp.sentClosing();
        Controller.saveFile();
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
