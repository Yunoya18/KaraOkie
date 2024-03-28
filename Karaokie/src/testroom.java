
import javax.swing.*;
import java.awt.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author BBoonZ
 */
public class testroom extends JInternalFrame{
    public JPanel panel = new JPanel();
    public testroom(String name){
        super("Room " + name, false, false, false, false);
        
        panel.add(new JLabel(new ImageIcon(System.getProperty("user.dir") + "/src/Karaokie/image/Rectangle 63.png")));
        
        panel.setBackground(Color.BLACK);
        add(panel);
        pack();
        //setSize(500, 500);
        setVisible(true);
    }
}
